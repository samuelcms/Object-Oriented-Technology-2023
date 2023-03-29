package le02.exercicios;

import static util.InterfaceGrafica.*;
import static java.lang.String.format;

public class Ex04 
{
	private static final char[] 
			VETOR_VOGAIS = {'a','e','i','o','u'},
			OPERADORES_ARITMETICOS = {'+','-','*','/','%'},
			SIMBOLOS_ESPECIAIS = {'@', '#', '$', '&', '<', '>', '}', '{', '\\', '|', '=', '£', '§', 'ª', 'º', '°', '¬' , '_' , '¢'},
			SINAIS_PONTUACAO = {'!', '?', ':', ';', '.', ',', '\"', ')' , '(' , ']' , '[', (char)39}, // (char)39 = Caractere apóstrofo '  
			SINAIS_ACENTUACAO = {'¨', '^', '~', '´', '`'};
	
	private static final String 
			INPUT_MSG = "Forneça uma string: ",
			TITLE = "Contagem de Caracteres";
	
	private static final int
						
			LETRAS = 0,
			VOGAIS = 1,
			CONSOANTES = 2, 
			DIGITOS = 3,
			PONTUACAO = 4,
			ACENTUACAO = 5,
			OPERADORES = 6,
			SIMBOLOS = 7,
			NUM_INFORMACOES = 8;
	
	public static void tiposCaracteres()
	{
		do 
		{
			String str = obterString(INPUT_MSG);
			
			if(str != null) 
				if(!str.isEmpty() && !str.isBlank())
					identificarCaracteres(str);
		
			msgAdvertencia("Finalizando programa.", TITLE);
			break;
			
		}while(true);
		
	}
	
	private static void identificarCaracteres(String str)
	{		
		int informacoes[] =  new int[NUM_INFORMACOES];
						
		for(int i = 0; i < str.length(); i++)
		{
			char caractere = str.charAt(i);
						
			// Se o caractere for uma letra, este pode ser uma vogal ou uma consoante.
			if(Character.isLetter(caractere))
			{
				informacoes[LETRAS]++;
				
				if(isContained(VETOR_VOGAIS, caractere) == true)
					informacoes[VOGAIS]++;
									
				else
					informacoes[CONSOANTES]++; 
			}
			
			else if(Character.isDigit(caractere))
				informacoes[DIGITOS]++;
			
			else if(isContained(OPERADORES_ARITMETICOS, caractere))
				informacoes[OPERADORES]++;
							
			else if(isContained(SIMBOLOS_ESPECIAIS, caractere))
				informacoes[SIMBOLOS]++;
			
			else if(isContained(SINAIS_ACENTUACAO, caractere))
				informacoes[ACENTUACAO]++;
							
			else if(isContained(SINAIS_PONTUACAO, caractere))
				informacoes[PONTUACAO]++;
		}
		
		exibirResultado(str, informacoes);
	}
	 
	private static void exibirResultado(String string, int[] informacoes) 
	{
		StringBuilder resultadoBuilder =  new StringBuilder();
		
		resultadoBuilder.append(format("\nString: %s\n", string));
		resultadoBuilder.append(format("\n - Número total de caracteres: %d", string.length()));
		resultadoBuilder.append(format("\n - Número de letras: %d", informacoes[LETRAS]));
		resultadoBuilder.append(format("\n 	- Vogais: %d", informacoes[VOGAIS]));
		resultadoBuilder.append(format("\n 	- Consoantes: %d", informacoes[CONSOANTES]));
		resultadoBuilder.append(format("\n - Dígitos: %d", informacoes[DIGITOS]));
		resultadoBuilder.append(format("\n - Sinais de pontuação: %d", informacoes[PONTUACAO]));
		resultadoBuilder.append(format("\n - Sinais de acentuação: %d", informacoes[ACENTUACAO]));
		resultadoBuilder.append(format("\n - Operadores aritméticos: %d", informacoes[OPERADORES]));
		resultadoBuilder.append(format("\n - Símbolos especiais: %d", informacoes[SIMBOLOS]));
		
		msgInfo(resultadoBuilder.toString(), TITLE);
	}
	
	private static String obterString(String mensagem)
	{
		return lerString(mensagem, TITLE);
	}
		
	private static boolean isContained(char[] vetor, char caractere)
	{
		for(char c : vetor)
			if(caractere == c)
				return true;
		
		return false;
	}

} // class Ex02 
