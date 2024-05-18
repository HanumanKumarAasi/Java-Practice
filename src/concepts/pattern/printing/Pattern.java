package concepts.pattern.printing;

public class Pattern {
	
	public void printSquare(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<height;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void printZero(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<height;j++) {
				if(i==0 || i==height-1) {
				System.out.print("*");
				}else if(j==0 || j==height-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	
	public void printRightAngle(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void printReverseRightAngle(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<height-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void printInverseRightAngle(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<height-i-1;j++) {
				System.out.print(" ");
			}
			
			for(int k=0;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void printTraingle(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<height-i-1;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++) {
				System.out.print("*");
			}
			for(int j=0;j<height-i-1;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	
	}
	
	public void printReverseTraingle(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<2*(height-i)-1;j++) {
				System.out.print("*");
			}
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	
	}
	
	public void printRhombus(int height) {
		printTraingle(height);
		printReverseTraingle(height);
	
	}
	
	public void printRightArrow(int height) {
		printRightAngle(height);
		printReverseRightAngle(height-1);
	}
	
	public void print101RightAngle(int height) {
		int temp=0;
		for(int i=0;i<height;i++) {
			if(i%2==0) temp=1;
			else temp=0;
			for(int j=0;j<=i;j++) {
				System.out.print(temp);
				temp=1-temp;
			}
			System.out.println();
		}
	}
	
	
	public void printRightAngleAlphabets(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print((char)(65+j));
			}
			System.out.println();
		}
	}
	
	public void printReverseRightAngleAlphabets(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<height-i;j++) {
				System.out.print((char)(65+j));
			}
			System.out.println();
		}
	}
	
	//A BB CCC DDDD
	
	public void printRightAngleOfSameAlphabets(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print((char)(65+i));
			}
			System.out.println();
		}
	}
	
	public void printAlphabetTraingle(int height) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<height-i-1;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++) {
				System.out.print("*");
			}
			for(int j=0;j<height-i-1;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	
	}
	
	public void printPattern18(int height) {
		for(int i=0;i<height;i++) {
			for(int j=height-i;j<=height;j++) {
				System.out.print((char)(65+j-1));
			}
			System.out.println();
		}
	}
	
	public void printPattern20(int height) {
		for(int i=0;i<2*height-1;i++) {
			int stars = i;
			int spaces = 2*(height-1);
			if(i>height) {
				stars -=1;
				spaces +=2;
			}
			
			//star
			for(int j=0;j<=stars;j++) {
				System.out.print("*");
			}
			//spaces
			for(int j=0;j<spaces;j++) {
				System.out.print(" ");
			}
			//star
			for(int j=0;j<=stars;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void printPatter22(int n) {
			for(int i=0;i<=2*n-1;i++) {
				for(int j=0;j<=2*n-1;j++) {
	
				
			}
		}	
	}
	
	

}
