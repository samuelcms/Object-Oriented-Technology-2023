package le02.exercicios;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;

public class Ex09 
{
	private static final String START_TIME_MSG = "Tempo inicial = ",
								FINISH_TIME_MSG = "Tempo final = ",
								DURATION_MSG = "Duração = ",
								SECONDS_MSG = "s",
								MILLISECONDS_MSG = "ms",
								STRING_MSG = "Concatenação com String....",
								STRINGBUILDER_MSG = "Concatenação com StringBuilder....",
								TIME_FORMAT = "HH:mm:ss.SSS";


	private static final int NUM_CONCATENATIONS = 100000,
							 S_IN_MS = 1000; 

	public static void testeConcatenacaoString()
	{
		concatenarString();
		concatenarStringBuilder();
	}

	public static void concatenarString()
	{
		/***/@SuppressWarnings("unused")
		String string = new String(), horaInicio, horaTermino;
		long duration, start;

		horaInicio = obterHora(TIME_FORMAT);
		start = System.currentTimeMillis();

		for (int i = 0; i < NUM_CONCATENATIONS; i++) 
			string += i;

		duration = System.currentTimeMillis() - start; 
		horaTermino = obterHora(TIME_FORMAT);

		exibirResultado(STRING_MSG, horaInicio, horaTermino, formatarTempoDuracao(duration));
	}

	public static void concatenarStringBuilder()
	{
		StringBuilder stringBuilder = new StringBuilder();
		String horaInicio, horaTermino;
		long duration, start;

		horaInicio = obterHora(TIME_FORMAT);
		start = System.currentTimeMillis();

		for (int i = 0; i < NUM_CONCATENATIONS; i++) 
			stringBuilder.append(i);

		duration = System.currentTimeMillis() - start; 
		horaTermino = obterHora(TIME_FORMAT);

		exibirResultado(STRINGBUILDER_MSG, horaInicio, horaTermino, formatarTempoDuracao(duration));	
	}

	public static void exibirResultado(String mensagem, String inicio, String termino, String duracao)
	{
		System.out.println(mensagem);
		System.out.printf("\n\t %s%s", START_TIME_MSG, inicio);
		System.out.printf("\n\t %s%s", FINISH_TIME_MSG, termino);
		System.out.printf("\n\t %s%s\n", DURATION_MSG, duracao);

		System.out.println();
	}

	/**
	 * Fornece uma string formatada com o tempo de duração em Milissegundos, se o 
	 * valor de 'duracao' for inferior a 1000 milissegundos, ou em Segundos, caso
	 * contrário. 
	 * 
	 * @param duracao Intervalo de tempo expresso em Milissegundos.
	 * @return Retorna a string formatada composta por duração e unidade de medida.
	 */
	public static String formatarTempoDuracao(long duracao)
	{
		return (duracao > S_IN_MS) ? format("%.1f %s", (double)duracao/S_IN_MS, SECONDS_MSG) : format("%d %s", duracao, MILLISECONDS_MSG);  
	}
	
	/**
	 * Fornece uma string com a hora atual formatada no padrão especificado via parâmetro. 
	 *
	 * @param pattern Padrão de formatação da hora. Ex.: HH:mm:ss.SSS 
	 * @return Retorna uma variável do tipo string com a hota formatada. 
	 */
	public static String obterHora(String pattern)
	{		
		return new SimpleDateFormat(pattern).format(new Date());	
	}

} // class Ex09
