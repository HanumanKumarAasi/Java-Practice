package concepts.greedy.algorithms;

public class LemanadeChange {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {5,5,10,10,5,20,5,10,5,5};
		
		System.out.println(lemonadeChange(arr));

	}
	//TC: O(N) SC:O(1)
	public static boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;// for recording the 5's , 10's and 20's count

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){ 
                five++; //if customer gives 5 we are incrementing five 1
            }else if(bills[i]==10 && five>0){
                ten++; //if customer gives 10 we are incrementing 10 1
                five--; //return change 5 to customer returning 5 back to them
            }else if(bills[i]==20 && (five>0 && ten>0)){
                
                five--; //if 20 we need to return 10 and 5 if we have 10 and 5 rupees coins
                ten--;
            }else if(bills[i]==20 && (five>=3)){
                
                five= five-3; //if we dont have 10 the for 20 we need to return 3 5 rupees
            }else{
                return false;
            }
        }

        return true;
    }

}
