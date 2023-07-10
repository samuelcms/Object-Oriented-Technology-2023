package le07.exercicios.ex06;

import java.awt.Color;

public final class Circulo extends Forma2D 
{
	private float raio;
	
	public Circulo() 
	{
		// Chamada explícita ao construtor Forma2D(String, Color) da superclasse Forma2D.
		super("Círculo", Color.LIGHT_GRAY);		
	}

	public Circulo(String nome, Color cor) 
	{
		// Chamada explícita ao construtor Forma2D(String, Color) da superclasse Forma2D.
		super(nome, cor);
	}

	public Circulo(String nome, Color cor, String unidade) 
	{
		// Chamada explícita ao construtor Forma2D(String, Color, String) da superclasse Forma2D.
		super(nome, cor, unidade);
	}
		
	public Circulo(float raio) 
	{
		super("Círculo", Color.LIGHT_GRAY);
		setRaio(raio);
	}
	
	public Circulo(String nome, Color cor, float raio) 
	{
		super(nome, cor);
		setRaio(raio);
	}
	
	public Circulo(String nome, Color cor, String unidade, float raio) 
	{
		super(nome, cor, unidade);
		setRaio(raio);
	}

	public float getRaio() 
	{
		return raio;
	}

	public Circulo setRaio(float raio) 
	{
		if(raio > 0)
			this.raio = raio;
		
		return this;
	}

	@Override
	public String toString()
	{
		return String.format("%s: %s - Raio: %,1.2f %s", super.toString(), nome, raio, unidade);
	}

	@Override
	public double area() 
	{
		return Math.PI * raio * raio;
	}
		
} // class Circulo
