package concepts.designpatterns.structural.AdapaterPattern;

public class Socket {
	

	
	public Volt getVolt(){
		//this is the wall socket that will always produces 120v.
		return new Volt(120);
	}

}
