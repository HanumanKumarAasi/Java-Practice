package concepts.greedy.algorithms;

public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int jump(int[] nums) {
        int jumps = 0; // initially jumps will be zero
        int l=0,r=0; // initially l and r will points to 0 by default
        while(r<nums.length-1){
            int farthestJumpFromTheRange = 0; //farthestJumpFromTheRange intially be zero

            for(int i=l;i<=r;i++){

                //considering the max farthest jumps from the given l and r range
                farthestJumpFromTheRange = Math.max(farthestJumpFromTheRange, i+nums[i]);
            }

            l=r+1; //l will take up the r position and 
            r=farthestJumpFromTheRange; // r will take up the  farthest
            jumps++; // incrementing the jumps
        }

        return jumps;
        
    }

}
