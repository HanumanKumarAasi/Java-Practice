package concepts.stack;

public class MainStack {
	
	
	public static void main(String args[]) {
		StackUsingLinkedList llStack = new StackUsingLinkedList();
		llStack.push(1);
		llStack.push(2);
		llStack.push(3);
		llStack.push(4);
		llStack.push(5);//push operation
		
		System.out.println(llStack.pop()); // pop operation
		System.out.println(llStack.peek());// peek operation
		System.out.println(llStack.display());// display operation
		System.out.println(llStack.is_Empty());// isEmpty? 
		//System.out.println(llStack.is_Full());// isFull?
		
		int[] arr1 = {1, 7, 9, 5};
		System.out.println(new MonotonicIncreasingStack().monotonicIncreasingStack(arr1).display()); // 5 1
		System.out.println(new MonotonicDecreasingStack().monotonicDecreasingStack(arr1).display()); // 5 9
	}

}
