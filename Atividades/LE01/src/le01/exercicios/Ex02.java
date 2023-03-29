package le01.exercicios;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.String.format;
import static util.Util.print;

public class Ex02 
{
	public static void exercicio1() 
	{
		double a, b, c, d, x, y, z, r1, r2;
		
		print("- Exercício 1\n");
		
		// a)
		x = 1;
		a = 3;
		z = x + pow(a, 2);
		print(format(" - a) %.1f", z));
		
		// b)
		a = 8;
		b = 2;
		c = 1;
		x = (a/b) + c - sqrt(a/b);
		print(format(" - b) %.1f", x));
		
		// c)
		a = 1;
		b = 2;
		c = 3;
		d = 4;
		x = 2;
		x = a + b * x + c * pow(x, 2) + d * pow(x, 3);
		print(format(" - c) %.1f", x));
		
		// d)
		x = 1;
		z = x * Math.E;
		print(format(" - d) %f", z));
		
		// e)
		x = 2;
		r1 = (2 * x + Math.pow((2 / Math.pow(x, (6 * x + 8))), 1/5)) / 3 * x * Math.log(x);
		r2 = (2 * x - Math.pow((2 / Math.pow(x, (6 * x + 8))), 1/5)) / 3 * x * Math.log(x);
		print(format(" - e) y1 = %.2f | y2 = %.2f", r1, r2));
		
		// f)
		x = 0;
		y = Math.sqrt((5 * x + Math.exp(x)) / Math.pow(Math.E, (8 * x + 8)));
		print(format(" - f) %f", y));
	
	} // exercicio1();

} // class Exercicio1
