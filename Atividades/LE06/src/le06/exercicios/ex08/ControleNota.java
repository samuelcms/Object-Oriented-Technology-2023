package le06.exercicios.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JScrollPane;
import le06.exercicios.ex06.Discente;

import static le06.entradaesaida.EntradaSaida.*;
import static javax.swing.JOptionPane.*;

public class ControleNota 
{	
	private static final int INDICE_INVALIDO = -1, CADASTRAR = 0, PESQUISAR = 1, ALTERAR = 2, EXCLUIR = 3, RELATORIO = 4, SAIR = 5,
							 PESQUISAR_DISCENTE = 0, PESQUISAR_DISCIPLINA = 1, SAIR_PESQUISA = 2;
	
	private static final String OPCOES_MENU_PRINCIPAL[] = {"Cadastrar", "Pesquisar", "Alterar", "Excluir", "Relatório", "Sair"},
								OPCOES_MENU_PESQUISAR[] = {"Pesquisar Discente", "Pesquisar Disciplina", "Sair"},

								TITULO_CADASTRAR_DISCIPLINA = "Cadastrar Disciplina",
								TITULO_PESQUISAR_DISCIPLINA = "Pesquisar Disciplina",
								TITULO_ALTERAR_DISCENTE = "Alterar Discente",
								TITULO_ALTERAR_DISCIPLINA = "Alterar Disciplina",
								TITULO_EXCLUSAO = "Exclusão",
								ESCOLHER_OPCAO = "Escolha uma opção",
								TURMA_VAZIA = "Não existem discentes cadastrados.",
								TITULO_PROGRAMA = "Controle de Notas", 
								TITULO_PESQUISAR_DISCENTE = "Pesquisar Discente",
								TITULO_CADASTRAR_DISCENTE = "Cadastrar Discente",
								MATRICULA = "Matrícula: ",
								NOME = "Nome do Discente: ", 
								CURSO = "Curso: ", 
								QTD_DISCIPLINAS = "Quantidade de disciplinas: ", 
								NOME_DISCIPLINA = "Nome da disciplina: ", 
								NOTA = "Nota: ", 
								CADASTRO_PENDENTE = "Cadastro pendente:", 
								DISCENTE_NAO_CADASTRADO = "Discente não cadastrado.",
								NOME_MATRICULA = "Nome ou matrícula do discente: ",
								RESUMO = "--------- Resumo ---------\n", 
								NUMERO_DISCENTES = "Número de Discentes =", 
								NUMERO_APROVADOS = "Número de Aprovados =", 
								NUMERO_REPROVADOS = "Número de Reprovados =", 
								PERCENTUAL_APROVADOS = "Percentual de Aprovados =", 
								PERCENTUAL_REPROVADOS = "Percentual de Reprovados =",
								TITULO_RELATORIO = "Relatório", 
								LINHA_EM_BRANCO = "\n\n",
								MATRICULA_DUPLICADA = "Matrícula já cadastrada.",
								ENCERRANDO = "Encerrando", 
								MATRICULA_VAZIA = "O campo \"matrícula\" precisa ser preenchido!", 
								NOME_VAZIO = "O campo \"nome\" precisa ser preenchido!",
								IDENTIFICACAO_DISCENTE_VAZIA = "É necessário fornecer o nome ou a matrícula do discente!",
								MSG_ALTERACAO = "Pressione enter para manter o valor original do campo.",
								CONFIRMAR_EXCLUSAO = "Confirmar exclusão?", 
								EXCLUSAO_CONCLUIDA = "Exclusão concluída.", 
								EXCLUSAO_CANCELADA = "Exclusão cancelada.",
								MATRICULA_INVALIDA = "Matrícula inválida.";
									
	public static void main(String[] args) 
	{
		new ControleNota();
	}
	
