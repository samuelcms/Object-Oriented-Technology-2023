package le06.exercicios.ex15;

public enum Imposto 
{
	AL1(22.5f, 0, "Até 180 dias"),
	AL2(20.0f, 181, "De 181 a 360 dias"),
	AL3(17.5f, 361, "De 361 a 720 dias"),
	AL4(15.0f, 721, "Acima de 720 dias");
		
	private float taxa;
	private int minimoDias;
	private String descricao;
	
	private Imposto(float taxa, int minimoDias, String descricao) 
	{
		this.taxa = taxa;
		this.minimoDias = minimoDias;
		this.descricao = descricao;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

	public int getMinimoDias() {
		return minimoDias;
	}

	public void setMinimoDias(int minimoDias) {
		this.minimoDias = minimoDias;
	}
		
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static float obterAliquota(int diasCorridos)
	{
		if(diasCorridos > 0)
		{
			if(diasCorridos < AL2.minimoDias) return AL1.taxa;
			else if(diasCorridos < AL3.minimoDias) return AL2.taxa;
			else if(diasCorridos < AL4.minimoDias) return AL3.taxa;
			else return AL4.taxa;
		}

		return 0;
	}
	
	@Override
	public String toString() 
	{
		return String.format("Taxa: %.1f%% | Tempo: %s", taxa, descricao);
	}
		
}
