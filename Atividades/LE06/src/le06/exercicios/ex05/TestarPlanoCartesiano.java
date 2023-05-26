package le06.exercicios.ex05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import le06.exercicios.ex04.PlanoCartesiano;
import le06.exercicios.ex04.Ponto;

public class TestarPlanoCartesiano 
{
	public static void main(String[] args) 
	{
		//testarPlanoCartesiano();
		
		List<Ponto> l = new ArrayList<>(Arrays.asList(new Ponto[]{new Ponto(1, 2), new Ponto(3, 4)})),
				      l2 = List.copyOf(l);
		
		System.out.println("L  " + Arrays.toString(l.toArray()));
		System.out.println("L2 " + Arrays.toString(l2.toArray()));
		
		// l.get(0).setX(-15);
		l.set(0, new Ponto(-65, -96));
		
		System.out.println("L  " + Arrays.toString(l.toArray()));
		System.out.println("L2 " + Arrays.toString(l2.toArray()));
	}

	public static void testarPlanoCartesiano() 
	{
		PlanoCartesiano p1, p2, p3;
		
		p1 = new PlanoCartesiano(-11, -6);
		p2 = new PlanoCartesiano(4, 6);
		p3 = new PlanoCartesiano();
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

}
