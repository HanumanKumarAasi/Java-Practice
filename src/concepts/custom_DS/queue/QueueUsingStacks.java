package concepts.custom_DS.queue;

import java.util.Stack;

public class QueueUsingStacks {
		Stack<Integer> input = new Stack<Integer>(); 
	    Stack<Integer> output = new Stack<Integer>(); 
	    
	    /*The method pop which return the element poped out of the stack*/
	    int dequeue()
	    {
		    // Your code here
		    if(input.isEmpty()&&output.isEmpty()){
		        return -1;
		    }
		    
		    int x;
		    if(output.isEmpty()){
		        while(!input.isEmpty()){
		            x=input.pop();
		            output.push(x);
		        }
		    }
		    return output.pop();
	    }
		
	    /* The method push to push element into the stack */
	    void enqueue(int x)
	    {
		    // Your code here	
		    input.push(x);
	    }

}


