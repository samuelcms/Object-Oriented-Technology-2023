package le08.exercicios.ex10;

public final class EmpregadoHorista extends Empregado 
{
	private float horasTrabalhadas;
	
	public EmpregadoHorista(short numDependentes, String nome, float salarioBase, float horasTrabalhadas) 
	{
		super(numDependentes, nome, salarioBase);
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public float getHorasTrabalhadas() 
	{
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(float horasTrabalhadas) 
	{
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	@Override
	public String toString() 
	{	
		return String.format("%s, Horas trabalhadas: %.2f", super.toString(), horasTrabalhadas);
	}

	@Override
	public float salarioBruto() 
	{
		return getSalarioBase() * horasTrabalhadas;
	}

}
