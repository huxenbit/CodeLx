import java.util.Scanner;

class TemperatureConverter {
	
	private float celsius;
	private float fahrenheit;
	private Scanner scanner;

	TemperatureConverter(Scanner scanner) {
		this.scanner = scanner;
	}

	void convertCelsius(float celsius) {

		fahrenheit = (celsius * (9f/5f)) + 32f;
		System.out.println("Celsius: " + celsius + " Fahrenheit: " + fahrenheit);
	}

	void convertFahrenheit(float fahrenheit) {

		celsius = ((fahrenheit - 32f) * (5f/9f));
		System.out.println("Fahrenheit: " + fahrenheit + " Celsius: " + celsius);
	}

	void inputCelsius() {

		System.out.print("Gib Celsius an: ");
		this.celsius = scanner.nextFloat();
		System.out.println("Du hast eingegeben: " + getCelsius());
	}


	void inputFahrenheit() {

		System.out.print("Gib Fahrenheit an: ");
		this.fahrenheit = scanner.nextFloat();
		System.out.println("Du hast eingegeben: " + getFahrenheit());
	}

	float getCelsius() {

		return this.celsius;
	}

	float getFahrenheit() {

		return this.fahrenheit;
	}
}