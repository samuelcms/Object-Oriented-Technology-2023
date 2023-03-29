package util;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class InterfaceGrafica
{
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
	
} // class InterfaceGrafica
