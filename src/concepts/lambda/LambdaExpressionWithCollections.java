package concepts.lambda;

import java.util.ArrayList;
import java.util.Collections;

public class LambdaExpressionWithCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(205);
        al.add(102);
        al.add(98);
        al.add(275);
        al.add(203);
        System.out.println("Elements of the ArrayList " + 
                              "before sorting : " + al);
        
        
        ArrayListCustomCompareWithLambda(al);

	}
	
	public static void ArrayListCustomCompareWithLambda(ArrayList<Integer> al){
		
        // using lambda expression in place of comparator object
        Collections.sort(al, 
        		(o1, o2) -> (o1 > o2) ? -1 
        				:
                          (o1 < o2) ? 1 
                        		  : 0);
 
        System.out.println("Elements of the ArrayList after" + 
                                           " sorting : " + al);
	}

}
