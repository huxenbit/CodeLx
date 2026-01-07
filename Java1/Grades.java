import java.util.Random;

public class Grades {
	private int[] grades;

	public void fillArray() {
		Random numGen = new Random();
		grades = new int[21];
		for (int i = 0; i < grades.length; i++) {
			grades[i] = numGen.nextInt(100) + 1;
		}
	}

	public int get(int index) {
		return grades[index];
	}

	public void set(int index, int value) {
		grades[index] = value;
	}

	public int average() {
		int sum = 0;
		for (int grade : grades) {
			sum += grade;
		}
		if (grades.length != 0) {
			System.out.println("Calculating: " + sum + " / " + grades.length);
			sum = sum / grades.length;
			return sum;
		}
		return 0;
	}

	public void findLowHigh() {
		int avg = average();

		for (int grade : grades) {
			if (grade >= avg) {
				System.out.println(grade + " is bigger or equals the average of " + avg);
			} else {
				System.out.println(grade + " is lower than the average of " + avg);
			}
		}
	}
}