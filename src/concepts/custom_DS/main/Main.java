package concepts.custom_DS.main;

import concepts.custom_DS.queue.Queue;
import concepts.custom_DS.queue.QueueUsingCallStack;
import concepts.custom_DS.queue.QueueUsingLinkedList;
import concepts.custom_DS.stack.StackUsingArray;
import concepts.custom_DS.stack.StackUsingLinkedList;
import concepts.custom_DS.stack.StackUsingTwoQueues;

public class Main {
	
	public static void main(String args[]) {
		
		StackUsingArray stack =new StackUsingArray(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		
		/*
		 * System.out.println(stack.size());
		 * 
		 * for(Integer ele:stack.toArray()) { System.out.println(ele); }
		 * 
		 * System.out.println("Top of the stack is :  "+stack.top());
		 * 
		 * while(stack.size()!=0) { System.out.println("popped element :"+stack.pop());
		 * }
		 */
		
		
		StackUsingLinkedList stackLL = new StackUsingLinkedList();
		stackLL.push(1);
		stackLL.push(2);
		stackLL.push(3);
		stackLL.push(4);
		stackLL.push(5);
		stackLL.push(6);
		stackLL.push(7);
		stackLL.push(8);
		stackLL.push(9);
		stackLL.push(10);
		stackLL.push(11);
		stackLL.push(12);
		stackLL.push(13);
		
		/*
		 * System.out.println(stackLL.peek()); System.out.println(stackLL.size());
		 * for(Integer ele:stackLL.toArray()) { System.out.println("element is : "+ele);
		 * }
		 * 
		 * 
		 * while(stackLL.size()!=0) { System.out.println(stackLL.pop()); }
		 */
		
		
		StackUsingTwoQueues stackUsingQueue = new StackUsingTwoQueues();
		stackUsingQueue.push(1);
		stackUsingQueue.push(2);
		stackUsingQueue.push(3);
		stackUsingQueue.push(4);
		stackUsingQueue.push(5);
		System.out.println(stackUsingQueue.pop());
		System.out.println(stackUsingQueue.top());
		
		Queue queue = new Queue(10);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.enqueue(11);
		
		/*
		 * queue.display(); System.out.println();
		 * System.out.println("size : "+queue.size()); queue.dequeue(); queue.display();
		 * System.out.println(); System.out.println("size : "+queue.size());
		 * System.out.println("peek : "+queue.peek()); queue.enqueue(12);
		 * queue.display(); System.out.println();
		 * System.out.println("size : "+queue.size());
		 */
		
		QueueUsingLinkedList queueLL = new QueueUsingLinkedList();
		queueLL.enqueue(1);
		queueLL.enqueue(2);
		queueLL.enqueue(3);
		queueLL.enqueue(4);
		queueLL.enqueue(5);
		queueLL.enqueue(6);
		queueLL.enqueue(7);
		queueLL.enqueue(8);
		queueLL.enqueue(9);
		queueLL.enqueue(10);
		queueLL.enqueue(11);
		
		/*
		 * queueLL.display(); System.out.println();
		 * System.out.println("size : "+queueLL.size()); queueLL.dequeue();
		 * queueLL.display(); System.out.println();
		 * System.out.println("size : "+queueLL.size()); queueLL.enqueue(12);
		 * queueLL.display(); System.out.println();
		 * System.out.println("size : "+queueLL.size());
		 * System.out.println("peek : "+queueLL.peek());
		 */
		
		QueueUsingCallStack queueCallStack = new QueueUsingCallStack();
		
		queueCallStack.enqueue(1);

		queueCallStack.enqueue(2);

		queueCallStack.enqueue(4);

		queueCallStack.enqueue(5);

		queueCallStack.enqueue(6);

		queueCallStack.enqueue(8);
		
		/*
		 * System.out.println(queueCallStack.dequeue());
		 * System.out.println(queueCallStack.dequeue());
		 * System.out.println(queueCallStack.dequeue());
		 * System.out.println(queueCallStack.dequeue());
		 * System.out.println(queueCallStack.dequeue());
		 * System.out.println(queueCallStack.dequeue());
		 */
		
		
		
		
		
		
	}
	

}