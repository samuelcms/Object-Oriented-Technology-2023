package le06.exercicios.ex15;

import static le06.exercicios.ex15.CalculoInvestimento.*;

public class Investimento 
{
	private String tipo, estrategia, nome, rating, dataInvestimento, dataResgate;
	private float valorInvestido, taxa, taxaImpostoRenda; 
	private boolean fgc;
	

	public Investimento() 
	{
		tipo = "";
		estrategia  = "";
		nome = "";
		rating = "";
		dataInvestimento = "";
		dataResgate = "";
				
		fgc = false;
	}

	public Investimento(String tipo, String estrategia, String nome, String rating, String dataInvestimento,
			            String dataResgate, float valorInvestido, float taxa, boolean fgc) 
	{
		this.tipo = tipo;
		this.estrategia = estrategia;
		this.nome = nome;
		this.rating = rating;
		this.dataInvestimento = dataInvestimento;
		this.dataResgate = dataResgate;
		this.valorInvestido = valorInvestido;
		this.taxa = taxa;
		this.fgc = fgc;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEstrategia() {
		return estrategia;
	}
	
	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getDataInvestimento() {
		return dataInvestimento;
	}
	
	public void setDataInvestimento(String dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}
	
	public String getDataResgate() {
		return dataResgate;
	}
	
	public void setDataResgate(String dataResgate) {
		this.dataResgate = dataResgate;
	}
	
	public float getValorInvestido() {
		return valorInvestido;
	}
	
	public void setValorInvestido(float valorInvestido) {
		this.valorInvestido = valorInvestido;
	}
	
	public float getTaxa() {
		return taxa;
	}
	
	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	
	public boolean isFgc() {
		return fgc;
	}
	
	public void setFgc(boolean fgc) {
		this.fgc = fgc;
	}
	
	public float getTaxaImpostoRenda() {
		return taxaImpostoRenda;
	}

	public void setTaxaImpostoRenda(float taxaImpostoRenda) {
		this.taxaImpostoRenda = taxaImpostoRenda;
	}

	@Override
	public String toString() 
	{
		return String.format(
				"Investimento [tipo=%s, estrategia=%s, nome=%s, rating=%s, dataInvestimento=%s, dataResgate=%s, valorInvestido=%s, taxa=%s, fgc=%s]",
				tipo, estrategia, nome, rating, dataInvestimento, dataResgate, valorInvestido, taxa, fgc);
	}
	
	// Calcula o valor bruto acumulado do investimento (sem desconto de IR);
	public float calcularValorBruto()
	{
		int periodo, numMeses;
		float taxa;
		
		numMeses = mesesEntreDatas(dataInvestimento, dataResgate);
		
		if(numMeses >= 12)
		{
			periodo = mesesEmAnos(numMeses);
			taxa = this.taxa;
		}
		
		else
		{
			periodo = numMeses;
			taxa = taxaEquivalenteMes();
		}
		
		return (float)(valorInvestido * Math.pow((1 + (taxa/100.0)), periodo));
	}
	
	// Calcula o valor líquido acumulado do investimento (com desconto de IR);
	public float calcularValorLiquido()
	{
		return rendimentoLiquido() + valorInvestido;
	}
	
	// Calcula o valor do IR em reais a ser pago sobre o rendimento;
	public float calcularValorIR()
	{
		return rendimentoBruto() * (taxaImpostoRenda / 100);	
	}
	
	// Calcula o rendimento bruto (sem desconto de IR);
	public float rendimentoBruto()
	{
		return calcularValorBruto() - valorInvestido;
	}
	
	// Calcula o rendimento líquido (com desconto de IR).
	public float rendimentoLiquido()
	{
		return rendimentoBruto() - calcularValorIR();
	}
	
	// Calcula a rentabilidade bruta percentual do investimento.
	public float calcularRentabilidade()
	{
		return ((calcularValorBruto() / valorInvestido) - 1) * 100;
	}
	
	/*
	 * Retorna a taxa equivalente ao mês a partir da taxa conhecida (ao ano). 
	 */
	public float taxaEquivalenteMes()
	{
		return (float)(Math.pow((1 + (taxa / 100)), (1.0/12.0)) - 1) * 100;
	}
}
