package concepts.stack;

public class MonotonicIncreasingStack {
	
	StackUsingLinkedList monotonicIncreasingStack(int[] arr) {
		int n = arr.length;
		
		StackUsingLinkedList sll = new StackUsingLinkedList();
		for(int i=0;i<n;i++) {
			while(!sll.is_Empty() && sll.peek()>arr[i]) {
				sll.pop();
			}
			sll.push(arr[i]);
		}
		return sll;
	}

}
