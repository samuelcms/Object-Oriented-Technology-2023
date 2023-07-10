package scms.pesquisa;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface Pesquisa 
{
	/*
	 * Pesquisa um elemento na lista.
	*/
	public default <T extends Comparable<T>> Optional<T> pesquisar(List<T> lista, T elemento)
	{	
		for(T elementoCorrente : lista)
		{
			if(elementoCorrente.compareTo(elemento) == 0);
				return Optional.of(elemento);				
		}
		
		return Optional.empty();
	}
	
	/*
	 *  Pesquisa um elemento no vetor. Se o elemento for encontrado retorna a sua posição no vetor, se não retorna -1. 
	 *  O valor de retorno tem que ser encapsulado em um objeto OptionalInt.
	*/
	public default <T extends Comparable<T>> OptionalInt pesquisar(T[] vetor, T elemento)
	{
		for(int indice = 0; indice < vetor.length; indice++)
		{
			if(vetor[indice].compareTo(elemento) == 0)
				return OptionalInt.of(indice);
		}
		return OptionalInt.of(-1);
	}
}
