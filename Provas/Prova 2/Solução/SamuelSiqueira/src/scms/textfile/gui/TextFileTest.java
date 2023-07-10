package scms.textfile.gui;

import java.util.ArrayList;
import java.util.List;

import scms.textfile.classes.Disciplina;
import scms.textfile.classes.Filme;
import scms.textfile.classes.Item;
import scms.textfile.dao.TextFileDAO;

public class TextFileTest 
{
	public static final String CABECALHO = "-----------------------------------------------------------------------------------\nArquivo: disciplinas_filmes.txt\nConteúdo: Disciplina (nome - nota) e Filme (nome - duração m)\n------------------------------------------------------------------------------------";
	
	private List<Item> listaObjetos;
		
	public TextFileTest()  
	{		
		listaObjetos = new ArrayList<>();
		
		listaObjetos.add(new Disciplina("Geografia", 9.5f));
		listaObjetos.add(new Disciplina("Sociologia", 9f));
		listaObjetos.add(new Disciplina("Filosofia", 10f));		
		listaObjetos.add(new Filme("Need for Speed", 160));	
		listaObjetos.add(new Filme("Titanic", 320));	
		listaObjetos.add(new Filme("After", 120));		
				
		// Ordenando a lista de objetos.
		listaObjetos.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
		
		// Escrevendo no arquivo.
		
		try(TextFileDAO arquivo = new Item()) 
		{
			arquivo.open("disciplinas_filmes.txt");
			arquivo.insert(CABECALHO);
			
			for(Item item : listaObjetos)
			{
				arquivo.insert(item);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Erro ao abrir o arquivo.");
		}		
	}

	public static void main(String[] args) 
	{
		new TextFileTest();
	}
}
