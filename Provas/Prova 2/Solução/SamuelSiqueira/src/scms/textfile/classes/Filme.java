package scms.textfile.classes;

public class Filme extends Item
{
	private String nome;
	private int duracaoMinutos;
	
	public Filme() 
	{
		nome = "";
	}

	public Filme(String nome, int duracaoMinutos) 
	{
		this.nome = nome;
		this.duracaoMinutos = duracaoMinutos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public int getDuracaoMinutos() 
	{
		return duracaoMinutos;
	}

	public void setDuracaoMinutos(int duracaoMinutos) 
	{
		this.duracaoMinutos = duracaoMinutos;
	}

	@Override
	public String toString() 
	{
		return String.format("%s  - %d m", nome, duracaoMinutos);
	}	
}
