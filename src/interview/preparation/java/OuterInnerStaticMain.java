package interview.preparation.java;

import interview.preparation.java.OuterAndInnerClasses.InnerClass;
import interview.preparation.java.OuterAndStaticClasses.StaticClass;

public class OuterInnerStaticMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//we can create the instance of the static class without outer class reference
		StaticClass staticInnerClass = new StaticClass();
		
		//for creation of inner class instance we need a outer class reference;
		InnerClass innerClass = new OuterAndInnerClasses().new InnerClass();
	
		
		System.out.println(staticInnerClass.callingStaticOuterClassNonStaticMethod());
		System.out.println(staticInnerClass.staticClassMethod());
	
		
		System.out.println(innerClass.innerNonStaticMethod());
		System.out.println(InnerClass.innerStaticMethod());
	
	}

}
