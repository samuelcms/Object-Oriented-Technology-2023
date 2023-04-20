package le03.exercicios.ex06;

public class SistemaNumerico 
{
	private static final int TAM_NUMERO_B2 = 32,
							 TAM_NUMERO_B8 = 11,
							 TAM_NUMERO_B16 = 8,
							 
							 SEPARADOR_B2 = 8,
							 SEPARADOR_B8 = 3,
							 SEPARADOR_B16 = 4;
	
	private static final char CARACTERE_ZERO = '0',
							  CARACTERE_ESPACO = ' ';
	
	/* 
	 * Exibe no console um número binário de no máximo 32 bits usando o formato abaixo.
	 * 		
	 * 		- binário: 00000000 00000000 00001100 11010100
	 */
	public static void exibirNumeroBinario(String numero)
	{
		System.out.println(addSeparator(addLeftZero(numero, TAM_NUMERO_B2), SEPARADOR_B2, CARACTERE_ESPACO));
	}

	/* 
	 * Exibe no console um número hexadecimal de no máximo 8 dígitos usando o formato abaixo.
	 * 
	 * 		- hexadecimal: 0000 0CD4
	 */
	public static void exibirNumeroHexadecimal(String numero)
	{
		System.out.println(addSeparator(addLeftZero(numero, TAM_NUMERO_B16), SEPARADOR_B16, CARACTERE_ESPACO));
	}

	/* 
	 * Exibe no console um número octal de no máximo 11 dígitos usando o formato abaixo. 
	 * 
	 * 		- octal: 00 777 777 777
	 */
	public static void exibirNumeroOctal(String numero)
	{
		System.out.println(addSeparator(addLeftZero(numero, TAM_NUMERO_B8 + 1), SEPARADOR_B8, CARACTERE_ESPACO).substring(1));
	}

	/* 
	 * Converte um número inteiro decimal (base 10) para binário (base 2). Considere no máximo 32 bits para representar o número em 
	 * binário e somente números decimais inteiros e positivos no intervalo de 0 a 4.294.967.295. Retorna uma string com o número no 
	 * formato binário.
	 */
	public static String converterBase10ParaBase2(long numero)
	{
        long numeroConvertido = 0;
        int base = 1;
        
        while (numero != 0) 
        {
            long resto = numero % 2;
            numero = numero >> 1;
            numeroConvertido = numeroConvertido + resto * base;
            base = base * 10;
        }
        		
		return String.format("%d", numeroConvertido);
	}

	/* 
	 * Converte um número inteiro decimal (base 10) para octal (base 8). Considere no máximo 11 dígitos para representar o número 
	 * octal e somente números octais inteiros e positivos no intervalo de 0 a 37 777 777 777. Retorna uma string com o número no 
	 * formato octal.
	 */
	public static String converterBase10ParaBase8(long numero)
	{
		long numeroConvertido = 0;
		int base = 1;
	    
		while (numero != 0) 
		{
	        long resto = numero & 7; 
	        numero = numero >> 3; 
	        numeroConvertido = numeroConvertido + resto * base;
	        base = base * 10;
	    }
	    	
		return String.format("%d", numeroConvertido);
	}

	/* 
	 * Converte um número inteiro decimal (base 10) para hexadecimal (base 16). Considere no máximo 8 dígitos para representar o 
	 * número hexadecimal e somente números hexadecimais inteiros e positivos no intervalo de 0 a FFFF FFFF. Retorna uma string 
	 * com o número no formato hexadecimal.
	 */
	public static String converterBase10ParaBase16(long numero)
	{
		String numeroConvertido = "";
		
		while (numero > 0) 
		{
			long  resto = numero % 16;
			
			if (resto < 10) numeroConvertido += resto;
			else numeroConvertido += (char) (resto - 10 + 'A');
			
			numero /= 16;
		}
		return new StringBuilder(numeroConvertido).reverse().toString();
	}

	/* 
	 * Converte um número inteiro hexadecimal (base 16) para binário (base 2). Considere no máximo 32 bits para representar o 
	 * número em binário e somente números hexadecimais inteiros e positivos no intervalo de 0 a FFFF FFFF.Retorna uma string 
	 * com o número no formato binário.
	 */
	public static String converterBase16ParaBase2(String numero)
	{
		return Long.toBinaryString(Long.parseLong(numero, 16));
	}

	/* 
	 * Converte um número inteiro octal (base 8) para binário (base 2). Considere no máximo 32 bits para representar o número 
	 * em binário e somente números octais inteiros e positivos no intervalo de 0 a 37 777 777 777. Retorna uma string com o 
	 * número no formato binário.
	 */
	public static String converterBase8ParaBase2(String numero)
	{
		return Long.toBinaryString(Long.parseLong(numero, 8));
	}

	/* 
	 * Converte um número binário (base 2) para decimal (base 10). Considere no máximo 32 bits para representar o número em 
	 * binário e somente números decimais inteiros e positivos no intervalo de 0 a 4.294.967.295. Retorna o número decimal.
	 */
	public static long converterBase2ParaBase10(String numero)
	{
		return Long.parseLong(numero, 2);
	}

	/* 
	 * Converte um número binário (base 2) para octal (base 8). Considere no máximo 32 bits para representar o número em 
	 * binário e somente números octais inteiros e positivos no intervalo de 0 a 37 777 777 777. Retorna o número octal.
	 */
	public static long converterBase2ParaBase8(String numero)
	{
		return Long.parseLong(converterBase10ParaBase8(Long.parseLong(numero, 2)));		
	}

	/* 
	 * Converte um número binário (base 2) para hexadecimal (base 16). Considere no máximo 32 bits para representar o número 
	 * em binário e somente números hexadecimais inteiros e positivos no intervalo de 0 a FFFF FFFF.
	 * Retorna o número hexadecimal.
	 */
	public static long converterBase2ParaBase16(String numero)
	{
		return Long.parseLong(converterBase10ParaBase16(Long.parseLong(numero, 2)));
	}
	
	/**
	 * Adiciona zeros à esquerda de uma representação String de um número que pode estar nas bases 2, 8 ou 16.   
	 * 
	 * @param numero Representação String do número em uma das bases citadas acima.
	 * @param tamanhoTotal Quantidade de dígitos que o número deverá ter após a normatização.
	 *
	 * @return Número formatado.
	 */
	private static String addLeftZero(String numero, int tamanhoTotal)
	{		
		return String.format("%" + tamanhoTotal + "s", numero).replace(CARACTERE_ESPACO, CARACTERE_ZERO);
	}
	
	/**
	 * Adiciona um separador à representação String do número. Por exemplo, o número 00000000000000000000110011010100
	 * separado pelo caractere de espaço em branco e em grupo de 8 dígitos será 00000000 00000000 00001100 11010100. 
	 * 
	 * @param numero Número que será formatado.
	 * @param qtdDigitos Quantidade de dígitos de cada grupo.
	 * @param separador Caractere separador.
	 * 
	 * @return Retorna o número formatado com o espaçamento definido. 
	 */
	private static String addSeparator(String numero, int qtdDigitos, char separador) 
	{
		StringBuilder stringBuilder =  new StringBuilder();
			
		for(int indice = 0; indice < numero.length();)
		{		
			stringBuilder.append(String.format("%s%c", numero.substring(indice, (indice + qtdDigitos)), separador));
			indice += qtdDigitos;
		}
				
		return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
	}

} // class SistemaNumerico
