package concepts.designpatterns;

public class ServerBuilder {
	
	public String ram;
	public String hdd;
	public String cpu;
	
	//optional fields which can be set using mutators or we can leave it as it is.
	public Boolean isGraphicsCardEnabled;
	public Boolean isBluetoothEnabled;
	
	public ServerBuilder(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}

	//In order to set the optional fields we are creating the mutators in the respective Builder classes
	public ServerBuilder  setIsGraphicsCardEnabled(Boolean isGraphicsCardEnabled) {
		this.isGraphicsCardEnabled = isGraphicsCardEnabled;
		return this;
	}

	public ServerBuilder  setIsBluetoothEnabled(Boolean isBluetoothEnabled) {
		this.isBluetoothEnabled = isBluetoothEnabled;
		return this;
	}
	
	public Server build(){
		return new Server(this);
	}
	
	
	
	

}
