package le08.exercicios.ex10;

public final class Chefe extends Empregado 
{
	private float gratificacao;
	
	public Chefe(short numDependentes, String nome, float salarioBase, float gratificacao) 
	{
		super(numDependentes, nome, salarioBase);
		this.gratificacao = gratificacao;
	}

	public float getGratificacao() 
	{
		return gratificacao;
	}

	public void setGratificacao(float gratificacao) 
	{
		this.gratificacao = gratificacao;
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s, Gratificação: R$ %.2f", super.toString(), gratificacao);
	}
	
	@Override
	public float salarioBruto() 
	{
		return getSalarioBase() + gratificacao;
	}
}
