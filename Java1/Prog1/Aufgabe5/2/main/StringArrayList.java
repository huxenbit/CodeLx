package main;

import java.util.Arrays;
import java.util.ArrayList;

public class StringArrayList {
	
	private ArrayList<String> stArray = new ArrayList<>();

	public String get(int index) {
		return stArray.get(index);
	}

	public void set(int index, String text) {
		//Catching if non-used index is given
		if (index < stArray.size()) {
			stArray.set(index, text);
		} else if (index == stArray.size()) {
			stArray.add(text);
		} else {
			return;
		}
	}

	public int size() {
		return stArray.size(); 
	}

	public void remove(int index) {
		stArray.remove(index);
	}

 	public int add(String text) {
 		stArray.add(text);
 		return stArray.indexOf(text);
    }

    public boolean contains(String text) {
    	if (stArray.contains(text)) { //Check if array contains text
    		return true;
    	} else {
    		return false;
    	}
    }

    public void clear() {
    	System.out.println("Clearing: " + stArray.toString());
		for (int i = stArray.size() - 1; i >= 0; i--) { //Iterate backwards through array and clear values
		    stArray.remove(i);
		}
		System.out.println("Cleared: " + stArray.toString());
    }

    public String[] toArray() {
    	String[] array = new String[size()];
    	for (int i = 0; i < array.length; i++) { //Iterate through new Array and set values at right indizes
    		array[i] = stArray.get(i);
    	}
    	return array;
    }

    public boolean isEmpty() {
    	return stArray.isEmpty();
    }
}