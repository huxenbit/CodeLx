public class SpeedOfLight {
	public static final long SPEED = 299_792_458; // m pro sek

	static double fraction(double factor) {
		return ((double) SPEED) * factor;
	}
}