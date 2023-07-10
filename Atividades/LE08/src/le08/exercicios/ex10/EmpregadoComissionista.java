package le08.exercicios.ex10;

public final class EmpregadoComissionista extends Empregado 
{
	private float comissao;
	private int itensVendidos;
	
	public EmpregadoComissionista(short numDependentes, String nome, float salarioBase, float comissao, int itensVendidos) 
	{
		super(numDependentes, nome, salarioBase);
		this.comissao = comissao;
		this.itensVendidos = itensVendidos;
	}

	public float getComissao() 
	{
		return comissao;
	}

	public void setComissao(float comissao) 
	{
		this.comissao = comissao;
	}

	public int getItensVendidos() 
	{
		return itensVendidos;
	}

	public void setItensVendidos(int itensVendidos) 
	{
		this.itensVendidos = itensVendidos;
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s, Comissão: %.2f, Vendas: %d", super.toString(), comissao, itensVendidos);
	}

	@Override
	public float salarioBruto() 
	{
		return getSalarioBase() + comissao * itensVendidos;
	}
}
