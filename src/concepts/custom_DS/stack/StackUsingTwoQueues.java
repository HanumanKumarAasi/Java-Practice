package concepts.custom_DS.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	public void push(int x) {
		q1.add(x);
		
	}
	
	public int pop() {
		if(q1.isEmpty()) {
			return -1;
		}
		else if(q2.isEmpty()) {
			while(q1.size()!=1) {
				q2.add(q1.remove());
			}
		}
		int temp = q1.remove();
		Queue<Integer> q = q1;
		q1=q2;
		q2=q;
		return temp;
	}
	
	public int top() {
		if(q1.isEmpty()) {
			return -1;
		}
		else if(q2.isEmpty()) {
			while(q1.size()!=1) {
				q2.add(q1.remove());
			}
		}
		int temp = q1.remove();
		q2.add(temp);
		Queue<Integer> q = q1;
		q1=q2;
		q2=q;
		return temp;
	}
	

}
