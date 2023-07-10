package le07.exercicios.ex06;

import java.awt.Color;

public class FormaGeometrica extends Forma
{
	protected String nome;
	protected Color cor;
	protected String unidade;
	
	public FormaGeometrica() 
	{
		super(); 			// Chamada explícita ao construtor da superclasse Forma.
		nome = "Forma Geométrica";
		cor = Color.BLACK;
		unidade = CENTIMETRO;
	}

	public FormaGeometrica(String nome, Color cor) 
	{
		/*
		 * Chamada implícita ao construtor da superclasse Forma. O Java SEMPRE invoca
		 * o construtor da superclasse direta.
		 */
		
		this.nome = nome;
		this.cor = cor;
		unidade = CENTIMETRO;
	}
	
	public FormaGeometrica(String nome, Color cor, String unidade) 
	{
		/*
		 * Chamada implícita ao construtor da superclasse Forma. O Java SEMPRE invoca
		 * o construtor da superclasse direta.
		 */
		
		this.nome = nome;
		this.cor = cor;
		this.unidade = unidade;
	}

	public final FormaGeometrica setNome(String nome) 
	{
		this.nome = nome;
		return this;
	}

	public final Color getCor() 
	{
		return cor;
	}

	public final FormaGeometrica setCor(Color cor) 
	{
		this.cor = cor;
		return this;
	}

	@Override
	public final String getNome() 
	{
		return nome;
	}
	
	@Override
	public double area() 
	{
		return super.area();
	}

	public final String getUnidade() 
	{
		return unidade;
	}

	public final FormaGeometrica setUnidade(String unidade) 
	{
		this.unidade = unidade;
		return this;
	}
	
	@Override
	public String toString() 
	{
		// Chamada explícita ao método toString() da superclasse Forma.
		return String.format("%s: FormaGeometrica", super.toString());
	}
	
	public String obterUnidadeArea()
	{
		return obterUnidadeArea(this);
	}
	
	public static String obterUnidadeArea(FormaGeometrica forma) 
	{
		return forma.getUnidade().equals(Forma.CENTIMETRO) ? Forma.CENTIMETRO_QUADRADO : Forma.METRO_QUADRADO ;
	}
	
} // class FormaGrometrica
