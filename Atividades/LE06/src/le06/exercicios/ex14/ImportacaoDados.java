package le06.exercicios.ex14;

import too.textfile.TextFile;

public class ImportacaoDados 
{
	public static final int
	
		/*
		 * Quantidade de seções que um arquivo pode ter levando em consideração a seguinte divisão: 
		 * 	
		 * 		- 1. Nome do exercício;
		 * 		- 2. Dados do Aluno;
		 * 		- 3. Detalhes do Exercício;
		 * 		- 4. Ritmo. 
		 * 
		 * 	Apenas arquivos do tipo 1, cujos exercícios são do mesmo gênero de Corrida ou Caminhada, 
		 * 	possuem a seção "Ritmo".  
		 */
		SECOES_ARQ_1 = 4,				 
		SECOES_ARQ_2 = 3,
		
		SECAO_EXERCICIO = 0,			 
		SECAO_DADOS_ALUNO = 1,
		SECAO_DETALHES_EXERCICIO = 2,
		SECAO_RITMO = 3,
		
		INDICE_NOME_CAMPO = 0,
		INDICE_INFORMACAO = 1,
		INDICE_VALOR = 0,
		
		INDICE_NOME_CLIENTE = 0,
		INDICE_SEXO = 1,
		INDICE_ALTURA = 2,
		INDICE_PESO = 3,
		INDICE_DATA_NASCTO = 4,
		
		INDICE_DATA_EXERCICIO = 0,
		INDICE_TEMPO = 1,
		INDICE_DURACAO = 2,
		INDICE_DISTANCIA = 3,
		INDICE_CALORIAS = 4,
		INDICE_PASSOS = 5,
		INDICE_VELOCIDADE_MEDIA = 6,
		INDICE_VELOCIDADE_MAXIMA = 7,
		INDICE_RITMO_MEDIO = 8,
		INDICE_RITMO_MAXIMO = 9,
		INDICE_MENOR_ELEVACAO = 10,
		INDICE_MAIOR_ELEVACAO = 11,
		
		QTD_CAMPOS_DADOS_ALUNO = 5,
		QTD_CAMPOS_BUFFER = 2,
		
		MIN_CAMPOS_DETALHES_EXERCICIO = 6,
		MAX_CAMPOS_DETALHES_EXERCICIO = 12;
	
	public static final String
	
		SEPARADOR_SECAO = "\n\n",
		SEPARADOR_CAMPO = ": ",
		SEPARADOR_RITMO = " Km: ",
		
		STRING_VAZIA = "",
		STRING_PONTO = ".",
		NOVA_LINHA = "\n",
		ESPACO_EM_BRANCO = " ",
		
		CABECALHO_1 = "------ Usuário  ------\n",
		CABECALHO_2 = "------ Detalhes do exercício ------ \n",
		CABECALHO_3 = "------ Ritmo ------ \n",
		CABECALHO_4 = "------ Exercícios ------ \n";
	
	public static final char
	 
		CARACTERE_PONTO = '.',
		CARACTERE_VIRGULA = ',';

	public static String obterConteudoArquivo(String nomeArquivo)
	{
		TextFile arquivo = new TextFile();
		String conteudoArquivo = null;
		
		if(arquivo.open("files/" + nomeArquivo))
			conteudoArquivo = arquivo.read();
		
		arquivo.close();
		return conteudoArquivo;
	}
	
	/*
	 *  Obtém os dados agrupados por seções:
	 *  
	 *  	1. Nome do exercício;
	 *  	2. Dados do aluno;
	 *  	3. Detalhes do exercício;
	 *  	4. Ritmo (se disponível).
	 */
	public static String[] obterSecoes(String conteudo)
	{
		return conteudo.split(SEPARADOR_SECAO);
	}
	
	/*
	 *	Remove o cabeçalho das seções que estçao definidos nas seguintes constantes:  	
	 *		
	 *		- CABECALHO_1 = "------ Usuário  ------\n";
	 *		- CABECALHO_2 = "------ Detalhes do exercício ------ \n";
	 *		- CABECALHO_3 = "------ Ritmo ------ \n".
	 */
	public static void removerCabecalhos(String[] dadosAgrupados)
	{
		dadosAgrupados[SECAO_DADOS_ALUNO] = dadosAgrupados[SECAO_DADOS_ALUNO].replaceAll(CABECALHO_1, STRING_VAZIA); 
		dadosAgrupados[SECAO_DETALHES_EXERCICIO] = dadosAgrupados[SECAO_DETALHES_EXERCICIO].replaceAll(CABECALHO_2, STRING_VAZIA);
		
		if(dadosAgrupados.length == SECOES_ARQ_1)
			dadosAgrupados[SECAO_RITMO] = dadosAgrupados[SECAO_RITMO].replaceAll(CABECALHO_3, STRING_VAZIA);
	}
	
	// Obtém o nome do exercício disponível na Seção 1.
	public static String obterNomeExercicio(String conteudo)
	{
		String dados[] = conteudo.split(SEPARADOR_CAMPO);
		return dados[INDICE_INFORMACAO];
	}

	public static String obterNomeCliente(String dadosAluno)
	{
		String conteudoSecao[] = obterDadosAluno(dadosAluno);
		return conteudoSecao[INDICE_NOME_CLIENTE];
	}

	
	// Obtém os dados do aluno disponíveis na Seção 2 e os armazena em um vetor do tipo String. 
	public static String[] obterDadosAluno(String conteudo)
	{
		String dadosBrutos[] = conteudo.split(NOVA_LINHA),
			   dadosAluno[] = new String[QTD_CAMPOS_DADOS_ALUNO],
			   buffer[];
								
		for(int i = 0; i < dadosBrutos.length; i++)
		{			
			buffer = dadosBrutos[i].split(SEPARADOR_CAMPO);				
			dadosAluno[i] = buffer[INDICE_INFORMACAO];
		}
		
		return dadosAluno;
	}
	
	// Obtém os dados do exercício disponíveis na Seção 3 e os armazena em um vetor do tipo String. 
	public static String[] obterDetalhesExercicio(String conteudo)
	{
		String dadosBrutos[] = conteudo.split(NOVA_LINHA),
			   dadosExercicio[] = new String[MAX_CAMPOS_DETALHES_EXERCICIO],
			   buffer[];
								
		for(int i = 0; i < dadosBrutos.length; i++)
		{
			buffer = dadosBrutos[i].split(SEPARADOR_CAMPO);		
			dadosExercicio[i] = buffer[INDICE_INFORMACAO];
		}

		return dadosExercicio;
	}
	
	// Substitui o caractere vírgula pelo caractere ponto de uma String. Exemplo: 76,0 -> 76.0
	public static String formatarCampoFloat(String campo)
	{
		return campo.replace(CARACTERE_VIRGULA, CARACTERE_PONTO);
	}

	// Remove o separador de milhar de um número representado por uma uma String. Exemplo: 8.298 -> 8298
	public static String formatarCampoInt(String campo)
	{
		return campo.replace(STRING_PONTO, STRING_VAZIA);
	}
	
	// Remove a unidade de medida de um determinado campo. Exemplo: 6,75 Km -> 6,75
	public static String removerUnidade(String campo)
	{
		String buffer[];
		
		buffer = campo.split(String.valueOf(ESPACO_EM_BRANCO));
		return buffer[INDICE_VALOR];
	}
	
} // class ImportacaoDados{};
