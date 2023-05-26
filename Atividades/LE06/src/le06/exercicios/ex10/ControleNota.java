package le06.exercicios.ex10;

import static le06.entradaesaida.EntradaSaida.*;

public class ControleNota 
{	
	private static final int INDICE_INVALIDO = -1, CADASTRAR = 0, PESQUISAR = 1, ALTERAR = 2, EXCLUIR = 3, RELATORIO = 4, SAIR = 5,
							 PESQUISAR_DISCENTE = 0, PESQUISAR_DISCIPLINA = 1, SAIR_PESQUISA = 2;
	
	private static final String OPCOES_MENU_PRINCIPAL[] = {"Cadastrar", "Pesquisar", "Alterar", "Excluir", "Relatório", "Sair"},
								OPCOES_MENU_PESQUISAR[] = {"Pesquisar Discente", "Pesquisar Disciplina", "Sair"},

								ESCOLHER_OPCAO = "Escolha uma opção",
								TURMA_VAZIA = "Não existem discentes cadastrados.",
								TITULO_PROGRAMA = "Controle de Notas"; 
									
	public static void main(String[] args) 
	{
		new ControleNota();
	}
	
	public ControleNota()
	{
		Turma turma = criarTurma();
		
		int opcao;
		
		do
		{
			opcao = menu(ESCOLHER_OPCAO, TITULO_PROGRAMA, OPCOES_MENU_PRINCIPAL, null);
			
			switch (opcao) 
			{
				/*TEMP*/ case CADASTRAR: if (turma.turmaVazia()) turma.inicializarTurma(); else turma.cadastrarDiscente(); break; // case CADASTRAR: cadastrarDiscente(); break;
			
				case PESQUISAR: pesquisar(turma); break;
				case ALTERAR: turma.alterarDiscente(); break;
				case EXCLUIR: turma.excluirDiscente(); break;
				case RELATORIO: turma.relatorio(); break;
			
				default: break;
			}
			
			if(opcao == SAIR || opcao == INDICE_INVALIDO) break;
		}
		while(true);					
		System.exit(0);
		
	} // ControleNota()
	
	private void pesquisar(Turma turma) 
	{
		int opcao;
		
		if(turma.turmaVazia())
		{
			do
			{
				opcao = menu(ESCOLHER_OPCAO, TITULO_PROGRAMA, OPCOES_MENU_PESQUISAR, null);

				switch (opcao) 
				{
					case PESQUISAR_DISCENTE: turma.pesquisarDiscente(); break;
					case PESQUISAR_DISCIPLINA: turma.pesquisarDisciplina(); break;	

					default: break;
				}
				if(opcao == SAIR_PESQUISA || opcao == INDICE_INVALIDO) break;
			}
			while(true);
		}
		else msgAlerta(TURMA_VAZIA, TITULO_PROGRAMA);
	}

	private Turma criarTurma()
	{
		return new Turma();
	}
}