	public ControleNota()
	{
		List<Discente> turma = criarTurma();
		
		int opcao;
		
		do
		{
			opcao = menu(ESCOLHER_OPCAO, TITULO_PROGRAMA, OPCOES_MENU_PRINCIPAL, null);
			
			switch (opcao) 
			{
				/*TEMP*/ case CADASTRAR: if (turma.isEmpty()) inicializarTurma(turma); else cadastrarDiscente(turma); break; // case CADASTRAR: cadastrarDiscente(turma); break;
			
				case PESQUISAR: pesquisar(turma); break;
				case ALTERAR: alterarDiscente(turma); break;
				case EXCLUIR: excluirDiscente(turma); break;
				case RELATORIO: relatorio(turma); break;
			
				default: break;
			}
			if(opcao == SAIR || opcao == INDICE_INVALIDO) break;
		}
		while(true);
			
		System.exit(0);
	
	} // ControleNota()
	
	private void pesquisar(List<Discente> discenteList) 
	{
		int opcao;
		
		if(!discenteList.isEmpty())
		{
			do
			{
				opcao = menu(ESCOLHER_OPCAO, TITULO_PROGRAMA, OPCOES_MENU_PESQUISAR, null);

				switch (opcao) 
				{
					case PESQUISAR_DISCENTE: pesquisarDiscente(discenteList); break;
					case PESQUISAR_DISCIPLINA: pesquisarDisciplina(discenteList); break;	

					default: break;
				}
				if(opcao == SAIR_PESQUISA || opcao == INDICE_INVALIDO) break;
			}
			while(true);
		}
		else msgAlerta(TURMA_VAZIA, TITULO_PROGRAMA);
	}

	private List<Discente> criarTurma()
	{
		return new ArrayList<>();
	}
	
	public void cadastrarDiscente(List<Discente> discenteList)
	{
		Discente discente;
		String nomeDiscente, nomeDisciplina, curso, matricula, quantidadeDisciplinas, nota;
					
		if((matricula = readString(MATRICULA, TITULO_CADASTRAR_DISCENTE)) != null) 
		{	
			if(!matricula.isBlank())
			{
				if(validarMatricula(discenteList, matricula))
				{
					if(pesquisarMatricula(discenteList, matricula) == null)
					{
						if((nomeDiscente = readString(NOME, TITULO_CADASTRAR_DISCENTE))!= null)
						{
							if((curso = readString(CURSO, TITULO_CADASTRAR_DISCENTE)) != null)
							{
								if((quantidadeDisciplinas = readString(QTD_DISCIPLINAS, TITULO_CADASTRAR_DISCENTE)) != null)
								{
									discente = new Discente(matricula, nomeDiscente, curso, Integer.parseInt(quantidadeDisciplinas));

									for(int indice = 0; indice < Integer.parseInt(quantidadeDisciplinas); indice++)
									{
										if((nomeDisciplina = readString(NOME_DISCIPLINA, TITULO_CADASTRAR_DISCIPLINA))!= null)
										{
											if((nota = readString(NOTA, TITULO_CADASTRAR_DISCIPLINA)) != null)
												discente.adicionarDisciplina(nomeDisciplina, Float.parseFloat(nota));

											else break;
										}
										else break;
									}
									discenteList.add(discente);
								}
								else if(matricula != null && nomeDiscente != null && curso != null)
									discenteList.add(new Discente(matricula, nomeDiscente, curso));
							}
						}
					}
					else 
					{					
						Discente discenteCadastrado = pesquisarMatricula(discenteList, matricula);

						if(!discenteCadastrado.disciplinasCadastradas() || discenteCadastrado.getNumeroDisciplinas() == 0)
						{						
							msgInfo(String.format("%s %s - %s", CADASTRO_PENDENTE, discenteCadastrado.getNomeDiscente(), discenteCadastrado.getNomeCurso()), TITULO_CADASTRAR_DISCENTE);

							if(discenteCadastrado.getNumeroDisciplinas() == 0)
							{
								if((quantidadeDisciplinas = readString(QTD_DISCIPLINAS, TITULO_CADASTRAR_DISCENTE)) != null)
									discenteCadastrado.setNumeroDisciplinas(Integer.valueOf(quantidadeDisciplinas));

								else return;
							}

							if(!discenteCadastrado.disciplinasCadastradas())
							{
								for(int i = discenteCadastrado.qtdDisciplinasCadastradads(); i < discenteCadastrado.getNumeroDisciplinas(); i++)
								{
									if((nomeDisciplina = readString(NOME_DISCIPLINA, TITULO_CADASTRAR_DISCIPLINA))!= null)
									{
										if((nota = readString(NOTA, TITULO_CADASTRAR_DISCIPLINA)) != null)
											discenteCadastrado.adicionarDisciplina(nomeDisciplina, Float.parseFloat(nota));

										else break;
									}
									else break;
								}
							}
						}
						else msgAlerta(MATRICULA_DUPLICADA, TITULO_CADASTRAR_DISCENTE);
					}
				}
				else msgErro(MATRICULA_INVALIDA, ENCERRANDO);
			}
			else msgErro(MATRICULA_VAZIA, ENCERRANDO);
		}

	} // cadastrarDiscente()
		
