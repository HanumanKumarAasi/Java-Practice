package interview.preparation.java;

public class OuterAndStaticClasses {
	
	//consider this is the enclosing/outer class
	
	private String str;
	
	private static String staticStr;
	
	String nonStaticMethod() {
		return "non-sttaic";
	}
	
	static String staticMethod() {
		return "static";
	}
	
	
	//Creating a Static class, A static class should be an inner class, all the staic classes are inner classes
	
	static class StaticClass{
		
		//we can directly use the static member of its enclosing/outer class
		String staticClassStr = staticStr;
		
		//we can directly use the static methods of its enclosing/outer class
		String staticClassMethod() {
			return staticMethod();
		}
		
		//we need to create a reference of the enclosing/outer class for accessing the non-static members and static methods
		OuterAndStaticClasses staticOuterclass = new OuterAndStaticClasses();
		
		
		String staticOuterClassMember = staticOuterclass.str;
		
		String callingStaticOuterClassNonStaticMethod() {
			return staticOuterclass.nonStaticMethod();
		}
		
	}

}
