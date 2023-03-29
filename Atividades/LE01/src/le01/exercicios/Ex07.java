package le01.exercicios;

public class Ex07
{
	public static void tabelas()
	{
		mensagemCabecalho("\n\n   - Operador relacional  \"AND\"");
		tabelaOperadorAnd();

		mensagemCabecalho("\n\n   - Operador relacional \"OR\"");
		tabelaOperadorOr();

		mensagemCabecalho("\n\n   - Operador relacional \"NOT\"");
		tabelaOperadorNot();
	}

	@SuppressWarnings("unused")
	public static void tabelaOperadorAnd() 
	{		
		System.out.printf("\t - false && false = %b\n", (false && false));
		System.out.printf("\t - false && true  = %b\n", (false && true));
		System.out.printf("\t - true  && false = %b\n", (true && false));
		System.out.printf("\t - true  && true  = %b\n", (true && true));	
	}

	@SuppressWarnings("unused")
	public static void tabelaOperadorOr() 
	{
		System.out.printf("\t - false || false = %b\n", (false || false));
		System.out.printf("\t - false || true  = %b\n", (false || true));
		System.out.printf("\t - true  || false = %b\n", (true || false));
		System.out.printf("\t - true  || true  = %b\n", (true || true));	
	}

	public static void tabelaOperadorNot() 
	{
		System.out.printf("\t - !false = %b\n", (!false));
		System.out.printf("\t - !true = %b\n", (!true));
	}

	public static void mensagemCabecalho(String mensagem)
	{
		System.out.printf("%s\n\n", mensagem);
	}
	
} // class Ex7
