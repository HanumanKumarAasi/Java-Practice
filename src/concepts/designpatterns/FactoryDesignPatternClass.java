package concepts.designpatterns;

//Client class
public class FactoryDesignPatternClass {
	public static void main(String[] args) {
		
		/*
		 * Here the Instantiation of Computer class got bypassed because Factory class
		 * is taking care of it by using factory method for creation of appropriate
		 * objects(it will return the sub class object based on the input we pass)
		 */		
		
		Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		System.out.println("Factory PC Config::"+pc);
		System.out.println("Factory Server Config::"+server);
	}
}


//Factory Class that created the factory method in it for helping the client class
class ComputerFactory {

	//factory method
	public static Computer getComputer(String type, String ram, String hdd, String cpu){
		if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
		else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
		
		return null;
	}
}

