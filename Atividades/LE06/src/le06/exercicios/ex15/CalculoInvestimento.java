package le06.exercicios.ex15;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.CLOSED_OPTION;
import static le06.entradaesaida.EntradaSaida.*;
import static le06.exercicios.ex15.ImportacaoArquivo.*;

public class CalculoInvestimento
{
	private static final String OPCOES_MENU[] = {"Importar Arquivo", "Relatório Investimentos", "Sair"},  RENDA_FIXA = "Renda Fixa", 
			                    RENDA_VARIAVEL = "Renda Variável", ABV_RENDA_FIXA = "RF", SIM = "sim", NAO = "não", TAB = "     ";
	
	private static final int IMPORTAR = 0, RELATORIO = 1, SAIR = 2, TIPO = 0, ESTRATEGIA = 1, NOME = 2, RATING = 3, 
							 FGC = 4, VALOR_INVESTIDO = 5, TAXA = 6, DATA_INVESTIMENTO = 7, DATA_RESGATE = 8,
							 DIAS_UTEIS_MES = 21, DIAS_UTEIS_ANO = 252, NUM_MESES = 12;

	private static final float ALIQUOTA_IR_RV = 15.0f;
	
	
	private List<Investimento> investimentos;
	
	public static void main(String[] args) 
	{
		new CalculoInvestimento();		
		System.exit(0);
	}
	
	public CalculoInvestimento() 
	{		
		investimentos = new ArrayList<>();
		int opcao;
						
		do
		{
			opcao = menu("Escolha uma opção: ", "Investimentos", OPCOES_MENU, null);
			
			switch (opcao) 
			{
				case IMPORTAR: importar(); break;
				case RELATORIO: relatorio(); break;
				
				default: break;
			}
		}
		while(opcao != SAIR && opcao != CLOSED_OPTION);
	}

	private void importar() 
	{		
		List<String> conteudoArquivo;
		String nomeArquivo = readString("Nome do arquivo: ", "Importar Arquivo"); //"Investimentos2.txt";  
		
		if(nomeArquivo != null && !nomeArquivo.isBlank())
		{;
			conteudoArquivo = linhasArquivo(nomeArquivo);
			
			if(conteudoArquivo != null)
				adicionarInvestimentos(conteudoArquivo);
									
			else msgErro(String.format("Não foi possível acessar o arquivo \"%s\".", nomeArquivo), "Importar Arquivo");
		}
	}

	// Cria e instancia um objeto para cada linha do aquivo e o adiciona na lista de investimentos.
	private void adicionarInvestimentos(List<String> linhasArquivo) 
	{
		Investimento investimento;
		String dadosInvestimento[];
		float aliquotaIR;
		
		if(linhasArquivo != null && !linhasArquivo.isEmpty())
		{
			for(String linha : linhasArquivo)
			{
				dadosInvestimento = dadosInvestimento(linha);
				investimento = new Investimento();
				
				if(dadosInvestimento[TIPO].equals(ABV_RENDA_FIXA)) investimento.setTipo(RENDA_FIXA);
				else investimento.setTipo(RENDA_VARIAVEL);
				
				if(dadosInvestimento[FGC].equals(SIM)) investimento.setFgc(true);
				else investimento.setFgc(false);
					
				
				investimento.setEstrategia(dadosInvestimento[ESTRATEGIA]);
				investimento.setNome(dadosInvestimento[NOME]);
				investimento.setRating(dadosInvestimento[RATING]);
				investimento.setValorInvestido(Float.parseFloat(dadosInvestimento[VALOR_INVESTIDO]));
				investimento.setTaxa(formatarTaxa(dadosInvestimento[TAXA]));
				investimento.setDataInvestimento(dadosInvestimento[DATA_INVESTIMENTO]);
				investimento.setDataResgate(dadosInvestimento[DATA_RESGATE]);
				
				if(investimento.getTipo().equals(RENDA_FIXA))
					aliquotaIR = Imposto.obterAliquota(diasEntreDatas(investimento.getDataInvestimento(), investimento.getDataResgate()));
				
				else aliquotaIR = ALIQUOTA_IR_RV;
				
				investimento.setTaxaImpostoRenda(aliquotaIR);
				
				investimentos.add(investimento);
			}
		}
	}

	private void relatorio() 
	{
		StringBuilder relatorioInvestimentos = new StringBuilder(),
				      relatorioRendaFixa = new StringBuilder(),
				      relatorioRendaVariavel = new StringBuilder();
				
		if(!investimentos.isEmpty())
		{
			relatorioInvestimentos.append("Relatório de Investimentos" + LINHA_VAZIA);
			relatorioRendaFixa.append("1. Renda Fixa" + LINHA_VAZIA);
			relatorioRendaVariavel.append("2. Renda Variável" + LINHA_VAZIA);
			
			for(Investimento investimento : investimentos)
			{
				if(investimento.getTipo().equals(RENDA_FIXA)) relatorioRendaFixa.append(relatorioInvestimento(investimento) + LINHA_VAZIA);
				else relatorioRendaVariavel.append(relatorioInvestimento(investimento) + LINHA_VAZIA);
			}
			
			relatorioInvestimentos.append(relatorioRendaFixa.toString() + NOVA_LINHA);
			relatorioInvestimentos.append(relatorioRendaVariavel.toString() + NOVA_LINHA);

			exibirTexto(relatorioInvestimentos.toString(), "Relatório", 40, 60);
		}
		else msgAlerta("Base de dados vazia!", "Relatório");
	}
	
