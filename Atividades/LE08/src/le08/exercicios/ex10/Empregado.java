package le08.exercicios.ex10;

public abstract class Empregado 
{
	private short numDependentes;
	private String nome;
	private float salarioBase;
	
	public Empregado() 
	{
		nome = "";
	}

	public Empregado(short numDependentes, String nome, float salarioBase) 
	{
		this();
		
		this.numDependentes = numDependentes;
		this.nome = nome;
		this.salarioBase = salarioBase;
	}

	public short getNumDependentes() 
	{
		return numDependentes;
	}

	public void setNumDependentes(short numDependentes) 
	{
		this.numDependentes = numDependentes;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public float getSalarioBase() 
	{
		return salarioBase;
	}

	public void setSalarioBase(float salario) 
	{
		this.salarioBase = salario;
	}

	@Override
	public String toString() 
	{
		return String.format("%s, %d dep, Salário Base: R$ %.2f", nome, numDependentes, salarioBase);
	}
	
	public float salarioLiquido()
	{
		return salarioBruto() - Imposto.irpf(salarioBruto(), numDependentes) - Imposto.pss(salarioBruto());
	}
	
	public abstract float salarioBruto();
}
