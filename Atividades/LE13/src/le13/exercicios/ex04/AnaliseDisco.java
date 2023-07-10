package le13.exercicios.ex04;

import java.io.File;
import java.time.LocalTime;

public class AnaliseDisco 
{
	public static void main(String[] args) 
	{
		String caminho = "C:\\TSI\\2023 - 01\\TOO\\Atividades\\LE13\\files\\arquivos";
		File diretorio = new File(caminho);
		
		Tamanho areaCompartilhada = new Tamanho();
		
		LocalTime inicio, termino;
		
		
		// Obtém o nome e o tamanho dos arquivos e insere no objeto monitor Tamanho.
		Thread produtor = new Thread(new ObterDiretorio(areaCompartilhada, diretorio));
		
		// Recupera do objeto monitor o tamanho de cada arquivo usando o seu nome e totaliza o tamanho real.
		Thread consumidor = new Thread(new CalcularTamanhoDiretorio(areaCompartilhada, diretorio));
				
		try 
		{
			inicio = LocalTime.now();
			
			produtor.start();
			consumidor.start();
						
			termino = LocalTime.now();
			
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}				
	}
}
