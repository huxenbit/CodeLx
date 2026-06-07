package de.htwsaar.esch.Codeopolis.DomainModel;

import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;
import java.io.Serializable;

/**
 * The Silo class represents a storage unit for a specific type of grain.
 */
public class Silo implements Serializable, Comparable<Silo> {
    private LinkedList<Harvest> stock;
    Status status;
    private Game.GrainType grainType;

    /**
     * Constructs a Silo object with the specified initial capacity.
     *
     * @param capacity The initial capacity of the silo.
     */
    public Silo(int capacity) {
        status = new Status(capacity);
        this.stock = new LinkedList<>();
    }

    @Override
    public int compareTo(Silo other) {
        return Integer.compare(this.getFillLevel(),
                other.getFillLevel());
    }

    /**
     * Copy constructor for the Silo class.
     * Creates a new Silo object as a deep copy of another Silo object.
     * This constructor is used to ensure that each property of the Silo,
     * including mutable objects, is copied and independent of the original object.
     *
     * @param other The Silo object to copy.
     */
    public Silo(Silo other) {
        status = new Status(other.status.capacity);
        status.fillLevel = other.status.fillLevel;

        stock = new LinkedList<>();

        LinkedList.Iterator<Harvest> it = other.stock.iterator();

        while (it.hasNext()) {
            stock.addLast(it.next().copy());
        }
    }

    /**
     * Stores a harvest in the silo if there is available capacity.
     *
     * @param harvest The harvest to be stored in the silo.
     * @return The amount of grain that could not be stored due to capacity limitations.
     */
    public Harvest store(Harvest harvest) {

        if (grainType == null) {
            grainType = harvest.getGrainType();
        }

        if (grainType != harvest.getGrainType()) {
            throw new IllegalArgumentException(
                    "The grain type of the given Harvest does not match the grain type of the silo");
        }

        int remainingCapacity = status.capacity - status.fillLevel;

        if (remainingCapacity <= 0) {
            return harvest;
        }

        if (harvest.getAmount() <= remainingCapacity) {

            stock.addLast(harvest);
            status.fillLevel += harvest.getAmount();

            return null;
        }

        Harvest storedPart = harvest.split(remainingCapacity);

        stock.addLast(storedPart);
        status.fillLevel += storedPart.getAmount();

        return harvest;
    }


    /**
     * Empties the silo by removing all stored harvests and returning them.
     *
     * @return An array containing all the removed harvests from the silo.
     *         If the silo is empty, an empty array is returned.
     */
    public Harvest[] emptySilo() {

        if (stock.isEmpty()) {
            return new Harvest[0];
        }

        Harvest[] removed = new Harvest[stock.size()];

        final int[] index = {0};

        stock.forEach(h -> removed[index[0]++] = h);

        stock.clear();

        status.fillLevel = 0;
        grainType = null;

        return removed;
    }

    /**
     * Takes out a specified amount of grain from the silo.
     *
     * @param amount The amount of grain to be taken out.
     * @return The actual amount of grain taken out from the silo.
     */
    public int takeOut(int amount) {

        int takenAmount = 0;
        int index = 0;

        while (index < stock.size() && amount > 0) {

            Harvest currentHarvest = stock.get(index);

            int taken = currentHarvest.remove(amount);

            amount -= taken;
            takenAmount += taken;

            if (currentHarvest.getAmount() == 0) {
                stock.remove(index);
            } else {
                index++;
            }
        }

        status.fillLevel -= takenAmount;

        return takenAmount;
    }

    /**
     * Gets the current fill level of the silo.
     *
     * @return The number of harvests currently stored in the silo.
     */
    public int getFillLevel() {
    	return status.fillLevel;
    }

    /**
     * Gets the capacity of the silo.
     *
     * @return The maximum number of harvests the silo can store.
     */
    public int getCapacity() {
        return status.capacity;
    }

    /**
     * Gets the grain type stored in the silo.
     *
     * @return A string representation of the grain type.
     */
    public Game.GrainType getGrainType() {
        return grainType;
    }

    /**
     * Retrieves the number of harvests currently stored in the silo.
     *
     * @return The number of harvests stored in the silo.
     */
    public int getHarvestCount() {
        return stock.size();
    }

    /**
     * Simulates the decay of grain in all harvests stored in the silo over time.
     *
     * @param currentYear The current year used to calculate the decay.
     * @return The total amount of grain that decayed in all harvests in the silo.
     */
    public int decay(int currentYear) {

        final int[] totalDecayedAmount = {0};

        stock.forEach(h -> totalDecayedAmount[0] += h.decay(currentYear));

        status.fillLevel -= totalDecayedAmount[0];

        return totalDecayedAmount[0];
    }

    public class Status {
        private int capacity;
        private int fillLevel;

        private Status(int capacity) {
            this.capacity = capacity;
            this.fillLevel = 0;
        }

        public int getFillLevel() {
            return fillLevel;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    public Status getStatus(int capacity) {
        return new Status(capacity);
    }
}

