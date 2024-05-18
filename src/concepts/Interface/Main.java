package concepts.Interface;

public class Main {
	
	public static void main(String args[]) {
		ConcreteClass concreteClass = new ConcreteClass();
		String interfaceDefaultMethodValue = concreteClass.hello();
		System.out.println(interfaceDefaultMethodValue);
		concreteClass.abstractHello();
	}

}
