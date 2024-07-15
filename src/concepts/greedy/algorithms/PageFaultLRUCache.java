package concepts.greedy.algorithms;

public class PageFaultLRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = pageFaults(9,4,new int[]{5, 0, 1, 3, 2, 4, 1, 0, 5});
		System.out.println(result);
	}
	
	static int pageFaults(int N, int C, int pages[]){
        // code here
        String str = "";
        for(int i=0;i<C;i++){
            str = str+pages[i];
        }
        int count=C;
        int index=0;
        while(C<N){
            if(str.contains(String.valueOf(pages[C]))){
                C++;
            }else if(str.length()>0){
                if(index==0){
                    str = pages[C]+str.substring(index+1,str.length());
                    count++;
                    index++;
                }else{
                    str = str.substring(0,index)+pages[C]+str.substring(index+1,str.length());
                    count++;
                    index++;
                }
            }
        }
        return count;
        
        
        
    }

}