	// Gera o relatório do investimento.
	public String relatorioInvestimento(Investimento investimento) 
	{
		StringBuilder relatorio = new StringBuilder();
		String prazo = investimento.getTipo().equals(RENDA_FIXA) ? calcularPrazoRendaFixa(investimento.getDataInvestimento(), investimento.getDataResgate()) : 
			                                                       calcularPrazoRendaVariável(investimento.getDataInvestimento(), investimento.getDataResgate());
		
		

		relatorio.append(String.format("- %s | %s | %s | FGC: %s | Prazo: %s\n", investimento.getNome(), 
				investimento.getRating(), investimento.getEstrategia(), 
				(investimento.isFgc() == true ? SIM : NAO), prazo));

		relatorio.append(NOVA_LINHA);

		relatorio.append(String.format("%s Valor investido: R$ %,.2f\n", TAB, investimento.getValorInvestido()));
		relatorio.append(String.format("%s Taxa ao ano: %.2f%% a.a.\n", TAB, investimento.getTaxa()));
		relatorio.append(String.format("%s Taxa ao mês: %.2f%% a.m.\n", TAB, investimento.taxaEquivalenteMes()));
		relatorio.append(String.format("%s Data do investimento: %s\n", TAB, investimento.getDataInvestimento()));
		relatorio.append(String.format("%s Data de resgate: %s\n", TAB, investimento.getDataResgate()));
		relatorio.append(String.format("%s Valor bruto: R$ %,.2f\n", TAB, investimento.calcularValorBruto()));
		relatorio.append(String.format("%s Valor líquido: R$ %,.2f\n", TAB, investimento.calcularValorLiquido())); 
		relatorio.append(String.format("%s Alíquota de IR: %.1f%%\n", TAB, investimento.getTaxaImpostoRenda())); 
		relatorio.append(String.format("%s Valor do IR: R$ %,.2f\n", TAB, investimento.calcularValorIR()));   
		relatorio.append(String.format("%s Rendimento bruto: R$ %,.2f\n", TAB, investimento.rendimentoBruto())); 
		relatorio.append(String.format("%s Rendimento líquido: R$ %,.2f\n", TAB, investimento.rendimentoLiquido())); 
		relatorio.append(String.format("%s Rentabilidade: %.2f%%\n", TAB, investimento.calcularRentabilidade()));
				
		return relatorio.toString();
	}
	
	/*
	 * Retorna o número de dias úteis entre duas datas. 
	 * 
	 * Atenção: A contagem de dias despreza os feriados, tanto os que acontecem nos finais de
	 * 			semana, quanto os que ocorrem em dias úteis. Apenas finais de semana não são
	 * 			contabilizados. 
	 */
	public static int diasEntreDatas(String dataInicio, String DataFim)
	{
		LocalDate inicio = converterData(dataInicio), termino = converterData(DataFim);
		int diasUteis = 0;
        
        while (!inicio.isAfter(termino)) 
        {
            if (inicio.getDayOfWeek() != DayOfWeek.SATURDAY && inicio.getDayOfWeek() != DayOfWeek.SUNDAY) 
                diasUteis++;
            
            inicio = inicio.plusDays(1);
        }
        
        return diasUteis;		
	}
	
	// Retorna o número de meses entre duas datas considerando apenas os dias úteis entre elas.
	public static int mesesEntreDatas(String dataInicio, String DataFim)
	{
		return diasEntreDatas(dataInicio, DataFim) / DIAS_UTEIS_MES;
	}
	
	// Retorna o número de anos entre duas datas considerando apenas os dias úteis entre elas.
	public static int anosEntreDatas(String dataInicio, String DataFim)
	{
		return diasEntreDatas(dataInicio, DataFim) / DIAS_UTEIS_ANO;
	}
	
	// Converte uma quantidade de dias em meses considerando a quantidade de dias úteis de um mês.
	public static int diasEmMeses(int numDias)
	{
		return numDias / DIAS_UTEIS_MES;
	}
	
	// Converte uma quantidade de dias em anos considerando a quantidade de dias úteis de um ano.
	public static int diasEmAnos(int numDias)
	{
		return numDias / DIAS_UTEIS_ANO;
	}
	
	// Converte uma quantidade de meses em anos.
	public static int mesesEmAnos(int numMeses)
	{
		return numMeses / NUM_MESES;
	}
		
	/*
	 * Retorna uma representação String do prazo calculado para investimentos de Renda Fixa,
	 * que é exibido em meses se o período de investimento for inferior a um ano (até 12 meses)
	 * ou em anos, caso contrário.  
	 */
	public static String calcularPrazoRendaFixa(String dataInicio, String dataFim)
	{
		int periodo = mesesEntreDatas(dataInicio, dataFim);
		
		if(periodo >= NUM_MESES)
		{
			periodo = mesesEmAnos(periodo);
			return String.format("%d %s", periodo, periodo > 1 ? "anos" : "ano");
		}
		
		else		
			return String.format("%d %s", periodo, periodo > 1 ? "meses" : "mês");
	}
	
	/*
	 * Retorna uma representação String do prazo calculado para investimentos de Renda Variável,
	 * que é exibido em dias se o período de investimento for inferior a um ano (252 dias) ou em 
	 * anos, caso contrário.  
	 */
	public static String calcularPrazoRendaVariável(String dataInicio, String dataFim)
	{
		int periodo = diasEntreDatas(dataInicio, dataFim);
		
		if(periodo >= DIAS_UTEIS_ANO)
		{
			periodo = diasEmAnos(periodo);
			return String.format("%d %s", periodo, periodo > 1 ? "anos" : "ano");
		}
		
		else		
			return String.format("%d %s", periodo, periodo > 1 ? "dias" : "dia");
	}
}
