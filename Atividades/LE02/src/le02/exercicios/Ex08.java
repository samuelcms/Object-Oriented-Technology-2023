package le02.exercicios;

import static util.InterfaceGrafica.*;

public class Ex08 
{
	private static final int UP_ALPHA = 0x0391, LOW_ALPHA = 0x03B1, UP_OMEGA = 0x03A9, LOW_OMEGA = 0x03C9;
	private static final String UPPERCASE = "Alfabeto Grego - Letras Maiúsculas", LOWERCASE = "Alfabeto Grego - Letras Minúsculas";
	
	public static void alfabetoGrego()
	{	
		msgInfo(gerarAlfabeto(LOW_ALPHA, LOW_OMEGA), LOWERCASE);
		msgInfo(gerarAlfabeto(UP_ALPHA, UP_OMEGA), UPPERCASE);
	}
	
	
	/**
	 * Gera um alfabeto a partir do primeiro e do último caracatere passado via parâmetro.
	 * 
	 * @param limiteInferior Primeiro caractere do alfabeto (UTF-16 Encoding).
	 * @param limiteSuperior Último caractere do alfabeto (UTF-16 Encoding).
	 * 
	 * @return Retorna um objeto String com o alfabeto criado.
	 */
	private static String gerarAlfabeto(int limiteInferior, int limiteSuperior)
	{
		StringBuilder strBuilder = new StringBuilder();
		
		for(int caractere = limiteInferior; caractere <= limiteSuperior; caractere++)
			strBuilder.append(String.format(" %s", (char)caractere));
			
		return strBuilder.toString();
	}
		
} // class Ex08
