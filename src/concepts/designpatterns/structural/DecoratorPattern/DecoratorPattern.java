package concepts.designpatterns.structural.DecoratorPattern;

public class DecoratorPattern {
	public static void main(String[] args) {
		
		//Here we can able to change the functionality of the car at runtime using decorators, but it wont be possible using Inheritance and composition
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");
		
		Car sportsLuxuryCar1 = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar1.assemble();
		
		Car sportsLuxuryCar2 = new LuxuryCar(new SportsCar(new BasicCar()));
		sportsLuxuryCar2.assemble();
	}

}

//Component Interface

interface Car {

	public void assemble();
}

//Component Implementation

class BasicCar implements Car{

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		System.out.println("Basic car..!");
	}
	
}


//Decorator class

class CarDecorator implements Car{
	
	protected Car car;
	
	public CarDecorator(Car car) {
		this.car = car;
	}

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		this.car.assemble();
	}
	
	
}

//concrete Decorator class
class SportsCar extends CarDecorator{

	public SportsCar(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void assemble(){
		super.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
	
}

class LuxuryCar extends CarDecorator{

	public LuxuryCar(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void assemble(){
		super.assemble();
		System.out.print(" Adding features of Luxury Car.");
	}
	
}

