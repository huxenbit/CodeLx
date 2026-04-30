public class Motorcycle extends Vehicle implements Motor {
	
	public void breaking() {
		System.out.println("Breaking..!");
	}

	public void useFuel(double miles) {
		for (double i = miles; i > 0; i--) {
			if (fuel >= 0.2) {
				fuel = fuel - 0.2;
			} else {
				System.out.println("Ran out of fuel!");
				break;
			}
		}
		System.out.println("Rest fuel: " + fuel);

	}
}