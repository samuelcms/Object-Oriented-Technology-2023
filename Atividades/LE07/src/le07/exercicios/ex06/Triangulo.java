package le07.exercicios.ex06;

import java.awt.Color;

public final class Triangulo extends Forma2D 
{
	private float base, altura;
	
	public Triangulo() 
	{
		// Chamada explícita ao construtor Forma2D(String, Color) da superclasse Forma2D.
		super("Triangulo", Color.GRAY);
	}

	public Triangulo(String nome, Color cor) 
	{
		// Chamada explícita ao construtor Forma2D(String, Color) da superclasse Forma2D.
		super(nome, cor);
	}

	public Triangulo(String nome, Color cor, String unidade) 
	{
		// Chamada explícita ao construtor Forma2D(String, Color, String) da superclasse Forma2D.
		super(nome, cor, unidade);
	}
	
	public Triangulo(float base, float altura) 
	{
		super("Círculo", Color.GRAY);
		setBase(base);
		setAltura(altura);
	}

	public Triangulo(String nome, Color cor, float base, float altura) 
	{
		super(nome, cor);
		setBase(base);
		setAltura(altura);
	}

	public Triangulo(String nome, Color cor, String unidade, float base, float altura) 
	{
		super(nome, cor, unidade);
		setBase(base);
		setAltura(altura);
	}
	
	public float getBase() 
	{
		return base;
	}

	public Triangulo setBase(float base) 
	{
		if(base > 0)
			this.base = base;
		
		return this;
	}

	public float getAltura() 
	{
		return altura;
	}

	public Triangulo setAltura(float altura) 
	{		
		if(altura > 0)
			this.altura = altura;
		
		return this;
	}

	@Override
	public String toString()
	{
		return String.format("%s: %s - Base: %,1.2f %5$s, Altura: %4$,1.2f %5$s", super.toString(), nome, base, altura, unidade);
	}

	@Override
	public double area() 
	{
		return (base * altura) / 2.0;  
	}

} // class Triangulo
