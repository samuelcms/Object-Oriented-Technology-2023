package le04.exercicios.ex04;

import static javax.swing.JOptionPane.*;

public class LerDado
{
	/*
	 * Lê uma String através de uma caixa de diálogo GUI. Retorna a String lida, seja ela válida ou não.
	 */
	public static String lerDado(String tituloJanela, String mensagemEntrada, String tipoLido)
	{
		String entrada = showInputDialog(null, mensagemEntrada, tituloJanela, QUESTION_MESSAGE);
		return (entrada != null) ? entrada : "";

	} // lerDado

	/*
	 * Lê um número int através de uma caixa de diálogo GUI. Retorna o número lido, se este for válido, ou 
	 * 0, caso contrário.
	 */
	public static int lerDado(String tituloJanela, String mensagemEntrada, int tipoLido)
	{
		String entrada = showInputDialog(null, mensagemEntrada, tituloJanela, QUESTION_MESSAGE);
		return (entrada != null && !entrada.isBlank()) ? Integer.parseInt(entrada) : 0;
		
	} // lerDado

	/*
	 * Lê um número float através de uma caixa de diálogo GUI. Retorna o número lido, se este for válido, ou 
	 * 0, caso contrário.
	 */
	public static float lerDado(String tituloJanela, String mensagemEntrada, float tipoLido)
	{
		String entrada = showInputDialog(null, mensagemEntrada, tituloJanela, QUESTION_MESSAGE);
		return (entrada != null && !entrada.isBlank()) ? Float.parseFloat(entrada) : 0;
		
	} // lerDado

	/*
	 * Lê um número double através de uma caixa de diálogo GUI. Retorna o número lido, se este for válido, ou 
	 * 0, caso contrário.
	 */
	public static double lerDado(String tituloJanela, String mensagemEntrada, double tipoLido)
	{
		String entrada = showInputDialog(null, mensagemEntrada, tituloJanela, QUESTION_MESSAGE);
		return (entrada != null && !entrada.isBlank()) ? Double.parseDouble(entrada) : 0;
		
	} // lerDado
	
	public static void exibirMensagem(String tituloJanela, String mensagem, int tipoMensagem)
	{
		showMessageDialog(getRootFrame(), mensagem, tituloJanela, tipoMensagem, null);
	}

} // class LerDado
