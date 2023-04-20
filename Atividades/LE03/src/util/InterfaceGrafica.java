package util;

import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showOptionDialog;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InterfaceGrafica
{
	/**
	 * Exibe uma caixa e diálogo com uma mensagem de erro.
	 * 
	 * @param mensagem Mensagem a ser exibida.
	 * @param titulo Título da janela.
	 **/
	public static void msgErro(String mensagem, String titulo )
	{
		showMessageDialog(null, mensagem, titulo, ERROR_MESSAGE);
	}
	
	/**
	 * Exibe uma caixa e diálogo com uma mensagem de erro.
	 * 
	 * @param mensagem Mensagem a ser exibida.
	 * @param titulo Título da janela.
	 **/
	public static void msgAdvertencia(String mensagem, String titulo )
	{
		showMessageDialog(null, mensagem, titulo, WARNING_MESSAGE);
	}
	
	/**
	 * Exibe uma caixa e diálogo com uma mensagem informartiva.
	 * 
	 * @param mensagem Mensagem a ser exibida.
	 * @param titulo Título da janela.
	 **/
	public static void msgInfo(String mensagem, String titulo )
	{
		showMessageDialog(null, mensagem, titulo, INFORMATION_MESSAGE);
	}
	
	/**
	 * Exibe uma caixa de diálogo para entrada de dados.
	 * 
	 * @param mensagem Mensagem a ser exibida.
	 * @param titulo Título da janela.
	 * 
	 * @return Retorna a string lida através da caixa de diálogo ou 'null', caso a leitura 
	 *         de dados seja cancelada.
	 **/
	public static String lerString(String mensagem, String titulo )
	{
		return showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE);
	}
	
	/**
	 * Exibe uma caixa de diálogo para entrada de dados.
	 * 
	 * @param mensagem Mensagem a ser exibida.
	 * @param titulo Título da janela.
	 * 
	 * @return Retorna o número inteiro lido através da caixa de diálogo ou 'null', caso 
	 * 		   a leitura de dados seja cancelada. 
	 **/
	public static Integer lerInteger(String mensagem, String titulo )
	{
		String valor = showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE);
		
		if(valor == null || valor.isBlank())
			return null;
		
		return Integer.valueOf(valor);
	}
	
	/**
	 * Exibe uma caixa de diálogo para entrada de dados.
	 * 
	 * @param mensagem Mensagem a ser exibida.
	 * @param titulo Título da janela.
	 * 
	 * @return Retorna o número decimal lido através da caixa de diálogo ou 'null', caso 
	 * 		   a leitura de dados seja cancelada. 
	 **/
	
	public static Float lerFloat(String mensagem, String titulo) 
	{
		String valor = showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE);
		
		if(valor == null || valor.isBlank())
			return null;
				
		return Float.parseFloat(valor);
	}
	
	/**
	 * Exibe uma caixa de diálogo para entrada de dados.
	 * 
	 * @param mensagem Mensagem a ser exibida.
	 * @param titulo Título da janela.
	 * 
	 * @return Retorna o número lido através da caixa de diálogo  em formato string  
	 * ou 'null', caso a leitura de dados seja cancelada.
	 **/
	public static String lerNumero(String mensagem, String titulo )
	{
		return showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE);
	}
	
	/**
	 * Exibe um <i>menu</i> em uma caixa de diálogo com botões de comando para cada opção armazenada em <code>opcoes</code>.
	 * 
	 * @param mensagem texto a ser exibido na caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo;
	 * @param opcoes nomes das opções de comando a serem exibidos nos botões do <i>menu</i>.
	 * 
	 * @return a posição do vetor <code>opcoes</code> correspondente a escolha de comando do usuário ou <code>CLOSED_OPTION</code> se a caixa de diálogo for fechada.
	 */
	public static int menu(String mensagem, String titulo, String[] opcoes) 
	{
		return showOptionDialog(null, mensagem, titulo, DEFAULT_OPTION, QUESTION_MESSAGE, null, opcoes, null);		
	}

	/**
	 * Exibe uma pergunta em uma caixa de diálogo para o usuário responder Sim ou Não.
	 * 
	 * @param pergunta pergunta a ser exibido na caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo.
	 * 
	 * @return o valor <code>YES_OPTION</code> se a resposta for sim, <code>NO_OPTION</code> se for não ou <code>CLOSED_OPTION</code> se a caixa de diálogo 
	 * for fechada sem que o usuário responda a pergunta.
	 * 
	 * @see javax.swing.JOptionPane#YES_OPTION
	 * @see javax.swing.JOptionPane#NO_OPTION
	 * @see javax.swing.JOptionPane#CLOSED_OPTION
	 */
	public static int msgConfirma(String pergunta, String titulo) 
	{
		return showConfirmDialog(null, pergunta, titulo, YES_NO_OPTION, QUESTION_MESSAGE);
	}
	
	/**
	 * Exibe uma mensagem informativa em uma caixa de diálogo.
	 * 
	 * @param componente componente GUI a ser exibido na caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo.
	 * 
	 * @see #msgInfo(String, String)
	 */
	public static void msgInfo(Object componente, String titulo) 
	{
		showMessageDialog(null, componente, titulo, INFORMATION_MESSAGE);
	}
	
	/**
	 * Exibe um texto em uma caixa de diálogo.
	 * 
	 * @param texto conteúdo a ser escrito na área de texto da caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo;
	 * @param numeroLinhas número de linhas da área de texto;
	 * @param numeroColunas número de colunas da área de texto.
	 * 
	 * @throws  IllegalArgumentException exceção disparada se o número de linhas e colunas for negativo.
	 * 
	 * @since 0.2
	 */
	public static void exibirTexto(String texto, String titulo, int numeroLinhas, int numeroColunas) throws IllegalArgumentException 
	{
		// ATENÇÃO: Os componentes GUI JTextArea e JScrollPane serão apresentados no Capítulo 7. Classes e Objetos. 
		
		// Cria uma área de texto vazia com o número de linhas e colunas indicado.
		JTextArea textArea = new JTextArea(numeroLinhas, numeroColunas);
		
		// Define a área de texto como não editável.
		textArea.setEditable(false);
		
		// Define a quebra automática das linha de texto.
		textArea.setLineWrap(true);
		
		// Define que a quebra automática das linha de texto ocorra entre palavras.
		textArea.setWrapStyleWord(true);
		
		// Escreve o texto na área de texto.
		textArea.setText(texto);
		
		// Exibe a área de texto em uma caixa de diálogo usando um painel rolável (JScrollPane).
		msgInfo(new JScrollPane(textArea), titulo);
	}

	
} // class InterfaceGrafica
