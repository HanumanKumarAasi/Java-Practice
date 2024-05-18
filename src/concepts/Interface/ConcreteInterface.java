package concepts.Interface;

public interface ConcreteInterface {
	
	int a = 10;
	
	default String hello() { //default Method
		return "hello hanuman";
	}
	
	void abstractHello(); //abstract method

}
