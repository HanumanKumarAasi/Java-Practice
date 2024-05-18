package concepts.recursion;

public class Recursion1 {
	int count=0;
	public int fact(int n) {
		++count;
		if(n==1) return 1;
		return n*fact(n-1);
	}
	//5*fact(4) //1
	//5*4*fact(3) //2 
	//5*4*3*fact(2)// 3
	//5*4*3*2*fact(1)// 4
	//5*4*3*2*1 //5
	public static void main(String args[]) {
		Recursion1 recur = new Recursion1();
		System.out.println("fact(5) is : "+recur.fact(5));
		System.out.println("no of ops: "+recur.count);
		
	}
}
