package le06.exercicios.ex15;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import too.textfile.TextFile;

public class ImportacaoArquivo
{
	private static final String SEPARADOR_LINHA = "\n", SEPARADOR_CAMPO = ";";
	
	/* 
	 * Retorna uma String com o conteúdo do arquivo ou null, caso não tenha sido possível acessá-lo.
	 */
	public static String obterConteudoArquivo(String nomeArquivo)
	{
		TextFile arquivo = new TextFile();
		String conteudoArquivo = null;
		
		if(arquivo.open("files/" + nomeArquivo))
			conteudoArquivo = arquivo.read();
		
		arquivo.close();
		return conteudoArquivo;
	}
	
	/*
	 * Retorna uma lista com as linhas do arquivo ou null, caso não tenha sido possível acessá-lo.
	 * 
	 * Importante: A primeira linha do arquivo possui a descrição dos dados, portanto, é descartada.
	 * 			   Logo, apenas as informações sobre os investimentos são retornadas.
	 */
	public static List<String> linhasArquivo(String nomeArquivo)
	{		
		String conteudoArquivo = obterConteudoArquivo(nomeArquivo);
				
		if(conteudoArquivo != null)
		{
			List<String> lista = new ArrayList<>(Arrays.asList(conteudoArquivo.split(SEPARADOR_LINHA)));
			lista.remove(0);

			return lista;			
		}
		
		return null;
	}
	
	public static String[] dadosInvestimento(String linha)
	{
		return linha.split(SEPARADOR_CAMPO);
	}	
	
	// Transforma uma data no fomato dd/mm/aaaa em um objeto da classe LocalDate. 
	public static LocalDate converterData(String data)
	{
		return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	// Converte a representação String da taxa (10.0%)  em float (10.0).
	public static float formatarTaxa(String taxa)
	{
		return Float.parseFloat(taxa.replace("%", ""));
	}
}