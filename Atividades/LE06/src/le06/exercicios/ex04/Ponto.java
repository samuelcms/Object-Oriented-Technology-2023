package le06.exercicios.ex04;

public class Ponto
{	
	private double x, y;
	
	public Ponto()
	{
		x = 0;
		y = 0;
	}

	public Ponto(double x, double y) 
	{
		this.x = x;
		this.y = y;
	}

	public double getX() 
	{
		return x;
	}

	public void setX(double x) 
	{
		this.x = x;
	}

	public double getY() 
	{
		return y;
	}

	public void setY(double y) 
	{
		this.y = y;
	}

	@Override
	public String toString() 
	{
		return String.format("(%.1f, %.1f)", x, y);
	}
	
}
