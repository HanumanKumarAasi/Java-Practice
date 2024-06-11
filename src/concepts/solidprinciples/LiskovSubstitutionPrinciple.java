package concepts.solidprinciples;

import concepts.solidprinciples.liskov.substitution.principles.ElectricCar;
import concepts.solidprinciples.liskov.substitution.principles.EngineCar;
import concepts.solidprinciples.liskov.substitution.principles.Vehicle;

public class LiskovSubstitutionPrinciple {

	public static void main(String args[]) {
		// ---------Engine example-----------------
		Vehicle engineCar = new EngineCar();
		System.out.println("Vehicle type : " + engineCar.printVehicleName());
		System.out.println("is Engine vehicle : " + engineCar.printModel());
		
		
		System.out.println();
		
		
		// ---------Electric example-----------------
		Vehicle electricCar = new ElectricCar();
		System.out.println("Vehicle type : " + electricCar.printVehicleName());
		System.out.println("is Electric vehicle : " + electricCar.printModel());
	}
}
