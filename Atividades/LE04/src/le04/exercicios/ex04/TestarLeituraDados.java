package le04.exercicios.ex04;

import static le04.exercicios.ex04.LerDado.*;
import static java.lang.String.format;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;;

public class TestarLeituraDados 
{
	public static void main(String[] args)
	{
		iniciar();
	}

	public static void iniciar() 
	{
		double numeroDouble;
		float numeroFloat;
		int numeroInteiro;
		String string;
		
		numeroDouble = lerDado("Ler double", "Número double:", 0.0);
		numeroFloat = lerDado("Ler float", "Número float:", 0.0f);
		numeroInteiro = lerDado("Ler int", "Número int:", 0);
		string = lerDado("Ler String", "String:", "");
		
		exibirMensagem("Resultado", format(" double: %.2f\n float: %.2f\n int: %d\n String: %s", numeroDouble, numeroFloat, numeroInteiro, string), INFORMATION_MESSAGE);
		
	}

} // class TestarLeituraDados
