package le06.exercicios.ex14;

import java.util.ArrayList;
import java.util.List;

import static le06.exercicios.ex14.ImportacaoDados.*;
import static javax.swing.JOptionPane.CLOSED_OPTION;
import static le06.entradaesaida.EntradaSaida.*;

public class PersonalTraining 
{	
	private static final int IMPORTAR = 0, PESQUISAR = 1, RELATORIO = 2, SAIR = 3;
	private static final String OPCOES_MENU[] = {"Importar Arquivo", "Pesquisar Aluno", "Relatório", "Sair"};
	
	private List<Pessoa> alunos;
	
	public static void main(String[] args)
	{
		new PersonalTraining();		
		System.exit(0);
	}
	
	public PersonalTraining() 
	{
		alunos = new ArrayList<>();
		int opcao;
		
		do
		{
			opcao = menu("Escolha uma opção: ", "Controle de Alunos", OPCOES_MENU, null);
			
			switch(opcao) 
			{
				case IMPORTAR:  importar();  break;
				case PESQUISAR: pesquisar(); break;
				case RELATORIO: relatorio(); break;
				
				default: break;
			}
		}
		while(opcao != SAIR && opcao != CLOSED_OPTION);
	}
	
	/*
	 *	Importa os dados do arquivo para o programa. 
	 */
	public void importar() 
	{
		String conteudoArquivo, 
		       nomeArquivo = readString("Nome do arquivo de exercício: ", "Importar Arquivo");
		
		if(nomeArquivo != null && !nomeArquivo.isBlank())
		{
			if((conteudoArquivo = obterConteudoArquivo(nomeArquivo)) != null)
			{
				instanciarAluno(conteudoArquivo);
				msgInfo(String.format("Arquivo \"%s\" importado com sucesso.", nomeArquivo), "Importar Arquivo");
			}
						
			else
				msgErro(String.format("Não foi possível abrir o arquivo \"%s\".", nomeArquivo), "Importar Arquivo");
		}
	}

	/*
	 * Procura por um aluno na lista de alunos e exibe suas informações e seus exercícios.
	 */
	public void pesquisar() 
	{
		if(!alunos.isEmpty())
		{
			String nomeAluno = readString("Pesquisar Cliente", "Nome do cliente: ");

			if(nomeAluno != null)
			{
				if(!nomeAluno.isEmpty())
				{ 
					if(alunoCadastrado(nomeAluno) == true)
						exibirTexto(gerarFichaCadastro(obterAluno(nomeAluno)), "Pesquisar Cliente", 30, 30);

					else
						msgErro("Pesquisar Cliente", "Cliente não cadastrado");
				}
			}	
		}
		else msgAlerta("Base de dados vazia!", "Pesquisar Cliente");
	}

	/*
	 * Exibe um relatório para cada cliente com as seguintes informações: 
	 * 
	 * 		a) A maior duração de um exercício.
	 * 		b) A maior distância percorrida.
	 * 		c) O maior número de calorias perdidas.
	 * 		d) O maior número de passos dados.
	 * 		e) A velocidade máxima mais rápida.
	 */
	private void relatorio() 
	{
		StringBuilder strb = new StringBuilder();
		
		if(!alunos.isEmpty())
		{
			for(Pessoa aluno : alunos)
			{
				strb.append(aluno.gerarRelatorio());
				strb.append("\n\n");
			}
		
			exibirTexto(strb.toString(), "Relatório", 20, 35);
		}
		else msgAlerta("Base de dados vazia!", "Relatório");
	}
	
	// Reúne todas as informações de uma pessoa e de seus exercícios em uma string.
	private String gerarFichaCadastro(Pessoa pessoa)
	{
		StringBuilder stringBuilder = new StringBuilder();
				
		stringBuilder.append(CABECALHO_1);
		stringBuilder.append("\n" + pessoa);
		stringBuilder.append("\n\n" + CABECALHO_4);

		for(Exercicio exercicio : pessoa.obterExercicios())
			stringBuilder.append("\n" + exercicio + "\n");

		return stringBuilder.toString();
	}

