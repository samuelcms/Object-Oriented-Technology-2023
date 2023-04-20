package le03.exercicios;

import static util.InterfaceGrafica.*;

public class Ex03 
{
	// Constantes.
	
	public static final int 
			
		MAX_DIGITOS = 20,
		MIN_DIGITOS = 1;
	
	public static final String 
	
		MSG_ERRO_OVERFLOW = "O valor excede o número de dígitos o tipo 'long.'",
		CABECALHO_ERRO_OVERFLOW = "Overflow",
		MSG_ADVERTENCIA = "Nenhum número fornecido.",
		CABECALHO_ADVERTENCIA = "Erro",
		
		MSG_SHORT = "short",
		MSG_SHORT_OBJ = "Short",
		
		MSG_INT = "int",
		MSG_INTEGER_OBJ = "Integer",
		
		MSG_LONG = "long",
		MSG_LONG_OBJ = "Long",
		
		CABECALHO = "Relatório",
		MSG_NUM = "Número inteiro",
		TIPO_DADO_PRIMITIVO = "Tipo de dado primtivo",
		TIPO_DADO_REFERENCIA = "Tipo de dado por referência",
		
		GET_NUM_MSG = "Forneça um número",
		TITLE = "Autoboxing e Auto-unboxing";
	
	
	public static void classificarNumero()
	{
		String numero;
		
		do
		{
			numero = lerNumero(GET_NUM_MSG, TITLE);

			if(numero != null)
			{
				if(numero.isEmpty())
					msgAdvertencia(MSG_ADVERTENCIA, CABECALHO_ADVERTENCIA);
				
				else
					identificarNumero(numero);
			}
			else
				break;
	
		}while(true);
	}
	
	public static boolean isShort(String numero)
	{
		return (Long.parseLong(numero) >= Short.MIN_VALUE && Long.parseLong(numero) <= Short.MAX_VALUE) ? true : false;
	}
	
	public static boolean isInteger(String numero)
	{
		return (Long.parseLong(numero) >= Integer.MIN_VALUE && Long.parseLong(numero) <= Integer.MAX_VALUE) ? true : false;
	}
	
	public static boolean isLong(String numero)
	{
		return (Long.parseLong(numero) >= Long.MIN_VALUE && Long.parseLong(numero) <= Long.MAX_VALUE) ? true : false;
	}
	
	public static void identificarNumero(String numero)
	{		
		short inteiroCurto;
		int inteiro;
		long inteiroLongo;
		
		Short inteiroCurtoObj;
		Integer inteiroObj;
		Long inteiroLongoObj;
					
		if(numero.length() > MAX_DIGITOS)
			msgErro(MSG_ERRO_OVERFLOW, CABECALHO_ERRO_OVERFLOW);
					
		else 
		{
			/*
			 *	Após identificar o tipo do número recebido, ele será convertido para seu tipo de dado
			 *	primitivo. Em seguida, há a atribuição do número à sua respectiva classe empacotadora,
			 *	ou seja, é feita a operação de autoboxing.
			 *
			 * 	Exemplo: O número 10 se enquadra no tipo primitivo short. Após ser convertido de String
			 * 			 para short, há a atribuição à sua respectiva classe empacotadora, Short.
			 */
			
			if(isShort(numero))
			{
				inteiroCurto = Short.parseShort(numero); 
				inteiroCurtoObj = inteiroCurto;								// Autoboxing.
				gerarRelatorio(inteiroCurtoObj);
			}
			 
			else if(isInteger(numero))
			{
				inteiro = Integer.parseInt(numero);
				inteiroObj = inteiro;								        // Autoboxing.
				gerarRelatorio(inteiroObj);
			}
			
			else if(isLong(numero))
			{
				inteiroLongo = Long.parseLong(numero);
				inteiroLongoObj = inteiroLongo;								// Autoboxing.
				gerarRelatorio(inteiroLongoObj);
			}
		}
				
	} // identificarNumero();

	public static void gerarRelatorio(short numero)
	{
		msgInfo(String.format(" - %s: %,d %s", MSG_NUM, numero, exibirTipoDado(MSG_SHORT, MSG_SHORT_OBJ)), CABECALHO);			
	}
	
	public static void gerarRelatorio(int numero)
	{
		msgInfo(String.format(" - %s: %,d %s", MSG_NUM, numero, exibirTipoDado(MSG_INT, MSG_INTEGER_OBJ)), CABECALHO);
	}
	
	public static void gerarRelatorio(long numero)
	{
		msgInfo(String.format(" - %s: %,d %s", MSG_NUM, numero, exibirTipoDado(MSG_LONG, MSG_LONG_OBJ)), CABECALHO);
		// msgInfo(String.format(" - %s: %,d %s", MSG_NUM, numero, exibirTipoDado(long.class.toString(), Long.class.toString())), CABECALHO);
	}
	
	private static String exibirTipoDado(String tipoDadoPrimitivo, String tipoDadoReferencia)
	{
		return String.format("\n - %s: %s\n - %s: %s", TIPO_DADO_PRIMITIVO, tipoDadoPrimitivo, TIPO_DADO_REFERENCIA, tipoDadoReferencia);
	}
	
} // class Ex03
