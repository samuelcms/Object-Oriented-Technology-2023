package le01.exercicios;

import java.util.Scanner;

public class Ex09 
{
	private static final int CAPACITY = 20;
	private static final String INPUT_MSG = "Forneça uma string: ";
	
	public static void testarStringBuilder()
	{
		StringBuilder strBuilder = new StringBuilder();
		Scanner entrada = new Scanner(System.in);
		
		// Garante que a capacidade seja pelo menos igual ao mínimo especificado.
		strBuilder.ensureCapacity(CAPACITY);
		
		System.out.println(INPUT_MSG);
		strBuilder.append(entrada.nextLine());
		
		System.out.printf("\n - Tamanho atual: %d \t - Capacidade atual: %d \n", strBuilder.length(), strBuilder.capacity());
		
		// Redefinindo o tamanho do objeto "stringBuilder" para o dobro de seu tamanho atual.
		strBuilder.setLength((strBuilder.length() * 2));
		
		// Atribuindo ao objeto "stringBuilder" uma string com o dobro da capacidade inicial.
		strBuilder.replace(0, strBuilder.length(), "0123456789012345678901234567890123456789");
						
		System.out.printf(" - Novo tamanho: %d \t - Nova capacidade: %d \n", strBuilder.length(), strBuilder.capacity());
			
		entrada.close();
	
	} // testarStringBuilder()

} // class Ex9
