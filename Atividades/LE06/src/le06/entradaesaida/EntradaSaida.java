package le06.entradaesaida;

import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showOptionDialog;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class EntradaSaida {
	private static final short NUMERO_LINHAS = 20, NUMERO_COLUNAS = 50;
	
	private static JTextArea textArea = new JTextArea(NUMERO_LINHAS, NUMERO_COLUNAS);
	private static StringBuilder stringBuilder = new StringBuilder();
	
	public static final String NOVA_LINHA = "\n";
	public static final String LINHA_VAZIA = "\n\n";
	public static final String VIRGULA = ",";
	public static final String ESPACO = " ";
	
	/**
	 * Obtém a área de texto usada pelo método {@link #writeTextArea(String)}.
	 *  
	 * @return a área de texto ({@link JTextArea}).
	 */
	public static JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * Exibe uma mensagem informativa em uma caixa de diálogo com título.
	 * 
	 * @param mensagem texto a ser exibido na caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo.
	 */
	public static void msgInfo(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);		
	}

	/**
	 * Exibe um componente de interface gráfica com o usuário (GUI) em uma caixa de diálogo com título.
	 * 
	 * @param componente componente GUI a ser exibido na caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo.
	 */
	public static void msgInfo(JComponent componente, String titulo) {
		JOptionPane.showMessageDialog(null, componente, titulo, JOptionPane.INFORMATION_MESSAGE);		
	}

	/**
	 * Exibe uma mensagem de erro em uma caixa de diálogo com título.
	 * 
	 * @param mensagem texto a ser exibido na caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo.
	 */
	public static void msgErro(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);		
	}

	/**
	 * Exibe uma mensagem de alerta em uma caixa de diálogo com título.
	 * 
	 * @param mensagem texto a ser exibido na caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo.
	 */
	public static void msgAlerta(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Lê uma string em uma caixa de diálogo com título.
	 * 
	 * @param mensagem texto a ser exibido na caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo.
	 * 
	 * @return a <code>String</code> fornecida pelo usuário ou <code>null</code> quando usuário cancelar a operação,
	 * ou seja, ele clicar no botão Cancelar ou Fechar da caixa de diálogo ou teclar ESC.
	 * 
	 * @see javax.swing.JOptionPane
	 */
	public static String readString(String mensagem, String titulo) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
	}
	
	/**
	 * Lê um número inteiro em uma caixa de diálogo com título.
	 * 
	 * @param mensagem texto a ser exibido na caixa de diálogo.
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo.
	 * 
	 * @return um número fornecido pelo usuário ou <code>null</code> quando usuário cancelar a operação,
	 * ou seja, ele clicar no botão Cancelar ou Fechar da caixa de diálogo ou teclar ESC.
	 */
	public static Integer lerNumeroInteiro(String mensagem, String titulo) {
		String string = readString(mensagem, titulo);
		
		return (string != null) ? Integer.parseInt(string) : null;
	}
	
	/**
	 * Lê um número real em uma caixa de diálogo com título.
	 * 
	 * @param mensagem texto a ser exibido na caixa de diálogo.
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo.
	 * 
	 * @return um número fornecido pelo usuário ou <code>null</code> quando usuário cancelar a operação,
	 * ou seja, ele clicar no botão Cancelar ou Fechar da caixa de diálogo ou teclar ESC.
	 */
	public static Double lerNumeroReal(String mensagem, String titulo) {
		String string = readString(mensagem, titulo);
		
		return (string != null) ? Double.parseDouble(string) : null;
	}
	
	/**
	 * Cria e retorna uma <i>string</i> formatada com os argumentos string que a ela são adicionados. 
	 * Portanto, a formatação é definida pela sequência que esses argumentos são adicionados.
	 * A cada chamada ao método formatar as <i>strings</i> passadas como argumentos são adicionadas
	 * na <code>String</code> formatada, portanto para reiniciar uma nova formatação o usuário deverá,
	 * por exemplo, usar o comando setLength da classe StringBuilder.
	 * 
	 * <pre><b>Exemplo:</b> 
	 * 	formatar("Salário: R$");
	 * 	StringBuilder stringBuilder = formatar(Float.toString(funcionario.getSalario()));
	 * 
	 * 	// Exibirá a saída: "Salário: R$ 1222", considerando que getSalario() retornou 1222.
	 * 	System.out.println(stringBuilder); 
	 * 
	 * 	stringBuilder.setLength(0);
	 * 
	 * 	// Exibirá a saída: "" 
	 * 	System.out.println(stringBuilder);
	 * </pre>
	 * 
	 *  @param string a ser adicionada na <code>String</code> formatada.
	 *  
	 *  @return um <code>StringBuilder</code> com a <i>string</i> formatada.
	 */
	public static StringBuilder formatar(String string) {
		return stringBuilder.append(string);
	}
	
	/**
	 * Cria e retorna uma <i>string</i> formatada usando os argumentos <i>strings</i> para 
	 * adicioná-los a <i>string</i> formatada. Portanto, a formatação é definida pela sequência que esses 
	 * argumentos são adicionados. A cada chamada ao método formatar uma nova <i>string</i> formatada
	 * será criada. 
	 * 
	 * @param strings uma lista ou um vetor do tipo <code>String</code>. 
	 * 
	 * @return um <code>StringBuilder</code> com a <i>string</i> formatada.
	 */
	public static StringBuilder formatar(String... strings) {
		var stringBuilder = new StringBuilder();
		
		/* Solução 1: Adiciona as strings do vetor no StringBuilder usando o loop for tradicional.
		  
				for (int indice = 0; indice < strings.length ; indice++)
					stringBuilder.append(strings[indice]);
					
			Solução 2: Adiciona as strings do vetor no StringBuilder usando o loop for aprimorado.
		*/
		for (var string : strings)
			stringBuilder.append(string);
		
		return stringBuilder;
	}
	
	/**
	 * Cria e retorna uma <i>string</i> formatada usando os argumentos do tipo <i>int</i> para 
	 * adicioná-los a <i>string</i> formatada. Portanto, a formatação é definida pela sequência que esses 
	 * argumentos são adicionados. A cada chamada ao método formatar uma nova <i>string</i> formatada
	 * será criada. 
	 * 
	 * @param numeros uma lista ou um vetor do tipo <code>int</code>.
	 * 
	 * @return um <code>StringBuilder</code> com a <i>string</i> formatada. Essa representação <i>string</i>
	 * consiste em uma lista de números do vetor separados pelos caracteres ", " (uma vírgula seguida de um espaço).
	 */
	public static StringBuilder formatar(int... numeros) {
		// Copia todos os números do vetor de int para o vetor de long e chama o método formatar(long...).
		return formatar(copiar(numeros)); 
	}
	
	/**
	 * Copia todos os números do vetor de int para um vetor de long.
      */
	private static long[] copiar(int[] numeros) {
		long[] numbers = new long[numeros.length];
		
		for (int indice  = 0; indice < numeros.length; indice++)
			numbers[indice] = numeros[indice];
		
		return numbers;
	}

	/**
	 * Cria e retorna uma <i>string</i> formatada usando os argumentos do tipo <i>long</i> para 
	 * adicioná-los a <i>string</i> formatada. Portanto, a formatação é definida pela sequência que esses 
	 * argumentos são adicionados. A cada chamada ao método formatar uma nova <i>string</i> formatada
	 * será criada. 
	 * 
	 * @param numeros uma lista ou um vetor do tipo <code>long</code>.
	 * 
	 * @return um <code>StringBuilder</code> com a <i>string</i> formatada. Essa representação <i>string</i>
	 * consiste em uma lista de números do vetor separados pelos caracteres ", " (uma vírgula seguida de um espaço).
	 */
	public static StringBuilder formatar(long... numeros) {
		var stringBuilder = new StringBuilder();
		
		for (int indice = 0; indice  < numeros.length; indice++) {
			stringBuilder.append(String.format("%,d", numeros[indice]));
			
			// Adicionar a vírgula até o penúltimo número do vetor.
			if (indice != numeros.length - 1) {
				stringBuilder.append(VIRGULA);
				stringBuilder.append(ESPACO);
			}
		}
		return stringBuilder;
	}
	
	/**
	 * Exibe um texto em uma caixa de diálogo.
	 * 
	 * @param texto conteúdo a ser escrito na área de texto da caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo;
	 * @param numeroLinhas número de linhas da área de texto;
	 * @param numeroColunas número de colunas da área de texto.
	 * 
	 * @throws IllegalArgumentException exceção disparada se o número de linhas e colunas for negativo.
	 * 
	 * @since 0.2
	 */
	public static void exibirTexto(String texto, String titulo, int numeroLinhas, int numeroColunas) 
			throws IllegalArgumentException 
	{
		// Cria uma área de texto vazia com o número de linhas e colunas indicado.
		JTextArea textArea = new JTextArea(numeroLinhas, numeroColunas);
		
		// Define a área de texto como não editável.
		textArea.setEditable(false);
		
		// Define a quebra automática das linha de texto.
		textArea.setLineWrap(true);
		
		// Define que a quebra automática das linha de texto ocorra entre palavras.
		textArea.setWrapStyleWord(true);
		
		// Escreve o texto na área de texto. O conteúdo anterior da área de texto será apagado.
		textArea.setText(texto);
		
		// Exibe a área de texto em uma caixa de diálogo usando um painel rolável (JScrollPane).
		msgInfo(new JScrollPane(textArea), titulo);
	} // exibirTexto()
	
	/**
	 * Exibe uma tabela em uma caixa de diálogo com o conteúdo dos arrays arrays <code>linhas</code> e <code>colunas</code>.
	 * 
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo;
	 * @param linhas conteúdo a ser exibido nas linhas da tabela;
	 * @param nomeColunas nomes das colunas da tabela;
	 * @param larguraColuna define o valor da largura de cada coluna da tabela. Se <code>larguraColuna</code> for <code>null</code> a largura das colunas 
	 *                 será calculada dividindo o valor <code>larguraTabela</code> pelo número de colunas da matriz <code>linhas</code>;
	 * @param alinhamentoColuna define o tipo de alinhamento de cada coluna da tabela. Se <code>alinhamentoColuna</code> for <code>null</code> o 
	 *                  alinhamento à esquerda (<code>SwingConstants.LEFT</code>) será utilizado em todas as colunas da tabela. Os valores válidos para alinhamento, 
	 *                  definidos na interface <code>SwingConstants</code>, são: <code>LEFT</code>, <code>CENTER</code>, <code>RIGHT</code>, 
	 *                  <code>LEADING</code> ou <code>TRAILING</code>;
	 * @param larguraTabela valor em <i>pixels</i> correspondente a largura da área de exibição da tabela;
	 * @param alturaTabela valor em <i>pixels</i> correspondente a altura da área de exibição da tabela.
	 * 
	 * @see javax.swing.SwingConstants
	 */
	public static void exibirTabela(String titulo, Object[][] linhas, String[] nomeColunas, int[] larguraColuna, 
			                                                 int[] alinhamentoColuna, int larguraTabela, int alturaTabela) {
		 	// Cria o componente GUI Swing JTable para exibir a tabela.
		 	JTable table = new JTable(linhas, nomeColunas);
		 	
		 	// Define o tamanho (largura e altura, em pixels, respectivamente) da área de visualização (viewport) da tabela.
		 	table.setPreferredScrollableViewportSize(new Dimension(larguraTabela, alturaTabela));

	 		for (int coluna = 0; coluna < nomeColunas.length; coluna++) {
	 				// Define a largura das colunas da tabela.
		 			table.getColumnModel().getColumn(coluna).setPreferredWidth(
		 					larguraColuna != null ? larguraColuna[coluna] : larguraTabela / nomeColunas.length);

		 		    // Cria um objeto para renderizar (exibir) as células de uma coluna da tabela. 
		 			DefaultTableCellRenderer colunaTableCellRenderer = new DefaultTableCellRenderer();
		 			
		 			// Define o alinhamento das colunas da tabela.
		 			colunaTableCellRenderer.setHorizontalAlignment(
		 					alinhamentoColuna != null ? alinhamentoColuna[coluna] : SwingConstants.LEFT);
		 			
		 			table.getColumnModel().getColumn(coluna).setCellRenderer(colunaTableCellRenderer);
		 	 }

		 	 // Exibe a tabela em uma caixa de diálogo usando um painel rolável (JScrollPane).
		 	msgInfo(new JScrollPane(table), titulo);
	} // exibirTabela()
	
	/**
	 * Exibe um <i>menu</i> em uma caixa de diálogo com botões de comando para cada opção armazenada em <code>opcoes</code>.
	 * 
	 * @param mensagem texto a ser exibido na caixa de diálogo;
	 * @param titulo texto a ser exibido na barra de título da caixa de diálogo;
	 * @param opcoes nomes das opções de comando a serem exibidos nos botões do <i>menu</i>;
	 * @param opcaoInicial nome da opção de comando do <i>menu</i> que será usado como <i>default</i>, ou seja,
	 *                  define qual botão que receberá o foco quando a barra de espaço for teclada.
	 * 
	 * @return a posição do vetor <code>opcoes</code> correspondente a escolha de comando do usuário ou <code>CLOSED_OPTION</code> se a caixa de diálogo for fechada.
	 */
	public static int menu(String mensagem, String titulo, String[] opcoes, String opcaoInicial) {
		return showOptionDialog(null, mensagem, titulo, DEFAULT_OPTION, QUESTION_MESSAGE, null, opcoes, opcaoInicial);		
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
	public static int msgConfirma(String pergunta, String titulo) {
		return showConfirmDialog(null, pergunta, titulo, YES_NO_OPTION, QUESTION_MESSAGE);
	}
	
	/**
	 * Escreve a mensagem na área de texto. Toda vez que este método for chamado a mensagem especificada será 
	 * acrescentada na área de texto. Portanto, quando o usuário quiser reiniciar a área de texto, ou seja, quiser limpar
	 * o conteúdo atual desse componente GUI ele deve passar o parâmetro <code>null</code> ou usar o método 
	 * {@link JTextArea#setText(String)} para apagar o conteúdo atual da área de texto retornada pelo método 
	 * <code>writeTextArea</code>.
	 * 
	 * @param texto texto a ser escrito na área de texto.
	 * 
	 * @return a área de texto ({@link JTextArea}). 
	 */
	public static JTextArea writeTextArea(String texto) {
		if (texto != null)
			textArea.append(texto); // Acrescentar o texto na área de texto.
		else
			textArea.setText("");  // Apaga o conteúdo atual da área de texto.
		
		return textArea;
	}
	
	/**
	 * Escreve a mensagem na área de texto. Toda vez que este método for chamado a mensagem especificada será 
	 * acrescentada na área de texto. Portanto, quando o usuário quiser reiniciar a área de texto, ou seja, quiser limpar
	 * o conteúdo atual desse componente GUI ele deve passar o parâmetro <code>null</code> ou usar o método 
	 * {@link JTextArea#setText(String)} para apagar o conteúdo atual da área de texto retornada pelo método 
	 * <code>writeTextArea</code>.
	 * 
	 * @param texto texto a ser escrito na área de texto.
	 * 
	 * @return a área de texto ({@link JTextArea}). 
	 */
	public static JTextArea writeTextArea(Object texto) 
	{
		return writeTextArea(texto.toString());
	}
	
} // class EntradaSaida