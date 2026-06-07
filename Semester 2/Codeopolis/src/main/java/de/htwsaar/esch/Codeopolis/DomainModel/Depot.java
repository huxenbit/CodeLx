package de.htwsaar.esch.Codeopolis.DomainModel;

import java.util.NoSuchElementException;
import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;
import java.text.DecimalFormat;

public class Depot {
    private LinkedList<Silo> silos;
    DepotIterator dI;

    /**
     * Constructs a Depot object with the specified number of silos and capacity per silo.
     *
     * @param numberOfSilos    The number of silos in the depot.
     * @param capacityPerSilo  The capacity per silo.
     */
    public Depot(int numberOfSilos, int capacityPerSilo) {
        this.silos = new LinkedList<>();

        for(int i = 0; i < numberOfSilos; i++) {
            silos.addLast(new Silo(capacityPerSilo));
        }
    }

    /**
     * Constructs a Depot object with the specified array of silos.
     * Each silo in the array is deeply copied to ensure that the Depot has its own separate instances.
     *
     * @param silosList The list of Silo objects to be copied into the depot.
     */
    public Depot(LinkedList<Silo> silosList) {

        silos = new LinkedList<>();

        silosList.forEach(s -> silos.addLast(new Silo(s)));
    }

    public Depot(Silo[] silosArray) {

        silos = new LinkedList<>();

        if (silosArray != null) {
            for (Silo silo : silosArray) {
                silos.addLast(new Silo(silo));
            }
        }
    }

    /**
     * Retrieves the current fill level of the depot for a specific grain type.
     *
     * @param grainType The grain type for which to retrieve the fill level.
     * @return The total amount of grain stored in the depot for the specified grain type.
     */
    public int getFillLevel(Game.GrainType grainType) {
        int[] total = new int[1];

        silos.filter(s -> s.getGrainType() == grainType).forEach(s -> total[0] += s.getFillLevel());

        return total[0];
    }

    public int getAvailableForPlanting(Game.GrainType grainType) {
        int[] available = new int[1];

        silos.filter(s -> s.getGrainType() == null || s.getGrainType() == grainType).forEach(s -> available[0] += (s.getCapacity() - s.getFillLevel()));

        return available[0];
    }

    /**
     * Creates and returns a copy of the silos array.
     * This method creates a new array and populates it with copies of the Silo objects,
     * ensuring that modifications to the returned array do not affect the original silos.
     *
     * @return A copy of the silos array.
     */
    public LinkedList<Silo> getSilos() {
        LinkedList<Silo> copy = new LinkedList<>();
        silos.forEach(s -> copy.addLast(new Silo(s)));
        return copy;
    }

    /**
     * Gets the total amount of bushels (grain) stored in the depot.
     *
     * @return The total amount of bushels stored in the depot.
     */
    public int getTotalFillLevel() {
        int[] total = new int[1];
        silos.forEach(s -> total[0] += s.getFillLevel());
        return total[0];
    }

    /**
     * Retrieves the capacity of the depot for a specific grain type.
     *
     * @param grainType The grain type for which to retrieve the capacity.
     * @return The total capacity of the depot for the specified grain type.
     */
    public int getCapacity(Game.GrainType grainType) {

        int totalCapacity = 0;

        DepotIterator it = getDepotIterator(grainType);

        while (it.hasNext()) {
            totalCapacity += it.next().getCapacity();
        }

        int[] wrapper = new int[1];

        silos.filter(s -> s.getGrainType() == null).forEach(s -> wrapper[0] += s.getCapacity());

        totalCapacity += wrapper[0];

        return totalCapacity;
    }

    /**
     * Stores a harvest in the depot.
     *
     * @param harvest The harvest to be stored in the depot.
     * @return True if the harvest was successfully stored, false otherwise.
     */
    public boolean store(Harvest harvest) {

        // 1. zuerst passende Silos
        LinkedList.Iterator<Silo> it = silos.iterator();

        while (it.hasNext()) {

            Silo silo = it.next();

            if (silo.getGrainType() == harvest.getGrainType()) {

                harvest = silo.store(harvest);

                if (harvest == null) {
                    return true;
                }
            }
        }

        // 2. freie Silos
        it = silos.iterator();

        while (it.hasNext()) {

            Silo silo = it.next();

            if (silo.getGrainType() == null) {

                harvest = silo.store(harvest);

                if (harvest == null) {
                    return true;
                }
            }
        }

        // 3. falls noch etwas übrig ist
        defragment();

        return false;
    }

