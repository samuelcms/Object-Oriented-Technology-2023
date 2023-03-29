package le01.exercicios;

import static java.lang.String.format;
// import java.util.Scanner;
import static util.InterfaceGrafica.lerFloat;
import static util.InterfaceGrafica.msgInfo;


public class Ex10
{
	public static final String KM_PER_DAY = "Quilômetros totais dirigidos por dia: ",
							   PRICE_FUEL = "Preço por litro de combustível: ",
	                           KM_PER_LITER = "Consumo médio (Km/L): ",
	                           SPENDING_PARKING = "Gasto com estacionamento por dia: ",
	                           TOLL_EXPENSES = "Gasto com pedágio por dia: ",
	                           DAILY_EXPENSE = "Gasto diário: R$ ",
	                           TITLE = "Custo para Dirigir";
	
	public static void obterCustoDiario()
	{
		float kmPorDia, precoLitroCombustivel, mediaKmLitro, gastoEstacionamentoDia, gastoPedagioDia, totalDia;

//		Scanner input = new Scanner(System.in);
						
//		kmPorDia = obterGasto(KM_PER_DAY, input);
//		precoLitroCombustivel = obterGasto(PRICE_FUEL, input);
//		mediaKmLitro = obterGasto(KM_PER_LITER, input);
//		gastoEstacionamentoDia = obterGasto(SPENDING_PARKING, input);
//		gastoPedagioDia = obterGasto(TOLL_EXPENSES, input);

		kmPorDia = obterGasto(KM_PER_DAY);
		precoLitroCombustivel = obterGasto(PRICE_FUEL);
		mediaKmLitro = obterGasto(KM_PER_LITER);
		gastoEstacionamentoDia = obterGasto(SPENDING_PARKING);
		gastoPedagioDia = obterGasto(TOLL_EXPENSES);
	
		totalDia = calcularGastoDiario(kmPorDia, precoLitroCombustivel, mediaKmLitro, gastoEstacionamentoDia, gastoPedagioDia);
		exibirCusto(totalDia);
		
		System.exit(0);
			
// 		input.close();
	
	} // obterCustoDiario();
	
//	public static void exibirCusto(float custo) 
//	{
//		System.out.printf("\n\t%s %1.2f", DAILY_EXPENSE, custo);
//	}
	
	public static void exibirCusto(float custo) 
	{
		msgInfo(format("%s %,.2f", DAILY_EXPENSE, custo), TITLE);
	}

	public static float calcularGastoDiario(float kmDia, float precoComb, float mediaKmL, float gastoEstacDia, float gastoPedagioDia) 
	{
		float totalGasto  = (kmDia / mediaKmL) * precoComb + gastoEstacDia + gastoPedagioDia;
		return totalGasto;
	}

	public static float obterGasto(String tipoGasto)
	{
		Float valor = lerFloat(tipoGasto, TITLE);
		return (valor != null) ? valor : 0;
	}

	
//	/**
//	 * Obtém um gasto através da interação com o console e a classe Scanner. 
//	 * Importante: Não é feita nenhuma validação acerca do tipo de dado obtido.
//	 * 
//	 * @param tipoGasto Mensagem detalhando o tipo de gasto que será obtido.
//	 * @param entrada Objeto da classe Scanner utilizado para a entrada de dados.
//	 * 
//	 * @return Retorna um valor do tipo float obtido via teclado.
//	 */
//	public static float obterGasto(String tipoGasto, Scanner entrada)
//	{
//		float gasto;
//			
//		System.out.printf("%s", tipoGasto);
//		gasto = entrada.nextFloat();
//				
//		return gasto;
//	}


} // class Ex10
