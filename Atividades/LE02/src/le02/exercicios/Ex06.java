package le02.exercicios;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Ex06 
{
	private static final String 
	
		ERRO = "Número inválido! O valor deve ser > 0.",
		VALOR_PI_MSG = " - Valor de Pi: ";
	
	public static void valorPi()
	{
		double soma;
		int valorN;
		Scanner scanner = new Scanner(System.in);
		
		do 
		{
			System.out.printf("\nValor de N: ");
			valorN = scanner.nextInt();
			
			if (valorN <= 0) 
				System.out.printf("%s \n", ERRO);
			else
				break;
			
		}while(true);
		
		scanner.close();
		soma = 1;
		
		for (int indice = 3, aux = 0; indice < 100; indice += 2) 
		{
			if (aux == 0)
			{
				soma -= 1/Math.pow(indice, 3);
				aux = 1;
			}
			
			else 
			{
				soma += 1/Math.pow(indice, 3);
				aux = 0;
			}
		}
		
		NumberFormat num_ = DecimalFormat.getNumberInstance();
		num_.setMinimumFractionDigits(1);
		num_.setMaximumFractionDigits(valorN);
		
		System.err.println("                 " + Math.pow(soma * 32, (double)1/3));
		System.out.printf("%s %s", VALOR_PI_MSG, num_.format(Math.pow(soma * 32, (double)1/3)));
	}
	
} // class Ex06
