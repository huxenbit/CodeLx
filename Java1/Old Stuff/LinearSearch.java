public class LinearSearch {

	public int linearSearch(int[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == k) {
				return i;
			}
		}
		return -1;
	}
}