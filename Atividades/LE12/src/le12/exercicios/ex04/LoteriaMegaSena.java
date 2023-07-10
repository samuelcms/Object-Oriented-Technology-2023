package le12.exercicios.ex04;

import static mos.reader.Reader.*;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mos.reader.Line;

public class LoteriaMegaSena 
{
	// Um número sorteado pode estar enre 01 e 60.
	private int RANGE_NUMEROS = 60; 
	private List<MegaSena> listaSorteios = new ArrayList<>();
		
	public LoteriaMegaSena() 
	{
		importarDados();
		apurarConcursos();
	}

	private void importarDados()
	{
		List<Line> linhasArquivo = read("C:\\TSI\\2023 - 01\\TOO\\Atividades\\LE12\\files\\concursos.csv", SEMICOLON);
		
		// Removendo cabeçalho.
		linhasArquivo.remove(0);
		
		for(Line linha : linhasArquivo)
		{
						
			String[] campos = linha.getLine();
			MegaSena concurso =  new MegaSena();
			
			concurso.setConcurso(campos[0]);
			concurso.setData(campos[1]);
			
			for(int i = 2; i < campos.length; i++)
				concurso.adicionarDezena(Integer.parseInt(campos[i]));
			
			listaSorteios.add(concurso);
		}	
	}
	
	private void apurarConcursos()
	{
		LocalTime inicio, termino;
		NumeroSorteado numerosSorteados[] = new NumeroSorteado[RANGE_NUMEROS]; 
		StringBuilder relatorio = new StringBuilder();
		
		inicio = LocalTime.now();
				
		for(MegaSena sorteio : listaSorteios)
		{				
			for(int numeroSorteado : sorteio.obterDezenas())
			{
				if(numerosSorteados[numeroSorteado - 1] == null)
					numerosSorteados[numeroSorteado - 1] = new NumeroSorteado();
				
				numerosSorteados[numeroSorteado - 1].setNumero(numeroSorteado);
				numerosSorteados[numeroSorteado - 1].incrementarOcorrencias();
			}
		}
		
		termino = LocalTime.now();
		
		Arrays.sort(numerosSorteados, (n1, n2) -> -Integer.compare(n1.getOcorrencias(), n2.getOcorrencias()));
		
		relatorio.append(String.format("Start: %s", inicio.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"))));
		relatorio.append(String.format("\nFinish: %s", termino.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"))));
		relatorio.append(String.format("\nTime spent: %,d ms", Duration.between(inicio, termino).toMillis()));
				
		relatorio.append("\n\n Most frequent numbers: \n");
		
		for(int i = 0; i < 6; i++)
			relatorio.append(String.format("\n   - %s", numerosSorteados[i]));
			
		System.out.println(relatorio);
		
		
	}
}