	/*
	 * Extrai do arquivo as informações sobre o aluno e instancia um objeto da classe Pessoa com os dados obtidos.
	 */
	private void instanciarAluno(String conteudoArquivo) 
	{
		String nomeAluno, nomeExercicio, dadosExercicio[], dadosAluno[], secoes[] = obterSecoes(conteudoArquivo);
		Pessoa aluno;
		
		removerCabecalhos(secoes);
		nomeAluno = obterNomeCliente(secoes[SECAO_DADOS_ALUNO]);
		
		if(!alunoCadastrado(nomeAluno))
		{
			dadosAluno = obterDadosAluno(secoes[SECAO_DADOS_ALUNO]); 
			
			alunos.add(new Pessoa(nomeAluno, dadosAluno[INDICE_SEXO], dadosAluno[INDICE_DATA_NASCTO], 
					   Float.parseFloat(removerUnidade(formatarCampoFloat(dadosAluno[INDICE_ALTURA]))), 
					   Float.parseFloat(removerUnidade(formatarCampoFloat(dadosAluno[INDICE_PESO])))));			
		}
		
		nomeExercicio = obterNomeExercicio(secoes[SECAO_EXERCICIO]);
		dadosExercicio = obterDetalhesExercicio(secoes[SECAO_DETALHES_EXERCICIO]);
		aluno = obterAluno(nomeAluno); 
				
		if(aluno.checarChavesPrimarias(nomeExercicio, dadosExercicio[INDICE_DATA_EXERCICIO]))
		{
			Exercicio novoExercicio;
			
			if(secoes.length == SECOES_ARQ_1)
				novoExercicio = instanciarExercicio(nomeExercicio, dadosExercicio, secoes[SECAO_RITMO]);
			
			else
				novoExercicio = instanciarExercicio(nomeExercicio, dadosExercicio, null);
			
			aluno.adicionarExercicio(novoExercicio);
			alunos.set(indicealuno(nomeAluno), aluno);
		}	
	}
	
	/*
	 * Extrai do arquivo as informações sobre o exercício e instancia e inicializa um objeto da classe Exercício com os dados obtidos.
	 */
	private Exercicio instanciarExercicio(String nomeExercicio, String[] dados, String secaoRitmo) 
	{
		Exercicio exercicio = new Exercicio(nomeExercicio, dados[INDICE_DATA_EXERCICIO], dados[INDICE_TEMPO], 
                                            dados[INDICE_DURACAO], Float.parseFloat(removerUnidade(formatarCampoFloat(dados[INDICE_CALORIAS]))), 
                                            Float.parseFloat(removerUnidade(formatarCampoFloat(dados[INDICE_DISTANCIA]))), 
                                            Integer.parseInt(formatarCampoInt(dados[INDICE_PASSOS])));

		if(secaoRitmo != null)
		{
			InformacoesAdicionais info = new InformacoesAdicionais(Float.parseFloat(removerUnidade(formatarCampoFloat(dados[INDICE_VELOCIDADE_MEDIA]))),
																   Float.parseFloat(removerUnidade(formatarCampoFloat(dados[INDICE_VELOCIDADE_MAXIMA]))),
																   dados[INDICE_RITMO_MEDIO], dados[INDICE_RITMO_MEDIO],
					                                               Integer.parseInt(formatarCampoInt(removerUnidade(dados[INDICE_MAIOR_ELEVACAO]))),
					                                               Integer.parseInt(formatarCampoInt(removerUnidade(dados[INDICE_MENOR_ELEVACAO]))));
			
			exercicio.setVelocidadeRitmoElevacao(info);
			exercicio.adicionarRitmoExericio(secaoRitmo.split(ImportacaoDados.NOVA_LINHA));
		}		
		return exercicio;
	}

	/*
	 * Retorna a posição relativa do aluno na lista de alunos, se este estiver cadastrado, 
	 * ou -1, caso contrário..
	 */
	private int indicealuno(String nomeCliente)
	{
		int indiceCliente = 0; 
				
		for(Pessoa pessoa : alunos)
		{
			if(pessoa.getNome().equals(nomeCliente))
				return indiceCliente;
			
			indiceCliente++;
		}
		
		return -1;
	}
	
	/*
	 * Obtém um aluno através do seu nome. Retorna null caso não encontre nenhum aluno com o nome
	 * passado via parâmetro.
	 */
	public Pessoa obterAluno(String nomeAluno)
	{
		int indiceAluno = indicealuno(nomeAluno);
		return (indiceAluno != -1) ? alunos.get(indiceAluno) : null;
	}
	
	/*
	 * Retorna true se um aluno já está cadastrado ou false, caso contrário.
	 */
	private boolean alunoCadastrado(String nomeAluno)
	{
		return (indicealuno(nomeAluno) != -1) ? true : false;
	}

} // class PersonalTraining
