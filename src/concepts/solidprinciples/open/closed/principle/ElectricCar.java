package concepts.solidprinciples.open.closed.principle;

public class ElectricCar extends Vehicle{
	
	public String turnOnElectric(){
		return "Electric Vehicle turned on";
	}
	
	@Override
	public String model() {
		return "Electric Vehicle";
	}

}
