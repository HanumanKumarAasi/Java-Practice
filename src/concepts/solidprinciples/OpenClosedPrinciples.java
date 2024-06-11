package concepts.solidprinciples;

import concepts.solidprinciples.open.closed.principle.ElectricCar;
import concepts.solidprinciples.open.closed.principle.EngineCar;

public class OpenClosedPrinciples {
	
	public static void main(String args[]) {
		ElectricCar electricVehicle = new ElectricCar();
		System.out.println(electricVehicle.model());
		System.out.println(electricVehicle.turnOnElectric());
		
		System.out.println();
		
		EngineCar engineVehicle = new EngineCar();
		System.out.println(engineVehicle.model());
		System.out.println(engineVehicle.turnOnEngine());
	}

}
