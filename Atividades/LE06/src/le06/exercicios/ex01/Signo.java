package le06.exercicios.ex01;

import static java.lang.String.*;

public class Signo 
{
	private static final Object SIGNOS[][] = {{20, "Capricórnio"},{19, "Aquário"},{20, "Peixes"},{20, "Áries"},{20, "Touro"}, {20, "Gêmeos"},
											  {21, "Câncer"}, {22, "Leão"}, {22, "Virgem"}, {22, "Libra"}, {21, "Escorpião"}, {21, "Sagitário"}};
	
	private static final int DIA = 0, MES = 1, ULTIMO_DIA = 0, JANEIRO = 0, DEZEMBRO = 11, SIGNO = 1;
	private static final String SEPARADOR_DATA = "/";
		
	// Recebe a data no formato DD/MM/AAAA, DD/MM/AA ou DD/MM e retorna o signo correspondente.
	public static String obterSigno(String data)
	{		
		int dia = obterDiaData(data), mes = obterMesData(data);
		
		if(dia > (Integer)SIGNOS[MES - 1][ULTIMO_DIA])
		{
			if(mes - 1 == DEZEMBRO)
				mes = JANEIRO + 1;
			
			else
				mes++;
		}
		
		return (String)SIGNOS[mes - 1][SIGNO];
	}
	
	// Recebe a data no formato DD/MM/AAAA, DD/MM/AA ou DD/MM e retorna o dia.
	private static int obterDiaData(String data)
	{
		return Integer.parseInt(data.split(SEPARADOR_DATA)[DIA]);
	}

	// Recebe a data no formato DD/MM/AAAA, DD/MM/AA ou DD/MM e retorna o mês.
	private static int obterMesData(String data)
	{
		return Integer.parseInt(data.split(SEPARADOR_DATA)[MES]);
	}
	
	public static String[][] obterSignos()
	{
		String[][] listaSignos = new String[12][];
		int indiceMes = 0;
				
		for(Object[] signo : SIGNOS)
		{			
			listaSignos[indiceMes] = new String[]{format("%02d", indiceMes + 1), valueOf(signo[ULTIMO_DIA]), valueOf(signo[SIGNO])};			
			indiceMes++;
		}
		
		return listaSignos;
	}
	
//	public static List<String[]> obterSignos()
//	{
//		List<String[]> listaSignos = new ArrayList<>();
//		int indiceMes = 0;
//				
//		for(Object[] signo : SIGNOS)
//		{			
//			listaSignos.add(new String[]{format("%02d", indiceMes + 1), valueOf(signo[ULTIMO_DIA]), valueOf(signo[SIGNO])});			
//			indiceMes++;
//		}
//		
//		return listaSignos;
//	}
	
}
