package concepts.lambda;

public class LambdaFunctionPractice {
	
	 String l = "lambda";
	
	public static void main(String agrs[]) {
		func1(str->str.length());
	}
	
	String lambda() {
		return "lambda";
	}
		
	static void func1(FunctionalInterface inter) {
		System.out.println(inter.length("Hanuman"));
	}
	
	
	static class Hello{
		LambdaFunctionPractice lam = new LambdaFunctionPractice();
		
		//we cant access non-static varibles
		String h = lam.l;
		
		String helloLambda() {
			//we cant access non-static 
			return "Hello "+lam.lambda();
		}
	}

}


interface FunctionalInterface{
	
	
	public int length(String str);
}


