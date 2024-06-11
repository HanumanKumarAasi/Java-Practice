package concepts.custom_DS.stack;

public class StackUsingLinkedList {
	
	Node top;
	
	public StackUsingLinkedList() {
		this.top = null;
	}
	
	
	public boolean push(Integer ele) {
		Node temp = new Node();
		temp.data = ele;
		temp.next = top;
		top = temp;
		return true;
	}
	
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public Integer peek() {
		return top!=null?top.data:null;
	}
	
	public Integer pop() {
		if(top==null) {
			return null;
		}
		Integer poppedelement = top.data;
		top = top.next;
		return poppedelement;
	}
	
	public int size() {
		int size=0;
		Node temp = top;
		while(temp!=null) {
			size++;
			temp=temp.next;
		}
		return size;
	}
	
	public Integer[] toArray() {
		Integer stack[] = new Integer[size()];
		Node temp = top;
		int i=0;
		while(temp!=null) {
			stack[i] = temp.data;
			temp = temp.next;
			i=i+1;
		}
		return stack;
	}

}

class Node{
	
	Integer data;
	Node next;
	
	public Node() {
		
	}
	
	public Node(Integer data) {
		this.data = data;
		this.next = null;		
	}
	
	public Node(Integer data, Node next) {
		this.data = data;
		this.next = next;
	}
}
