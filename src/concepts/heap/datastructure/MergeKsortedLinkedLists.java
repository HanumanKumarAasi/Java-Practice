package concepts.heap.datastructure;

import java.util.PriorityQueue;

public class MergeKsortedLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] listNodes= new ListNode[3];
		listNodes[0] = new ListNode(1);
		listNodes[0].next = new ListNode(4);
		listNodes[0].next.next = new ListNode(5);
		
		listNodes[1] = new ListNode(1);
		listNodes[1].next = new ListNode(3);
		listNodes[1].next.next = new ListNode(4);
		
		listNodes[2] = new ListNode(2);
		listNodes[2].next = new ListNode(6);
		
		ListNode result = mergeKLists(listNodes);
		
		
		System.out.println(result);
	}

	public static ListNode mergeKLists(ListNode[] lists) {

		// Write your code here.
		// result list
		
		ListNode head = new ListNode(0);
		ListNode result = head;

		// priority queue
		PriorityQueue<HeapNode1> pq = new PriorityQueue<>();

		// adding only 0th index elements to pq initially
		for (int in = 0; in < lists.length; in++) {
			if(lists[in]!=null){
                pq.add(new HeapNode1(in, lists[in], lists[in].val));
            }
		}

		while (!pq.isEmpty()) {
			HeapNode1 curr = pq.poll(); // removing the pq minimum value first and adding the next element to that value
										// into PQ from the same array

			
				result.next = new ListNode(curr.value);
				result = result.next;
			

			if (curr.listNode.next != null) {
				pq.add(new HeapNode1(curr.i, curr.listNode.next, curr.listNode.next.val));
			}
		}

		return head.next;

	}
}

class HeapNode1 implements Comparable<HeapNode1> {

	int i;
	ListNode listNode;
	int value;

	HeapNode1(int i, ListNode j, int val) {
		this.i = i;
		this.listNode = j;
		this.value = val;
	}

	@Override
	public int compareTo(HeapNode1 that) {
		if (this.value >= that.value) {
			return 1;
		}
		return -1;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
