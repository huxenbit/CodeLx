public class PlantTestDrive {
	
	public static void main(String[] args) {

		Plant plant = new Plant();
		Plant plant2 = new Plant();

		plant2.setHeight(9.0);
		plant2.setType("Tree");
		plant2.setWaterLevel(5);
		plant2.setIsEqual();

		plant.setHeight(9.0);
		plant.setType("Tree");
		plant.setWaterLevel(5);
		plant.setIsEqual();

		System.out.println(plant.getHeight() + " " + plant.getType() + " " + plant.getWaterLevel());
		System.out.println(plant.getIsEqual());

		plant.grow(4);
		plant.grow(7);
		plant.grow(8);

		if (plant.needsWater() == true) {
			plant.water(3);
		}

		System.out.println(plant.getHeight() == plant2.getHeight());
		System.out.println(plant.getType().equals(plant2.getType()));

	}
}