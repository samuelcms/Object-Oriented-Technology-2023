package le02.exercicios;

import static util.InterfaceGrafica.*;
import static java.lang.String.format;

public class Ex01 
{
	// Valores constantes.
	
		private static final char[] 
				
				VOGAIS = {'a','e','i','o','u'},
				OPERADORES_ARITMETICOS = {'+','-','*','/','%'},
				SIMBOLOS_ESPECIAIS = {'@', '#', '$', '&', '<', '>', '}', '{', '\\', '|', '=', '£', '§', 'ª', 'º', '°', '¬' , '_' , '¢'},
				SINAIS_PONTUACAO = {'!', '?', ':', ';', '.', ',', '\"', ')' , '(' , ']' , '[', (char)39}, // (char)39 = Caractere apóstrofo '  
				SINAIS_ACENTUACAO = {'¨', '^', '~', '´', '`'};
		
		private static final String 
		
				CATEGORY_NOT_FOUND = "Não foi possível encontrar a categoria do caractere.",
				UNIDENTIFIER_CHARACTER = "O caractere não foi identificado.", 
				INPUT_MSG = "Forneça um caractere: ", 
				MSG_VOGAL = "Vogal",
				MSG_CONSOANTE = "Consoante", 
				MSG_DIGITO = "Dígito decimal",
				MSG_OPERADOR = "Operador aritmético", 
				MSG_SIMBOLO = "Símbolo especial", 
				MSG_PONTUACAO = "Sinal de pontuação", 
				MSG_ACENTUACAO = "Sinal de acentuação", 
				TITLE = "Identificar Caractere"; 

		/**
		 * Obtém informações sobre os caracteres fornecidos através da janela exclusiva 
		 * para entrada de dados. Caso o usuário escreva mais do que um caractere ou 
		 * forneça um caractere inválido, o programa será finalizado. 
		 */
		public static void obterInformacaoCaractere() 
		{
			do 
			{	
				Character caractere = obterCarcatere();
				 
				if(caractere != null) exibirInformacoes(caractere);
				else break;
					
			}while(true);
							
			// System.exit(0);
		}

		public static void exibirInformacoes(char caractere)
		{
			StringBuilder resultadoBuilder = new StringBuilder();
						
			resultadoBuilder.append(format("\n Informações disponíveis do caractere: %c           \n", caractere));
			resultadoBuilder.append(format("\n - Identificação: %s", identificarCaractere(caractere)));
			resultadoBuilder.append(format("\n - Nome: %s", Character.getName(Character.codePointAt(String.valueOf(caractere), 0))));
			resultadoBuilder.append(format("\n - Categoria: %s \n\n", identificarCategoriaCaractere(caractere)));
			
			msgInfo(resultadoBuilder.toString(), TITLE);
		}

		/***
		 * Obtém um caractere através de uma janela para entrada de dados.
		 * 
		 * @return Retorna o caractere obtido ou null, caso não tenha tido uma entrada válida.
		 */
		public static Character obterCarcatere()
		{
			String entrada = lerString(INPUT_MSG, TITLE);
			 
			if(entrada != null)
			{
				// Verificando se apenas um caractere foi digitado e este não é um espaço em branco.
				if (entrada.length() == 1 && !entrada.isBlank()) return entrada.charAt(0);		
			}
			return null;			 
		}

		public static String identificarCaractere(char caractere)
		{
			if(Character.isLetter(caractere))
				return checkCaractere(caractere, VOGAIS) == true ? MSG_VOGAL : MSG_CONSOANTE; 
				
			else if(Character.isDigit(caractere))
				return MSG_DIGITO;
			
			else if(isArithmeticOperator(caractere))
				return MSG_OPERADOR;
			
			else if(isSpecialSymbol(caractere))
				return MSG_SIMBOLO;
			
			else if(isSignScore(caractere))
				return MSG_PONTUACAO;
			
			else if(isAccentuationSign(caractere))
				return MSG_ACENTUACAO;
			
			else
				return UNIDENTIFIER_CHARACTER;
		}
		
		/**
		 * Verifica se um caractere é um operador aritmético, conforme relação 
		 * do vetor OPERADORES_ARITMETICOS.
		 * 
		 * @param ch caractere.
		 * @return <code>true</code>, se o caractere for um operador aritmético ou false, caso contrário.  
		 */
		public static boolean isArithmeticOperator(char ch)
		{
			return checkCaractere(ch, OPERADORES_ARITMETICOS);
		}

