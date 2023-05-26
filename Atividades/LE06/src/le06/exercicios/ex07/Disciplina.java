package le06.exercicios.ex07;

public class Disciplina 
{
	private String nomeDisciplina;
	private float nota;
		
	public Disciplina() 
	{
		nomeDisciplina = "";
		nota = 0;
	}

	public Disciplina(String nomeDisciplina, float nota) 
	{
		this.nomeDisciplina = nomeDisciplina;
		this.nota = nota;
	}

	public String getNomeDisciplina() 
	{
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) 
	{
		this.nomeDisciplina = nomeDisciplina;
	}

	public float getNota() 
	{
		return nota;
	}

	public void setNota(float nota) 
	{
		if(nota > 0)
			this.nota = nota;
	}

	@Override
	public String toString() 
	{
		return String.format("%s, %.1f", nomeDisciplina, nota);
	}
}
