package le03.exercicios.ex05;

import le03.exercicios.ex04.Dicionario;
import java.util.Arrays;

import static javax.swing.JOptionPane.CLOSED_OPTION;
import static le03.exercicios.ex04.Dicionario.isValid;
import static util.InterfaceGrafica.*;
import static java.lang.String.format;

public class TestarDicionario 
{
	private static final String  
	
	NOME_PROGRAMA =	"Dicionário",
	CADASTRAR 	  = "Cadastro",
	CONSULTAR 	  = "Consulta",
	ALTERAR 	  = "Alteração",
	EXCLUIR 	  = "Exclusão",
	LISTAR 		  = "Listagem",
	SAIR		  = "Sair",
	
	OPCOES_MENU[] = {CADASTRAR, CONSULTAR, ALTERAR, LISTAR, EXCLUIR, SAIR},
	
	MSG_PALAVRA_NAO_CADASTRADA = "A palavra \"%s\" não está cadastrada.",
	MSG_PALAVRA_CADASTRADA 	   = "A palavra \"%s\" está cadastrada.",
	MSG_PALAVRA_ADICIONADA     = "A palavra \"%s\" foi cadastrada.",
	MSG_DICIONARIO_VAZIO       = "Dicionário vazio!",
	MSG_ALTERACAO_CONCLUIDA    = "Alteração concluída",
	MSG_CONFIRMAR_EXCLUSAO     = "Confirmar exclusão?",
	MSG_EXCLUSAO_CANCELADA     = "Exclusão cancelada!",
	MSG_MENU 			       = "Escolha uma opção:",
	MSG_OBTER_PALAVRA 		   = "Forneça uma palavra:",
	MSG_NOVA_PALAVRA 		   = "Nova palavra:",
	MSG_PALAVRA_EXCLUIDA 	   = "Palavra \"%s\" excluída.";
	
	private static final int COD_CADASTRAR = 0, COD_CONSULTAR = 1, COD_ALTERAR = 2, 
			                 COD_LISTAR = 3, COD_EXCLUIR = 4, COD_SAIR = 5, CONFIRMAR = 0;
	
	private Dicionario dicionario;
	
	public static void main(String[] args) 
	{
		new TestarDicionario();
	}
	
	public TestarDicionario()
	{
		dicionario = new Dicionario();
		int opcao;
		
		do 
		{
			opcao = menu(MSG_MENU, NOME_PROGRAMA, OPCOES_MENU);
			
			switch (opcao)
			{
				case COD_CADASTRAR: cadastrar(); break;
				case COD_CONSULTAR: consultar(); break;
				case COD_ALTERAR: alterar(); break;
				case COD_LISTAR: listar(); break;
				case COD_EXCLUIR: excluir(); break;
			}
		}
		while(opcao != CLOSED_OPTION && opcao != COD_SAIR);

	} // TestarDicionario()
	
	public void cadastrar() 
	{
		// String palavra = lerString(MSG_OBTER_PALAVRA, CADASTRAR);
		
		/* TEMP */
		String palavra = "abobrinha#banana#chuchu#damasco#amora#batata#caqui#danone#tomate#uva#inhame#melancia#ovo#suco"
					   + "#lima#pitanga#mexerica#alface#couve#beterraba#cebolinha#alecrim#gengibre#cenoura#acerola";
		
		if(isValid(palavra))
		{
			dicionario.adicionarPalavra(palavra);
			msgInfo(format(MSG_PALAVRA_ADICIONADA, palavra), NOME_PROGRAMA);
			
		}	
	} // cadastrar()
	
	public void consultar() 
	{
		if(!dicionario.isEmpty())
		{
			String palavra = lerString(MSG_OBTER_PALAVRA, CONSULTAR);
			
			if(Dicionario.isValid(palavra))
			{
				if(dicionario.consultarPalavra(palavra) == true)
					msgInfo(format(MSG_PALAVRA_CADASTRADA, palavra), CONSULTAR);
				
				else
					msgAdvertencia(format(MSG_PALAVRA_NAO_CADASTRADA, palavra), CONSULTAR);
			}
		}
		else 
			msgAdvertencia(MSG_DICIONARIO_VAZIO, CONSULTAR);
	
	} // consultar()
	
	public void alterar()
	{
		if(!dicionario.isEmpty())
		{
			String palavraAntiga = lerString(MSG_OBTER_PALAVRA, ALTERAR);
					
			if(Dicionario.isValid(palavraAntiga))
			{				
				if(dicionario.consultarPalavra(palavraAntiga))
				{
					String palavraNova = lerString(MSG_NOVA_PALAVRA, ALTERAR);
					if(isValid(palavraNova))
					{
						dicionario.alterarPalavra(palavraAntiga, palavraNova);
						msgInfo(MSG_ALTERACAO_CONCLUIDA, ALTERAR);
					}
				}
				else
					msgAdvertencia(format(MSG_PALAVRA_NAO_CADASTRADA, palavraAntiga), ALTERAR);
			}
		}
		else
			msgAdvertencia(MSG_DICIONARIO_VAZIO, CONSULTAR);
		
	} // alterar()
	
	public void excluir()
	{	
		if(!dicionario.isEmpty())
		{
			String palavra = lerString(MSG_OBTER_PALAVRA, EXCLUIR);
			int confirmacao;
			
			if(Dicionario.isValid(palavra))
			{
				if(dicionario.consultarPalavra(palavra))
				{
					confirmacao = msgConfirma(MSG_CONFIRMAR_EXCLUSAO, EXCLUIR);

					if(confirmacao == CONFIRMAR)
					{
						dicionario.excluirPalavra(palavra);
						msgInfo(format(MSG_PALAVRA_EXCLUIDA, palavra), EXCLUIR);
					}
					else
						msgAdvertencia(MSG_EXCLUSAO_CANCELADA, EXCLUIR);							
				}
				else
					msgAdvertencia(format(MSG_PALAVRA_NAO_CADASTRADA, palavra), EXCLUIR);
			}
		}
		else 
			msgAdvertencia(MSG_DICIONARIO_VAZIO, EXCLUIR);		
		
	} // excluir()
	
	public void listar() 
	{
		char A_CHAR = 'a', Z_CHAR = 'z';
		String listaPalavras, listaPalavrasOrdenada[];
		StringBuilder palavrasFormatadas = new StringBuilder();

		if(!dicionario.isEmpty())
		{
			for(int letra = A_CHAR, contadorPalavras = 1 ; letra <= Z_CHAR; letra++)
			{
				listaPalavras = dicionario.obterPalavras((char)letra);
							
				if(listaPalavras != null)
				{								
					listaPalavrasOrdenada = listaPalavras.toLowerCase().split(String.valueOf(dicionario.getSeparador()));
					Arrays.sort(listaPalavrasOrdenada);
					palavrasFormatadas.append(format("- %c", Character.toUpperCase((char)letra)));
							
					for(String palavra : listaPalavrasOrdenada)
						palavrasFormatadas.append(format("\n   - %d. %s", contadorPalavras++, palavra));
					
					palavrasFormatadas.append(format("\n\n"));
				}			
			}
			exibirTexto(palavrasFormatadas.toString(), LISTAR, 10, 20);
		}
		else
			msgAdvertencia(MSG_DICIONARIO_VAZIO, CONSULTAR);

	} // listar()
		
} // class TestarDicionario