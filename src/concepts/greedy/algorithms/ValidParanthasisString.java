package concepts.greedy.algorithms;

public class ValidParanthasisString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkValidString("(()*)(*))"));
	}
	
	public static boolean checkValidString(String s) {
        char[] chars= s.toCharArray();
        // Stack<Character> stack = new Stack<>();
        // int count=0;
        // for(int i=0;i<chars.length;i++){
        //     if(chars[i]=='('){
        //         stack.push(chars[i]);
        //     }else if(chars[i]==')'){
        //         if(stack.size()>0){
        //             stack.pop();
        //         }else if(count>0){
        //             count--;
        //             continue;
        //         }else{
        //             return false;
        //         }
        //     }else if(chars[i]=='*'){
        //         count++;
        //     }else{
        //         return false;
        //     }
        // }

        // if(stack.size()==0){
        //     return true;
        // }
        // return false;

        int min=0; //min should always be >=0
        int max=0; //max should always be >=0

        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                min++;
                max++;
            }else if(chars[i]==')'){
                min--;
                max--;
            }else if(chars[i]=='*'){
                min--;//considering * as (
                max++;//considering * as )
            }

            if(min<0) min=0;

            if(max<0) return false;
        }

        return (min==0);
    }

}