    /**
     * Takes out a specified amount of grain from the depot for a specific grain type.
     *
     * @param amount    The amount of grain to be taken out.
     * @param grainType The grain type for which to take out the grain.
     * @return The actual amount of grain taken out from the depot.
     */
    public int takeOut(int amount, Game.GrainType grainType) {
        int[] taken = new int[1];
        int[] remaining = new int[]{amount};

        silos.filter(s -> s.getGrainType() == grainType).forEach(s -> {
                    if (remaining[0] > 0) {
                        int t = s.takeOut(remaining[0]);
                        remaining[0] -= t;
                        taken[0] += t;
                    }
                });

        return taken[0];
    }
    
    /**
     * Takes out the specified amount of grain from the silo, distributing it evenly among the stored bushels.
     * If the specified amount exceeds the total amount of grain in the silo, all grain is removed and returned.
     * If the specified amount is less than the total amount of grain, the grain is taken out evenly from each bushel,
     * with any remaining grain distributed among the bushels in a round-robin fashion.
     *
     * @param amount The amount of grain to be taken out from the silo.
     * @return The actual amount of grain taken out from the silo.
     */
    public int takeOut(int amount) {
    	if(amount >= this.getTotalFillLevel()){
    		int totalAmountOfBushels =  this.getTotalFillLevel();
            silos.forEach(Silo::emptySilo);
    		return totalAmountOfBushels;
    	}

    	int remainder = amount % this.silos.size();
        final int partition = amount / silos.size();
        silos.forEach(s -> {
            if (s.getFillLevel() < partition) {
                s.emptySilo();
            } else {
                s.takeOut(partition);
            }
        });

    	int j = 0;
    	while(remainder > 0) {
    		if(this.silos.get(j).getFillLevel() > 0) {
    			this.silos.get(j).takeOut(1);
    			remainder--;
    		}
            j = (j + 1) % silos.size();
    	}
    	return amount;
    }

    /**
     * Expands the depot by adding more silos with the specified capacity per silo.
     *
     * @param numberOfSilos    The number of silos to add.
     * @param capacityPerSilo  The capacity per silo.
     */
    public void expand(int numberOfSilos, int capacityPerSilo) {

        for(int i = 0; i < numberOfSilos; i++) {
            silos.addLast(new Silo(capacityPerSilo));
        }

        takeOut((int)(numberOfSilos * GameConfig.DEPOT_EXPANSION_COST));
    }

    /**
     * Performs defragmentation on the depot to redistribute grain across silos.
     */
    public void defragment() {

        Harvest[] all = new Harvest[getTotalHarvestCount()];
        int[] index = new int[1];

        silos.forEach(s -> {
            Harvest[] h = s.emptySilo();
            if (h != null) {
                for (Harvest x : h) {
                    all[index[0]++] = x;
                }
            }
        });

        for (Harvest h : all) {
            if (h != null) {
                simpleStore(h);
            }
        }
    }

    private void simpleStore(Harvest harvest) {

        LinkedList.Iterator<Silo> it = silos.iterator();

        while (it.hasNext()) {

            Silo silo = it.next();

            if (silo.getGrainType() == harvest.getGrainType()
                    || silo.getGrainType() == null) {

                harvest = silo.store(harvest);

                if (harvest == null) {
                    return;
                }
            }
        }
    }

    /**
     * Retrieves the total count of harvests across all silos.
     *
     * @return The total count of harvests stored in all silos combined.
     */
    private int getTotalHarvestCount() {

        int totalCount = 0;

        LinkedList.Iterator<Silo> it = silos.iterator();

        while(it.hasNext()) {
            totalCount += it.next().getHarvestCount();
        }

        return totalCount;
    }


