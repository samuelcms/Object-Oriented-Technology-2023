package le09.exercicios.ex5;

import static le09.exercicios.ex5.Util.definirLookAndFeel;
import static le09.exercicios.ex5.Util.stringToLocalDate;
import static mos.reader.Reader.SEMICOLON;
import static mos.reader.Reader.read;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import mos.reader.Line;

public class MCU 
{
	public static final String URL_ICONES = "C:/TSI/2023 - 01/TOO/Atividades/LE09/files/mcu-poster/",
			
							   OPCOES[] = {"Ant-Man", "Avengers", "Captain America", "Guardians of the Galaxy", "Iron Man", "Spider-Man", "Thor", 
			                               "Lançados em maio", "Lançados em anos pares", "Lançados em anos ímpares", "Próximos lançamentos", "Todos"};
	
	// Lista de filmes.
	private static List<Filme> filmes = new ArrayList<>();
	
	public boolean importarDados()
	{
		List<Line> linhasArquivo = read("C:\\TSI\\2023 - 01\\TOO\\Atividades\\LE09\\files\\mcu.csv", SEMICOLON);
		
		linhasArquivo.remove(0);
		
		for(Line line : linhasArquivo)
		{
			String atributos[] = line.getLine();
			filmes.add(new Filme(atributos[1], atributos[2], atributos[4], stringToLocalDate(atributos[3])));			
		}
		
		return false;
	}
	
	public static void main(String[] args) 
	{
		new MCU().importarDados();
				
		definirLookAndFeel(new NimbusLookAndFeel());
		new MCU_GUI();	
	}
		
	public static List<Filme> obterFilmes(String chave, int indice) 
	{
		switch (indice)
		{
			case 0, 1, 2, 3, 4, 5, 6: return selecionarFilmeNome(chave, indice); 
			
			case 7: return selecionarFilmeMes(chave, indice); 
			
			case 8,9,10: return selecionarFilmeAno(chave, indice); 
			
			case 11: return new ArrayList<>(filmes); 
		}
		
		return null;
	}
	
	private static List<Filme> selecionarFilmeNome(String chave, int indice) 
	{
		String expressao = String.format(".*\\b%s\\b.*", chave);
		return selecionarFilme(expressao);
	}

	private static List<Filme> selecionarFilmeMes(String chave, int indice) 
	{
		String expressao = ".*\\b\\d{2}/05/\\d{4}\\b.*";
		return selecionarFilme(expressao);
	}
	
	private static List<Filme> selecionarFilmeAno(String chave, int indice) 
	{
		String expressao = "";
		
		switch (indice) 
		{
			case 8: expressao = ".*\\b(0[1-9]|[12]\\d|3[01])/(0[2468]|1[048])/(\\d{4})\\b.*"; break;
			case 9: expressao = ".*\\b\\d{2}/\\d{2}/(\\d*[13579])\\d{3}\\b.*"; break;
			case 10: expressao = "\\b\\d{2}/05/(20[3-9]\\d|2[3-9]\\d{2}|[3-9]\\d{3}|\\d{5,})\\b";  break;
		}
		
		return selecionarFilme(expressao);
	}

	private static List<Filme> selecionarFilme(String expressao)
	{
		List<Filme> selecao = new ArrayList<>();
		Pattern pattern = Pattern.compile(expressao);
						
		for(Filme filme : filmes)
		{				
			Matcher matcher = pattern.matcher(filme.toString());
			if(matcher.matches())
				selecao.add(filme);
		}
		
		return selecao;
	}
	
	public static Filme pesquisarFilme(String titulo)
	{
		for(Filme filme : filmes)
			if(filme.getTituloOriginal().equals(titulo) || filme.getTituloBrasil().equals(titulo))
				return filme;
		
		return null;
	}
}
