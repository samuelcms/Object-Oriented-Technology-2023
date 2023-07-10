package le07.exercicios.ex06;

import java.awt.Color;

public class Forma2D extends FormaGeometrica 
{
	public Forma2D() 
	{
		// Chamada explícita ao construtor Default da superclasse FormaGeometrica.
		super();
		
		nome = "Forma 2D";
	}

	public Forma2D(String nome, Color cor) 
	{
		// Chamada explícita ao construtor sobrecarregado da superclasse FormaGeometrica.
		super(nome, cor);
	}
	
	public Forma2D(String nome, Color cor, String unidade) 
	{
		// Chamada explícita ao construtor sobrecarregado da superclasse FormaGeometrica.
		super(nome, cor, unidade);
	}

	@Override
	public String toString() 
	{
		// Chamada explícita ao toString da superclasse FormaGeometrica.
		return String.format("%s: Forma2D", super.toString());
	}
	
	

} // class Forma2D
