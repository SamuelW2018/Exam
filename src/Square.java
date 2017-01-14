
public class Square implements Shape{
	private int ID;
	private String Color;
	private int Side;
	private int Area;
	private int Perimeter;
	
	public Square(String C, int I, int S)
	{
		Color = C;
		ID = I;
		Side = S;
		Area = S*S;
		Perimeter = 4*S;
	}
	
	public String toString()
	{
		return "Square (ID# " + ID + ")\n";
	}

	public String getKind() {
		// TODO Auto-generated method stub
		return "Square";
	}

	public String getDetailString() {
		// TODO Auto-generated method stub
		return toString() + "Color: " + Color + "\n Side: " + Side + "\n Area: " + Area + "\n Perimeter: " + Perimeter;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
}