	public void pesquisarDiscente(List<Discente> discenteList)
	{
		String nomeDiscente;
		Discente discente;
		
		if(!discenteList.isEmpty())		
		{
			if((nomeDiscente = readString(NOME, TITULO_PESQUISAR_DISCENTE)) != null)
			{
				if(!nomeDiscente.isBlank())
				{
					if((discente = pesquisarDiscente(discenteList, nomeDiscente)) != null)
						msgInfo(formatarInfoDiscente(discente), TITULO_PESQUISAR_DISCENTE);
					
					else
						msgAlerta(DISCENTE_NAO_CADASTRADO, TITULO_PESQUISAR_DISCENTE);				
				}
				else msgErro(NOME_VAZIO, ENCERRANDO);
			}
		}
		else msgAlerta(TURMA_VAZIA, TITULO_PESQUISAR_DISCENTE);
	
	} // pesquisarDiscente()
		
	private Discente pesquisarDiscente(List<Discente> discenteList, String nome)
	{
		for(Discente discente : discenteList)
			if(discente.getNomeDiscente().equalsIgnoreCase(nome))
				return discente;
		
		return null;
	
	} // pesquisarDiscente()
	
	public void pesquisarDisciplina(List<Discente> discenteList)
	{
		String identificacaoDiscente, nomeDisciplina;
		Discente discente;
		Object dadosDisciplina[];
		
		if(!discenteList.isEmpty())		
		{
			if((identificacaoDiscente = readString(NOME_MATRICULA, TITULO_PESQUISAR_DISCIPLINA)) != null)
			{				
				if(!identificacaoDiscente.isBlank())
				{					
					if((discente = pesquisarDiscente(discenteList, identificacaoDiscente)) == null)
						discente = pesquisarMatricula(discenteList, identificacaoDiscente);
					
					if(discente != null)
					{
						if((nomeDisciplina = readString(NOME_DISCIPLINA, TITULO_PESQUISAR_DISCIPLINA)) != null)
							if(!nomeDisciplina.isBlank())
							{
								if((dadosDisciplina = pesquisarDisciplina(discente, nomeDisciplina)) != null)
									msgInfo(String.format("%s: %s - %.2f", discente.getNomeDiscente(), dadosDisciplina[0], (float)dadosDisciplina[1]), TITULO_PESQUISAR_DISCIPLINA);
								
								else msgAlerta(String.format("O discente %s não está matriculado nesta disciplina.", identificacaoDiscente), TITULO_PESQUISAR_DISCENTE);
							}
							else msgErro(NOME_VAZIO, ENCERRANDO);
					}
					else msgAlerta(String.format("Discente %s não cadastrado.", identificacaoDiscente), TITULO_PESQUISAR_DISCENTE);
				}
				else msgErro(IDENTIFICACAO_DISCENTE_VAZIA, ENCERRANDO);
			}
		}
		else msgAlerta(TURMA_VAZIA, TITULO_PESQUISAR_DISCIPLINA);
	
	} // pesquisarDisciplina()
	
	private Discente pesquisarMatricula(List<Discente> discenteList, String matricula)
	{
		for(Discente discente : discenteList)
			if(discente.getMatricula().equals(matricula))
				return discente;
		
		return null;
	
	} // pesquisarMatricula()
	
	private Object[] pesquisarDisciplina(Discente discente, String nome)
	{
		int INDICE_NOME = 0;
		
		for(Object disciplina[] : discente.obterRelacaoDisciplinas())
			if(nome.equalsIgnoreCase(String.valueOf(disciplina[INDICE_NOME])))
				return disciplina;
		
		return null;
	
	} // pesquisarDisciplina()
	
