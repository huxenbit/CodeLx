import java.util.Arrays;

public class Search {

	public int linearSearch(int[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == k) {
				return i;
			}
		}
		return -1;
	}

	public int binarySearch(int[] a, int k) {
		int l = 0;
		int r = (a.length - 1);

		while (l <= r) {
			int m = ((l + r) / 2);
			if (k < a[m]) {
				r = (m - 1);
			} else if (k == a[m]) {
				return m;
			} else {
				l = (m + 1);
			}
		}
		return -1;
	}

	//Laufzeit O(n)
	public int findeEinzigartig(int[] a) {
	    for (int i = 0; i < a.length; i++) {
	        int current = a[i];
	        int count = 0;

	        for (int j = 0; j < a.length; j++) {
	            if (a[j] == current) {
	                count++;
	            }
	        }

	        if (count == 1) {
	            return current;
	        }
	    }

	    return -1; // Falls keine eindeutige Zahl existiert
	}

	public int findFriend(String[] schlange) {
	    int count = 0;

	    // Alle Dreiergruppen prüfen
	    for (int i = 0; i <= schlange.length - 3; i++) {
	        int numBlue = 0;
	        int numYellow = 0;

	        for (int j = i; j < i + 3; j++) {
	            if (schlange[j].equals("blue")) {
	                numBlue++;
	            } else if (schlange[j].equals("yellow")) {
	                numYellow++;
	            }
	        }

	        // Prüfen, ob 1 blau und 2 gelb
	        if (numBlue == 1 && numYellow == 2) {
	            // Zähle die blaue Maske in der Gruppe als möglicher Freund
	            for (int j = i; j < i + 3; j++) {
	                if (schlange[j].equals("blue")) {
	                    count++;
	                }
	            }
	        }
	    }

	    return count;
	}

	public int quersummeReduzieren(int n) {
		while (n >= 10) { //wenn n 2-stellig
			int sum = 0;
			while (n > 0) {
				sum += n % 10; //addiere letzte Ziffer von n mit sum
				n /= 10; //entferne letzte Ziffer von n
			}
			n = sum; //weise n sum zu
		}
		return n;
	}
}