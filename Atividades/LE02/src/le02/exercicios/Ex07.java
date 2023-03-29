package le02.exercicios;

import java.util.Scanner;

public class Ex07 
{
	private static final String NUM_TERMOS = "Quantidade de termos: ";
		
	public static void exibirSequencia()
	{
		int numTermos;

		numTermos = obterQuantidadeTermos(NUM_TERMOS);
		
		for (int i = 0; i < numTermos; i++) 
            System.out.printf(" %d ", fibonacci(i));
	}

	private static long fibonacci(int n) 
	{
		if (n < 2) 
			return n;

		else 
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	private static int obterQuantidadeTermos(String mensagem)
	{
		int numTermos;
		Scanner entrada = new Scanner(System.in);
		System.out.printf("%s", mensagem);
		
		numTermos = entrada.nextInt();
		entrada.close();
		
		return numTermos;
	}
			
} // class Ex07
