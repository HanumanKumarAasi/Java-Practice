package concepts.solidprinciples;

import concepts.solidprinciples.dependency.inversion.principle.Bus;
import concepts.solidprinciples.dependency.inversion.principle.ElectricBus;
import concepts.solidprinciples.dependency.inversion.principle.EngineBus;
import concepts.solidprinciples.dependency.inversion.principle.School;

public class DependencyInversionPrinciple {

	public static void main(String args[]) {
		Bus electricBus = new ElectricBus();
		School schoolWithElectricBus = new School(electricBus);
		schoolWithElectricBus.getBus().printModel();
		
		System.out.println();
		
		Bus engineBus = new EngineBus();
		School schoolWithEngineBus = new School(engineBus);
		schoolWithEngineBus.getBus().printModel();
	}
}
