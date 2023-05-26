package le06.exercicios.ex13;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class PrecisaoCalculo 
{
	private static final String 
	
		PATTERN = "HH:mm:ss.SSSS", 
		MSG_DOUBLE = "Soma 1 bilhão de R$ 0,01 com double = R$",
		MSG_BIGDECIMAL = "Soma 1 bilhão de R$ 0,01 com BigDecimal = R$",
		MSG_TEMPO_INICIAL = "Tempo Inicial:",
		MSG_TEMPO_TERMINO = "Tempo Final..:",
		MSG_TEMPO_EXECUCAO = "Tempo de execução =",
		UNIDADE_TEMPO = "segundos";
	
	private static final int LIMITE_LOOP = 1000000000, INDICE_INICIO = 0, INDICE_TERMINO = 1, INDICE_RESULTADO = 2;
	
	private static final double INCREMENTO = 0.01;
	
	public static void main(String[] args)
	{
		executarCalculos();
	}
	
	private static void executarCalculos() 
	{
		List<Object> infoDouble = calculoDouble(), infoBigDecimal = calculoBigDecimal();
						
		float tempoDouble = Float.parseFloat(calcularDiferencaHoras((LocalTime)infoDouble.get(INDICE_INICIO), (LocalTime)infoDouble.get(INDICE_TERMINO)).replace(',', '.')), 
       		  tempoBigDecimal = Float.parseFloat(calcularDiferencaHoras((LocalTime)infoBigDecimal.get(INDICE_INICIO), (LocalTime)infoBigDecimal.get(INDICE_TERMINO)).replace(',', '.'));
		
		exibirRelatorio(MSG_DOUBLE, (LocalTime)infoDouble.get(INDICE_INICIO), (LocalTime)infoDouble.get(INDICE_TERMINO), format("%,.2f", infoDouble.get(INDICE_RESULTADO)));
		exibirRelatorio(MSG_BIGDECIMAL, (LocalTime)infoBigDecimal.get(INDICE_INICIO), (LocalTime)infoBigDecimal.get(INDICE_TERMINO), format("%,.2f", infoDouble.get(INDICE_RESULTADO)));
		
		mensagemComparacao(tempoBigDecimal, tempoDouble);
		
	}

	private static void mensagemComparacao(float tempoBigDecimal, float tempoDouble) 
	{
		System.out.println(format("\nO tempo de execução com double foi %s vezes mais veloz do que com BigDecimal.", format("%,.2f", tempoBigDecimal / tempoDouble ).replace('.', ',')));
	}

	public static List<Object> calculoDouble()
	{
		List<Object> infoTempo = new ArrayList<>();
		double somatorio = 0;
		
		infoTempo.add(obterHoraAtual());
		
		for(int i = 0; i <= LIMITE_LOOP; i++)
			somatorio += INCREMENTO; 
		
		infoTempo.add(obterHoraAtual());
		infoTempo.add(somatorio);
		return infoTempo;
	}

	public static List<Object> calculoBigDecimal()
	{
		List<Object> infoTempo = new ArrayList<>();		
		BigDecimal somatorio = BigDecimal.ZERO;
				
		infoTempo.add(obterHoraAtual());
		
		for(int i = 0; i <= LIMITE_LOOP; i++)
			somatorio = somatorio.add(BigDecimal.valueOf(INCREMENTO));
		
		infoTempo.add(obterHoraAtual());
		infoTempo.add(somatorio);
		return infoTempo;
	}

	public static LocalTime obterHoraAtual()
	{
		return LocalTime.now();
	}
	
	// Calcula a quantidade de segundos e milésimos entre dois horários.
	public static String calcularDiferencaHoras(LocalTime inicio, LocalTime termino)
	{
		Duration duration = Duration.between(inicio, termino);		
		StringBuilder stringbuilder = new StringBuilder();

		stringbuilder.append(duration.toSecondsPart());
		stringbuilder.append(",");
		stringbuilder.append(duration.toMillisPart());
			
		return stringbuilder.toString();
	}
	
	public static String formatarHora(LocalTime hora)
	{
		return hora.format(DateTimeFormatter.ofPattern(PATTERN));
	}
	
	public static void exibirRelatorio(String mensagem, LocalTime tempoInicio, LocalTime tempoTermino, String resultado)
	{	
		StringBuilder relatorio = new StringBuilder();
		
		relatorio.append(format("\n%s %s", mensagem, resultado));
		relatorio.append(format("\n%s %s", MSG_TEMPO_INICIAL, formatarHora(tempoInicio)));
		relatorio.append(format("\n%s %s", MSG_TEMPO_TERMINO, formatarHora(tempoTermino)));
		relatorio.append(format("\n\t%s %s %s\n", MSG_TEMPO_EXECUCAO, calcularDiferencaHoras(tempoInicio, tempoTermino), UNIDADE_TEMPO));
		
		System.out.println(relatorio);
	}
	
} // class PrecisaoCalculo{};
