import java.util.Scanner;

public class TemperatureConverterTestDrive {
	

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		TemperatureConverter tc = new TemperatureConverter(scanner);

		tc.inputCelsius();
		tc.convertCelsius(tc.getCelsius());
		tc.inputFahrenheit();
		tc.convertFahrenheit(tc.getFahrenheit());

		scanner.close();
	}
}