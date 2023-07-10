package le13.exercicios.ex04;

import java.io.File;

public class CalcularTamanhoDiretorio implements Runnable
{
	public static int CLUSTER = 4096;
	
	private Tamanho areaCompartilhada;
	private File diretorio;
	
	public CalcularTamanhoDiretorio(Tamanho tamanho, File diretorio) 
	{
		this.areaCompartilhada = tamanho;
		this.diretorio = diretorio;
	}
	
	private long calcularTamanho(File caminho) throws InterruptedException
	{		
		long tamanhoTotal = 0;
		
		if(caminho.isFile())
		{
			return areaCompartilhada.obterTamanho(caminho.getAbsolutePath());
		}
		
		else if(caminho.isDirectory())
		{
			File arquivos[] = caminho.listFiles();
			if(arquivos != null)
			{
				for(File arquivo : arquivos)
					tamanhoTotal += calcularTamanho(arquivo);
			}
		}
		
		return tamanhoTotal;		
	}

	@Override
	public void run() 
	{
		try 
		{
			long tamanhoReal = calcularTamanho(diretorio);
			long tamanhoEmDisco = calcularTamanhoDisco(tamanhoReal);
			
			System.out.println(String.format("TR: %,d", tamanhoReal));
			System.out.println(String.format("TD: %,d", tamanhoEmDisco));
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}

	private long calcularTamanhoDisco(long tamanhoReal) 
	{
		return Math.round(Math.ceil(((double)tamanhoReal / (double)CLUSTER))) * CLUSTER;
	}
}
