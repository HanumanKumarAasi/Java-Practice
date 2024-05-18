package concepts.doublyLinkedList;

public class DoublyLinkedList {
	
	Node convertTheArraytoDLL(int[] arr) {
		Node head = new Node(arr[0]);
		
		Node prev = head;
		for(int i=1;i<arr.length;i++) {
			Node temp = new Node(arr[i],prev,null);
			prev.next = temp;
			prev = prev.next;
		}
		
		return head;
	}
	
	Node deleteTheHead(Node head) {
		if(head==null || head.next==null) return null;
		//1(h)<=>2<=>3
		head = head.next;//1<=>2(h)<=>3
		head.prev = null;//null<=>2<=>3 //now the current head.prev should be the null
		return head;
	}
	
	Node deleteTheTail(Node head) {
		
		Node tail = head;
		if(tail==null || tail.next==null) return null;
		
		while(tail.next.next!=null) {
			tail=tail.next;
		}
		tail.next.prev=null; //while removing the tail that tail.prev should be the null
		tail.next=null;
		return head;
	}
	
	Node deleteTheKthElement(Node head, int k) {
		if(head==null) return null;
		
		if(k==1 && head.next==null && head.prev==null) return null;
		
		if(k==1 && head.next!=null) {
			head = head.next;
			head.prev = null;
			return head;
		}
		
		int count=0;
		Node temp = head;
		
		while(temp!=null) {
			count++;
			
			if(count == k) {
				temp.prev.next = temp.next;
				if(temp.next!=null) {
					temp.next.prev = temp.prev;
					break;
				}else {
					temp=null;
					break;//if k points to last element
				}
			}
			temp=temp.next;
		}
		
		return head;
	}
	
	Node deleteTheGivenNode(Node head, Node node) {
		if(head==null) return null;
		
		if(head.data==node.data && head.next==null && head.prev==null) return null;
		
		if(head.data==node.data && head.next!=null) {
			head = head.next;
			head.prev = null;
			return head;
		}
		
		Node temp = head;
		
		while(temp!=null) {
			
			
			if(temp.data == node.data) {
				temp.prev.next = temp.next;
				if(temp.next!=null) {
					temp.next.prev = temp.prev;
					break;
				}else {
					temp=null;
					break;//if k points to last element
				}
			}
			temp=temp.next;
		}
		
		return head;
	}

	Node insertAtHead(Node head, int val) {
		if(head==null) return new Node(val);
		
		Node temp = new Node(val,null,head);
		head.prev=temp;
		head=temp;
		return head;
	}
	
	
	Node insertAtTail(Node head, int val) {
		if(head==null) return new Node(val);
		
		Node temp = head;
		
		while(temp.next!=null) {
			temp=temp.next;
		}
		
		Node newNode = new Node(val,temp,null);
		temp.next = newNode;
		
		return head;
	}
	
	Node insertAtKthPos(Node head, int val, int pos) {
		if(head==null) return null;
		
		if(pos==1) { //if we need place at the head
			return insertAtHead(head,val);
		}
		
		
		
		Node temp = head;
		int count=0;
		while(temp!=null) {
			count++;
			if(count==pos) {
				Node newNode = new Node(val,temp.prev,temp);
				temp.prev.next=newNode;
				temp.prev=newNode;			
			}
			temp=temp.next;
		}
		
		if(pos==count+1) { //if we need place after the tail
			return insertAtTail(head, val);
		}
		
		
		
		return head;
	}
	
	Node insertBeforeTheGivenValue(Node head, int val, int placeBefore) {
		if(head==null) return null;
		
		if(head.data==placeBefore) { //if we need place before the head value
			return insertAtHead(head,val);
		}
		
		
		
		Node temp = head;
		while(temp!=null) {
			if(temp.data==placeBefore) {
				Node newNode = new Node(val,temp.prev,temp);
				temp.prev.next=newNode;
				temp.prev=newNode;			
			}
			temp=temp.next;
		}
		
		
		
		
		
		return head;
	}

}


class Node{
	
	int data;
	Node prev;
	Node next;
	
	
	public Node(int data, Node prev, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public Node(int data)
	{
		this.data= data;
		this.next=null;
		this.prev=null;
	}
	
	public Node() {
		
	}
	
}
