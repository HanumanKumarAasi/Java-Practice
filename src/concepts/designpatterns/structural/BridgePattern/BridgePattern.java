package concepts.designpatterns.structural.BridgePattern;

public class BridgePattern {

	public static void main(String[] args) {
		
		//Here the abstraction acts as a bridge between the Client and Interface
		Shape tri = new Triangle(new RedColor());
		tri.applyColor();
		
		//Here the abstraction acts as a bridge between the Client and Interface
		Shape pent = new Pentagon(new GreenColor());
		pent.applyColor();
	}
}

//Interface
interface Color {

	public void applyColor();
}

//Abstraction
abstract class Shape {
	//Decoupled through composition
	//Composition - implementor of Interface
	protected Color color;
	
	//constructor with implementor as input argument
	public Shape(Color c){
		this.color=c;
	}
	
	abstract public void applyColor();
}

class Triangle extends Shape{

	public Triangle(Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Triangle filled with color ");
		color.applyColor();
	} 

}

class Pentagon extends Shape{

	public Pentagon(Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Pentagon filled with color ");
		color.applyColor();
	} 

}


class RedColor implements Color{

	public void applyColor(){
		System.out.println("red.");
	}
}

class GreenColor implements Color{

	public void applyColor(){
		System.out.println("green.");
	}
}
