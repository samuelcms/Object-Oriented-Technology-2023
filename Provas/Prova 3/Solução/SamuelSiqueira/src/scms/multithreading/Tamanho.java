package scms.multithreading;

import java.util.HashMap;
import java.util.Map;

public class Tamanho 
{
	private Map<String, Long> informacaoDiretorio = new HashMap<>();
	
	public synchronized void escreverTamanho(String caminho, long tamanho)
	{				
		informacaoDiretorio.put(caminho, tamanho);
		notify();
	}
	
	public  synchronized long obterTamanho(String caminho) throws InterruptedException
	{
		if(!informacaoDiretorio.containsKey(caminho))
			wait();
		
		return informacaoDiretorio.get(caminho);	
	}
}
