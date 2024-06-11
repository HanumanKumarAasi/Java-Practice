package concepts.custom_DS.queue;

import java.util.Stack;

public class QueueUsingCallStack {

	Stack<Integer> stack = new Stack<Integer>();

	public void enqueue(int x) {
		stack.push(x);
	}

	public int dequeue() {
		int x;
		if (stack.isEmpty()) {
			return -1;
		} else if (stack.size() == 1) {
			return stack.pop();
		} else {
			x = stack.pop();
			int res = dequeue();
			stack.push(x);
			return res;
		}
	}

}
