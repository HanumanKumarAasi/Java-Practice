package concepts.greedy.algorithms;

import java.util.Arrays;

public class FractionalKnapSnack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Item arr[] = {new Item(8,10), new Item(2,1), new Item(10,7), new Item(1,7),
				new Item(9,5), new Item(7,1), new Item(2,8), new Item(6,6), new Item(4,8), new Item(9,7)};
		
		double res = fractionalKnapsack(21, arr, 10);
		
		System.out.println(res);

	}
	
	static double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        
		//1. sort Value/weight
        Arrays.sort(arr,(a,b)->{
        return Double.compare((double)(b.value)/(double)(b.weight), (double)(a.value)/(double)(a.weight));
        });
         
        int currWeight=0;
        double currValue=0;
         
        //traverse the array
        for(int i=0; i<n; i++){
         
        if(currWeight+arr[i].weight<=W){
        currWeight+=arr[i].weight;
        currValue+=arr[i].value;
         
        }else{
        int remaining=W-currWeight;
        currValue+= (double)(arr[i].value)/(double)(arr[i].weight) * (double)remaining;
        break;
        }
        }
         
        return currValue;
    }

}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}