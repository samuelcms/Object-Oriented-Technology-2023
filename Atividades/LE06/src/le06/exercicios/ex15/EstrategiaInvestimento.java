package le06.exercicios.ex15;

public enum EstrategiaInvestimento 
{
	INFLACAO("Inflação"),
	PREFIXADO("Prefixado"),
	POS_FIXADO("Pós-fixado"),
	RENDA_VARIAVEL("Renda Variável"),
	INTERNACIONAL("Internacional"),
	MULTIMERCADO("Multimercado"),
	ALTERNATIVO("Alternativo");
	
	private String nomeEstrategia;
	
	EstrategiaInvestimento(String nomeEstrategia) 
	{
		this.nomeEstrategia = nomeEstrategia;
	}

	public String getNomeEstrategia()
	{
		return nomeEstrategia;
	}

	public void setNomeEstrategia(String nomeEstrategia) 
	{
		this.nomeEstrategia = nomeEstrategia;
	}

	@Override
	public String toString() 
	{
		return nomeEstrategia;
	}	
}
