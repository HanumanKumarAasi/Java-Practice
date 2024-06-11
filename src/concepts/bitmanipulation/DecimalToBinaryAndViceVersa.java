package concepts.bitmanipulation;

public class DecimalToBinaryAndViceVersa {
	
	static void bitManipulation(int num, int i) {
        // code here
		String res = "";
		int temp = num;
		while (temp != 1) {
			if (temp % 2 == 1) {
				res = res + String.valueOf(1);
			} else {
				res = res + String.valueOf(0);
			}
			temp = temp / 2;
		}
		res = res + "1";
		System.out.println(res);
		System.out.print(res.charAt(i - 1));
		if (res.charAt(i - 1) == '1') {
			System.out.print(" "+ num);

		} else {
			System.out.print(" "+ num + Math.pow(2, i - 1));
		}

		if (res.charAt(i - 1) == '0') {
			System.out.println(" "+num);

		} else {
			System.out.print(" "+ (int)(num - Math.pow(2, i - 1)));
		}
        
        
        
        
    }
	
	public static void main(String args[]) {
		//bitManipulation(129909780,17);
		System.out.println(~(4));
		System.out.println(17^1);
		System.out.println(17&2);
		System.out.println(17|2);
		System.out.println(17<<2);
		System.out.println(17>>2);
		
		System.out.println(2&1);
		
		////first approach for finding no of set bits
		int m=84;
		int count=0;
		int count1=1;
		while(m>1) {
			count+=m&1;
			m=m>>1;
			
		}
		
		if(m==1)
			count+=1;
		System.out.println(count);
		
		//second approach for finding no of set bits
		int n=84;
		if(n==0) {
			count1=0;
		}else {
			while((n&(n-1))!=0) {
				count1+=1;
				n=(n&(n-1));	
			}
		}
		System.out.println(count1);
		
		System.out.println(4|(1<<2));
		
		System.out.println(Math.pow(2, 31));
	}

}
