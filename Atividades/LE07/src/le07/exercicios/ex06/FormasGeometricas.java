package le07.exercicios.ex06;

import static le07.entradaesaida.EntradaSaida.*;

import java.awt.Color;
import javax.swing.JScrollPane;

public class FormasGeometricas 
{	
	public static void main(String[] args) 
	{
		formasGeometricas();
	}

	public static void formasGeometricas()
	{
		Forma forma = new Forma();
		FormaGeometrica formaGeometrica = new FormaGeometrica();
		Forma2D forma2d = new Forma2D();
		Forma3D forma3d = new Forma3D();
		Circulo circulo = new Circulo(3);
		Quadrado quadrado = new Quadrado(5);
		Triangulo triangulo = new Triangulo();
		
		// Define os atributos do objeto via chamada encadeada dos métodos set.
		formaGeometrica.setCor(Color.BLUE).setNome("Forma Geométrica");
		triangulo.setBase(3).setAltura(5).setNome("Triângulo");
		
		circulo.setUnidade(Forma.METRO);
		
		writeTextArea(forma.toString());
		writeTextArea(NOVA_LINHA);
		writeTextArea(formaGeometrica.toString());
		writeTextArea(NOVA_LINHA);
		writeTextArea(forma2d.toString());
		writeTextArea(NOVA_LINHA);
		writeTextArea(forma3d.toString());
		writeTextArea(LINHA_VAZIA);
		writeTextArea(String.format("Nome: %s \nCor: %s", formaGeometrica.getNome(), formaGeometrica.getCor()));
		writeTextArea(LINHA_VAZIA);
		writeTextArea(circulo.toString());
		writeTextArea(LINHA_VAZIA);
		writeTextArea(quadrado.toString());
		writeTextArea(LINHA_VAZIA);
		writeTextArea(triangulo.toString());
		writeTextArea(LINHA_VAZIA);
		writeTextArea("Área das Formas Geométricas: \n\n");
		writeTextArea(String.format("  - Círculo: %1.2f %s\n  - Quadrado: %1.2f %s\n  - Triangulo %1.2f %s", 
				                         circulo.area(), circulo.obterUnidadeArea(), quadrado.area(), quadrado.obterUnidadeArea(),
				                         triangulo.area(), FormaGeometrica.obterUnidadeArea(triangulo)));
		
		forma = triangulo;
		writeTextArea(LINHA_VAZIA);
		writeTextArea(forma.toString());
		
		
		if(forma instanceof Quadrado)
		{
			// Converte a referência da superclasse em uma referência da subclasse.
			quadrado = (Quadrado)forma;
			writeTextArea(LINHA_VAZIA);
			writeTextArea(quadrado.toString());
		}
		else
		{
			writeTextArea(LINHA_VAZIA);
			writeTextArea("A variável forma não possui uma referência da classe Quadrado.");
		}
		
		forma = quadrado;
		
		if(forma instanceof Quadrado)
		{
			// Converte a referência da superclasse em uma referência da subclasse.
			quadrado = (Quadrado)forma;
			writeTextArea(LINHA_VAZIA);
			writeTextArea(quadrado.toString());
		}
		else
		{
			writeTextArea(LINHA_VAZIA);
			writeTextArea("A variável forma não possui uma referência da classe Quadrado.");
		}

		
		msgInfo(new JScrollPane(getTextArea()), ESPACO);
	}
}
