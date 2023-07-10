package le09.exercicios.ex5;

import java.time.LocalDate;

import static le09.exercicios.ex5.Util.*;

public class Filme 
{
	private String tituloOriginal, tituloBrasil, urlPoster;
	private LocalDate lancamento;
	
	public Filme() 
	{
		tituloBrasil = "";
		tituloOriginal = "";
		urlPoster = "";
	}

	public Filme(String tituloOriginal, String tituloBrasil, String urlPoster, LocalDate lancamento) 
	{
		this.tituloOriginal = tituloOriginal;
		this.tituloBrasil = tituloBrasil;
		this.urlPoster = urlPoster;
		this.lancamento = lancamento;
	}

	public String getTituloOriginal() 
	{
		return tituloOriginal;
	}

	public void setTituloOriginal(String tituloOriginal) 
	{
		this.tituloOriginal = tituloOriginal;
	}

	public String getTituloBrasil() 
	{
		return tituloBrasil;
	}

	public void setTituloBrasil(String tituloBrasil) 
	{
		this.tituloBrasil = tituloBrasil;
	}

	public String getUrlPoster() 
	{
		return urlPoster;
	}

	public void setUrlPoster(String urlPoster) 
	{
		this.urlPoster = urlPoster;
	}

	public LocalDate getLancamento() 
	{
		return lancamento;
	}

	public void setLancamento(LocalDate lancamento) 
	{
		this.lancamento = lancamento;
	}

	@Override
	public String toString() 
	{
		return String.format("%s (%s) - %s", tituloOriginal, tituloBrasil, localDateToString(lancamento));
	}
}
