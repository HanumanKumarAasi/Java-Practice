package interview.preparation.java;

public class OuterAndInnerClasses {
	
	private String outerStr="Str";
	
	private static String outerStaticStr = "StaticStr";
	
	
	private String nonStaticMethod() {
		return "non-static";
	}
	
	private static String staticMethod() {
		return "static";
	}
	
	
	class InnerClass{
		
		//In Inner class we can access both static and non-static members without creating the reference of the Outer class
		//non-static member
		private String innerStr = outerStr;
		//static member
		private static String innerStaticStr = outerStaticStr;
		
		//accessing non static method without reference
		public String innerNonStaticMethod() {
			return innerStr+nonStaticMethod();
		}
		
		//accessing static method without reference
		public static String innerStaticMethod() {
			return innerStaticStr+staticMethod();
		}
		
		
		
	}

}
