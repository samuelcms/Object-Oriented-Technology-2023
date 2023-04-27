package le04.exercicios.ex06;

import static java.lang.String.format;
import static le04.exercicios.entradaEsaida.EntradaESaida.*;

public class TestarClasseData 
{
	private static final String ESPACOS = "                                                                                                 ";
	
	public static void main(String[] args) 
	{
		iniciar();
	}

	public static void iniciar() 
	{		
		Data data1 = new Data(),
			 data2 = new Data(29, 4, 2000);
		
		data1.setAno(2002);
		data1.setMes(6);
		data1.setDia(11);
		
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append(format("Data 1: %s", data1) + NOVA_LINHA);
		strBuilder.append(format("Data 2: %s", data2) + NOVA_LINHA);
		
		strBuilder.append(format(NOVA_LINHA + "Dia: %02d", Data.obterDiaAtual()) + " | ");
		strBuilder.append(format("Mês: %02d", Data.obterMesAtual()) + " | ");
		strBuilder.append(format("Ano: %04d", Data.obterAnoAtual()) + NOVA_LINHA);
		
		strBuilder.append(format("Data: %s", Data.obterDataAtual()) + NOVA_LINHA);
		
		strBuilder.append(NOVA_LINHA + format("2023 é ano bissexto? %s", Data.anoBissexto(2023) == true ? "Sim" : "Não"));
		strBuilder.append(NOVA_LINHA + format("2024 é ano bissexto? %s", Data.anoBissexto(2024) == true ? "Sim" : "Não") + NOVA_LINHA);
		
		strBuilder.append(NOVA_LINHA + format("11/06/2002 é uma data válida? %s", Data.dataValida("11/06/2002") == true ? "Sim" : "Não" ));
		strBuilder.append(NOVA_LINHA + format("31/02/2003 é uma data válida? %s", Data.dataValida("31/02/2003") == true ? "Sim" : "Não" ));
		strBuilder.append(NOVA_LINHA + format("01/13/2004 é uma data válida? %s", Data.dataValida("01/13/2004") == true ? "Sim" : "Não" ));
		strBuilder.append(NOVA_LINHA + format("02/02/-2005 é uma data válida? %s", Data.dataValida("02/02/-2005") == true ? "Sim" : "Não" ));
		strBuilder.append(NOVA_LINHA + ESPACOS);
		
		msgInfo(strBuilder.toString(), "Classe Data");
		
		System.exit(0);
	}
	
} // class TestarClasseData
