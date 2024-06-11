package concepts.designpatterns;

public class BuilderDesignPatternClass {
	
public static void main(String[] args) {
	
		//As per the conceptual example
		Builder builder = new Builder.ComputerBuilder("16 GB","1 TB").setBluetoothEnabled(true).setGraphicsCardEnabled(true).build();
		System.out.println(builder);
		
		System.out.println(); 
		
		//As per common example
		Computer pc = new PCBuilder("16 GB","1 TB","2.9 GHz").setIsBluetoothEnabled(Boolean.TRUE).setIsGraphicsCardEnabled(Boolean.TRUE).build();
		Computer server = new ServerBuilder("16 GB","1 TB","2.9 GHz").setIsGraphicsCardEnabled(Boolean.TRUE).setIsBluetoothEnabled(Boolean.TRUE).build();
		System.out.println("Factory PC Config::"+pc);
		System.out.println("Factory Server Config::"+server);
	}

}
