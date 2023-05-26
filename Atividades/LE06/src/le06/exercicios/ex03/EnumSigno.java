package le06.exercicios.ex03;

import static java.lang.String.format;

public enum EnumSigno 
{
	CAPRICORNIO(1, 20, "Capricórnio"),
	AQUARIO(2, 19, "Aquário"),
	PEIXES(3, 20, "Peixes"),
	ARIES(4, 20,"Áries"),
	TOURO(5, 20,"Touro"),
	GEMEOS(6, 20, "Gêmeos"),
	CANCER(7, 21,"Câncer"),
	LEAO(8, 22, "Leão"),
	VIRGEM(9, 22, "Virgem"),
	LIBRA(10, 22, "Libra"),
	ESCORPIAO(11, 21, "Escorpião"),
	SAGITARIO(12, 21, "Sagitário");
	
	private static final int DIA = 0, MES = 1, JANEIRO = 0, DEZEMBRO = 11;
	
	private static final String SEPARADOR_DATA = "/";
	
	private int mes, ultimoDia;
	private String signo;
	
	private EnumSigno(int mes, int ultimoDia, String signo) 
	{
		this.mes = mes;
		this.ultimoDia = ultimoDia;
		this.signo = signo;
	}

	public int getMes() 
	{
		return mes;
	}

	public void setMes(int mes) 
	{
		this.mes = mes;
	}

	public int getUltimoDia() 
	{
		return ultimoDia;
	}

	public void setUltimoDia(int ultimoDia) 
	{
		this.ultimoDia = ultimoDia;
	}

	public String getSigno() 
	{
		return signo;
	}

	public void setSigno(String signo) 
	{
		this.signo = signo;
	}
	
	@Override
	public String toString() 
	{
		return String.format("%d, %d, %s", mes, ultimoDia, signo);	
	}	
	
	public static String[][] obterSignos()
	{
		String[][] listaSignos = new String[12][];
		int indiceMes = 0;
				
		for(EnumSigno signo : EnumSigno.values())
		{			
			listaSignos[indiceMes] = new String[]{format("%02d", signo.mes), String.valueOf(signo.ultimoDia), signo.signo};			
			indiceMes++;
		}
		
		return listaSignos;
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
	
	public static String obterSigno(String data) 
	{				
		int mes = obterMesData(data),
			dia = obterDiaData(data);
		
		if(EnumSigno.values()[mes - 1].getUltimoDia() < dia)
		{
			if(mes < DEZEMBRO)
				mes++;
			
			else
				mes = JANEIRO;
		}
		
		return EnumSigno.values()[mes - 1].getSigno();
	}
}
