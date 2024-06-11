package concepts.designpatterns;

public class PCBuilder {
	
	public String ram;
	public String hdd;
	public String cpu;
	
	//optional fields which can be set using mutators or we can leave it as it is.
	public Boolean isGraphicsCardEnabled;
	public Boolean isBluetoothEnabled;
	
	public PCBuilder(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	//In order to set the optional fields we are creating the mutators in the respective Builder classes
	public PCBuilder  setIsGraphicsCardEnabled(Boolean isGraphicsCardEnabled) {
		this.isGraphicsCardEnabled = isGraphicsCardEnabled;
		return this;
	}

	public PCBuilder  setIsBluetoothEnabled(Boolean true1) {
		this.isBluetoothEnabled = true1;
		return this;
	}
	
	public PC build(){
		return new PC(this);
	}

}
