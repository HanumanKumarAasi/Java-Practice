package concepts.custom_DS.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q1 = new LinkedList<Integer> ();
	
	
	public void push(int x)
    {
        //  Get previous size of queue
        int s = q1.size();

        // Push the current element
        q1.add(x);

        // Pop all the previous elements and put them after
        // current element
        for (int i = 0; i < s; i++) {
            q1.add(q1.remove());
        }
    }

	public int pop()
    {
        // if no elements are there in q1
        if (q1.isEmpty())
            return -1;
        return q1.remove();
    }

	public int top()
    {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

	public int size() { return q1.size(); }

}
