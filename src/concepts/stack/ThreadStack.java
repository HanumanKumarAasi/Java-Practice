package concepts.stack;

public class ThreadStack {
	
	int array[];
	int stackTop;
	Object lock;
	//here the lock is optional used for synchronization concept for thread locking
	public ThreadStack(int capacity) {
		array = new int[capacity];
		stackTop=-1;
		lock = new Object();
	}
	
	public boolean push(int ele) {
		synchronized(lock) {
			if(isFull()) return false;
			++stackTop;
			
			try {
				Thread.sleep(1000);
			}catch(Exception e){
				
			}
			array[stackTop] = ele;
			return true;
		}		
		
	}
	
	public synchronized int pop() {
		
		if(isEmpty()) return Integer.MIN_VALUE;
		
		try {
			Thread.sleep(1000);
		}catch(Exception e){
			
		}
		
		int obj = array[stackTop];
		 array[stackTop] = Integer.MIN_VALUE;
		 stackTop--;
		 return obj;
		
	}
	
	public synchronized int peek() {
		
		if(isEmpty()) return Integer.MIN_VALUE;
		
		try {
			Thread.sleep(1000);
		}catch(Exception e){
			
		}
		
		return array[stackTop];
	}
	
	
	
	
	
	public boolean isEmpty() {
		return stackTop<0;
	}
	
	public boolean isFull() {
		return stackTop>=array.length-1;
	}

}
