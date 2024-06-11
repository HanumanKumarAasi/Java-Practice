package concepts.custom_DS.queue;

public class QueueUsingLinkedList {
	
	Node front;
	
	Node rear;
	
	public QueueUsingLinkedList() {
		front = rear = null;		
	}
	
	public boolean enqueue(Integer ele) {
		Node temp = new Node(ele);
		if(front==null) {
			front = rear = temp;
		}else {
			rear.next = temp;
			rear = rear.next;
		}
		return true;
	}
	
	public void dequeue() {
		if(front!=null) {
			front = front.next;
		}
	}
	
	public void display() {
		Node temp = front;
		while(temp!=null) {
			System.out.printf("%d <-- ",temp.data);
			temp=temp.next;
		}
	}
	
	public int size() {
		Node temp = front;
		int size=0;
		while(temp!=null) {
			size+=1;
			temp=temp.next;
		}
		return size;
	}
	
	public Integer peek() {
		if(front!=null) {
			return front.data;
		}
		return null;
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

