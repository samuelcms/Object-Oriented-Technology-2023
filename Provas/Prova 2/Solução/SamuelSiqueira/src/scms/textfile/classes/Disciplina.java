package scms.textfile.classes;

public class Disciplina extends Item
{
	private String nome;
	private float nota;
	
	public Disciplina() 
	{
		nome = "";
	}

	public Disciplina(String nome, float nota) 
	{
		this.nome = nome;
		this.nota = nota;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public float getNota() 
	{
		return nota;
	}

	public void setNota(float nota) 
	{
		this.nota = nota;
	}

	@Override
	public String toString() 
	{
		return String.format("%s - %.1f", nome, nota);
	}
		
}
