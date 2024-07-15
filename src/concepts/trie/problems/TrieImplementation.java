package concepts.trie.problems;

public class TrieImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("apps");
		trie.insert("apxl");
		trie.insert("bat");
		trie.insert("ball");
		
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		
		System.out.println(trie.startsWith("app"));
		System.out.println(trie.startsWith("ba"));
		System.out.println(trie.startsWith("ca"));
		
	}

}

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }
    
    //insert the node into the tree
    //TC: O(N)
    public void insert(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            //if the curr char doesnt exists in the trie we will add that to it
            if(!temp.containsKey(word.charAt(i))){
                temp.put(word.charAt(i),new Node());
            }
            //now the new ref node is the curr node
            temp = temp.get(word.charAt(i));
        }

        //after pointing and adding all the char trie nodes
        //the last node flag should be true means till that true flag it is one word
        temp.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;

        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        if(node.isEnd()){
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;

        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }

        return true;
    }
    
    public boolean checkIfPrefixExists(String prefix){
        Node node = root;
        boolean flagg = true;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
            flagg = flagg&node.isEnd();
        }
        return flagg;
    }
}

class Node{
    Node links[] = new Node[26];
    boolean flag = false;

    public Node(){

    }

    //this will check whether we have a trie node for this character
    boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    //adding the node for this char in trie ds
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    //getting the character trie node
    Node get(char ch){
        return links[ch-'a'];
    }
    //setting the last flag to true stating the given word is inserted
    void setEnd(){
        flag = true;
    }

    //does word exists, if it is true the word exists bcoz after inserting we are making last char trie nnode flag to true 
    boolean isEnd(){
        return flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