	public void alterarDiscente(List<Discente> discenteList)
	{
		String nomeDiscente, novoValor;
		Discente discente;
		Object disciplinas[][];
		
		if(!discenteList.isEmpty())
		{
			if((nomeDiscente = readString(NOME, TITULO_ALTERAR_DISCENTE)) != null)
			{
				if(!nomeDiscente.isBlank())
				{
					if((discente = pesquisarDiscente(discenteList, nomeDiscente)) != null)
					{
						msgInfo(MSG_ALTERACAO, TITULO_ALTERAR_DISCENTE);
						
						if((novoValor = readString(String.format("(%s)\n%s", discente.getNomeDiscente(), NOME), TITULO_ALTERAR_DISCENTE)) != null)
						{
							if(!novoValor.isEmpty()) discente.setNomeDiscente(novoValor);
							if((novoValor = readString(String.format("(%s)\n%s", discente.getNomeCurso(), CURSO), TITULO_ALTERAR_DISCENTE)) != null)
							{
								if(!novoValor.isEmpty()) discente.setNomeCurso(novoValor);
								
								disciplinas = discente.obterRelacaoDisciplinas();
								for(int i = 0; i < disciplinas.length; i++)
								{
									if((novoValor = readString(String.format("(%s)\n%s", disciplinas[i][0], NOME_DISCIPLINA), TITULO_ALTERAR_DISCIPLINA))!= null)
									{
										if(!novoValor.isBlank()) disciplinas[i][0] = novoValor;	
										if((novoValor = readString(String.format("(%.2f)\n%s", (float)disciplinas[i][1], NOTA), TITULO_ALTERAR_DISCIPLINA)) != null)
										{
											if(!novoValor.isBlank()) disciplinas[i][1] = novoValor;
										}
										else break;
									}
									else break;
								}
								// Atualizando a lista de disciplinas.
								discente.atualizarDisciplinas(disciplinas);
							}
						}
					}
					else msgAlerta(DISCENTE_NAO_CADASTRADO, TITULO_ALTERAR_DISCENTE);				
				}
				else msgErro(NOME_VAZIO, ENCERRANDO);
			}
		}
		else msgAlerta(TURMA_VAZIA, TITULO_PESQUISAR_DISCENTE);
	
	} // alterarDiscente()
	
	public void excluirDiscente(List<Discente> discenteList)
	{
		Discente discente;
		String nomeDiscente;

		if(!discenteList.isEmpty())
		{
			if((nomeDiscente = readString(NOME, TITULO_PESQUISAR_DISCENTE)) != null)
			{
				if(!nomeDiscente.isBlank())
				{		
					if((discente = pesquisarDiscente(discenteList, nomeDiscente)) != null)
					{
						msgInfo(formatarInfoDiscente(discente), TITULO_PESQUISAR_DISCENTE);
						
						if((msgConfirma(CONFIRMAR_EXCLUSAO, TITULO_EXCLUSAO)) == YES_OPTION)
						{
							discenteList.remove(discente);
							msgInfo(EXCLUSAO_CONCLUIDA, TITULO_EXCLUSAO);
						}
						else msgInfo(EXCLUSAO_CANCELADA, TITULO_EXCLUSAO);
					}
					else msgAlerta(DISCENTE_NAO_CADASTRADO, TITULO_EXCLUSAO);				
				}
				else msgErro(NOME_VAZIO, ENCERRANDO);
			}
		}
		else msgAlerta(TURMA_VAZIA, TITULO_PESQUISAR_DISCENTE);		
	
	} // excluirDiscente()
	
