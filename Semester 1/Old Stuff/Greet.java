import java.util.*;

class Greet {
	public static void main (String[] agrs) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Gib deinen Namen ein.");
		String name = scanner.next();
		System.out.println("Hallo, " + name);
	}
}