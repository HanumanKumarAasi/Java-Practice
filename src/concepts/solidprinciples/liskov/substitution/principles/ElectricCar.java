package concepts.solidprinciples.liskov.substitution.principles;

public class ElectricCar extends Vehicle{

	@Override
	public String printVehicleName() {
		return "ElectricCar";
	}
	@Override
	public String printModel() {
		return "ElectricModel-123";
	}
}
