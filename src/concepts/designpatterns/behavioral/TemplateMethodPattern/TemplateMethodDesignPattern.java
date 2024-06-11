package concepts.designpatterns.behavioral.TemplateMethodPattern;

public class TemplateMethodDesignPattern {
	public static void main(String[] args) {

		HouseTemplate houseType = new WoodenHouse();

		// using template method for wooden house
		houseType.buildHouse();
		
		
		System.out.println("************");

		houseType = new GlassHouse();

		// using template method for wooden house
		houseType.buildHouse();
	}
}

//Template Method Concrete Classes
//Concrete Class1
class WoodenHouse extends HouseTemplate {

	@Override
	public void buildWalls() {
		System.out.println("Building Wooden Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}

}

//Concrete Class2
class GlassHouse extends HouseTemplate {

	@Override
	public void buildWalls() {
		System.out.println("Building Glass Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with glass coating");
	}

}

//Base template for building the house
abstract class HouseTemplate {

	// template method, final so subclasses can't override
	public final void buildHouse() {
		buildFoundation();// this would be common implementation
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}

	// default implementation
	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}

	// methods to be implemented by subclasses
	public abstract void buildWalls();

	public abstract void buildPillars();

	public final void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}
}