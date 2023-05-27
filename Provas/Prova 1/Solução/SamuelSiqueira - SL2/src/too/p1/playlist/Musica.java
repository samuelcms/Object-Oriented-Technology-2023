package too.p1.playlist;

public class Musica 
{
	private String album, titulo, autor, genero;
	private short tempoEmSegundos, numeroMusica;
	
	public Musica() 
	{
		album = "";
		titulo = "";
	}
	
	public Musica(String titulo, short tempoEmSegundos) 
	{
		this();
		this.titulo = titulo;
		this.tempoEmSegundos = tempoEmSegundos;
	}

	public Musica(String autor, String album, String titulo, String genero, short tempoEmSegundos, short numeroMusica) 
	{
		this(titulo, tempoEmSegundos);
		
		this.autor = autor;
		this.album = album;
		this.genero = genero;
		this.numeroMusica = numeroMusica;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public short getTempoEmSegundos() {
		return tempoEmSegundos;
	}

	public void setTempoEmSegundos(short tempoEmSegundos) {
		this.tempoEmSegundos = tempoEmSegundos;
	}

	public short getNumeroMusica() {
		return numeroMusica;
	}

	public void setNumeroMusica(short numeroMusica) {
		this.numeroMusica = numeroMusica;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() 
	{
		return String.format("%ds - %s", tempoEmSegundos, titulo);
	}
	
}
