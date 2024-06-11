package concepts.custom_DS.stack;

import java.util.Arrays;

public class StackUsingArray {
	
	Integer top;
	
	Integer[] stack;
	
	public StackUsingArray(Integer capacity) {
		this.top=-1;
		this.stack=new Integer[capacity];
	}
	
	public boolean isEmpty() {
		return this.top<0;
	}
	
	//adding the element by considering the capacity if capacity is full we are incrementing the actual length by one and adding the element into the stack
	public boolean push(Integer element) {
		this.top+=1;
		if(this.top>=this.stack.length) {
			this.stack = Arrays.copyOf(this.stack, this.stack.length+1);
			this.stack[this.top]=element;
			return true;
		}
		else if(this.top<this.stack.length) {
			this.stack[this.top]=element;
			return true;
		}
		return false;
	}
	
	
	public Integer pop() {
		if(this.top>=0) {
			Integer poppedelement = this.stack[this.top];
			this.top-=1;
			return poppedelement;
		}
		return null;
	}
	
	public int size() {
		return this.top+1;
	}
	
	public Integer top() {
		return this.stack[this.top];
	}
	
	public Integer[] toArray() {
		return this.stack;
	}

}
