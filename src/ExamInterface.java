import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.net.URL;
import java.io.*;

import javax.swing.*;

public class ExamInterface extends JComponent implements ActionListener{
	public static ArrayList<ArrayList<String>> FileString = new ArrayList<ArrayList<String>>();
	public static ArrayList<Shape> Shapes = new ArrayList<Shape>();
	public static int CurrentLocation = 0;
	final static JTextPane J = new JTextPane();
	public static Image SquareImage;
	public static Image CircImage;
	public static Image RectImage;
	public static Image TriImage;
	public static JButton btn;
	static int widthW = 100;
	static int HeightH = 100;
	static int width2 = 200;
	public static JFrame frame;
	
	public ExamInterface()
	{
		super();
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		if (Shapes.get(CurrentLocation) instanceof Circle)
		{
			System.out.printf("C "+J.getX() + " "+J.getY());
			g2.drawImage(CircImage, 0, 0, btn);
			ImageIcon icon = new ImageIcon(CircImage);
			btn = new JButton(icon);
		}
		else if (Shapes.get(CurrentLocation) instanceof Square)
		{
			System.out.printf("Q "+J.getX() + " "+J.getY());
			g2.drawImage(SquareImage, 0, 0, btn);
			ImageIcon icon = new ImageIcon(SquareImage);
			btn = new JButton(icon);
		}
		else if (Shapes.get(CurrentLocation) instanceof Rectangle)
		{
			System.out.printf("R "+J.getX() + " "+J.getY());
			g2.drawImage(RectImage, 0, 0, btn);
			ImageIcon icon = new ImageIcon(RectImage);
			btn = new JButton(icon);
		}
		else
		{
			System.out.printf("T "+J.getX()+ " "+J.getY());
			g2.drawImage(TriImage, 0, 0, btn);
			ImageIcon icon = new ImageIcon(TriImage);
			btn = new JButton(icon);
		}
	}
	
	public static void GetFile()
	{
		
		try (FileInputStream is = new FileInputStream("shapes.txt"))
		{
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader rdr = new BufferedReader(ir);
			String line = rdr.readLine();
			ArrayList<String> ourString = new ArrayList<String>();
			while (line != null)
			{
				String[] parts = line.split(" ");
				for (String p: parts) 
				{
//					if (p.length() > 0 && p.charAt(0) == '"')
//						p = p.substring(1, p.length()-1);
					ourString.add(p);
				}
				FileString.add(ourString);
				ourString = new ArrayList<String>();
				line = rdr.readLine();
				
			}
		}
		catch(Exception ex) {System.out.printf("Failed for %s\n", "shapes.txt");}
	}
	
	public static void main(String[] args)
	{
		ExamInterface E = new ExamInterface();
		frame = new JFrame("Shapes");
		JPanel Panel = new JPanel();
		//Toolkit toolkit = Toolkit.getDefaultToolkit();
//		URL sqrURL = getClass().getResource("https://en.wikipedia.org/wiki/File:Green_square.svg");
//		URL triURL = getClass().getResource("https://en.wikipedia.org/wiki/File:Green_equilateral_triangle_point_up.svg");
//		URL recURL = getClass().getResource("https://en.wikipedia.org/wiki/Rectangle#/media/File:Rectangle_Geometry_Vector.svg");
//		URL cirURL = getClass().getResource("https://commons.wikimedia.org/wiki/File:Circle_-_black_simple.svg");
		
		String square = "/graphics/square.png";
		String rect = "/graphics/rectangle.png";
		String triangle = "/graphics/triangle.png";
		String circle = "/graphics/Circle.png";
		SquareImage = Toolkit.getDefaultToolkit().getImage(ExamInterface.class.getResource(square));
		SquareImage = SquareImage.getScaledInstance(widthW, HeightH, Image.SCALE_DEFAULT);
		CircImage = Toolkit.getDefaultToolkit().getImage(ExamInterface.class.getResource(circle));
		CircImage = CircImage.getScaledInstance(widthW, HeightH, Image.SCALE_DEFAULT);
		TriImage = Toolkit.getDefaultToolkit().getImage(ExamInterface.class.getResource(triangle));
		TriImage = TriImage.getScaledInstance(widthW, HeightH, Image.SCALE_DEFAULT);
		RectImage = Toolkit.getDefaultToolkit().getImage(ExamInterface.class.getResource(rect));
		RectImage = RectImage.getScaledInstance(width2, HeightH, Image.SCALE_DEFAULT);
		JPanel Panel2 = new JPanel();
		Box box = Box.createHorizontalBox();
		Box box2 = Box.createVerticalBox();
		GetFile();
		//String ourText = "";
		
		for(int i = 0; i < FileString.size()-1; i++)
		{
			
			String ShapeType = FileString.get(i).get(0);
			if (ShapeType.equals("circle:"))
			{
				int Rad = Integer.parseInt(FileString.get(i).get(2));
				int I = Integer.parseInt(FileString.get(i).get(1));
				Shape C = new Circle(FileString.get(i).get(3), I, Rad);
				Shapes.add(C);
				String JBText = "Circle (" + I + ")";
				JButton B = new JButton(JBText);
				B.setActionCommand(""+i);
				B.addActionListener(E);
				box2.add(B);
				
			}
			else if(ShapeType.equals("square:"))
			{
				int X = Integer.parseInt(FileString.get(i).get(2));
				int I = Integer.parseInt(FileString.get(i).get(1));
				Shape Q = new Square(FileString.get(i).get(3), I, X);
				Shapes.add(Q);
				String JBText = "Square (" + I + ")";
				JButton B = new JButton(JBText);
				B.setActionCommand(""+i);
				B.addActionListener(E);
				box2.add(B);
			}
			else if(ShapeType.equals("rectangle:"))
			{
				int X = Integer.parseInt(FileString.get(i).get(2));
				int Y = Integer.parseInt(FileString.get(i).get(3));
				int I = Integer.parseInt(FileString.get(i).get(1));
				Shape R = new Rectangle(FileString.get(i).get(4), I, X, Y);
				Shapes.add(R);
				String JBText = "Rectangle (" + I + ")";
				JButton B = new JButton(JBText);
				B.setActionCommand(""+i);
				B.addActionListener(E);
				box2.add(B);
			}
			else
			{
				int S1 = Integer.parseInt(FileString.get(i).get(2));
				int S2 = Integer.parseInt(FileString.get(i).get(3));
				int S3 = Integer.parseInt(FileString.get(i).get(4));
				int I = Integer.parseInt(FileString.get(i).get(1));
				Shape T = new Triangle(FileString.get(i).get(5), I, S1, S2, S3);
				Shapes.add(T);
				String JBText = "Triangle (" + I + ")";
				JButton B = new JButton(JBText);
				B.setActionCommand(""+i);
				B.addActionListener(E);
				box2.add(B);
			}
		}
		
		Panel.add(box2);
		
		JScrollPane Scroller = new JScrollPane(Panel);
		box.add(Scroller);
		frame.setSize(500, 500);
		J.setText(Shapes.get(0).getDetailString());
		
		Panel2.add(J);
		Panel2.add(E);
		box.add(Panel2);
		ImageIcon icon = new ImageIcon(CircImage);
		btn = new JButton(icon);
		box.add(btn);
		frame.add(box);
		
		
		//frame.add(E);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ourText = "";
		String actionCommand = (((JButton)e.getSource()).getActionCommand());
		int Location = Integer.parseInt(actionCommand);
		CurrentLocation = Location; 
		
		J.setText(Shapes.get(Location).getDetailString());
		//repaint();
	}
}
