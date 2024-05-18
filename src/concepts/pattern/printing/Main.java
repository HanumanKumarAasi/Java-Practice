package concepts.pattern.printing;

public class Main {

	
	public static void main(String args[]) {
		Pattern pattern = new Pattern();
		System.out.println("printing square :");
		pattern.printSquare(5);
		System.out.println("printing zero :");
		pattern.printZero(5);
		System.out.println("printing right angle trianle :");
		pattern.printRightAngle(5);
		System.out.println("printing inverse right angle trianle :");
		pattern.printInverseRightAngle(5);
		System.out.println("printing trianle :");
		pattern.printTraingle(7);
		System.out.println("printing reverse trianle :");
		pattern.printReverseTraingle(7);
		
		System.out.println("printing rhombus :");
		pattern.printRhombus(7);
		
		System.out.println("printing printReverseRightAngle :");
		pattern.printReverseRightAngle(7);
		
		System.out.println("printing printRightArrow :");
		pattern.printRightArrow(7);
		
		System.out.println("printing print101RightAngle :");
		pattern.print101RightAngle(5);
		
		System.out.println("printing printRightAngleAlphabets :");
		pattern.printRightAngleAlphabets(5);
		
		System.out.println("printing printReverseRightAngleAlphabets :");
		pattern.printReverseRightAngleAlphabets(5);
		
		System.out.println("printing printRightAngleOfSameAlphabets :");
		pattern.printRightAngleOfSameAlphabets(5);
		
		System.out.println("printing printPattern18 :");
		pattern.printPattern18(5);
		
		System.out.println("printing printPattern20 :");
		pattern.printPattern20(5);
		
		System.out.println("printing printPattern20 :");
		pattern.printPatter22(4);
	}
}
