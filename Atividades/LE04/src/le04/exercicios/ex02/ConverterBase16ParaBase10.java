package le04.exercicios.ex02;

import java.util.Scanner;

public class ConverterBase16ParaBase10 
{	
	private static final int BASE_16 = 16;
	
	private static Scanner scanner = new Scanner(System.in);
			
	public static void main(String[] args) 
	{
		iniciar();
		scanner.close();
	}

	public static void iniciar() 
	{	
		System.out.print("Hexadicimal number: ");
		String numeroHex = scanner.nextLine();		
		System.out.println(String.format("(B16) %s == (B10) %s", numeroHex, converterBase16ParaBase10(numeroHex)));
	}
	
	public static String converterBase16ParaBase10(String numeroHex)
	{		
		Double soma = 0.0;
		for(int indice = numeroHex.length() - 1, exp = 0; indice > -1; indice--, exp++)
		{	
			soma += Integer.parseInt(Character.toString(numeroHex.charAt(indice)), BASE_16) * Math.pow(BASE_16, exp);  
		}
		
		return String.format("%.0f", soma);
	}

} // class ConverterBase16ParaBase10