package le04.exercicios.ex05;

import java.time.LocalDate;
import java.time.Duration;

import static java.time.format.DateTimeFormatter.*;

public class Mes 
{
	private static final String MESES[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", 
										   "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	
	private byte numeroDias, numeroMes;
	private String nomeMes;
	
	private static int objetosCriados;
	
	public Mes()
	{
		objetosCriados++;
	}

	public Mes(byte numeroDias, byte numeroMes, String nomeMes) 
	{
		this();
		
		this.numeroDias = numeroDias;
		this.numeroMes = numeroMes;
		this.nomeMes = nomeMes;
	}

	public byte getNumeroDias() 
	{
		return numeroDias;
	}

	public void setNumeroDias(byte diaMes) 
	{
		this.numeroDias = diaMes;
	}

	public byte getNumeroMes() 
	{
		return numeroMes;
	}

	public void setNumeroMes(byte numeroMes) 
	{
		this.numeroMes = numeroMes;
	}

	public String getNomeMes() 
	{
		return nomeMes;
	}

	public void setNomeMes(String nomeMes) 
	{
		this.nomeMes = nomeMes;
	}
	
	public static int getObjetosCriados() 
	{
		return objetosCriados;
	}

	@Override
	public String toString() 
	{
		return String.format("%02d/%s - %02d dias", numeroMes, nomeMes, numeroDias);
	}
	
	public static long diferencaDias()
	{
		return diferencaDias(1, 1, obterAnoAtual());
	}
	
	public static long diferencaDias(int dia, int mes)
	{
		return diferencaDias(dia, mes, obterAnoAtual());
	}
	
	public static long diferencaDias(int dia, String mes)
	{
		return diferencaDias(dia, obterNumeroMes(mes), obterAnoAtual());
	}
	
	public static long diferencaDias(int dia, int mes, int ano)
	{
		LocalDate dataInicial = LocalDate.now(),
				  dataFinal = LocalDate.of(ano, mes, dia);
		
		return Math.abs(Duration.between(dataInicial.atStartOfDay(), dataFinal.atStartOfDay()).toDays());
	}
	
	public static int obterAnoAtual()
	{
		return Integer.parseInt(LocalDate.now().format(ofPattern("yyyy")));
	}
	
	public static String obterDataAtual()
	{
		return LocalDate.now().format(ofPattern("dd/MM/yyyy"));
	}
		
	private static int obterNumeroMes(String mes)
	{
		for(int indice = 0; indice < MESES.length; indice++)
			if(MESES[indice].equalsIgnoreCase(mes))
				return ++indice;
		
		return -1;
	}
			
} // class Mes
