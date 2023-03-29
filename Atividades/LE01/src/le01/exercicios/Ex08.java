package le01.exercicios;

import static util.InterfaceGrafica.*;

public class Ex08 
{	
	private final static String CHAR_MSG = "Caractere: ",
								WINDOW_TITLE = "Obter código Unicode",
								ERROR_MSG = "Digite um caractere!",
								CODE_MSG = "Código: "; 
	
	public static void codigoUnicode()
	{	
		char caractere;
		String entrada;
		int codigoUnicode;
				
		do 
		{
			entrada = lerString(CHAR_MSG, WINDOW_TITLE);
			
			// Verifica se a operação não foi cancelada.
			if(entrada != null) 
			{	
				/* 
				   Verficando se a entrada é vazia ou composta apenas por um caractere em branco e se contém apenas um caractere.
				 */
				if(!entrada.isBlank() && entrada.length() == 1)
				{
					caractere = entrada.charAt(0);
					codigoUnicode = toUnicode(caractere);
					msgInfo(String.format("%s%c | %s%03d", CHAR_MSG, caractere, CODE_MSG, codigoUnicode), WINDOW_TITLE);					
				}
				
				else
					msgErro(ERROR_MSG, WINDOW_TITLE);
			}
			
		}while(entrada != null);
	
		System.exit(0);
	}
	
	private static int toUnicode(char ch)
	{
		return Character.codePointAt(String.valueOf(ch), 0);
	}
	
} // class Ex8
