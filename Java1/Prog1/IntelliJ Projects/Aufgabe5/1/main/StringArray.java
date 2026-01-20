package main;

import java.util.Arrays;

public class StringArray {
	
	private String[] stArray = new String[10];
	private int count = 0;

	public String get(int index) {
		if (index < 0 || index >= stArray.length) { //Check if index is below zero or not available
			System.out.println("Error at getting! Invalid index");
			return null;
		} 

		return stArray[index]; //return value
	}

	public void set(int index, String text) {
		if (index < 0 || index >= stArray.length) { //Check if index is below zero or not available
			System.out.println("Error at setting! Invalid index!");
			return;
		}
		if (text == null) {
			System.out.println("Error at setting! Invalid text!"); //Check if text is valid
			return;
		}
		if (stArray[index] == null) { //Counting up when adding values
			count++;
		}

		stArray[index] = text; //Set array at given index
	}

	public int size() {
		return count;
	}

	public void remove(int index) {
		if (index < 0 || index >= stArray.length || stArray[index] == null) { //Check if index is below zero or not available
			System.out.println("Error at removing! Invalid index!");
			return;
		}
		stArray[index] = null;
		count--; //Counting down when removing values
	}

 	public int add(String text) {
        if (text == null) { // Check if text is valid
            System.out.println("Error at adding! Invalid text!");
            return -1;
        }
        int slot = findSlot();
        if (slot != -1) { 
        	set(slot, text);
        	return slot;
        }

        int newLength = stArray.length + (stArray.length / 2); //Setting new size 1.5 times bigger
        String[] copy = new String[newLength]; //Creating copy of String Array
        for (int j = 0; j < copy.length; j++) {
        	if (copy[j] == null) { //copying process
        		copy[j] = stArray[j];	
        	}
        }
        stArray = copy; //Finally resizing String Array

        slot = findSlot();
        if (slot != -1) { 
        	set(slot, text);
        	return slot;
        }        
        return -1;
    }

    //Find a free slot in String Array
    private int findSlot() {
        for (int i = 0; i < stArray.length; i++) {
        	if (stArray[i] == null) {
        		return i; //returns used index
        	}
        }
        return -1;
    }
}