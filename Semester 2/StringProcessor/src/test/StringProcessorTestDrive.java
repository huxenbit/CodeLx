package test;

import main.StringProcessor;
import main.LinkedList;

public class StringProcessorTestDrive {
    LinkedList<String> names = new LinkedList<>();

    public static void main(String args[]) {
        StringProcessorTestDrive testDrive = new StringProcessorTestDrive();
        testDrive.names.addLast("lars ");
        testDrive.names.addLast("Doldde ");
        testDrive.names.addLast("Gianluca");
        testDrive.names.addLast(" scuzzarella ");
        testDrive.names.addLast("Bruce");
        testDrive.names.addLast("wayne ");
        StringProcessor processor = new StringProcessor(testDrive.names);
        System.out.println("##############");

        //Test 1: Names with more than 5 letters
        testDrive.printTestsString(processor.filter(name -> name.length() > 5));
        System.out.println("##############");

        //Test 2: Names that start with uppercase
        testDrive.printTestsString(processor.filter(name -> !name.isEmpty() && Character.isUpperCase(name.charAt(0))));
        System.out.println("##############");

        //Test 3: Use .trim() via forEach()-Method
        processor.forEach(name -> System.out.println(name.trim()));
        System.out.println("##############");

        //Test 4: Use .toUpperCase() via forEach()-Method
        processor.forEach(name -> System.out.println(name.toUpperCase()));
        System.out.println("##############");

        //Test 5: Use String Builder to reverse Strings via forEach()-Method
        processor.forEach(name -> System.out.println(new StringBuilder(name).reverse()));
        System.out.println("##############");

        //Test 6: Use mapToInt() to turn Strings into their length-value
        testDrive.printTestsInt(processor.mapToInt(s -> s.length()));
        System.out.println("##############");

        //Test 7: Use mapToInt() to turn Strings into their capacity of the letter "a"
        testDrive.printTestsInt(processor.mapToInt(s -> {
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a') {
                    count++;
                }
            }

            return count;
        }));
        System.out.println("##############");

        //Test 8: Use forEach() to add "»" symbol before every String
        processor.forEach(name -> System.out.println("»" + name));
        System.out.println("##############");
    }

    public void printTestsString(LinkedList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void printTestsInt(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
