
public class Rectangle implements Shape{
	private int ID;
	private String Color;
	private int Width;
	private int Length;
	private int Area;
	private int Perimeter;
	
	public Rectangle(String C, int I, int W, int L)
	{
		Color = C;
		ID = I;
		Width = W;
		Length = L;
		Area = W*L;
		Perimeter = (2*W)+(2*L);
		
	}
	
	public String toString()
	{
		return "Rectangle (ID# " + ID + ")\n";
	}

	public String getKind() {
		// TODO Auto-generated method stub
		return "Rectangle";
	}

	public String getDetailString() {
		// TODO Auto-generated method stub
		return toString() + "Color: " + Color + "\n Width: " + Width + "\n Length: " + Length + "\n Area: " + Area + "\n Perimeter: " + Perimeter;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
}
