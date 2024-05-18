package concepts.LinkedList;

public class PracticeLinkedList {

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		// converting array to linked list
		Node head = list.covertArraytoList(arr);
		System.out.println(head.data);

		// deleting the head from the linked list
		head = list.deletehead(head);

		// deleting the tail from the linked list
		head = list.deletetail(head);

		// deleting the Kth element from the linked list
		head = list.deleteKthElement(head, 5);

		// deleting the Kth element from the linked list
		head = list.deleteGivenValueFromList(head, 2);

		// inserting the 1 as new head
		head = list.inserthead(head, 1);

		// inserting the 6 as new tail
		head = list.inserttail(head, 6);

		// inserting the 2 at 2nd position
		head = list.insertElementAtKthPosition(head, 6, 2);

		// inserting the 2 at element 3
		head = list.insertGivenValuebeforetheGivenValue(head, 2, 3);

		// tarversing the linked list
		System.out.println("Traversing");

		LinkedList list1 = new LinkedList();

		int arr1[] = { 1, 15, 15, 13, 7, 0, 15, 8, 15, 5, 6, 3, 17, 18, 16, 9, 19, 10 };
		int arr2[] = { 5, 4, 3, 7, 9, 2 };
		int arr3[] = { 1, 9, 2, 8, 3, 7, 4 };
		// converting array to linked list
		Node head1 = list1.covertArraytoList(arr3);

//		Node head2 = reverseNodesInKthGroup(head1,4);

