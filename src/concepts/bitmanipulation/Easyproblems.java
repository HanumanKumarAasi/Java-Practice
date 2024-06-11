package concepts.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easyproblems {

	static void bitManipulation(int num, int i) {
        // code here
		System.out.print((num &(1<<(i-1)))==0?0:1);
        
        System.out.print(" "+ (num|(1<<i-1)));
        
        System.out.print(" "+(num&(~(1<<(i-1)))));
        
        
        
    }
	
	static boolean checkKthBit(int n, int k)
    {
        // Your code here
        return (((n >> k)&1) != 0);
    }
	
	static String oddEven(int N){
        // code here
        return (N&1)!=0?"odd":"even";
    }
	
	public boolean isPowerOfTwo(int n) {
        if(n<=(-Math.pow(2,31)) || n==0) return false;
        return (n&(n-1))==0?true:false;
    }
	
	public static int countSetBits(int n){
	    
        // Your code here
        
        int count=1;
        
        if(n==0) {
        	return 0;
        }
        int temp=n;
        while((n&(n-1))!=0){
            count=count+1;
            n=(n&(n-1));
        }
        return count+countSetBits(temp-1);
    }
	
	static int setBit(int N){
        // code here
        return N|(N+1);
    }
	
	static List<Integer> get(int a,int b)
    {
        // code here
        List<Integer> list = new ArrayList<Integer>();
        
        a = a^b;
        b = b^a;
        a = a^b;
        list.add(a);
        list.add(b);
        
        return list;
    }
	
	//to find out the min bit flips we need to find how many flips we need to make to match with the goal, so for this operation we will be using xor(^) operation
	//it will tell how flips it requires to match the goal.
	
	public int minBitFlips(int start, int goal) {
        int ans = (start^goal);
        if(ans==0){
            return 0;
        }
        int count=1;
        while((ans&(ans-1))!=0){
            count=count+1;
            ans=(ans&(ans-1));
        }
        return count;
    }
	
	//power sets
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int total = (int)Math.pow(2,nums.length);
        int i=0;
        while(i<total){
        	int j=0;
            List<Integer> sublist = new ArrayList<Integer>();
            while(j<nums.length){
                if((i&(1<<j))!=0){
                    sublist.add(nums[j]);
                }
                j++;
            }
            list.add(sublist);
            i++; 
        }
        return list;
    }
	
	//finding the single number in an array where other numbers exists 2 times. we have performed xor operation where xor of 2 same number will be 0 and it returns the single number from an array.
	public int singleNumber(int[] nums) {
        int xor=0;
        for(int i:nums){
            xor = xor^i;
        }
        return xor;
    }
	
	public static int findXOR(int l, int r) {
        
        return (xorFunc(l-1)^xorFunc(r));
    }
    
    
    static int xorFunc(int n){
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        if(n%4==3) return 0;
        if(n%4==0) return n;
        
        return -1;
    }
	
	public static int[] twoOddNum(int Arr[], int N)
    {
        int xor = 0;
        
        for(int i:Arr){
            xor = xor^i;
        }
        
        int rightmost = (xor&(xor-1))^xor;
        
        int bucket1 = 0;
        
        int bucket2 = 0;
        
        for(int i:Arr){
            if((rightmost&i)!=0){
                bucket1 = bucket1^i;
            }else{
                bucket2 = bucket2^i;
            }
        }
        
        int res[] = {-1,-1};
        
        if(bucket1>bucket2){
            res[0] = bucket1;
            res[1] = bucket2;
        }else{
            res[0] = bucket2;
            res[1] = bucket1;
        }
        
        
        return res;
    }
	
	public static int divide(int dividend, int divisor) {
        
        if(dividend==divisor){
            return 1;
        }

        boolean sign =true;

        if(dividend>=0 && divisor<0){
            sign=false;
        }else if(dividend<=0 && divisor>0) {
            sign=false;
        }

        long n = Math.abs((long)dividend);

        long d = Math.abs((long)divisor);
        int ans=0;
        while(n>=d){
            int count =0;

            while(n>=(d<<(count+1))){
                count+=1;
            }

            ans += (1<<count);
            n = n - (d<<(count));
        }

        if((ans==(1<<31)) && sign){
            return Integer.MAX_VALUE;
        }else if((ans==(1<<31)) && !sign){
            return Integer.MIN_VALUE;
        }
        if(!sign){
            return -1* ans;
        }
        return ans;
        
    }
	
	
	public static void main(String args[]) {
		int arr[] = {37,30,12,12,19,19,30,19,19,37,12,2,2,19,37,2,12,2,12,19,46,2,2,2,37,12,12,37,2,2,27,19,46,12,2,37,12,12};
		System.out.println(twoOddNum(arr,38));
	}
	
}
