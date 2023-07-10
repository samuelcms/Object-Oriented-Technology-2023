package scms.multithreading;

import java.io.File;

public class CalcularTamanhoDiretorio implements Runnable
{
	private int TAMANHO_CLUSTER = 4096;
	
	private Tamanho areaCompartilhada;
	private File diretorio;
	private int diretorios = 0, arquivos = 0;
		
	public CalcularTamanhoDiretorio(Tamanho areaCompartilhada, File diretorio) 
	{
		this.areaCompartilhada = areaCompartilhada;
		this.diretorio = diretorio;
	}
	
	private long calcularTamanhoDiretorio (File caminho) throws InterruptedException 
	{
		long tamanhoTotal = 0;
		
		if(caminho.isFile())
		{
			long tamanho = areaCompartilhada.obterTamanho(caminho.getAbsolutePath());
			tamanhoTotal += tamanho;
			arquivos++;
		}
		else if(caminho.isDirectory())
		{
			File listaArquivos[] = caminho.listFiles();
			if(listaArquivos != null)
			{
				for(File arquivo : listaArquivos)
					tamanhoTotal += calcularTamanhoDiretorio(arquivo);
			}
			diretorios++;
		}
		return tamanhoTotal;
	}

	@Override
	public void run()
	{
		try 
		{
			long tamanhoDiretorio = calcularTamanhoDiretorio(diretorio);
			long tamanhoEmDisco = calcularTamanhoEmDisco(tamanhoDiretorio);
			
			System.out.println(String.format("Tamanho real: %,d bytes", tamanhoDiretorio));
			System.out.println(String.format("Tamanho em Disco: %,d bytes", tamanhoEmDisco));
			System.out.println(String.format("Arquivos: %,d", arquivos));
			System.out.println(String.format("Subdiretórios: %,d", diretorios - 1));
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	private long calcularTamanhoEmDisco(long tamanhoDiretorio) 
	{
		Double divisao = (double)tamanhoDiretorio /(double) TAMANHO_CLUSTER;
		return Double.valueOf(Math.ceil(divisao) * 4096).longValue();
	}
}
