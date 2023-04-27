package le04.exercicios.ex03;

import static javax.swing.JOptionPane.*;

public class LerString 
{
	public static void main(String[] args) 
	{
		iniciar();
	}

	public static void iniciar() 
	{
		System.out.println(lerString("String", "String", "Erro", false));		
	}

	/**
	 * Lê uma <i>string</i> em uma caixa de diálogo.
	 *
	 * @param mensagem texto a ser exibido na caixa de diálogo;
	 * @param titulo texto da barra de título da caixa de diálogo;
	 * @param msgErro mensagem de erro a ser exibida caso o usuário não digite nenhum valor e o 
	 * 		  parâmetro <code>vazia</code> seja <code>false</code>;
	 * @param vazia se <code>true</code> o método aceitará uma string vazia, se <code>false</code>, não.
	 * 
	 * @return a string lida. Se o usuário cancelar a operação de leitura retorna <code>null</code>. 
	 * 		   Se o usuário não fornecer nenhum valor de entrada e vazia for <code>true</code> será 
	 * 		   retornado uma <i>string</i> vazia.
	 */
	public static String lerString(String mensagem, String titulo, String msgErro, boolean vazia)
	{
		String entrada;
		
		if(vazia == false)
		{			
			do
			{
				entrada = showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE);
				
				if(entrada != null)
				{
					if(!entrada.isBlank()) break;
					else exibirMensagem("Erro", msgErro, ERROR_MESSAGE);
				}					
			}
			while(entrada != null);
		}
		
		else entrada = showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE);
		return entrada;

	} // lerString
	
	public static String lerString(String tituloJanela, String mensagem) 
	{
		return showInputDialog(null, mensagem, tituloJanela, QUESTION_MESSAGE);
	}
	
	public static void exibirMensagem(String tituloJanela, String mensagem, int tipoMensagem)
	{
		showMessageDialog(getRootFrame(), mensagem, tituloJanela, tipoMensagem, null);
	}
	
} // class LerString
