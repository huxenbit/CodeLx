public class LinearSearchTestDrive {
	public static void main(String[] args) {
		Search search = new Search();
		int[] array = {3,7,2,1,0,9,4,8,6,5};
		int[] array2 = {0,1,7,12,23,33,34,44,83,91};
		int[] array3 = {19, 0, 3, 77, 3, 0, 19, 19};

		System.out.println(search.linearSearch(array, 8));
		System.out.println(search.binarySearch(array2, 83));
		System.out.println(search.binarySearch(array2, 42));
		System.out.println(search.findeEinzigartig(array3));
		System.out.println(search.quersummeReduzieren(78));
	}
}