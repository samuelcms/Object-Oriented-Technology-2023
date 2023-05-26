package le06.exercicios.ex03;

import static java.lang.String.format;
import static le06.entradaesaida.EntradaSaida.*;
import static javax.swing.SwingConstants.*;

public class Zodiaco 
{
	public static final int SEU_SIGNO = 0, SIGNOS = 1, SAIR = 2, INDICE_INVALIDO = -1;
	
	public static void main(String[] args) 
	{
		new Zodiaco();
	}
	
	public Zodiaco()
	{
		String opcoes[] = {"Seu Signo", "Signos", "Sair"};
		int opcao;
				
		do
		{
			opcao = menu("Escolha uma opção:", "Zodíaco", opcoes, null);
			
			switch (opcao) 
			{
				case SEU_SIGNO: obterSigno(); break;
				case SIGNOS: obterSignos(); break;
			}
		}
		while(opcao != SAIR && opcao != INDICE_INVALIDO);
	}
	
	private void obterSigno()
	{
		String dataNascimento = readString("Data de nascimento (DD/MM/AAAA)", "Idenfificar Signo");
		if(dataNascimento != null && !dataNascimento.isBlank())
			msgInfo(format("Seu signo é: %s",EnumSigno.obterSigno(dataNascimento)), dataNascimento);
	}
	
	private void obterSignos()
	{
		String colunas[] = {"Mês", "Último dia", "Signo"};//, signos[][] = new String[12][];
		int larguraColunas[] = {50, 80, 100}, alinhamento[] = {CENTER, CENTER, CENTER};
			
		exibirTabela("", EnumSigno.obterSignos(), colunas, larguraColunas, alinhamento, 230, 100);
	}
}
