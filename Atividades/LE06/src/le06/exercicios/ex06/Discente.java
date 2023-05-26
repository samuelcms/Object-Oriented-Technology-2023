package le06.exercicios.ex06;

import java.util.ArrayList;
import java.util.List;

import le06.exercicios.ex07.Disciplina;

public class Discente 
{
	public static String REGEX_MATRICULA = "^[A-Z]{1,3}\\d{4}-\\d{1,3}$";
	
	private static int numeroDiscentes;
	
	private String nomeDiscente, nomeCurso, matricula;
	private int numeroDisciplinas;

	private List<Disciplina> disciplinas;
		
	public Discente()
	{
		numeroDiscentes++;		
		disciplinas = new ArrayList<>();
		nomeCurso = nomeDiscente = matricula = "";
	}

	public Discente(String matricula, String nomeDiscente, String nomeCurso) 
	{
		this();
		this.nomeDiscente = nomeDiscente;
		this.nomeCurso = nomeCurso;
		this.matricula = matricula;
	}
	
	public Discente(String matricula, String nomeDiscente, String nomeCurso, int quantidadeDisciplinas) 
	{
		this(matricula, nomeDiscente, nomeCurso);
		numeroDisciplinas = quantidadeDisciplinas;
	}
		
	public static int getNumeroDiscentes() 
	{
		return numeroDiscentes;
	}
	
	public String getNomeDiscente() 
	{
		return nomeDiscente;
	}

	public void setNomeDiscente(String nomeDiscente) 
	{
		this.nomeDiscente = nomeDiscente;
	}

	public String getNomeCurso() 
	{
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) 
	{
		this.nomeCurso = nomeCurso;
	}

	public String getMatricula() 
	{
		return matricula;
	}
	
	public int getNumeroDisciplinas() 
	{
		return numeroDisciplinas;
	}

	public void setNumeroDisciplinas(int numeroDisciplinas) 
	{
		this.numeroDisciplinas = numeroDisciplinas;
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s, %s, %s", matricula, nomeDiscente, nomeCurso);
	}
	
	public void adicionarDisciplina(String nomeDisciplina, float nota)
	{
		disciplinas.add(new Disciplina(nomeDisciplina, nota));
	}
	
	public int qtdDisciplinasCadastradads()
	{
		return disciplinas.size();
	}

	public static int numeroDiscentes()
	{
		return numeroDiscentes;
	}
	
	// Obtém o nome e a nota de todas as disciplinas cursadas pelo discente.
	public Object[][] obterRelacaoDisciplinas()
	{		
		Object boletim[][] = new Object[disciplinas.size()][];
		int indice = 0;
		
		for(Disciplina disciplina : disciplinas)
		{
			boletim[indice] = new Object[]{disciplina.getNomeDisciplina(), disciplina.getNota()};
			indice++;
		}
		
		return boletim;
	}
	
	// Verifica se o aluno está aprovado.
	public boolean aprovado()
	{
		final float MEDIA = 6;
		
		if(disciplinas.isEmpty()) 
			return false;
		
		for(Disciplina disciplina : disciplinas)
			if(disciplina.getNota() < MEDIA)
				return false;
		
		return true;
	}
	
	public void atualizarDisciplinas(Object[][] disciplinasAtualizadas)
	{
		int indiceDisciplinas = 0;
		
		if(!disciplinas.isEmpty())
		{
			for(Disciplina disciplina : disciplinas)
			{
				if(!disciplina.getNomeDisciplina().equals(String.valueOf(disciplinasAtualizadas[indiceDisciplinas][0])))
					disciplina.setNomeDisciplina(String.valueOf(disciplinasAtualizadas[indiceDisciplinas][0]));
				
				if(disciplina.getNota() != (float)disciplinasAtualizadas[indiceDisciplinas][1])
					disciplina.setNota((float)disciplinasAtualizadas[indiceDisciplinas][1]);
					
				indiceDisciplinas++;
			}
		}
	}
	
	public boolean disciplinasCadastradas()
	{
		return numeroDisciplinas == disciplinas.size() ? true : false;
	}	
}
