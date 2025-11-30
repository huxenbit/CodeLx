public class SpeedConverterTestDrive {
	
	public static void main(String[] args) {
		SpeedConverter converter  = new SpeedConverter();

		System.out.println("# Speed Converter");
		System.out.println();

		System.out.println("Test #1: km/h -> mp/h");
		test(19.88813f, converter.convertKmhToMph(32f));
		System.out.println();

		System.out.println("Test #2: km/h -> mp/h");
		test(32f, converter.convertMphToKmh(19.88813f));
		System.out.println();
	}

	static void test(float expected, float actual) {
		if (Math.abs(expected - actual) < 0.01f) {
			System.out.println("PASS:\nExpected: " + expected + " - Actual: " + actual);
		} else {
			System.out.println("NOT PASSED:\nExpected: " + expected + " - Actual:" + actual);
		}
	}
}