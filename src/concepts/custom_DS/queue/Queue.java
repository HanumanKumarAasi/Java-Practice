package concepts.custom_DS.queue;

import java.util.Arrays;

public class Queue {
	
	Integer front;
	
	Integer rear;
	
	int capacity;
	
	Integer[] queue;
	
	public Queue(int capacity) {
		front=rear=0;
		this.capacity = capacity;
		queue = new Integer[capacity];
	}
	
	
	public boolean enqueue(Integer element) {
		
		if(rear==capacity) {
			System.out.println("Queue is Full....but trying to add...");
			queue = Arrays.copyOf(queue, size()+1);
		}
		
		queue[rear] = element;
		rear++;//incrementing the rear for adding the next element
		
		return true;
	}
	
	public void dequeue() {
		if(front==rear) {
			System.out.println("Queue is empty");
		}
		
		for(int i=0;i<rear-1;i++) { //rear will always points to the next to the end element
			queue[i]=queue[i+1];
		}
		
		if(rear-1<capacity) {
			queue[rear-1]=null; // pointing the last element to zero
		}
		rear--;//decrementing the rear as the we removed one element from the queue
	}
	
	public Integer peek() {
		if(front==rear) {
			System.out.println("Queue is empty");
			return null;
		}
		
		return queue[front];
	}
	
	public int size() {
		return rear;
	}
	
	public void display() {
		if(front==rear) {
			System.out.println("Queue is empty..");
		}
		
		for(int i=0;i<rear;i++) {
			System.out.printf("%d <--" , queue[i]);
		}
	}
	
	

}
