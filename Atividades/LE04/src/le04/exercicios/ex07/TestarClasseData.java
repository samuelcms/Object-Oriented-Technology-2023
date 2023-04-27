package le04.exercicios.ex07;

import le04.exercicios.ex06.Data;

import static le04.exercicios.ex07.Data.*;
import static le04.exercicios.entradaEsaida.EntradaESaida.*;

public class TestarClasseData 
{		
	private static final String ESPACOS = "                                                      ", LINHA_EM_BRANCO = "\n\n";
	
	public static void main(String[] args) 
	{
		testarClasseData();	
	}

	private static void testarClasseData() 
	{
		Data data1 = new Data(11, 6, 2002),
		     data2 = new Data(29, 4, 2000);
		
		String dataInvalida = "31/02/1998";
		
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append(String.format("- %s: %s.", data1, dataPorExtenso(data1.toString()))).append(LINHA_EM_BRANCO);
		strBuilder.append(String.format("- %s: %s.", data2, dataPorExtenso(data2.getDia(), data2.getMes(), data2.getAno()))).append(LINHA_EM_BRANCO);
		strBuilder.append(String.format("- A data %s %s válida.", dataInvalida, dataValida(dataInvalida) ? "é" : "não é")).append(ESPACOS).append(LINHA_EM_BRANCO);
		
		msgInfo(strBuilder.toString(), "Classe Data");
	}
}