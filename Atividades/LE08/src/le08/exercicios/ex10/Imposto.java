package le08.exercicios.ex10;

public interface Imposto
{
	static float irpf(float salarioBruto, short numeroDependentes)
	{
		float aliquota, deducao, baseCalculo;
		
		salarioBruto -= numeroDependentes * 189.59;
		
		if(salarioBruto <= 2112.00)
			return 0;
		
		else if(salarioBruto < 2286.66)
		{
			baseCalculo = 2112.01f;
			aliquota = 7.5f;
			deducao = 158.40f;			
		}
		
		else if(salarioBruto < 3751.06) 
		{
			baseCalculo = 2826.66f;
			aliquota = 15f;
			deducao = 370.40f;
		}
		else if (salarioBruto < 4664.69) 
		{
			baseCalculo = 3751.06f;
			aliquota = 22.5f;
			deducao = 651.73f;			
		}
		else
		{
			baseCalculo = 4664.69f;
			aliquota = 27.5f;
			deducao = 884.96f;
		}
				
		return baseCalculo * (aliquota / 100) - deducao;
	}
	
	static float pss(float salarioBruto)
	{
		return salarioBruto * 0.11f;
	}
}
