package concepts.solidprinciples.liskov.substitution.principles;

public class EngineCar extends Vehicle{
	
	@Override
	public String printVehicleName() {
		return "EngineCar";
	}
	@Override
	public String printModel() {
		return "EngineModel-123";
	}

}
