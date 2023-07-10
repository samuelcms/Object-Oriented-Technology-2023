package le13.exercicios.ex04;

import java.util.HashMap;
import java.util.Map;

public class Tamanho 
{
	private Map<String, Long> arquivos = new HashMap<>();
	
	public synchronized void escreverTamanho(String nomeArquivo, long tamanhoArquivo) throws InterruptedException
	{
		arquivos.put(nomeArquivo, tamanhoArquivo);
		notify();
	}
	
	public synchronized long obterTamanho(String nomeArquivo) throws InterruptedException
	{
		while(!arquivos.containsKey(nomeArquivo))
		{
			wait();
		}
		return arquivos.get(nomeArquivo);
	}
}
