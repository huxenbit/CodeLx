import java.util.Scanner;

class FactorialBitflip {
	long input;
	long factorial = 1;
	long x = 1;
	long result = 0;
	boolean again = true;

	public static void main(String[] args) {
		FactorialBitflip f = new FactorialBitflip();
		Scanner scanner = new Scanner(System.in);

		while (f.again) {
			System.out.print("Gib deine gewünschte Fakultät ein: ");

			if (scanner.hasNextLong()) {
				f.input = scanner.nextLong();
				f.x = 1;
				f.result = 1;
				f.factorial = 1;
			} else {
				System.out.println("Gib eine gültige Zahl ein! Wiederhole...");
				scanner.next();
				continue;
			}

			while (f.x <= f.input) {
				f.result = f.x * f.factorial;
				f.factorial = f.result;
				f.x = f.x + 1;
			}

			System.out.println("Das Ergebnis ist: " + f.result);
			System.out.print("Nochmal? J/N: ");
			char answer = scanner.next().charAt(0);
			answer = Character.toLowerCase(answer);

			switch(answer) {
				case 'j': 
					f.again = true; 
					break;

				case 'n': 
					f.again = false; 
					break;

				default:
					System.out.println("Ungültige Eingabe wird als 'weiter' gewertet."); 
					f.again = true; 
					break;
			}
		}
		System.out.println("");
		System.out.println("Auf wiedersehen!");
		System.out.println("");
	}
}
