package le06.exercicios.ex14;

public class Pessoa 
{
	private String nome, sexo, dataNascimento;
	private float altura, peso;
	private ExercicioList listaExercicios;
	
	private static final String STR_NOME = "Nome:",
						  		STR_MAIOR_DURACAO = "Maior duração de um exercício:",
						  		STR_MAIOR_DISTANCIA  = "Maior distância percorrida:",
						  		STR_MAIOR_PERDA_CALORIAS = "Maior número de calorias perdidas:",
						  		STR_MAIOR_QTD_PASSOS = "Maior número de passos dados:",
						  		STR_MAIOR_VELOCIDADE = "Maior velocidade atingida:";
	
	public Pessoa() 
	{
		nome = sexo = dataNascimento = "";
		listaExercicios = new ExercicioList();
	}
		
	public Pessoa(String nome, String sexo) 
	{
		this();
		
		this.nome = nome;
		this.sexo = sexo;
	}

	public Pessoa(String nome, String sexo, String dataNascimento) 
	{
		this(nome, sexo);
		this.dataNascimento = dataNascimento;
	}
	
	public Pessoa(String nome, String sexo, String dataNascimento, float altura, float peso) 
	{
		this(nome, sexo, dataNascimento);
		
		this.altura = altura;
		this.peso = peso;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getSexo() 
	{
		return sexo;
	}

	public void setSexo(String sexo) 
	{
		this.sexo = sexo;
	}

	public String getDataNascimento() 
	{
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) 
	{
		this.dataNascimento = dataNascimento;
	}

	public float getAltura() 
	{
		return altura;
	}

	public void setAltura(float altura) 
	{
		this.altura = altura;
	}

	public float getPeso() 
	{
		return peso;
	}

	public void setPeso(float peso) 
	{
		this.peso = peso;
	}
	
	@Override
	public String toString() 
	{
		return String.format("Nome: %s\nSexo: %s\nAltura: %.2f m\nPeso: %.2f Kg\nData de nascimento: %s", nome, sexo, altura, peso, dataNascimento);
	}
	
	public boolean adicionarExercicio(Exercicio exercicio)
	{
		return listaExercicios.adicionarExercicio(exercicio);
	}
	
	public boolean checarChavesPrimarias(String nomeExercicio, String data) 
	{
		return listaExercicios.identificacaoValida(nomeExercicio, nomeExercicio);
	}
	
	public Exercicio obterExercicio(int indiceExercicio) 
	{
		return listaExercicios.obterExercicio(indiceExercicio);
	}
	
	public Exercicio[] obterExercicios() 
	{
		return listaExercicios.obterRelacaoExercicios();
	}
	
	/*
	 * Obtém um relatório com as seguintes informações: 
	 * 
	 * 		a) A maior duração de um exercício.
	 * 		b) A maior distância percorrida.
	 * 		c) O maior número de calorias perdidas.
	 * 		d) O maior número de passos dados.
	 * 		e) A velocidade máxima mais rápida.
	 */
	public String gerarRelatorio()
	{
		StringBuilder strb = new StringBuilder();
		
		strb.append(String.format("%s %s", STR_NOME, nome));
		strb.append(String.format("\n%s %s", STR_MAIOR_DURACAO, listaExercicios.obterMaiorDuracao()));
		strb.append(String.format("\n%s %s", STR_MAIOR_DISTANCIA, listaExercicios.obterMaiorDistancia()));
		strb.append(String.format("\n%s %s", STR_MAIOR_PERDA_CALORIAS, listaExercicios.obterMaiorPerdaCalorias()));
		strb.append(String.format("\n%s %s", STR_MAIOR_QTD_PASSOS, listaExercicios.obterMaiorQtdPassos()));
		
		if(listaExercicios.obterMaiorVelocidade() != null)
			strb.append(String.format("\n%s %s", STR_MAIOR_VELOCIDADE, listaExercicios.obterMaiorVelocidade()));
		
		return strb.toString();
	}
}
