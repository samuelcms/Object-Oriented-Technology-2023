package le07.exercicios.ex06;

import java.awt.Color;

public class Forma3D extends FormaGeometrica {

	public Forma3D()
	{
		// Chamada implícita ao construtor Default da superclasse FormaGeometrica.		
		nome = "Forma 3D";
	}

	public Forma3D(String nome, Color cor) 
	{
		// Chamada explícita ao construtor sobrecarregado da superclasse FormaGeometrica.
		super(nome, cor);
	}
	
	public Forma3D(String nome, Color cor, String unidade) 
	{
		// Chamada explícita ao construtor sobrecarregado da superclasse FormaGeometrica.
		super(nome, cor, unidade);
	}

	@Override
	public String toString() 
	{
		return String.format("%s: Forma3D", super.toString());
	}
	
	

} // class Forma3D
