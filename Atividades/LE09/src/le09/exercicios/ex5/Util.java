package le09.exercicios.ex5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Util 
{
	/**
	 * Define o look-and-feel escolhido pelo usuário em todos os componentes da caixa de diálogo.
	 * 
	 * @param lookAndFeel Objeto que indica qual será o Look-and-feel a ser definido. 
	 * 
	 * @return {@code true} se o look-and-feel foi ativado ou {@code false}, caso contrário.
	 */
	public static boolean definirLookAndFeel(LookAndFeel lookAndFeel) 
	{
		try 
		{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            return true;
        } 
		catch (UnsupportedLookAndFeelException exception) 
		{
            return false;
        }
			
	} // ativarLookAndFeel
	
	public static String localDateToString(LocalDate data)
	{
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public static LocalDate stringToLocalDate(String data)
	{
		return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	
}
