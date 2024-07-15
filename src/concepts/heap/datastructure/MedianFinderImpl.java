package concepts.heap.datastructure;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinderImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(-1);    // arr = [1]
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(-2);    // arr = [1, 2]
		System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(-3);    // arr[1, 2, 3]
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(-4);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(-5);
		System.out.println(medianFinder.findMedian()); // return 2.0
		 

	}

}

class MedianFinder {
    PriorityQueue<Integer> small; //stores smaller values
    PriorityQueue<Integer> large; // stores larger values
    boolean even;
    public MedianFinder() {
        small = new PriorityQueue<>((a,b) -> b-a);
        large = new PriorityQueue<>();
        even = true;
    }
    //logn but for n addition it will be nlogn
    public void addNum(int num) {
        if(even){
            large.add(num);
            small.add(large.poll()); //large always return smaller value
        }else{
            small.add(num);
            large.add(small.poll()); //small always return larger value
        }
        even = !even;
    }
    //o(1)
    public double findMedian() {
        if(even){
            return (double)(small.peek()+large.peek())/2; //if even length the taking up larger value from small and smaller value from large
        }
        return (double)small.peek(); //else returning larger value from small;
    }
}