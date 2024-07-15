package concepts.greedy.algorithms;

import java.util.Arrays;

public class AssignCookiesTwoPointersApproach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int g[] = {1,2};
		int s[] = {1,2,3};
		
		System.out.println(findContentChildren(g,s));
		

	}
	//TC:  O(NlogN + MlogM + min(m,n)) SC: O(1)
	public static int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int l=0,r=0;
        //l is the pointer for moving towards the sizes of m cookies
        //r is the pointer for moving towards the n childrens
        while(l<m && r<n){ //l point should alwyas be less than m cookies
            if(s[l]>=g[r]){
                //if this conditions matched the we have assigned cookies to one of the children
                r=r+1;//moving to next children
            }
            l=l+1;
        }
        return r; // returning number of childrens got assigned wwith cookies
    }
	
	

}
