package concepts.slidingwindow_twopointers;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasketsProblem {
	
	/*Fruit Into Baskets

	 * 
	 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits of size N, where fruits[i]  is the type of fruit the ith tree produces.
		You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow :
		
		You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
		Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of the baskets.
		Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
		Given the integer array fruits, return the maximum number of fruits you can pick.
		
		
		Example 1:
		
		Input:
		N = 3
		fruits [ ] = { 2, 1, 2 }
		Output: 3
		Explanation: We can pick from all three trees. 
		 
		
		Example 2:
		
		Input:
		N = 6
		fruits [ ] = { 0, 1, 2, 2, 2, 2 }
		Output: 5
		Explanation: It's optimal to pick from trees(0-indexed) [1,2,3,4,5].
		
		Your Task:
		You don't need to read input or print anything. Your task is to complete function totalFruits() which takes the integer array fruits and its size N as input parameters and returns the maximum number of fruits that you can pick.
		Expected Time Complexity: O(N).
		Expected Auxiliary Space: O(1).
		
		
		Constraints:
		1 ≤ N ≤ 105
		0 ≤ fruitsi < N
	 */
	
public static int totalFruits(int N, int[] fruits) {
        
        int l=0,r=0,maxlen=0;
        Map<Integer,Integer> mpp = new HashMap<Integer,Integer>();
        
        while(r<fruits.length){
            if(mpp.get(fruits[r])!=null){
                mpp.put(fruits[r],mpp.get(fruits[r])+1);
            }else{
                mpp.put(fruits[r],1);
            }
            
            if(mpp.size()>2){
                mpp.put(fruits[l],mpp.get(fruits[l])-1);
                if(mpp.get(fruits[l])==0){
                    mpp.remove(fruits[l]);
                }
                l++;
            }
            
            if(mpp.size()<=2){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }

}
