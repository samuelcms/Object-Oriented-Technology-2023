package le08.exercicios.ex10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import javax.swing.JOptionPane;

import static mos.es.EntradaSaida.*;

public class FolhaPagamento 
{
	@SuppressWarnings("unused")
	private EmpregadoList funcionarios;
	
	public FolhaPagamento() 
	{
		final String OPCOES[] = {"Cadastrar", "Alterar", "Consultar", "Relatório", "Reajuste", "Sair"};
		final short CAD = 0, ALT = 1, CON = 2, REL = 3, REA = 4, SAIR = 5;
		
		funcionarios = criarListaDeFuncionarios();
		int opcao;
		
		do
		{
			opcao = menu("Escolha uma opção: ", "Controle de Funcionários", OPCOES, null);
			
			switch (opcao) 
			{
				case CAD: break;
				case ALT: break;
				case CON: break;
				case REL: break;
				case REA: break;				
			}
		}
		while(opcao != SAIR && opcao != JOptionPane.CLOSED_OPTION);
	}
	
	public static void main(String[] args) 
	{
		new FolhaPagamento();
	}
	
	private EmpregadoList criarListaDeFuncionarios()
	{
		return new EmpregadoList();
	}
	
	// Classe interna.
	public class EmpregadoList 
	{
		private List<Empregado> listaEmpregados = new ArrayList<>();
		
		// Informa o número atual de empregados da lista.
		public int numeroEmpregados()
		{
			return listaEmpregados.size(); 
		}
		
		// Insere um empregado na lista.
		public void inserir(Empregado empregado)
		{
			
		}
	
		// Obtém um empregado se o seu nome estiver na lista.
		public Optional<Empregado> obter(String nome)
		{
			return Optional.empty();
		}
		
		// Obtém um empregado na posição indicada.
		public Optional<Empregado> obter(int posicao)
		{
			return Optional.empty();
		}
		
		// Obtém a posição do empregado na lista se o seu nome estiver cadastrado.
		@SuppressWarnings("unused")
		private OptionalInt pesquisar(String nome)
		{
			return OptionalInt.empty();
		}
	}
}