		Node head2 = sortLinkedList(head1);
//		Node head3 = segregateEvenOdd(head1);
		while (head2 != null) {
			System.out.println(head2.data);
			head2 = head2.next;
		}

	}

	// segregateEvenOddnumbers
	public static Node segregateEvenOdd(Node head) {
		// Write Your Code Here.
		// Node t1 = new Node(-1);
		// Node t2 = new Node(-1);
		// Node evenNodes = t1;
		// Node oddNodes = t2;
		// Node dummyNode = new Node(-1);
		// Node currentNode = dummyNode;
		// while(head!=null){
		// if(head.data%2==0){
		// t1.next = new Node(head.data);
		// t1=t1.next;
		// }else{
		// t2.next = new Node(head.data);
		// t2 = t2.next;
		// }
		// head = head.next;
		// }
		// evenNodes = evenNodes.next;
		// oddNodes = oddNodes.next;
		// while(evenNodes!=null){
		// currentNode.next = new Node(evenNodes.data);
		// evenNodes=evenNodes.next;
		// currentNode = currentNode.next;
		// }

		// while(oddNodes!=null){
		// currentNode.next = new Node(oddNodes.data);
		// oddNodes=oddNodes.next;
		// currentNode = currentNode.next;
		// }

		// return dummyNode.next;

		// Write Your Code Here.

		Node even = new Node(-1);
		Node odd = new Node(-1);
		Node evenHead = even;
		Node oddHead = odd;
		Node temp = head;
		while (temp != null) {
			if (temp.data % 2 == 0) {
				even.next = temp;
				even = even.next;
				temp = temp.next;
			} else {
				odd.next = temp;
				odd = odd.next;
				temp = temp.next;
			}
		}
		odd.next = null;
		even.next = oddHead.next;
		return evenHead.next;
	}

	// sorting the 0's,1's,2's
	public static Node sortList(Node head) {
		// Write your code here
		// creating the dummy nodes for zero and one and 2 and traversing through the List of nodes and append them to each of its dummy node and at the last connect the each dummy node to its next dummy node
		Node zeros = new Node(-1);
		Node ones = new Node(-1);
		Node twos = new Node(-1);
		Node zerosHead = zeros;
		Node onesHead = ones;
		Node twosHead = twos;
		Node temp = head;
		while (temp != null) {
			if (temp.data == 0) {
				zeros.next = temp;
				zeros = zeros.next;
				temp = temp.next;
			} else if (temp.data == 1) {
				ones.next = temp;
				ones = ones.next;
				temp = temp.next;
			} else {
				twos.next = temp;
				twos = twos.next;
				temp = temp.next;
			}
		}
		twos.next = null;
		zeros.next = onesHead.next;
		ones.next = twosHead.next;
		return zerosHead.next;
	}

	// reverse the LL
	public static Node reverseLinkedList(Node head) {
		// Write your code here.

		// Node prev= null;
		// Node temp = head;

		// while(temp!=null){
		// Node front = temp.next; // this will be the front element for the
		// temp.next = prev; // asssigning the prev as the next for reversing the linked
		// list
		// prev = temp;
		// temp = front;
		// }

		// return prev; // this is the last node which would be the head of the reversed
		// LL

		// recursive approach

		if (head == null || head.next == null)
			return head;
		// 1->2->3->4->5->null
		Node newHead = reverseLinkedList(head.next); // for last function reverseLinkedList(5(head.next)) - newHead = 5 and head = 4
		Node front = head.next;// front = 4.next = 5
		front.next = head;// 3->2(head) = 5.next = 4
		head.next = null;// 5->2->null  = 4.next = null 
		return newHead;// 5 => 5->4->null // this will be returned as the value for reverseLinkedList(4)

	}

	// find the middle element of the LL(Tortoise and Hare algorithm)
	public static Node findMiddle(Node head) {

		// Write your code here.
		// Tortoise and hare algorithm
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow; // by using the tortoise and hare algo will makes that slow would be the middle node in the given linked list
	}

	// check if the LL is a palindrome or not
	public static boolean isPalindrome(Node head) {
		// write your code here

		// Step-1(find the middle)
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// slow is the middle element in LL
		// step-2 reverse the second half from slow to tail
		Node newHead = reverseLinkedList(slow);
		// comapre the fist hald and second half nodes

		Node first = head;
		Node second = newHead;

		while (second != null) {
			if (first.data != second.data) { // if doesn't matches then given LL is not palindrome
				reverseLinkedList(newHead); // by the end we need to return the original linked list, we are making the operations just for the sake of our purpose
				return false;
			}
			first = first.next;
			second = second.next;
		}
		reverseLinkedList(newHead);
		return true;
	}

	// remove the kth node from the end
	// the optimal approach of this problem is to initially put the fast in the kth position from the head and slow at head and traverse till fast.next != null by moving the fast and slow by one step
	public static Node removeKthNode(Node head, int K) {
		// Write your code here.
		if (head==null) return head;
		Node fast = head;
		Node slow = head;
		for (int i = 0; i < K; i++) {
			fast = fast.next;
		}
		// if fast = null
		if (fast == null) {
			return head.next;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;
		return head;
	}

	// add 1 to the LL node
	public static Node addOne(Node head) {
		// Write your code here.

		Node temp = head;

		// findout the carry after all the recusive calls
		int carry = carryOverFunction(temp);

		if (carry == 0)
			return head; // if carry is 0 then return head

		if (carry == 1) { // if carry is 1 then we need to create a new node before the head with 1 and
							// return new head.
			Node newHead = new Node(carry);
			newHead.next = head;
			return newHead;
		}

		return head; // else return head

	}

	public static int carryOverFunction(Node temp) {
		if (temp == null)
			return 1; // it head is null then no nodes in that case we needto add the 1 to List and
						// return it

		int carry = carryOverFunction(temp.next);// perform the recursive calls that can add 1 to the each node

		temp.data = temp.data + carry; // adding the carry

		if (temp.data < 10) { // if carry is <10 then all are single digits so no need of other recursive
								// calls
			return 0;
		}

		temp.data = 0;// if sum is >10 the 0 should be stored in the node and carry would be 1

		return 1; // return the carry 1.

	}

	public static int findIntersection(Node firstHead, Node secondHead) {
		// Write your code here

		// Better solution
		// calulation length for firstHead and secondHead and determine the +ve difference b/w the len1 and len2 and move the head of the largest length head to its next by difference no of times and then compare the nodes data till its get matched and return that matched data

//		Node temp1 = firstHead;
//		int len1 = 0;
//		while (temp1 != null) {
//			len1++;
//			temp1 = temp1.next;
//		}
//
//		Node temp2 = secondHead;
//		int len2 = 0;
//		while (temp2 != null) {
//			len2++;
//			temp2 = temp2.next;
//		}
//
//		if (len1 > len2) {
//			// here we need to decrease the length of the first head
//			int diff = len1 - len2;
//			for (int i = 1; i <= diff; i++) {
//				firstHead = firstHead.next;
//			}
//		} else {
//			int diff = len2 - len1;
//			for (int i = 0; i < diff; i++) {
//				secondHead = secondHead.next;
//			}
//		}
//
//		while (firstHead != secondHead) {
//			firstHead = firstHead.next;
//			secondHead = secondHead.next;
//		}
//
//		if (firstHead == null)
//			return -1;
//
//		return firstHead.data;

		// optimal approach
		// optimal approach for the above solution is traverse the each head to its next until it gets null, if it is null then point that head to its opposite head(if curr1 is null then point curr1 to seacondHead and vice versa), because both of these current heads will comes to the same length the we can compare the each current nodes data and if matches we can return that data
		 Node curr1=firstHead,curr2= secondHead;
		 while(curr1!=curr2){
		 if(curr1!=null) curr1=curr1.next; 
		 else curr1=secondHead;// if curr1 points to null then curr1 needs to be secondHead
		 if(curr2!=null) curr2=curr2.next;
		 else curr2=firstHead;// if curr2 points to null then curr1 needs to be firstHead
		 }
		 return curr1.data;
	}

	// find the loop in the linked list
	public static boolean detectCycle(Node head) {
		// Your code goes here
		// this is solved by using tortoise and hare algorithm, the loop exists if slow and fast matches at some point of time
		if (head == null && head.next == null)
			return false;

		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	// calculate the length of the loop in LL
	public static int lengthOfLoop(Node head) {
		// Write your code here

		if (head == null && head.next == null)
			return 0;

		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				// the length of the loop can be calculated only if loop exists, the length can be calculated by either slow or fast by one step and increment the count by 1 and break whenever slow and fast gets matched. 
				return calculate(slow, fast);
			}
		}
		return 0;
	}

	// the length of the loop can be calculated only if loop exists, the length can be calculated by either slow or fast by one step and increment the count by 1 and break whenever slow and fast gets matched. 
	public static int calculate(Node slow, Node fast) {
		int len = 1;
		
		fast = fast.next;
		while (slow != fast) {
			fast = fast.next;
			len++;
		}
		return len;
	}

	// delete middle of the linked list
	public static Node deleteMiddle(Node head) {
		// Write your code here.
		// this is also solved by using tortoise and hare algo by find the middle and removing is from the list by pointing the middle prev node to middle.next
		if (head == null || head.next == null)
			return null; // in this case there wont be no middle so return null

		Node prev = null;
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next;// pointing middle prev node to middle next node
		slow.next = null;
		return head;
	}

	// find the starting point of the loop..
	public static Node firstNode(Node head) {
		// Write your code here.
		if (head == null && head.next == null)
			return null;

		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				//detect the loop and mark the slow from it current  position to head
				return startingPoint(head, fast);
			}
		}
		return null;
	}

	public static Node startingPoint(Node head, Node fast) {
		// Write your code here.
		Node slow = head;
		while (slow != fast) { // traverse the slow and head by 1 step till slow and fast gets matched and return the slow bcoz it is the starting point of the loop
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	// remove the duplicate elements in the sorted linked list
	public static Node uniqueSortedList(Node head) {
		// Write your code here.
		// partially accepted code
		// if(head==null ||head.next==null) return head;

		// Node temp = head;
		// Node prev = null;
		// while(temp!=null){

		// if(temp.next!=null && temp.next.data==temp.data){
		// temp.next = temp.next.next;
		// prev = temp;
		// }else if(prev!=null && prev.data==temp.data){
		// prev.next = temp.next;
		// prev = temp;
		// }

		// temp=temp.next;
		// }

		// return head;

		// if(head == null || head.next == null){

		// return head;

		// }

		// TC O(N) SC O(1)
		Node temp = head;

		while (temp.next != null) {

			if (temp.data == temp.next.data) {

				temp.next = temp.next.next; // this will be removing all the duplicates and we are not moving the temp to it next because we need to find if the same node data is matching with the next nodes else we will be moving to temp.next

			} else {

				temp = temp.next;

			}

		}

		return head;
	}

	// reverse the Nodes in Kth group
	public static Node reverseNodesInKthGroup(Node head, int k) {
		// Write your code here.
		Node temp = head; // 1->2->3|->4->5->6|->7->8->9->|10->null k=3
		Node prev = null;
		while (temp != null) {
			Node KthNode = findtheKthnode(temp, k); // returns the kth node
			if (KthNode == null) {
				if (prev != null)
					prev.next = temp;//3->2->1->4->5->6->7->8->9->|10->null(kth node is null in 10->null group)
				break;
			}
			Node nextNodeAfterKthNode = KthNode.next;
			KthNode.next = null; // C-i: 1->2->3(kth)->(null)
			reverseLinkedList(temp); // C-i: 1->2->3(kth)->(null) = 3->2->1->null
			if (temp == head) {
				head = KthNode; // if temp=head means we are in the first group so first group head would be the
								// main head (3) in this case
			} else {
				prev.next = KthNode; //3->2->1->|4->5->6->|7->8->9->|
			}
			prev = temp;// prev = 1-C-i,4-C-ii,7-C-iii for next group head
			temp = nextNodeAfterKthNode;//4,7,10
		}

		return head;
	}

	public static Node findtheKthnode(Node head, int k) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			if (count == k) {
				return temp; // returning the Kth node
			}
			temp = temp.next;
		}
		return null;

	}

	// rotate the LL by k times
	public static Node rotate(Node head, int k) {
		// Write your code here. //1->2->3->4->5->null
		int length = 1;
		Node tail = head;
		//calculating the length and tail in this loop
		while (tail.next != null) {
			tail = tail.next;
			length++;
		}

		// if no of rotation required is the multiple of 10 then we no need to rotate, bcoz after rotation the head will be the head
		if (k % length == 0)
			return head;

		k = k % length;// if helps us when k is > length

		tail.next = head;

		Node newLastNode = funcForNewLastNode(head, length - k);// pos of last node = len-k

		head = newLastNode.next;// this would be the new head of the rotated linked list head=4
		newLastNode.next = null; // modified last node point to the null 3-> null

		return head;//4->5->1->2->3->null

	}

	public static Node funcForNewLastNode(Node head, int Pos) {
		int count = 1;
		Node temp = head;
		while (temp.next != null) {
			if (count == Pos) {
				break;
			}
			temp = temp.next;
			count++;
		}
		return temp;
	}

	// sort the linked list //another approach is even and odd list and merge after
	// them
	public static Node sortLinkedList(Node head) {
		//merge sort mechanism
		if (head == null || head.next == null)
			return head;
		Node mid = FindMid(head); // finding the mid node
		Node R = mid.next; //right side
		mid.next = null; // pointing mid.next to null to make left side as separate list
		Node L = head; // left side
		L = sortLinkedList(L);
		R = sortLinkedList(R);
		return merge(L, R);// merging 2 nodes and returning its head
	}

	static Node FindMid(Node head) {// Rabbit and horse algo for finding Middle
		Node s = head;
		Node f = head.next;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
		}
		return s;
	}

	// Merging 2 sorted lists method
	static Node merge(Node L, Node R) {
		Node dummy = new Node(-1);
		Node temp = dummy;
		while (L != null && R != null) {
			if (L.data < R.data) {
				temp.next = L;
				temp = L;
				L = L.next;
			} else {
				temp.next = R;
				temp = R;
				R = R.next;
			}
		}
		if (L != null)
			temp.next = L;
		else
			temp.next = R;
		return dummy.next;
	}

	/*
	 * T = O(N) {in two passes}
	 * 
	 * S = O(1) {only link changes}
	 * 
	 * 
	 * 
	 * Node* sortList(Node* head){
	 * 
	 * // Write your code here.
	 * 
	 * 
	 * 
	 * if (head == NULL || head->next == NULL)
	 * 
	 * return head;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Separate this list into two Linked-Lists
	 * 
	 * one with nodes at odd places
	 * 
	 * second with nodes at even places (in reverse)
	 * 
	 * 
	 * 
	 * Node* odd = head;
	 * 
	 * Node* even = head->next;
	 * 
	 * Node* head2 = NULL;
	 * 
	 * 
	 * 
	 * while (even && even->next) {
	 * 
	 * odd->next = even->next;
	 * 
	 * even->next = head2;
	 * 
	 * 
	 * 
	 * odd = odd->next;
	 * 
	 * head2 = even;
	 * 
	 * even = odd->next;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * if (even) {
	 * 
	 * even->next = head2;
	 * 
	 * head2 = even;
	 * 
	 * }
	 * 
	 * odd->next = NULL;
	 * 
	 * 
	 * 
	 * // Now we have two Linked lists in non-decreasing order
	 * 
	 * // Merge both into a single Linked List
	 * 
	 * 
	 * 
	 * Node* newHead = NULL;
	 * 
	 * Node* tail = NULL;
	 * 
	 * 
	 * 
	 * if (head->data <= head2->data) {
	 * 
	 * newHead = tail = head;
	 * 
	 * head = head->next;
	 * 
	 * } else {
	 * 
	 * newHead = tail = head2;
	 * 
	 * head2 = head2->next;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * while (head && head2) {
	 * 
	 * if (head->data <= head2->data) {
	 * 
	 * tail->next = head;
	 * 
	 * tail = head;
	 * 
	 * head = head->next;
	 * 
	 * } else {
	 * 
	 * tail->next = head2;
	 * 
	 * tail = head2;
	 * 
	 * head2 = head2->next;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * if (head) tail->next = head;
	 * 
	 * if (head2) tail->next = head2;
	 * 
	 * 
	 * 
	 * return newHead;
	 */
	
	
	
	//flattenning problem from LL with child concepts
	
	public static Nodewithchild flattenLinkedList(Nodewithchild root) {
        //Write your code here
         /*  The process to flatten the given linked list is as follows:-

 

        We will recurse until the head pointer moves null. The main motive is to merge each list from the last.

        Merge each list chosen using the merge algorithm. The steps are

        Create a dummy node. Point two pointers, i.e, temp and res on dummy node. res is to keep 

        track of dummy node and temp pointer is to move ahead as we build the flattened list.

        We iterate through the two chosen. Move head from any of the chosen lists ahead whose 

        current pointed node is smaller. 

        Return the new flattened list found.

 

        Time Complexity: O(N), where N is the total number of nodes present

 

        Reason: We are visiting all the nodes present in the given list.

 

        Space Complexity: O(1)

    */

         if (root == null || root.next == null) 

                return root; 

      

            // recur for list on right 

            root.next = flattenLinkedList(root.next); 

      

            // now merge 

            root = mergeTwoLists(root, root.next); 

      

            // return the root 

            // it will be in turn merged with its left 

            return root; 

    }

 

    public static Nodewithchild mergeTwoLists(Nodewithchild a, Nodewithchild b) {

        

    	Nodewithchild temp = new Nodewithchild(0);

    	Nodewithchild res = temp;

        a.next=null; // imp

        b.next=null; //imp

        

        while(a != null && b != null) {

            if(a.data < b.data) {

                temp.child = a; 

                temp = temp.child; 

                a = a.child; 

            }

            else {

                temp.child = b;

                temp = temp.child; 

                b = b.child; 

            }

        }

        

        if(a != null) temp.child = a; 

        else temp.child = b;

        return res.child; 

    

    }

    //cloning the LL
    public static NodeWithRandom cloneLL(NodeWithRandom head) {
        // Write your code here.

        //step1 - creating the copy of the eachnode and place in between to curr and next

    	NodeWithRandom temp = head;
        while(temp!=null){
        	NodeWithRandom newNode = new NodeWithRandom(temp.data); // for cloning the node
            temp.next = newNode;
            newNode.next = temp.next.next; // making actual next node as next node for copy node 7->7(c)->13
            temp = temp.next.next; // making temp points to actual next node i.e 13
        }

        //step-2 connect the copy with the random pointers respectively
        temp = head;
        while(temp!=null){
            temp.next.random = temp.random; //copy of temp is temp.next/connecting the random pointers to the copied node
            temp = temp.next.next;
        }
        //step3 create the dummy node and connect the dummyNode to the copy of the nodes and connect their next to their copy
        NodeWithRandom dummyNode = new NodeWithRandom(-1);

        temp=head;
        NodeWithRandom res = dummyNode;
        while(temp!=null){
            res.next = temp.next;//point dummy to points to actuals copy node ie 7(c)
            NodeWithRandom orignalNext = temp.next.next;
            temp.next = orignalNext; //7(original) -> 13(original) //this may cause the NPE // pointing the nodes to its original next nodes
            temp = orignalNext; //13
        }

        return res.next;
    }
}

class Nodewithchild {
    public int data;
    public Nodewithchild next;
    public Nodewithchild child;

    Nodewithchild()
    {
        this.data = 0;
        this.next = null;
        this.child = null;
    }
    Nodewithchild(int data)
    {
        this.data = data;
        this.next = null;
        this.child = null;
    }
    Nodewithchild(int data, Nodewithchild next, Nodewithchild child)
    {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}

class NodeWithRandom {
    public int data;
    public NodeWithRandom next;
    public NodeWithRandom random;

    NodeWithRandom()
    {
        this.data = 0;
        this.next = null;
        this.random = null;
    }
    NodeWithRandom(int data)
    {
        this.data = data;
        this.next = null;
        this.random = null;
    }
    NodeWithRandom(int data, NodeWithRandom next, NodeWithRandom random)
    {
        this.data = data;
        this.next = next;
        this.random = random;
    }
}

