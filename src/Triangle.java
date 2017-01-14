
public class Triangle implements Shape{

	private int ID;
	private String Color;
	private int SideA;
	private int SideB;
	private int SideC;
	private double Area;
	private double Perimeter;
	
	public Triangle(String C, int I, int S1, int S2, int S3)
	{
		Color = C;
		ID = I;
		SideA = S1;
		SideB = S2;
		SideC = S3;
		int s = (S1+S2+S3)/2;
		Area = Math.sqrt(s*(s-S1)*(s-S2)*(s-S3));
		Perimeter = S1+S2+S3;
	}
	
	public String toString()
	{
		return "Triangle (ID# " + ID + ")\n";
	}

	public String getKind() {
		// TODO Auto-generated method stub
		return "Triangle";
	}

	public String getDetailString() {
		// TODO Auto-generated method stub
		return toString() + "Color: " + Color + "\n Side A: " + SideA + "\n Side B: " + SideB + "\n Side C: " + SideC + "\n Area: " + Area + "\n Perimeter: " + Perimeter;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
}