	public void relatorio(List<Discente> discenteList)
	{
		StringBuilder relatorio = new StringBuilder();
		int aprovados = 0, reprovados = 0;
		
		writeTextArea(null);
		
		if(!discenteList.isEmpty())
		{
			for(Discente discente : discenteList)
			{
				if(discente.aprovado()) aprovados++;						
				relatorio.append(String.format("%s \t%s \t%s \t%s\n", discente.getMatricula(), discente.getNomeDiscente(), discente.getNomeCurso(), discente.aprovado()? "Aprovado" : "Reprovado"));
			}

			reprovados = discenteList.size() - aprovados;
			
			relatorio.append("\n\n");
			relatorio.append(RESUMO);
			relatorio.append(String.format("%s %d\n", NUMERO_DISCENTES, discenteList.size()));
			relatorio.append(String.format("%s %d\n", NUMERO_APROVADOS, aprovados));
			relatorio.append(String.format("%s %d\n", NUMERO_REPROVADOS, reprovados));
			relatorio.append(String.format("%s %.1f%%\n", PERCENTUAL_APROVADOS, (float)(aprovados * 100) / discenteList.size()));
			relatorio.append(String.format("%s %.1f%%\n", PERCENTUAL_REPROVADOS, (float)(reprovados * 100) / discenteList.size()));

			writeTextArea(relatorio.toString());
			msgInfo(new JScrollPane(getTextArea()), TITULO_PROGRAMA);
		}
		else msgAlerta(TURMA_VAZIA, TITULO_RELATORIO);
	
	} // relatorio()
	
	private String formatarInfoDiscente(Discente discente)
	{
		StringBuilder strBuilder = new StringBuilder();
		
		if(discente.qtdDisciplinasCadastradads() != 0)
		{
			strBuilder.append(discente.toString() + LINHA_EM_BRANCO);
			for(Object[] disciplina : discente.obterRelacaoDisciplinas())
				strBuilder.append(String.format("%s - %.2f\n", disciplina[0], (float)disciplina[1]));
		}
		return strBuilder.toString();
	
	} // formatarInfoDiscente()

	/*
	 * Verifica se uma matrícula é válida seguindo o modelo SSSAAAA-DDD (Sigla do Curso, Ano da matrícula e
	 * Valor numérico sequencial). Exemplo: TSI2023-015, TI2023-016. 
	 */
	public static boolean validarMatricula(List<Discente> discenteList, String matricula)
	{
		if(matricula.matches(Discente.REGEX_MATRICULA))
		{
			if(discenteList.size() != 0)
			{
				String ultimaMatricula[] = discenteList.get(discenteList.size() - 1).getMatricula().split("-"),
					   infoMatricula[] = matricula.split("-");
				
				return (Integer.parseInt(ultimaMatricula[1]) < Integer.parseInt(infoMatricula[1])) ? true : false;			
			}
				
			else 
				return true;
		}
		return false;
	}
		
	// ATENÇÃO: Função usada para testes.
	private void inicializarTurma(List<Discente> turma)
	{
		Random random = new Random();
		
		String matriculas[] = {"AGR2023-001", "BIO2023-002", "CON2023-003", "DAN2023-004", "ECO2023-005", "FIS2023-006", "GAS2023-007", 
				               "HOT2023-008", "ING2023-009", "JOR2023-010", "LAT2023-011", "LET2023-012", "MOD2023-013", "NUT2023-014", 
				               "ODO2023-015", "PED2023-016", "QUI2023-017", "RAD2023-018", "SOC2023-019"},
			   
			   nomes[] = {"Alfredo", "Betina", "Cícero", "Denise", "Euzébio", "Francisca", "Gusmão", "Horácio", "Irene", "Jurandir", 
					      "Kátia", "Luiz", "Madalena", "Norberto", "Olívia", "Pedro", "Quésia", "Ronaldo", "Sílvia"},
			   
			   cursos[] = {"Agronomia", "Biologia", "Contabilidade", "Dança", "Economia", "Fisioterapia", "Gastronomia", "Hotelaria", 
					       "Inglês", "Jornalismo", "Latim", "Letras", "Moda", "Nutrição", "Odontologia", "Pedagogia", "Química", 
					       "Radiologia", "Sociologia"},
			   
			   disciplinas[] = {"D1", "D2", "D3", "D4", "D5"};
		
		int discentes = matriculas.length, numDisciplinas = disciplinas.length;
		
		for(int i = 0; i < discentes; i++)
			turma.add(new Discente(matriculas[i], nomes[i], cursos[i]));
		
		for(Discente discente : turma)
		{
			discente.setNumeroDisciplinas(numDisciplinas);
			
			for(int i = 0; i < numDisciplinas; i++)
				discente.adicionarDisciplina(disciplinas[i], random.nextFloat(100));
		}
	
	} // inicializarTurma()
}
