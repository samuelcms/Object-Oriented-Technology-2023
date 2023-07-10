package le12.exercicios.ex04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MegaSena 
{
	private String concurso, data;
	private List<Integer> dezenas = new ArrayList<>();
	
	public MegaSena() 
	{
		concurso = "";
		data = "";
	}

	public MegaSena(String concurso, String data) 
	{
		this.concurso = concurso;
		this.data = data;
	}

	public String getConcurso() 
	{
		return concurso;
	}

	public void setConcurso(String concurso) 
	{
		this.concurso = concurso;
	}

	public String getData() 
	{
		return data;
	}

	public void setData(String data) 
	{
		this.data = data;
	}
	
	public void adicionarDezena(int dezena)
	{
		dezenas.add(dezena);
	}
	
	public Integer[] obterDezenas()
	{
		return dezenas.toArray(new Integer[0]);
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s, %s, %s", concurso, data, Arrays.toString(obterDezenas()));
	}
}
