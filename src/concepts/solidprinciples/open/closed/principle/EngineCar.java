package concepts.solidprinciples.open.closed.principle;

public class EngineCar extends Vehicle{

	public String turnOnEngine() {
		return "Engine Vehicle turned on";
	}
	
	@Override
	public String model() {
		return "Engine Vehicle";
	}
}