		/**
		 * Verifica se um caractere é um símbolo especial, conforme relação 
		 * do vetor SIMBOLOS_ESPECIAIS.
		 * 
		 * @param ch caractere.
		 * @return <code>true</code>, se o caractere for um símbolo especial ou false, caso contrário.
		 */
		public static boolean isSpecialSymbol(char ch)
		{
			return checkCaractere(ch, SIMBOLOS_ESPECIAIS);
		}
		
		/**
		 * Verifica se um caractere é um sinal de pontuação, conforme relação 
		 * do vetor SINAIS_PONTUACAO.
		 * 
		 * @param ch caractere.
		 * @return
		 */
		public static boolean isSignScore(char ch)
		{
			return checkCaractere(ch, SINAIS_PONTUACAO);
		}
		
		/**
		 * Verifica se um caractere é um sinal de acentuação, conforme relação 
		 * do vetor SINAIS_ACENTUACAO.
		 * 
		 * @param ch caractere.
		 * @return
		 */
		public static boolean isAccentuationSign(char ch)
		{
			return checkCaractere(ch, SINAIS_ACENTUACAO);
		}
				
		/**
		 * Procura por um caractere em um vetor do tipo char.
		 * 
		 * @param caractere Caractere procurado.
		 * @param vetor Conjunto de caracteres para busca.
		 * 
		 * @return Retorna true se encontrar o caractere ou false, caso contrário.
		 */
		public static boolean checkCaractere(char caractere, char[] vetor)
		{
			for(char charOfVetor : vetor)
				if(charOfVetor == caractere)
					return true;

			return false;
		}
		
		/**
		 * Identifica a categoria geral de um caractere.
		 * 
		 * @param caractere Caractere cuja categoria será procurada.
		 * 
		 * @return Retorna o acrônimo correspondente à categoria geral do caractere especificado no 
		 * padrão Unicode, em caso de sucesso, ou a constante CATEGORY_NOT_FOUND, em caso de falha.
		 * 
		 * Referências para as categorias de caracteres Unicode: 
		 * 
		 * 		- www.compart.com/en/unicode/category
		 * 		- www.unicode.org/reports/tr44/#General_Category_Values
		 */
		public static String identificarCategoriaCaractere(char caractere) 
		{
		    int codePoint = Character.codePointAt(String.valueOf(caractere), 0);
		    			
		    return switch (Character.getType(codePoint)) 
		    {
			    // L, Letter
			    case Character.UPPERCASE_LETTER -> "Lu";
			    case Character.LOWERCASE_LETTER -> "Ll";
			    case Character.TITLECASE_LETTER -> "Lt";
			    case Character.MODIFIER_LETTER -> "Lm";
			    case Character.OTHER_LETTER -> "Lo";
		
			    // M, Mark
			    case Character.NON_SPACING_MARK -> "Mn";
			    case Character.COMBINING_SPACING_MARK -> "Mc";
			    case Character.ENCLOSING_MARK -> "Me";
		
			    // N, Number
			    case Character.DECIMAL_DIGIT_NUMBER -> "Nd";
			    case Character.LETTER_NUMBER -> "Nl";
			    case Character.OTHER_NUMBER -> "No";
		
			    // P, Punctuation
			    case Character.CONNECTOR_PUNCTUATION -> "Pc";
			    case Character.DASH_PUNCTUATION -> "Pd";
			    case Character.START_PUNCTUATION -> "Ps";
			    case Character.END_PUNCTUATION -> "Pe";
			    case Character.INITIAL_QUOTE_PUNCTUATION -> "Pi";
			    case Character.FINAL_QUOTE_PUNCTUATION -> "Pf";
			    case Character.OTHER_PUNCTUATION -> "Po";
		
			    // S, Symbol
			    case Character.MATH_SYMBOL -> "Sm";
			    case Character.CURRENCY_SYMBOL -> "Sc";
			    case Character.MODIFIER_SYMBOL -> "Sk";
			    case Character.OTHER_SYMBOL -> "So";
		
			    // Z, Separator
			    case Character.SPACE_SEPARATOR -> "Zs";
			    case Character.LINE_SEPARATOR -> "Zl";
			    case Character.PARAGRAPH_SEPARATOR -> "Zp";
		
			    // C, Other
			    case Character.CONTROL -> "Cc";
			    case Character.FORMAT -> "Cf";
			    case Character.SURROGATE -> "Cs";
			    case Character.PRIVATE_USE -> "Co";
			    case Character.UNASSIGNED -> "Cn";
		
			    default -> CATEGORY_NOT_FOUND;
		    }; 
		
		} // identificarCategoriaCaractere();

} // class Ex01
