package concepts.stack;

public class StackUsingLinkedList {
	Node top;
	//int capacity;
	StackUsingLinkedList(int capacity){
		this.top =  null;
		//this.capacity = capacity;
	}
	
	StackUsingLinkedList(){
		this.top =  null;
	}
	
	int size() {
		Node temp = top;
		if(temp==null) {
			return 0;
		}
		int count=0;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	/*
	 * boolean is_Full() { if(size()==capacity) { return true; } return false; }
	 */
	
	boolean is_Empty() {
		if(size()==0) {
			return true;
		}
		return false;
	}
	
	
	boolean push(int data) {
		
		Node newNode = new Node(data);
		
		//checking if the size of the Stack is full or not
		/*
		 * if(size() == capacity) { return false; }
		 */
		
		if(top==null) {
			top = newNode;
		}else {
			Node nextNode = top;
			top = newNode;
			top.next = nextNode;
		}
		return true;
	}
	
	
	int pop() {
		int popped = Integer.MIN_VALUE;
		if(top!=null) {
			popped = top.data;
			top = top.next;
		}
		return popped;
	}
	
	int peek() {
		int peek_element = Integer.MIN_VALUE;
		if(top!=null) {
			peek_element = top.data;
		}
		return peek_element;
	}
	
	String display() {
		StringBuilder sb = new StringBuilder(" ");
		Node temp = top;
		while(temp!=null) {
			sb.append(temp.data).append(" ");
			temp=temp.next;
		}
		return sb.toString().trim();
	}
	
	
	/*
	 * StackUsingLinkedList monotonicIncreasingStack(int[] arr) { int n =
	 * arr.length;
	 * 
	 * StackUsingLinkedList sll = new StackUsingLinkedList(); for(int i=0;i<n;i++) {
	 * while(!sll.is_Empty() && sll.peek()>arr[i]) { sll.pop(); } sll.push(arr[i]);
	 * } return sll; }
	 */
	
	/*
	 * StackUsingLinkedList monotonicDecreasingStack(int[] arr) { int n =
	 * arr.length;
	 * 
	 * StackUsingLinkedList sll = new StackUsingLinkedList(); for(int i=0;i<n;i++) {
	 * while(!sll.is_Empty() && sll.peek()<arr[i]) { sll.pop(); } sll.push(arr[i]);
	 * } return sll; }
	 */
		

}

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}
