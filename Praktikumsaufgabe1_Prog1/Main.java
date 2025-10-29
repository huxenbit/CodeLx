import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int age;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Wie alt bist du?: ");
		age = scanner.nextInt();

		if (age > 50) {
			System.out.println("Wow, " + age + "?!");
		} else {
			System.out.println("Also bist du " + age + "... ziemlich Jung.");
		}
	}
}