package le06.exercicios.ex14;

import static le06.exercicios.ex14.Exercicio.*;

import java.util.ArrayList;
import java.util.List;

public class ExercicioList 
{
	private List<Exercicio> listaExercicios;

	public ExercicioList() 
	{
		listaExercicios = new ArrayList<>();
	}
	
	public boolean adicionarExercicio (Exercicio exercicio) 
	{
		return listaExercicios.add(exercicio);
	}
	
	public Exercicio obterExercicio(int indiceExercicio)
	{
		return (indiceExercicio > 0 && indiceExercicio < listaExercicios.size()) ? listaExercicios.get(indiceExercicio) : null;
	}
	
	public Exercicio[] obterRelacaoExercicios()
	{
		return listaExercicios.toArray(new Exercicio[listaExercicios.size()]);
	}
	
	// Verifica a integridade dos campos de identificação única (nome e data do exercício).
	public boolean identificacaoValida(String nomeExercicio, String dataExercicio)
	{
		for(Exercicio exercicio : listaExercicios)
			if(exercicio.getNome().equals(nomeExercicio) && exercicio.getData().equals(dataExercicio))
				return false;
		
		return true;
	}
	
	// Obtém a maior duração de um exercício.
	public String obterMaiorDuracao()
	{
		float maiorDuracao = 0;
		String data = "";
		
		for(Exercicio exercicio : listaExercicios)
		{
			if(maiorDuracao < exercicio.formatarDuracao())
			{
				maiorDuracao = exercicio.formatarDuracao();
				data = exercicio.getData();
			}
		}
		
		return String.format("%s%s (%s)", String.valueOf(maiorDuracao).replace(STRING_PONTO, U_MINUTOS), U_SEGUNDOS, data);
	
	} // obterMaiorDuracao();

	// Obtém a maior distância percorrida.
	public String obterMaiorDistancia()
	{
		float maiorDistancia = 0;
		String data = "";
		
		for(Exercicio exercicio : listaExercicios)
		{
			if(maiorDistancia < exercicio.getDistancia())
			{
				maiorDistancia = exercicio.getDistancia();
				data = exercicio.getData();
			}
		}
		
		return String.format("% .2f %s (%s)", maiorDistancia, U_DISTANCIA, data);
		
	} // obterMaiorDistancia();

	// Obtém o maior número de calorias perdidas.
	public String obterMaiorPerdaCalorias()
	{
		float maiorQtdCalorias = 0;
		String data = "";
		
		for(Exercicio exercicio : listaExercicios)
		{
			if(maiorQtdCalorias < exercicio.getCaloriasPerdidas())
			{
				maiorQtdCalorias = exercicio.getCaloriasPerdidas();
				data = exercicio.getData();
			}
		}
		
		return String.format("%.2f %s (%s)", maiorQtdCalorias, U_CALORIAS, data);
	
	} // obterMaiorPerdaCalorias();

	// Obtém o maior número de passos dados.
	public String obterMaiorQtdPassos()
	{
		int maiorQtdPassos = 0;
		String data = "";
		
		for(Exercicio exercicio : listaExercicios)
		{
			if(maiorQtdPassos < exercicio.getPassos())
			{
				maiorQtdPassos = exercicio.getPassos();
				data = exercicio.getData();
			}
		}
				
		return String.format("%,d (%s)", maiorQtdPassos, data);
	
	} // obterMaiorQtdPassos();

	// Retorna uma string com a maior velocidade atingida dentre os exercícios e a data que foi alcançadas.
	public String obterMaiorVelocidade()
	{
		float maiorVelocidade = 0;
		String data = "";
				
		for(Exercicio exercicio : listaExercicios)
		{
			if(exercicio.getVelocidadeRitmoElevacao() != null && maiorVelocidade < exercicio.getVelocidadeRitmoElevacao().getVelocidadeMaxima())
			{
				maiorVelocidade = exercicio.getVelocidadeRitmoElevacao().getVelocidadeMaxima();
				data = exercicio.getData();
			}
		}
		
		if(maiorVelocidade == 0)
			return null;
								
		return String.format("%s %s (%s)", String.valueOf(maiorVelocidade), U_VELOCIDADE, data);
	
	} // obterMaiorVelocidade();
}
