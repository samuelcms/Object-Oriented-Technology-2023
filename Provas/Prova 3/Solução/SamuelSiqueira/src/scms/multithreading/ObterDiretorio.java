package scms.multithreading;

import java.io.File;

public class ObterDiretorio  implements Runnable
{
	private Tamanho areaCompartilhada;
	private File diretorio;
	
	public ObterDiretorio(Tamanho areaCompartilhada, File diretorio) 
	{
		this.areaCompartilhada = areaCompartilhada;
		this.diretorio = diretorio;
	}
	
	private void obterDiretorio(File diretorio)
	{		
		if(diretorio.isFile())
		{
			areaCompartilhada.escreverTamanho(diretorio.getAbsolutePath(), diretorio.length());
		}
				
		else if(diretorio.isDirectory())
		{
			File listaArquivos[] = diretorio.listFiles();
			if(listaArquivos != null)
			{
				for(File arquivo : listaArquivos)
					obterDiretorio(arquivo);
			}			
		}	
	}

	@Override
	public void run() 
	{
		obterDiretorio(diretorio);
	}
}
