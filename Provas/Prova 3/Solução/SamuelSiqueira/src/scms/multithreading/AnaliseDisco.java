package scms.multithreading;

import java.io.File;

public class AnaliseDisco
{
	public static void main(String[] args) 
	{
		Tamanho areaCompartilhada = new Tamanho();
		File diretorio = new File ("C:\\Users\\Aluno\\Documents\\Prova 3");
		
		Thread consumidor = new Thread(new CalcularTamanhoDiretorio(areaCompartilhada, diretorio)),
					  produtor = new Thread(new ObterDiretorio(areaCompartilhada, diretorio));
		
		consumidor.start();
		produtor.start();
		
	}
}
