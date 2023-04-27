package le04.exercicios.ex07;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;
import java.time.Year;

public class Data 
{
	private static final int ANO_MINIMO = 1, ANO_MAXIMO = 999999, JANEIRO = 1, DEZEMBRO = 12, NUMERO_MAXIMO = 999999;
	
	private static final String UNIDADES[] = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", 
			                                  "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"},

								DEZENAS[] = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"},

								CENTENAS[] = {"", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", 
			                                  "oitocentos", "novecentos"},

								ZERO = "zero", CEM = "cem", CENTO = "cento", MIL = "mil",
								
								MESES[] = {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho",  "agosto", "setembro", "outubro", 
										   "novembro", "dezembro"};	
		
	private int dia, mes, ano;

	public Data(){}

	public Data(int dia, int mes, int ano) 
	{
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public int getDia() 
	{
		return dia;
	}

	public void setDia(int dia) 
	{
		this.dia = dia;
	}

	public int getMes() 
	{
		return mes;
	}

	public void setMes(int mes) 
	{
		this.mes = mes;
	}

	public int getAno() 
	{
		return ano;
	}

	public void setAno(int ano) 
	{
		this.ano = ano;
	}
	
	@Override
	public String toString() 
	{
		return String.format("%02d/%02d/%04d", dia, mes, ano);
	}

	public static String obterDataAtual()
	{
		return LocalDate.now().format(ofPattern("dd/MM/yyyy"));
	}
	
	public static int obterDiaAtual()
	{
		return LocalDate.now().getDayOfMonth();
	}
	
	public static int obterMesAtual()
	{
		return LocalDate.now().getMonthValue();
	}
	
	public static int obterAnoAtual()
	{
		return LocalDate.now().getYear();
	}
	
	public static boolean anoBissexto(int ano)
	{
		return Year.of(ano).isLeap();
	}
	
	public static boolean dataValida(String data)
	{
		String dataDesmembrada[] = data.split("/");
		
		int dia = Integer.parseInt(dataDesmembrada[0]),
		    mes = Integer.parseInt(dataDesmembrada[1]),
		    ano = Integer.parseInt(dataDesmembrada[2]);
			
		if(anoValido(ano) && mesValido(mes, ano) && obterQuantidadeDiasMes(mes, ano) >= dia)
				return true;

		return false;
	}
	
	private static boolean anoValido(int ano)
	{
		return (ano >= ANO_MINIMO && ano <= ANO_MAXIMO) ? true : false;
	}
	
	private static boolean mesValido(int mes, int ano)
	{	
		return (mes >= JANEIRO && mes <= DEZEMBRO) ? true : false;
	}
	
	private static int obterQuantidadeDiasMes(int mes, int ano)
	{
		return LocalDate.of(ano, mes, 1).lengthOfMonth();
	}
	
	public static String dataPorExtenso(int dia, int mes, int ano)
	{
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append(converterParaExtenso(dia) + " de ");
		strBuilder.append(MESES[mes - 1] + " de ");
		strBuilder.append(converterParaExtenso(ano));
				
		return strBuilder.toString();
	}
	
	public static String dataPorExtenso(String data)
	{
		String dataDesmembrada[] = data.split("/");
		return dataPorExtenso(Integer.parseInt(dataDesmembrada[0]), Integer.parseInt(dataDesmembrada[1]), Integer.parseInt(dataDesmembrada[2]));
	}
	
	private static String converterParaExtenso(int numero) 
	{
		StringBuilder resultado = new StringBuilder();
		int copiaNumero = numero;
	
		if(numero > NUMERO_MAXIMO) return "";
		
		if (numero == 0) return ZERO;
		
		if(numero % 10000 == 0 && numero > 10000 && numero < 100000)
		{
			resultado.append(DEZENAS[numero / 10000]).append(" " + MIL);
			return resultado.toString();
		}
			
		if (numero >= 1000) 
		{			
			if(numero >= 2000) resultado.append(converterParaExtenso(numero / 1000)).append(" " + MIL);
			else resultado.append(MIL);
			
			if( numero % 1000 <= 100 && numero % 1000 > 0) resultado.append(" e ");
			else resultado.append(" ");
			
			numero %= 1000;			
		}
		
		if (numero >= 100) 
		{			
			resultado.append(CENTENAS[numero / 100]);
			
			if( numero % 100 > 0) resultado.append(" e ");
			else resultado.append(" ");
			
			numero %= 100;
		}

		if (numero >= 20) 
		{		
			resultado.append(DEZENAS[numero / 10]).append(" e ");
			numero %= 10;
		}

		if (numero > 0) 
		{
			if (numero < 20) 
				resultado.append(UNIDADES[numero]).append(" ");
			
			else 
			{
				resultado.append(DEZENAS[numero / 10]).append(" ");
				resultado.append(UNIDADES[numero % 10]).append(" ");
			}
		}

		String numeroExtenso = resultado.toString().trim(); 
		
		if(copiaNumero % 1000 > 100)
			numeroExtenso = numeroExtenso.replace(CEM, CENTO);
		
		return numeroExtenso;
	}

} // class Data
