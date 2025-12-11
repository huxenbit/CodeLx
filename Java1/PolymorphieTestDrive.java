import java.util.Random;

public class PolymorphieTestDrive {
	public static void main(String[] args) {
		Random numGen = new Random();
		
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();

		Motorcycle mtc1 = new Motorcycle();
		Motorcycle mtc2 = new Motorcycle();
		Motorcycle mtc3 = new Motorcycle();

		Bicycle bic1 = new Bicycle();
		Bicycle bic2 = new Bicycle();
		Bicycle bic3 = new Bicycle();

		Vehicle[] vehicles = new 

		Vehicle[] {
			car1,
			car2,
			car3,
			mtc1,
			mtc2,
			mtc3,
			bic1,
			bic2,
			bic3
		};

		for (int i = 0; i < 10; i++) {
			for (Vehicle vh : vehicles) {
				if (vh instanceof Motor) {
					vh.fuel = numGen.nextDouble(237);
					double miles = numGen.nextDouble(101);
					((Motor) vh).useFuel(miles);
				} else {
					System.out.println("Vehicle uses no fuel!");
				}

			}
		}
	}
}