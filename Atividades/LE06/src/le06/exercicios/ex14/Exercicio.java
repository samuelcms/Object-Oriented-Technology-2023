package le06.exercicios.ex14;

import java.util.ArrayList;
import java.util.List;

public class Exercicio 
{
	public static final int TIPO_1 = 1, // Corrida, caminhada, etc.
							TIPO_2 = 2; // Basquete, vôlei, etc.
	
	public static final String U_MINUTOS = "m",
			  				   U_SEGUNDOS = "s",
			  				   U_DISTANCIA = "km",
			  				   U_VELOCIDADE = "Km/h",
			  				   U_ELEVACAO = "m",
			  				   U_CALORIAS = "Kcal",
							
			  				   STR_EXERCICIO = "Exercício:",
			  				   STR_DATA = "Data:",
			  				   STR_TEMPO = "Tempo",
			  				   STR_DURACAO = "Duração:",
			  				   STR_DISTANCIA = "Distância:",
			  				   STR_CALORIAS = "Calorias:",
			  				   STR_PASSOS = "Passos:",
			  				   STR_VELOCIDADE_MEDIA = "Velocidade média:",
			  				   STR_VELOCIDADE_MAXIMA = "Velocidade máxima:",
			  				   STR_RITMO_MEDIO = "Ritmo médio:",
			  				   STR_RITMO_MAXIMO = "Ritmo máximo:",
			  				   STR_MENOR_ELEVACAO = "Menor elevação",
			  				   STR_MAIOR_ELEVACAO = "Maior elevação:", 
			  				   
			  				   STRING_VAZIA = "",
			  				   STRING_PONTO = ".",
			  				   NOVA_LINHA = "\n",
			  				   ESPACO_EM_BRANCO = " ";
	
	private String nome, data, tempo, duracao;
	private float caloriasPerdidas, distancia;
	private int passos;
	
	private List<Ritmo> ritmoExercicio;
	private InformacoesAdicionais velocidadeRitmoElevacao;
	
	public Exercicio() 
	{
		nome = "";
		data = "";
		tempo = "";
		duracao = "";
	}

	public Exercicio(String nome, String data, String tempo, String duracao) 
	{
		this.nome = nome;
		this.data = data;
		this.tempo = tempo;
		this.duracao = duracao;
	}

	public Exercicio(String nome, String data, String tempo, String duracao, float caloriasPerdidas, float distancia, int passos) 
	{
		this(nome, data, tempo, duracao);

		this.caloriasPerdidas = caloriasPerdidas;
		this.distancia = distancia;
		this.passos = passos;
	}

	public Exercicio(String nome, String data, String tempo, String duracao, float caloriasPerdidas, float distancia, int passos,
			         InformacoesAdicionais informacoesAdicionais) 
	{
		this(nome, data, tempo, duracao, caloriasPerdidas, distancia, passos);
		velocidadeRitmoElevacao = informacoesAdicionais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public InformacoesAdicionais getVelocidadeRitmoElevacao() {
		return velocidadeRitmoElevacao;
	}

	public void setVelocidadeRitmoElevacao(InformacoesAdicionais velocidadeRitmoElevacao) {
		this.velocidadeRitmoElevacao = velocidadeRitmoElevacao;
	}

	public float getCaloriasPerdidas() {
		return caloriasPerdidas;
	}

	public void setCaloriasPerdidas(float caloriasPerdidas) {
		this.caloriasPerdidas = caloriasPerdidas;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public int getPassos() {
		return passos;
	}

	public void setPassos(int passos) {
		this.passos = passos;
	}

	@Override
	public String toString() 
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(String.format("Exercício: %s\n\nData: %s\nTempo: %s\nDuração: %s\nDistância: %.2f Km\nCalorias perdidas %.2f Kcal\nPassos: %,d", 
				                            nome, data, tempo, duracao, distancia, caloriasPerdidas, passos));
		
		if(velocidadeRitmoElevacao != null)
			stringBuilder.append("\n" + velocidadeRitmoElevacao.toString());
		
		if(ritmoExercicio != null)
		{
			stringBuilder.append("\n\n------ Ritmo ------\n");
			for(Ritmo ritmo : ritmoExercicio)
				stringBuilder.append("\n" + ritmo.toString());
		}
		
		return stringBuilder.toString();
	}
	
	/*
	 *	Recebe um vetor de strings com as informações do ritmo do exercício vindas diretamente do arquivo 
	 *  e adiciona ao array de objetos da classe ritmo. 
	 */
	public void adicionarRitmoExericio(String infoRitmo[])
	{
		String buffer[];
		
		if(ritmoExercicio == null)
			ritmoExercicio = new ArrayList<>();
		
		for(String ritmo : infoRitmo)
		{
			buffer = ritmo.split(" Km: ");
			ritmoExercicio.add(new Ritmo(buffer[0], buffer[1]));
		}
	}
	
	public Ritmo[] obterRitmo() 
	{
		return ritmoExercicio != null ? ritmoExercicio.toArray(new Ritmo[ritmoExercicio.size()]) : null;
	}
	
	public float formatarDuracao()
	{
		String buffer = duracao;
				
		buffer = buffer.replace(U_SEGUNDOS, STRING_VAZIA);
		buffer = buffer.replace(U_MINUTOS, STRING_PONTO);
				
		return Float.parseFloat(buffer);
	}
}
