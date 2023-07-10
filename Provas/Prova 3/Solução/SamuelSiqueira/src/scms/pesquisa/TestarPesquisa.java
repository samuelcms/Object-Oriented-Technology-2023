package scms.pesquisa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestarPesquisa implements Pesquisa
{
	public TestarPesquisa() 
	{
		List<String> nomes = new ArrayList<>();
		List<Integer> numerosInteiros = new ArrayList<>();
		List<Object> listas = new ArrayList<>();
		
		//Float numerosDecimais[] = {11.06F, 1.02F, 7.12F, 29.04F};
		//String palavras[] = {"Hoje", "tivemos", "a", "terceira", "prova"};
				
		listas.add(numerosInteiros);
		listas.add(nomes);
				
		nomes.add("Maria");
		nomes.add("Marcela");
		nomes.add("Mirian");
		nomes.add("Miguel");
		nomes.add("Marcos");
		
		numerosInteiros.add(12);
		numerosInteiros.add(7);
		numerosInteiros.add(4);
		numerosInteiros.add(6);	
	}

	public <T extends Comparable<T>> Optional<T> testarPesquisa(T elemento, T... conjuntoValores)
	{
		return pesquisar(Arrays.asList(conjuntoValores), elemento);
	}
}
