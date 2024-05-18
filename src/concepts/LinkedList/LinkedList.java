package concepts.LinkedList;

public class LinkedList {
	Node head;
	
	public Node covertArraytoList(int[] arr){
		Node head = new Node(arr[0]);
		Node mover = head; //at every iteration the pointer that points to its respective node
		
		for(int i=1;i<arr.length;i++) {
			Node temp = new Node(arr[i]);
			mover.next = temp;
			mover=temp; //mover points to the new node
		}
		
		return head;
	}
	
	public int length(LinkedList list){
		int len=0;
		Node tempNode = list.head;
		while(tempNode!=null) {
			len++;
			tempNode = tempNode.next;
		}
		
		return len;
	}
	
	public Node deletehead(Node head) {
		if(head==null) return null;
		head = head.next;
		return head;
	}
	
	public Node deletetail(Node head) {
		//if there is only head that is also a tail we need to remove that from LL
		if(head==null || head.next==null) return null;
		
		Node temp=head;
		
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		temp.next = null;
		return head;
	}
	
	public Node deleteKthElement(Node head, int k) {
		//if there is only head that is also a tail we need to remove that from LL
		if(head==null) return null;
		
		if(k==1) {
			return head.next;
		}
		
		Node temp=head;
		
		int count=0;
		Node prev=null;
		while(temp!=null) {
			count++;
			if(k==count) {
				prev.next = temp.next;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		return head;
	}
	
	public Node deleteGivenValueFromList(Node head, int val) {
		if(head==null) return null;
		
		if(head.data==val) {
			return head.next;
		}
		
		Node temp=head;
		
		Node prev=null;
		while(temp!=null) {
			if(val==temp.data) {
				prev.next = temp.next;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		return head;
	}
	
	public Node inserthead(Node head, int val) {
		Node newhead = new Node(val);
		
		if(head==null) {
			return newhead;
		}
		
		newhead.next = head;
		return newhead;
	}
	
	public Node inserttail(Node head, int val) {
		Node newtail = new Node(val);
		
		if(head==null) {
			return newtail; //this will be the head and tail
		}
		Node temp=head;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		temp.next.next = newtail;
		return head;
	}
	
	public Node insertElementAtKthPosition(Node head, int k, int val) {
		Node newNode =new Node(val);
		if(head==null) {
			if(k==1) {
				newNode.next=head;
				return newNode;
			}else {
				return null;
			}
		}
		
		if(k==1) {
			newNode.next=head;
			return newNode;
		}
		
		Node temp=head;
		
		int count=0;
		Node prev=null;
		while(temp!=null) {
			count++;
			if(k==count) {
				prev.next = newNode;
				newNode.next = temp;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		//if you need to insert on the last position/tail i.e actualposition+1 beyond that it is not possible
		if(k==count+1) {
			prev.next=newNode;
		}
		return head;
	}
	
	public Node insertGivenValuebeforetheGivenValue(Node head, int val, int before) {
		if(head==null) return null;
		
		Node newNode =new Node(val);
		if(head.data==before) {
			newNode.next=head;
			return newNode;
		}
		
		Node temp=head;
		
		while(temp.next!=null) {
			if(temp.next.data==before) {
				newNode.next = temp.next; //passing the new value before the before value
				temp.next=newNode; //appending next elements to the newNode value
				break;
			}
			temp=temp.next;
		}
		return head;
	}
	
	
	
	
}

class Node{
	
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next=null;
	}
}
