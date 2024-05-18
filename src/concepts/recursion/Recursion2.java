package concepts.recursion;

import java.util.ArrayList;

public class Recursion2 {
	
	public static void main(String args[]) {
		
	}
	
	public int[] printNos(int x) {
		ArrayList<Integer> num = new ArrayList<Integer>();

        if (x < 1) {

            return new int[0]; // Return an empty array if x is less than 1

        } else {

            int[] result = printNos(x - 1); // Recursive call to get the array for x-1

            for (int i : result) {

                num.add(i); // Add elements from the result of the recursive call

            }

            num.add(x); // Add the current number x

        }

        int[] arr = new int[num.size()];

        for (int i = 0; i < num.size(); i++) {

            arr[i] = num.get(i); // Convert ArrayList to array

        }

        return arr;
	}

}
