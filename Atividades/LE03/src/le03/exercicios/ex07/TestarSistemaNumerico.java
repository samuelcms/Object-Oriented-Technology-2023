package le03.exercicios.ex07;

import static le03.exercicios.ex06.SistemaNumerico.*;

public class TestarSistemaNumerico 
{
	public static void main(String[] args) 
	{
		testarSistemaNumerico();
	}

	public static void testarSistemaNumerico() 
	{		
		print("- (B10) 429 -> (B2) ");
		exibirNumeroBinario(converterBase10ParaBase2(429));
		
		print("- (B10) 201 -> (B8) ");
		exibirNumeroOctal(converterBase10ParaBase8(201));
		
		print("- (B10) 611 -> (B16) ");
		exibirNumeroHexadecimal(converterBase10ParaBase16(611));	
	}
	
	public static void print(String... strings)
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		for(String string : strings)
			stringBuilder.append(string);
		
		System.out.printf("%s", stringBuilder);
	}
}
