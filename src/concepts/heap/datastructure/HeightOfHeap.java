package concepts.heap.datastructure;

public class HeightOfHeap {
	
	// Function to calculate height - height of Complete binary tree is log2(N) 
    static int height(int N)
    {
        return (int)Math.ceil(Math.log(N + 
                    1) / Math.log(2)) - 1;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int N = 15;
        System.out.println(height(N));
    }

}
