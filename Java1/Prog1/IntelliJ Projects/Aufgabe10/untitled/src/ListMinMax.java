import java.util.ArrayList;

public class ListMinMax {
    public static int min(ArrayList<Integer> list) {

        //Wenn Liste null oder leer gib MAX VALUE aus
        if (list == null || list.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        //Nehme die erste Zahl und schaue, ob kleinere in der Liste existieren
        int min = list.getFirst();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                //Setze min auf Wert der niedrigeren Zahl
                min = list.get(i);
            }
        }
        return min;
    }

    public static int max(ArrayList<Integer> list) {

        //Wenn Liste null oder leer gib MIN VALUE zurück
        if (list == null || list.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        //Nehme die erste Zahl und schaue, ob größere in der Liste existieren
        int max = list.getFirst();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                //Setze max auf den Wert der größeren Zahl
                max = list.get(i);
            }
        }
        return max;
    }
}
