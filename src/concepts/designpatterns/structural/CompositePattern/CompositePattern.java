package concepts.designpatterns.structural.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
	public static void main(String[] args) {
		Shape tri = new Triangle();
		Shape tri1 = new Triangle();
		Shape cir = new Circle();
		
		//Here we have added multiple leaf objects into the composite object and treating all of them in the same like
		//like applying the red color to all of them like shown below.
		Drawing drawing = new Drawing();
		drawing.add(tri1);
		drawing.add(tri1);
		drawing.add(cir);
		
		drawing.draw("Red");
		
		drawing.clear();
		
		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("Green");
	}
}

//1. Base Component
interface Shape {

	public void draw(String fillColor);
}


// 2.1 leaf objects
class Triangle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color "+fillColor);
	}

}
//2.2 leaf objects
 class Circle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color "+fillColor);
	}

}
 
 //3. Composite Object - Client class that is implementing the Base component(Interface/abstract)
 class Drawing implements Shape{

		//collection of Shapes
		private List<Shape> shapes = new ArrayList<Shape>();

		@Override
		public void draw(String fillColor) {
			for(Shape sh : shapes)
			{
				sh.draw(fillColor);
			}
		}

		//adding shape to drawing
		public void add(Shape s){
			this.shapes.add(s);
		}

		//removing shape from drawing
		public void remove(Shape s){
			shapes.remove(s);
		}

		//removing all the shapes
		public void clear(){
			System.out.println("Clearing all the shapes from drawing");
			this.shapes.clear();
		}
	}