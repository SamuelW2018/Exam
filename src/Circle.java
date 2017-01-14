
public class Circle implements Shape{

	private int ID;
	private String Color;
	private int Radius;
	private double Area;
	private double Perimeter;
	
	public Circle(String C, int I, int R)
	{
		Color = C;
		ID = I;
		Radius = R;
		Area = R*R*3.14;
		Perimeter = 2*R*3.14;
	}
	
	public String toString()
	{
		return "Circle (ID# " + ID + ")\n";
	}

	public String getKind() {
		// TODO Auto-generated method stub
		return "Circle";
	}

	public String getDetailString() {
		// TODO Auto-generated method stub
		return toString() + "Color: " + Color + "\n Radius: " + Radius + "\n Area: " + Area + "\n Perimeter: " + Perimeter;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