    /**
     * Simulates the decay of grain in the depot over time.
     *
     * @return The total amount of grain that decayed in the depot.
     */
    public int decay(int currentYear) {
        int[] total = new int[1];
        silos.forEach(s -> total[0] += s.decay(currentYear));
        return total[0];
    }


    /**
     * Checks if the depot is fully occupied with grain.
     * 
     * @return {@code true} if the total fill level of all silos equals or exceeds the total capacity of the storage system, {@code false} otherwise.
     */
    public boolean full() {
        return getTotalFillLevel() >= totalCapacity();
    }
	
	/**
	 * Calculates the total capacity of the depot by summing the capacities of all silos.
	 * 
	 * @return The total capacity of the storage system.
	 */
    public int totalCapacity() {

        int total = 0;

        LinkedList.Iterator<Silo> it = silos.iterator();

        while(it.hasNext()) {
            total += it.next().getCapacity();
        }

        return total;
    }

	/**
	 * Retrieves the total amount of grain categorized by grain type.
	 * 
	 * @return An array containing the total amount of grain for each grain type, indexed by the grain type constants defined in the {@code GameConfig} class.
	 */
	public int[] getBushelsCategorizedByGrainType() {
	    int[] result = new int[Game.GrainType.values().length];
	    for(Game.GrainType grainType : Game.GrainType.values()) {
	        result[grainType.ordinal()] = getFillLevel(grainType);
	    }
	    return result;
	}

	/**
	 * Returns a string representation of the depot, including information about each silo's grain type, fill level, capacity, and absolute amount of grain.
	 *
	 * @return A string containing information about the depot, including each silo's grain type, fill level, capacity, and absolute amount of grain.
	 */
    @Override
    public String toString() {

        LinkedList<Silo> sorted = getSilos();
        sorted.sort();

        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");

        int[] siloNumber = new int[]{1};

        sorted.forEach(silo -> {

            builder.append("Silo ").append(siloNumber[0]++).append(": ");

            String grainName = (silo.getGrainType() != null)
                    ? silo.getGrainType().toString()
                    : "EMPTY";

            builder.append(grainName).append("\n");

            int fill = silo.getFillLevel();
            int cap = silo.getCapacity();

            double percent = ((double) fill / cap) * 100;

            builder.append("Amount of Grain: ").append(fill).append(" units\n");

            int bars = (int)((percent / 100.0) * 20);

            builder.append("|");
            for (int i = 0; i < bars; i++) builder.append("=");
            for (int i = bars; i < 20; i++) builder.append("-");
            builder.append("| ").append(df.format(percent)).append("% filled\n");

            builder.append("Capacity: ").append(cap).append(" units\n\n");
        });

        return builder.toString();
    }

    private class DepotIterator implements Iterator {

        private final Game.GrainType grainType;
        private final LinkedList.Iterator<Silo> iterator;

        private Silo nextSilo;

        public DepotIterator(Game.GrainType grainType) {
            this.grainType = grainType;
            this.iterator = silos.iterator();
            advance();
        }

        private void advance() {

            nextSilo = null;

            while(iterator.hasNext()) {

                Silo silo = iterator.next();

                if(silo.getGrainType() == grainType) {
                    nextSilo = silo;
                    break;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return nextSilo != null;
        }

        @Override
        public Silo.Status next() {

            if(nextSilo == null) {
                throw new NoSuchElementException();
            }

            Silo.Status status =
                    nextSilo.getStatus(nextSilo.getCapacity());

            advance();

            return status;
        }
    }

    public interface Iterator {
        /**
         * Checks if there are further objects available for iteration.
         *
         * @return {@code true} if more objects are available; {@code false} otherwise.
         */

        boolean hasNext();

        /**
         * Returns the next {@link Silo.Status} object in the iteration.
         * This method should only be called if {@code hasNext()} returns {@code true}.
         *
         * @return The next { @link Silo . Status } object .
         * @throws NoSuchElementException if no more elements are available.
         */
        Silo.Status next();
    }

    public DepotIterator getDepotIterator(Game.GrainType grainType) {
        return new DepotIterator(grainType);
    }
}
