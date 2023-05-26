package le06.exercicios.ex04;

public class PlanoCartesiano 
{
	private Ponto eixoX, eixoY;
	
	public PlanoCartesiano() 
	{
		eixoX = new Ponto();
		eixoY = new Ponto();
	}
	
	public PlanoCartesiano(double x, double y)
	{
		eixoX = new Ponto(x, 0);
		eixoY = new Ponto(0, y);
	}

	public double getX() 
	{
		return eixoX.getX();
	}

	public void setX(double x) 
	{
		this.eixoX.setX(x);
	}

	public Ponto getY() 
	{
		return eixoY;
	}

	public void setY(double y) 
	{
		this.eixoY.setY(y);
	}

	@Override
	public String toString() 
	{
		return String.format("(%.1f, %.1f)", eixoX.getX(), eixoY.getY());
	}	
}
