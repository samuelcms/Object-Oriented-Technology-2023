package le03.exercicios.ex04;

import static java.lang.String.format;

public class Dicionario 
{
	private static final char SEPARADOR_PADRAO = '#';
	private static final int VAZIO = 0;
	
	private StringBuilder dicionario;
	private char separador;
	private int tamanho;

	// Construtor Default.
	public Dicionario() 
	{
		dicionario = new StringBuilder();
		separador = SEPARADOR_PADRAO;
	}	

	// Construtor sobrecarregado para definir o caractere separador.
	public Dicionario(char separador) 
	{
		this.separador = separador;
	}

	// Construtor sobrecarregado para definir o tamanho inicial.
	public Dicionario(int tamanho) 
	{
		this.tamanho = tamanho;
	}
	
	// Construtor sobrecarregado para definir o caractere separador e o tamanho inicial.
	public Dicionario(char separador, int tamanho) 
	{
		this.separador = separador;
		this.tamanho = tamanho;
	}
	
	// Obtém o caractere separador.
	public char getSeparador() 
	{
		return separador;
	}

	/* 
	 * Retorna uma representação String das palavras do dicionário juntamente com o 
	 * caractere separador.
	 * 
	 * 		Ex.: palavra1#palavra2#palavra# 
	 */
	@Override
	public String toString() 
	{
		return dicionario.toString();
	}

	/* 
	 * Adiciona a palavra no dicionário. Retorna true se a palavra foi adicionada no 
	 * dicionário ou false se não. 
	 */
	public boolean adicionarPalavra(String palavra)
	{
		if(!consultarPalavra(palavra))
		{
			if(!dicionario.isEmpty()) 
				dicionario.append(separador);
			
			dicionario.append(palavra);
			incrementarTamanho();
			
			return true;				
		}
		return false;
	}
	
	// Obtém o número de palavras do dicionário.
	public int tamanho()
	{
		int numPalavras = contarPalavras();
		
		/* 
		 * Verifica se o atributo 'tamanho' corresponde ao número atual de palavras do dicionário,
		 * impedindo que haja divergência quanto a quantidade de palavras. 
		 * 
		 * 		Ex.: Se o usuário utilizar o construtor com a opção de definir o tamanho inicial 
		 * 		passando "4" e o dicionário possuir apenas "2" palavras, o atributo tamanho indicará 
		 * 		a existência de 4 palavras. Neste caso, a função 'contarPalavras()' é invocada para 
		 * 		eliminar inconsistências.  
		 */ 
		return (tamanho != numPalavras) ? numPalavras : tamanho;
	}
	
	/* 
	 * Obtém uma lista de palavras do dicionário separadas pelo caractere separador que começam
	 * com o caractere especificado. Retorna null se nenhuma palavra existir no dicionário. 
	 */
	public String obterPalavras(char caractere)
	{					
		return obterPalavras(String.valueOf(caractere));
	}
	
	/* 
	 * Obtém uma lista de palavras do dicionário separadas pelo caractere separador que começam
	 * com a substring especificada. Retorna null se nenhuma palavra existir no dicionário. 
	 */
	public String obterPalavras(String substring)
	{
		String[] palavras = obterListaDePalavras();
		StringBuilder palavrasEncontradas = new StringBuilder();
		
		if(palavras.length != VAZIO)
		{
			for(String palavra : palavras)
				if(palavra.startsWith(substring))
					palavrasEncontradas.append(format("%s%c", palavra, separador));
			
			if(!palavrasEncontradas.isEmpty())
				return palavrasEncontradas.deleteCharAt(palavrasEncontradas.length()-1).toString();						
		}
		
		return null;
	}
	
	/* 
	 * Obtém uma lista com todas as palavras do dicionário separadas pelo caractere separador.
	 * Retorna null se nenhuma palavra existir no dicionário. 
	 */
	public String listar()
	{
		return (!dicionario.isEmpty()) ? toString() : null;
	}
	
	// Pesquisa uma palavra no dicionário.
	public boolean consultarPalavra(String palavra)
	{
		if(!dicionario.isEmpty())
		{
			String palavras = obterPalavras(palavra);
			
			// Verificando se a pesquisa de palavras no dicionário retornou algum resultado.
			if(palavras != null)
			{
				String listaPalavras[] = palavras.split(String.valueOf(separador));
				
				if(listaPalavras != null)
				{
					for(String buffer : listaPalavras)
						if(palavra.equalsIgnoreCase(buffer))
							return true;
				}
			}
		}
		return false;	
	}
	
	// Altera uma palavra no dicionário substituindo-a por uma outra palavra.
	public boolean alterarPalavra(String palavraAtual, String palavraNova)
	{
		int index = 0;

		if(consultarPalavra(palavraAtual))
		{
			index = indicePalavra(palavraAtual);
			dicionario.replace(index, (palavraAtual.length() + index), palavraNova);
			return true;
		}
		return false;
	
	} // alterar()

	// Exclui a palavra do dicionário.
	public boolean excluirPalavra(String palavra)
	{
		int index = 0;

		if(consultarPalavra(palavra))
		{
	        index = indicePalavra(palavra);
			
			if(index == 0)
				dicionario.delete(index, (palavra.length() + index));
	        
			else
				dicionario.delete(index - 1, (palavra.length() + index));
			
			// Verificando se o primeiro caractere após a exclusão é o carcatere separador.
			if(dicionario.charAt(0) == separador)
	        	dicionario.deleteCharAt(0);
			
			// Verificando se o último caractere após a exclusão é o carcatere separador.
	        if(dicionario.charAt(dicionario.length() - 1) == separador)
	        	dicionario.deleteCharAt(dicionario.length() - 1);
	        
	        decrementarTamanho();
	        
			return true;
		}		
		return false;
	
	} // excluir()
	
	// Verifica se o dicionário está vazio.
	public boolean isEmpty()
	{
		return dicionario.isEmpty();
	}
	
	// Conta as palavras do dicionario. 
	private int contarPalavras()
	{
		return dicionario.toString().split(String.valueOf(separador)).length; 
	}
	
	/*
	 *	Obtém um vetor com as palavras do dicionário. Caso este esteja vazio, o valor null é retornado. 
	 */ 
	private String[] obterListaDePalavras()
	{
		return dicionario.toString().split(String.valueOf(separador));
	}
	
	/*
	 *	Obtém a posição relativa da primeira ocorrência de uma palavra no dicionário, ou seja, o 
	 *	índice inicial do primeiro caractere desta. Retorna o índice da palavra, caso a tenha 
	 *	encontrado ou -1 (INDICE_INVALIDO).  
	 */
	private int indicePalavra(String palavra)
	{
		return dicionario.indexOf(palavra);
	}
		
	// Incrementa o atributo tamanho do dicionário através da contagem de palavras. 
	private void incrementarTamanho()
	{
		if(tamanho == contarPalavras())
			tamanho++;
	}

	// Decrementa o atributo tamanho do dicionário através da contagem de palavras. 
	private void decrementarTamanho()
	{
		if(tamanho == contarPalavras())
			tamanho--;
	}
		
	/*
	 * Verifica se uma string é válida, neste caso, se é diferente de null e não vazia. 
	 * Retorna true se a string for válida ou false, caso contrário.
	 */
	public static boolean isValid(String string)
	{
		return (string != null && !string.isBlank()) ? true : false;
	}
		
} // class Dicionario
