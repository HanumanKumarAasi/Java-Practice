package concepts.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
	
	private Queue<Integer> q;
	
	private int capacity;
	
	public BlockingQueue(int capacity) {
		q = new LinkedList<Integer>();
		this.capacity = capacity;
		
	}
	
	
	
	public boolean add(int ele) {
		synchronized(q) {
			while(q.size()>=capacity) {
				try {
					/*
					 * Here there is a chance of multiple threads(thread1, thread2) gets waited in
					 * it, so when notifyall gets called these threads will get awakened and starts
					 * processing
					 */					
					q.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
				q.add(ele);
				q.notifyAll();
				return true;
		}
	}
	
	public int remove() {
		
		synchronized(q) {
			while(q.size()==0) {
				try {
					q.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		 int i = q.poll();
		 q.notifyAll();
		 return i;
		}
		
	}

}
