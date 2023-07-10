package le12.exercicios.ex04;

public class NumeroSorteado 
{
	private int numero, ocorrencias;

	public NumeroSorteado() 
	{
		numero = 0;
		ocorrencias = 0;
	}

	public NumeroSorteado(int numero, int ocorrencias) 
	{
		this.numero = numero;
		this.ocorrencias = ocorrencias;
	}

	public int getNumero() 
	{
		return numero;
	}

	public void setNumero(int numero) 
	{
		this.numero = numero;
	}

	public int getOcorrencias() 
	{
		return ocorrencias;
	}

	public void setOcorrencias(int ocorrencias) 
	{
		this.ocorrencias = ocorrencias;
	}

	@Override
	public String toString() 
	{
		return String.format("%02d: %d occurrences", numero, ocorrencias);
	}
	
	public void incrementarOcorrencias()
	{
		ocorrencias++;
	}
}
