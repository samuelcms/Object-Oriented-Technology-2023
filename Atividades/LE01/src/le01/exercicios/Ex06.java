package le01.exercicios;

import static util.InterfaceGrafica.*;

public class Ex06 
{
		// Constantes.
		private static final String TITLE = "Calculadora";
		private static final String DELTA_ERROR_MESSAGE = "A equação não tem raízes reais.";
		private static final String A_TERM_ERROR = "O termo 'a' deve ser diferente de 0.";
		private static final String FINISHED_CALCULATION = "Cálculo finalizado";
		private static final String VALUE_OF_A = "Valor de A: ";
		private static final String VALUE_OF_B = "Valor de B: ";
		private static final String VALUE_OF_C = "Valor de C: ";
		private static final int INVALID_DELTA = -1;
			
		public static void calcularEquacao() 
		{
			int termoA, termoB, termoC, delta;
			double x1, x2;
			String resultado;
			
			// Obtendo os termos da equação.
			while((termoA = lerInteger(VALUE_OF_A, TITLE)) == 0)
			{	
				if(termoA == 0)
					msgAdvertencia(A_TERM_ERROR, TITLE);			
			}
				
			termoB = lerInteger(VALUE_OF_B, TITLE);
			termoC = lerInteger(VALUE_OF_C, TITLE);

			// Calculando o valor de Delta.
			delta = calculaDelta(termoA, termoB, termoC);
			
			// Verificando se o valor de DElta é válido.
			if(delta == -1)
			{
				msgErro(DELTA_ERROR_MESSAGE, FINISHED_CALCULATION);
				System.exit(0);
			}
			
			// Calculando as raízes da equação.
	        x1 = ((-termoB) + Math.sqrt(delta)) / 2*termoA; 
	        x2 = ((-termoB) - Math.sqrt(delta)) / 2*termoA;
	        
	        resultado = String.format("Valor de X1: %.2f\nValor de X2: %.2f", x1, x2);
	                
	        msgInfo(resultado, FINISHED_CALCULATION);        
			System.exit(0);
		}

		public static int calculaDelta(int a, int b, int c)
		{
			int delta;
			return (delta = b * b - 4 * a * c) > 0 ? delta : INVALID_DELTA;
		}
	
} // class Ex6



