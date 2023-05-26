package le06.exercicios.ex14;

/*
 * Informações sobre velocidade, ritmo e elevação presentes em exercícios como 
 * caminhada ou corrida.  
 */
public class InformacoesAdicionais
{
	private float velocidadeMedia, velocidadeMaxima;
	private String ritmoMedio, ritmoMaximo;
	private int menorElevacao, maiorElevacao;
	
	public InformacoesAdicionais() 
	{
		ritmoMaximo = ritmoMedio = "";
	}

	public InformacoesAdicionais(float velocidadeMedia, float velocidadeMaxima, String ritmoMedio, String ritmoMaximo,
                                 int menorElevacao, int maiorElevacao) 
	{
		this.velocidadeMedia = velocidadeMedia;
		this.velocidadeMaxima = velocidadeMaxima;
		this.ritmoMedio = ritmoMedio;
		this.ritmoMaximo = ritmoMaximo;
		this.menorElevacao = menorElevacao;
		this.maiorElevacao = maiorElevacao;
	}

	public float getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(float velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	public float getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(float velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public String getRitmoMedio() {
		return ritmoMedio;
	}

	public void setRitmoMedio(String ritmoMedio) {
		this.ritmoMedio = ritmoMedio;
	}

	public String getRitmoMaximo() {
		return ritmoMaximo;
	}

	public void setRitmoMaximo(String ritmoMaximo) {
		this.ritmoMaximo = ritmoMaximo;
	}

	public int getMenorElevacao() {
		return menorElevacao;
	}

	public void setMenorElevacao(int menorElevacao) {
		this.menorElevacao = menorElevacao;
	}

	public int getMaiorElevacao() {
		return maiorElevacao;
	}

	public void setMaiorElevacao(int maiorElevacao) {
		this.maiorElevacao = maiorElevacao;
	}

	@Override
	public String toString() 
	{
		return String.format("Velocidade média: %.1f Km/h\nVelocidade máxima: %.1f Km/h\nRitmo médio: %s \nRitmo máximo: %s \nMenor elevação: %d m\nMaior elevação: %d m",
				             velocidadeMedia, velocidadeMaxima, ritmoMedio, ritmoMaximo, menorElevacao, maiorElevacao);
	}	
}
