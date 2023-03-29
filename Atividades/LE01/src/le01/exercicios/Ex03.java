package le01.exercicios;

import static java.lang.String.format;
import static util.Util.print;

public class Ex03
{
	public static void exercicio2() 
	{
		char c = 'A';
		int i = 15;
		float f;
		double d, circunferencia;
		
		print("\n- Exercício 2\n");
		
		// a)
		i = 5 / 2;
		print(format(" - a) %d", i));
		
		// b)
		f = 5 / 2.5f;
		print(format(" - b) %.1f", f));
		
		// c)
		i = 15;
		i = c + 10;
		print(format(" - c) %d", i));
		
		// d)
		circunferencia = Math.TAU;
		print(format(" - d) %f", circunferencia));
		
		// e)
		i = 15;
		f = (c + i) / 1.5f;
		print(format(" - e) %.1f", f));
		
		// f)
		f = (float) 7 / 2;
		print(format(" - f) %.1f", f));
		
		// g)
		d = Math.PI * 2;
		print(format(" - g) %f", d));
		
		// h)
		d = 7.5 / 3;
		print(format(" - h) %.1f", d));
		
		// i)
		d = Math.E * Math.exp(1);
		print(format(" - i) %.1f", d));
		
		// j)
		d = Math.log(Math.E);
		print(format(" - j) %.1f", d));
		
		// k)
		i = (int) 7.5 / 3;
		print(format(" - k) %d", i));
		
		// l)
		f = 1 / 1000 * 2.5f;
		print(format(" - l) %.4f", f));
		
		// m)
		f = (float) 1 / 1000 * 2.0f;
		print(format(" - m) %.4f", f));
		
		// n)
		d = 0.0 / 0;
		print(format(" - n) %f", d));	
	}
}
