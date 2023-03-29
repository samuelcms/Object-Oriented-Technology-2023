package le02.exercicios;

import java.util.Scanner;

public class Ex05 
{
	private static final String VALOR_SERIE_MSG = " - O valor da soma: ";
	
	/*
	 *	Calcula o valor da série a partir de um número inteiro positivo. Para encerrar o programa, 
	 *	basta fornecer um valor igual ou inferior a zero.
	 *
	 * 	Atenção: Não estão sendo tratadas possíveis exceções!
	 */
	public static void resultadoSerie()
	{
		int valorN = 0;
		Scanner entrada = new Scanner(System.in);
		
		do
		{
			System.out.printf("\nValor de N: ");
			valorN = entrada.nextInt();
			
			if (valorN > 0)
				System.out.printf("%s %.2f", VALOR_SERIE_MSG, calcularSoma(valorN));
						
			else
				break;
						
		}while(true);
		
		entrada.close();
			
	} // resultadoSerie()

	private static double calcularSoma(int numero)
	{
		double soma = 0;
		
		for (int indice = 0; indice < numero; indice++)
			soma += ( indice + 1 ) / ( numero - indice) + ( numero - indice) / ( indice + 1);
		
		return soma;
	}
		
} // class Ex03
