package concepts.trie.problems;

public class MaxXor {
	
	
	public static void main(String args[]) {
		int nums[] = {3,10,5,25,2,8};
		
		int maxXor = findMaximumXOR(nums);
		
		System.out.println(maxXor);
	}

	/*
	Trie Structure:

	We define a BitNode class to represent each node in the Trie, where each node has two potential links (0 and 1).
	The Tries class contains methods to insert a number in its binary form into the Trie and to find the maximum XOR for a given number.
	
	Insertion:

	For each number, insert its 32-bit binary representation into the Trie.
	
	Maximizing XOR:

	For each number, traverse the Trie to find the number that would produce the maximum XOR with the current number. This is done by trying to take the opposite bit (1-bit) at each step if possible.
	Finding the Maximum XOR:

	As we insert each number into the Trie, we simultaneously check for the maximum XOR possible with the numbers already inserted.
	
	Complexity
	Time Complexity: Insertion and query operations for each number take O(32) time because we are dealing with 32-bit integers. Hence, for n numbers, the total time complexity is O(n * 32) = O(n).
	Space Complexity:
	The space complexity is O(n * 32) = O(n), where n is the number of integers, because each node might have up to 32 levels.
	*/

	    public static int findMaximumXOR(int[] nums) {
			BitTrie bitTrie = new BitTrie();
	        int maxi = 0;
			for(int i=0;i<nums.length;i++) {
				bitTrie.insert(nums[i]);
			    maxi = Math.max(maxi, bitTrie.getMaxNumber(nums[i]));//check for the maximum XOR possible with the numbers already inserted
			    /*
			     * 1. 3 with 3
			     * 2. 10 with 3,10
			     * 3. 5 with 3,10,5
			     * 4. 25 with 3,10,5,25
			     * 5. 2 with 3,10,5,25,2
			     * 6. 8 with 3,10,5,25,2,8
			     */
			}
			return maxi;
		}
	}

	class BitNode{
		BitNode links[] = new BitNode[2];
		
		public BitNode() {
			
		}
		
		boolean containsKey(int bit) {
			return links[bit]!=null;
		}
		
		BitNode get(int bit) {
			return links[bit];
		}
		
		void put(int bit, BitNode node) {
			links[bit] = node;
		}
	}

	class BitTrie{
		
		BitNode root;
		
		public BitTrie() {
			root=new BitNode();
		}
		
		public void insert(int num) {
			BitNode node =root;
			
			for(int i=31;i>=0;i--) {
				int bit = (num>>i)&1;//it gives the current bit value of the number ie either 0 or 1
				if(!node.containsKey(bit)) {
					node.put(bit, new BitNode());
				}
				node = node.get(bit);
			}
		}
		
		public int getMaxNumber(int num) {
			BitNode node =root;
			int maxNum=0;
			for(int i=31;i>=0;i--) {
				int bit = (num>>i)&1;//it gives the current bit value starting from 32 bit of the number ie either 0 or 1
				if(node.containsKey(1-bit)) {//this is the condition that we are checking for opposite bit of the current bit then olny the xor operation will gives us 1 else 0
					maxNum = maxNum | (1<<i);
					node = node.get(1-bit); //(1-bit) is the bit that we have considered from that only we need to consider them
				}else {
					node = node.get(bit); //node points to the curr bit node
				}
			}
			return maxNum;
		}
	}
