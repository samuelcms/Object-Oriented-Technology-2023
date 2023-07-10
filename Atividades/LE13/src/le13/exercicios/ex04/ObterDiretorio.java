package le13.exercicios.ex04;

import java.io.File;

public class ObterDiretorio implements Runnable
{
	private Tamanho areaCompartilhada;
	private File diretorio;
	
	public ObterDiretorio(Tamanho areaCompartilhada, File diretorio) 
	{
		this.areaCompartilhada = areaCompartilhada;
		this.diretorio = diretorio;
	}
	
	private void calcularTamanho(File caminho)
	{		
		if(caminho.isFile())
		{
			try 
			{
				areaCompartilhada.escreverTamanho(caminho.getAbsolutePath(), caminho.length());
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		else if(caminho.isDirectory())
		{
			File arquivos[] = caminho.listFiles();
			if(arquivos != null)
			{
				for(File arquivo : arquivos)
					calcularTamanho(arquivo);
			}
		}
	}

	@Override
	public void run() 
	{
		calcularTamanho(diretorio);
	}
}
