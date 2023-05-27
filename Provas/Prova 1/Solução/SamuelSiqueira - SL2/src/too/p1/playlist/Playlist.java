package too.p1.playlist;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import mos.readercsv.Line;

import static mos.readercsv.ReaderCSV.*;
import static mos.es.EntradaSaida.*;
import static javax.swing.SwingConstants.*;

public class Playlist 
{	
	private static final String OPCOES_MENU[] = {"Importar Playlist", "Exibir Playlist", "Exibir Playlist Ordenada", "Sair"}, 
								COLUNAS_TABELA[] = {"Álbum", "Nº", "Título", "Tempo (s)" }, TAB_1 = "   ", TAB_2 = "       "; 
	
	private static final int  IMPORTAR_PLAYLIST = 0, EXIBIR_PLAYLIST = 1, EXIBIR_PLAYLIST_ORDENADA = 2, SAIR = 3 ,
							  AUTOR = 0, TITULO = 1, ALBUM = 2, NUMERO = 3, GENERO = 4, TEMPO = 5;	
	
	private String nomeArquivo;
	private List<Musica> musicas;
		
	public static void main(String[] args) 
	{
		new Playlist("files/Playlist.csv");
		System.exit(0);
	}
		
	public Playlist(String nomeArquivo) 
	{
		this.nomeArquivo = nomeArquivo;
		musicas = new ArrayList<Musica>();
		
		int opcao;
		
		do
		{
			opcao = menu("Escolha uma opção: ", "Gerenciar Playlist", OPCOES_MENU, null);
			
			switch (opcao) 
			{
				case IMPORTAR_PLAYLIST: importarMusicas(); break;
				case EXIBIR_PLAYLIST:  exibirPlaylist(); break;
				case EXIBIR_PLAYLIST_ORDENADA: exibirPlaylistClassificada(); break;
					
				default: break;
			}

		}while(opcao != SAIR && opcao != JOptionPane.CLOSED_OPTION);
	}
		
	public void importarMusicas()
	{
		List<Line> linhasArquivo = toImport(nomeArquivo);
		
		for(Line linha : linhasArquivo)
		{
			String dados[] = linha.getLine();
			insert(new Musica(dados[AUTOR], dados[ALBUM], dados[TITULO], dados[GENERO], Short.parseShort(dados[TEMPO]), Short.parseShort(dados[NUMERO])));
		}
		
		msgInfo(String.format("Playlist do arquivo \"%s\" importada.", nomeArquivo.split("/")[1]), "Exibir Playlist");
	}
	
	public void exibirPlaylist()
	{		
		if(!musicas.isEmpty())
		{
			int larguraCampos[] = {120, 5, 200,10}, alinhamentoCampos[] = {LEADING, CENTER, LEADING, CENTER};
			
			exibirTabela("Playlist Legião Urbana", toArray(), COLUNAS_TABELA, larguraCampos, alinhamentoCampos, 600, 300);
		}
		else msgAlerta("Base de dados vazia!", "Exibir Playlist");
	}
	
	public void exibirPlaylistClassificada()
	{
		if(!musicas.isEmpty())
		{
			StringBuilder relatorio = new StringBuilder();
			
			relatorio.append(NOVA_LINHA);
			relatorio.append(TAB_1 + "Playlist classificada pelo tempo da música\n");
			relatorio.append(String.format(TAB_1 +  "Número de músicas = %02d\n", size()));
			relatorio.append(String.format(TAB_1 + "Tempo total = %,d segundos ou %.2f minutos\n\n\n", totalTime(), totalTimeMinutos()));
			
			for(String musica : toList())
				relatorio.append(TAB_2 + musica + "\n\n");
			
			writeTextArea(relatorio.toString());
			msgInfo(new JScrollPane(getTextArea()), "Playlist Ordenada");
		}
		else msgAlerta("Base de dados vazia!", "Exibir Playlist Ordenada");		
	}
	
	/**
		Importa as músicas armazenadas no arquivo CSV.
		@param fileName nome do arquivo CSV que possui as músicas da playlist.
		@return uma lista com as linhas de dados do arquivo CSV ou null se ocorrer um erro de leitura.
	*/
	public List<Line> toImport(String fileName)
	{
		return read(fileName, SEMICOLON);		
	}
	
	/**
		Insere uma música na playlist.
	*/
	public Playlist insert(Musica musica)
	{
		musicas.add(musica);
		return this;
	}
	
	/**
		Obtém uma lista com todas as músicas da playlist ordenadas ascendentemente pelo
		tempo da música em segundos. Cada string da lista possui o formato abaixo. <tempo s> - <titulo>
		Exemplo: 547 s - Faroeste Cabloco
	*/
	public List<String> toList()
	{
		if(!musicas.isEmpty())
		{
			List<String> musicasOrdenadas = new ArrayList<String>();
			
			for(Musica musica : musicas)
				musicasOrdenadas.add(musica.toString());
			
			musicasOrdenadas.sort(((musica1, musica2) -> musica1.compareTo(musica2)));
			return musicasOrdenadas;
		}
		return null;
	}
		
	private float totalTimeMinutos()
	{
		return (float)totalTime() / 60;
	}	
	
	/**
		Calcula o tempo total em segundos de todas as músicas da playlist.
	*/
	public int totalTime()
	{
		int somatorio = 0;
		
		if(!musicas.isEmpty())
		{
			for(Musica musica : musicas)
				somatorio += musica.getTempoEmSegundos();
		}
		
		return somatorio;
	}
	
	/**
		Obtém uma matriz com todas as músicas da playlist. Os dados a serem armazenados nessa matriz são o nome do álbum, o número da música no álbum, o título e o tempo da música em segundos.
	*/
	public Object[][] toArray()
	{
		int indice = 0;
		
		if(!musicas.isEmpty())
		{
			Object arrayMusicas[][] = new Object[musicas.size()][];
			
			for(Musica musica : musicas)
			{
				arrayMusicas[indice] = new Object[] {musica.getAlbum(), String.format("%02d", musica.getNumeroMusica()), musica.getTitulo(), musica.getTempoEmSegundos()};
				indice++;
			}
			return arrayMusicas;
		}	
		return null;
	}
	
	/**
	* Obtém o tamanho (número de músicas) da playlist.
	*/
	public int size()
	{
		return musicas.size();
	}
}