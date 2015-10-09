package environnement;

public class Place
{
	private int x;
	private int y;
	public Place(int _x,int _y)
	{
		this.setX(_x);
		this.setY(_y);
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
}
