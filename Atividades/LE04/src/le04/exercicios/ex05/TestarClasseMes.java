package le04.exercicios.ex05;

import static le04.exercicios.ex05.Mes.*;
import static java.lang.String.format;

public class TestarClasseMes 
{
	public static void main(String[] args) 
	{
		Mes abril = new Mes();
		Mes junho = new Mes((byte)30, (byte)6, "Junho");
		
		abril.setNomeMes("Abril");
		abril.setNumeroDias((byte)30);
		abril.setNumeroMes((byte)4);
		
		System.out.println(abril);
		System.out.println(junho);
		
		System.out.println(format("\nQuantidade de meses criados: %d \n", Mes.getObjetosCriados()));
				
		System.out.println(format("01/01/%d - %s: %d dias", obterAnoAtual(), obterDataAtual(), diferencaDias()));
		System.out.println(format("07/12/%d - %s: %d dias", obterAnoAtual(), obterDataAtual(), diferencaDias(7, 12)));
		System.out.println(format("01/02/%d - %s: %d dias", obterAnoAtual(), obterDataAtual(), diferencaDias(1, "Fevereiro")));
		System.out.println(format("11/06/2002 - %s: %d dias", obterDataAtual(), diferencaDias(11, 6, 2002)));
	}	

} // class TestarClasseMes
