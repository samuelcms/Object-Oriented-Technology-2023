package le08.exercicios.ex10;

public class Teste {

	public static void main(String[] args) 
	{
		Chefe c = new Chefe((short) 1, "Adailton", 9876.54f, 1000f);
		EmpregadoComissionista ec = new EmpregadoComissionista((short)2, "Bernardina", 1590f, 150, 5);
		EmpregadoHorista eh = new EmpregadoHorista((short)3, "Clodoaldo", 150f, 16f);
		
		Empregado ve[] = {c, ec, eh};
		
		for(Empregado e : ve)
		{
			String s = String.format("%s, %d, SBA: %.2f, SBR: %.2f, SL: %.2f, IRPF: %.2f, PSS: %.2f", e.getNome(), e.getNumDependentes(),
					      e.getSalarioBase(), e.salarioBruto(), e.salarioLiquido(), Imposto.irpf(e.salarioBruto(), e.getNumDependentes()),
					      Imposto.pss(e.salarioBruto()));
			
			System.out.println(s);
		}
	}
}
