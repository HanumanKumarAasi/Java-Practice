package concepts.designpatterns.structural.FlyweightPattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import concepts.designpatterns.structural.FlyweightPattern.ShapeFactory.ShapeType;

public class FlyweightPattern {
	
	public static void main(String[] args) {
		DrawingClient drawing = new DrawingClient(500,600);
	}

}

interface Shape {

	public void draw(Graphics g, int x, int y, int width, int height,
			Color color);
}

//Inorder to reduce the time consuming delays we will be using flyweight pattern

// we will creating the factoryclass and will be returning the object form the map if exists else we will be creating 
//new object and adding it to map and returning it.

class ShapeFactory {

	private static final HashMap<ShapeType,Shape> shapes = new HashMap<ShapeType,Shape>();

	public static Shape getShape(ShapeType type) {
		Shape shapeImpl = shapes.get(type);

		if (shapeImpl == null) {
			if (type.equals(ShapeType.OVAL_FILL)) {
				shapeImpl = new Oval(true);
			} else if (type.equals(ShapeType.OVAL_NOFILL)) {
				shapeImpl = new Oval(false);
			} else if (type.equals(ShapeType.LINE)) {
				shapeImpl = new Line();
			}
			//here we will be adding if the shape object is not there in Map
			shapes.put(type, shapeImpl);
		}
		return shapeImpl;
	}
	
	public static enum ShapeType{
		OVAL_FILL,OVAL_NOFILL,LINE;
	}
}


class DrawingClient extends JFrame{

	private static final long serialVersionUID = -1350200437285282550L;
	private final int WIDTH;
	private final int HEIGHT;

	private static final ShapeType shapes[] = { ShapeType.LINE, ShapeType.OVAL_FILL,ShapeType.OVAL_NOFILL };
	private static final Color colors[] = { Color.RED, Color.GREEN, Color.YELLOW };
	
	public DrawingClient(int width, int height){
		this.WIDTH=width;
		this.HEIGHT=height;
		Container contentPane = getContentPane();

		JButton startButton = new JButton("Draw");
		final JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(startButton, BorderLayout.SOUTH);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Graphics g = panel.getGraphics();
				for (int i = 0; i < 20; ++i) {
					Shape shape = ShapeFactory.getShape(getRandomShape());
					shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
							getRandomHeight(), getRandomColor());
				}
			}
		});
	}
	
	private ShapeType getRandomShape() {
		return shapes[(int) (Math.random() * shapes.length)];
	}

	private int getRandomX() {
		return (int) (Math.random() * WIDTH);
	}

	private int getRandomY() {
		return (int) (Math.random() * HEIGHT);
	}

	private int getRandomWidth() {
		return (int) (Math.random() * (WIDTH / 10));
	}

	private int getRandomHeight() {
		return (int) (Math.random() * (HEIGHT / 10));
	}

	private Color getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	
}












//Adding some delay while creation of the objects as shown below.
class Line implements Shape {

	public Line(){
		System.out.println("Creating Line object");
		//adding time delay
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void draw(Graphics line, int x1, int y1, int x2, int y2,
			Color color) {
		line.setColor(color);
		line.drawLine(x1, y1, x2, y2);
	}

}


class Oval implements Shape {
	
	//intrinsic property
	private boolean fill;
	
	public Oval(boolean f){
		this.fill=f;
		System.out.println("Creating Oval object with fill="+f);
		//adding time delay
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void draw(Graphics circle, int x, int y, int width, int height,
			Color color) {
		circle.setColor(color);
		circle.drawOval(x, y, width, height);
		if(fill){
			circle.fillOval(x, y, width, height);
		}
	}

}