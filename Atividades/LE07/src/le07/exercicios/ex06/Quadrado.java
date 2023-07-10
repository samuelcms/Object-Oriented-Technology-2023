package le07.exercicios.ex06;

import java.awt.Color;

public final class Quadrado extends Forma2D 
{
	private float lado;
	
	public Quadrado() 
	{
		// Chamada explícita ao construtor Forma2D(String, Color) da superclasse Forma2D.
		super("Quadrado", Color.DARK_GRAY);		
	}

	public Quadrado(String nome, Color cor) 
	{
		// Chamada explícita ao construtor Forma2D(String, Color) da superclasse Forma2D.
		super(nome, cor);
	}
	
	public Quadrado(String nome, Color cor, String unidade) 
	{
		// Chamada explícita ao construtor Forma2D(String, Color, String) da superclasse Forma2D.
		super(nome, cor, unidade);
	}
	
	public Quadrado(float lado) 
	{
		super("Quadrado", Color.DARK_GRAY);	
		setLado(lado);
	}
		
	public Quadrado(String nome, Color cor, float lado) 
	{
		super(nome, cor);
		setLado(lado);
	}
	
	public Quadrado(String nome, Color cor, String unidade, float lado) 
	{
		super(nome, cor, unidade);
		setLado(lado);
	}

	public float getLado() 
	{
		return lado;
	}

	public Quadrado setLado(float lado) 
	{
		if(lado > 0)
			this.lado = lado;
		
		return this;
	}

	@Override
	public String toString() 
	{
		return String.format("%s: %s - Lado: %,1.2f %s", super.toString(), nome, lado, unidade);
	}

	@Override
	public double area() 
	{
		return lado * lado;
	}
	
	
	
} // class Quadrado
