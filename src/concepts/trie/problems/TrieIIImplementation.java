package concepts.trie.problems;

public class TrieIIImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TrieII {
    Nodee root;
    public TrieII() {
        // Write your code here.
        root = new Nodee();
    }

    //O(N)
    public void insert(String word) {
        // Write your code here.
        Nodee temp = root;
        for(int i=0;i<word.length();i++){
            if(!temp.containsKey(word.charAt(i))){
                temp.put(word.charAt(i),new Nodee());
                temp.get(word.charAt(i)).startsWith++;
            }else{
                temp.get(word.charAt(i)).startsWith++;
            }
            temp = temp.get(word.charAt(i));
        }
        temp.endsWith++;
    }

    //O(N)
    public int countWordsEqualTo(String word) {
        // Write your code here.
        Nodee node = root;

        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        if(node.endsWith!=0){
            return node.endsWith;
        }
        return 0;
    }

    //O(N)
    public int countWordsStartingWith(String prefix) {
        // Write your code here.
        Nodee node = root;

        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return 0;
            }
            node = node.get(prefix.charAt(i));
        }

        return node.startsWith;
    }

    //O(2N)
    public void erase(String word) {
        // Write your code here.
        Nodee temp = root;
        if(countWordsEqualTo(word)>0){//O(N)
            for(int i=0;i<word.length();i++){
                if(temp.containsKey(word.charAt(i))){
                    temp.get(word.charAt(i)).startsWith--;
                }
              temp = temp.get(word.charAt(i));
            }
            temp.endsWith--;
        }
        
    }

}

class Nodee{
    Nodee links[] = new Nodee[26];

    int endsWith=0;
    int startsWith=0;

    Nodee(){

    }


    boolean containsKey(char ch){
        
        return links[ch-'a']!=null;
    }

    void put(char ch, Nodee node){
        links[ch-'a']=node;
    }

    Nodee get(char ch){
        return links[ch-'a'];
    }

}
