package concepts.doublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class PracticeDoublyLinkedList {
	
	public static void main(String args[]) {
		
		DoublyLinkedList dll = new DoublyLinkedList();
		
		int[] arr = {1,2,3,4,5,6};
		// below all  are basic operations declared in DLL class
		Node head = dll.convertTheArraytoDLL(arr);
		
		head = dll.deleteTheHead(head);
		
		head = dll.deleteTheTail(head);
		
		head = dll.deleteTheKthElement(head,4);
		
		head = dll.deleteTheGivenNode(head,new Node(3));
		
		head = dll.insertAtHead(head, 1);
		
		head = dll.insertAtTail(head, 5);
		
		head = dll.insertAtKthPos(head, 3, 5);
		
		head = dll.insertBeforeTheGivenValue(head, 4, 11);
		
		System.out.println("Traversing the dll elements");
		
		
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		
		//Traversing the DLL in reverse order
		
		//first find out the tail of the DLL
		
//				Node tail=null;
//				Node temp = head;
//				while(temp!=null) {
//					tail=temp;
//					temp=temp.next;
//				}
//				System.out.println("Traversing the dll elements in reverse order");
//				while(tail!=null) {
//					System.out.println(tail.data);
//					tail=tail.prev;
//				}
		
		
		
		Browser browser = new Browser("home");
		browser.visit("facebook");
		browser.visit("instagram");
		String back = browser.back(1);
		String forward = browser.forward(1);
		System.out.println(back);
		System.out.println(forward);
		
		
	}
	
	//delete all the occurrences of the key in DLL
	public static Node deleteAllOccurrences(Node head, int k) {
        // Write your code here.
		// the optimal approach is traversing through each node and and comparing with the k, if matches we are changing the prev and next
        Node temp = head;

        while(temp!=null){
            if(temp.data == k){
                if(temp==head) head = head.next; //if Kth data node is head? then we are marking head as head.next that is case of removing that Kth data head.
              //else we are changing the links from 2<=>10<=>5 to 2<=>5 here k=10
                if(temp.next!=null) temp.next.prev = temp.prev; //2<-5
                 if(temp.prev!=null) temp.prev.next = temp.next;//2->5  i.e 2<=>5
                
            }
            temp=temp.next;
        }
        return head; // TC: O(N) SC:O(1)
    }

	//find the pairs of the nodes that matches with sum k in a sorted DLL (null<-1<->2<->3<->4->null)
	public static List<int[]> findPairs(Node head, int k) { //k=5 o/p:[{1,4}{2,5}]
        // Write your code here.
		// the bruete force approach would be using two loops and traversing the through each element and summing up with diffent element wrt the first
        // the optimal approach would be finding the tail of the DLL -> TC-O(N) and checking from left(head) and right(tail) by summing up their values
		Node tail = findTail(head);//O(N)
        List<int[]> pairs = new ArrayList<>();
        Node left = head;
        Node right = tail;

        while(right.data> left.data){ // traversing till right element crosses the left bcoz post that we may get duplicate reverse pair which will provide you the wrong answer
            if(right.data+left.data==k){
                int[] pair = {left.data,right.data};
                pairs.add(pair);
                right = right.prev;
                left = left.next;								//O(N/2)
            }else if(right.data+left.data>k){
                    right = right.prev;
            }else{
                left = left.next;
            }
        }
        return pairs; //total TC: O(N)+O(N/2) - O(3N/2) //SC:O(N/2)
    }

	//method for finding the tail of the DLL
    public static Node findTail(Node head){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        return temp;
    }

    
    
    

}

// This is the problem of building the browser.......
class Browser {
	NodePage currentPage;
	public Browser(String homePage) {
		 // Write you code here
		 currentPage = new NodePage(homePage); // this is the default home page
	}

	public void visit(String string) {
		 // Write you code here
		// we are using this method for visiting the new page post creating the new page, the new page will be the current page and actual current page would be the previous page
		NodePage newPage = new NodePage(string);
		 currentPage.next = newPage;
		 newPage.prev = currentPage;
		 currentPage = newPage;
		 
	}

	public String back(int steps) {
		 // Write you code here
		// This method is moving back from the current page to the prev page by the given number of steps
		 while(steps>0){
			 //edge case
			 
			 if(currentPage.prev==null) break;// if there is no prev page for the current page we can just return that current page

			currentPage = currentPage.prev;
			steps--;
			

		 }
		 return currentPage.url;
	}

	public String forward(int steps) {
		 // Write you code here
		// This method is for moving next from the current page to the next page by the given number of steps
		
		while(steps>0){
			
			 if(currentPage.next==null) break; // if there is no next page for the current page we can just return that current page
			 currentPage = currentPage.next;
			 steps--;
		 }
		 return currentPage.url;
	}

}
// NodePage class for building the Browser.
class NodePage{
	String url;
	NodePage next;
	NodePage prev;
	
	NodePage(String url){
		this.url = url;
		this.next = null;
		this.prev = null;
	}

	NodePage(String url,NodePage next, NodePage prev){
		this.url = url;
		this.next = next;
		this.prev = prev;
	}
}
