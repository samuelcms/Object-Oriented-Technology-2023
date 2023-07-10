package le09.exercicios.ex5;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static le09.exercicios.ex5.MCU.*;

public class MCU_GUI extends JFrame 
{
	private static final int PROX = 1, ANT = -1;
	
	private List<Filme> filmesSelecionados;
	private JLabel lblTituloIngles;
	private JLabel lblTituloPortugues;
	private JLabel lblDataLancamento;
	private JLabel lblPoster;
	
	public MCU_GUI() 
	{							
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JComboBox<String> comboBoxFilmes = new JComboBox<>();
		comboBoxFilmes.setBounds(139, 6, 177, 25);
		comboBoxFilmes.setModel(new DefaultComboBoxModel<String>(OPCOES));
		comboBoxFilmes.setSelectedIndex(11);
		comboBoxFilmes.setMaximumRowCount(12);
		contentPanel.add(comboBoxFilmes);
		
		lblPoster = new JLabel("");
		lblPoster.setBounds(26, 48, 405, 466);
		contentPanel.add(lblPoster);
		
		lblTituloIngles = new JLabel("Captain America - The Winter Soldier");
		lblTituloIngles.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloIngles.setForeground(new Color(0, 0, 160));
		lblTituloIngles.setBounds(26, 525, 405, 14);
		contentPanel.add(lblTituloIngles);
		
		lblTituloPortugues = new JLabel("Capitão América - O Soldado Invernal");
		lblTituloPortugues.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTituloPortugues.setBounds(26, 550, 405, 14);
		contentPanel.add(lblTituloPortugues);
		
		lblDataLancamento = new JLabel("04/04/2014");
		lblDataLancamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataLancamento.setBounds(26, 575, 405, 14);
		contentPanel.add(lblDataLancamento);
		
		JButton btnProximo = new JButton("Próximo > ");
		btnProximo.setMnemonic(KeyEvent.VK_P);
		btnProximo.setBounds(342, 626, 89, 23);
		contentPanel.add(btnProximo);
		
		JButton btnAnterior = new JButton("< Anterior");
		btnAnterior.setMnemonic(KeyEvent.VK_A);
		btnAnterior.setBounds(243, 626, 89, 23);
		contentPanel.add(btnAnterior);
		
		setTitle("ComboBox");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 699);
		
		filmesSelecionados = obterFilmes(comboBoxFilmes.getSelectedItem().toString(), comboBoxFilmes.getSelectedIndex());
		exibirFilme(0);
		
		comboBoxFilmes.addItemListener(new ItemListener() 
		{
			// Muda o ícone conforme o usuário selecionar na caixa de opções.
			public void itemStateChanged(ItemEvent event) 
			{
				if(event.getStateChange() == ItemEvent.SELECTED)
				{
					filmesSelecionados = obterFilmes(comboBoxFilmes.getSelectedItem().toString(), comboBoxFilmes.getSelectedIndex());
					
					System.out.println(filmesSelecionados.size());
					
					exibirFilme(0);
				}
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exibirFilme(obterIndiceFilme(MCU.pesquisarFilme(lblTituloIngles.getText()), ANT));
			}
		});
		
		btnProximo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exibirFilme(obterIndiceFilme(MCU.pesquisarFilme(lblTituloIngles.getText()), PROX));
			}
		});
		
		setVisible(true);
	}
	
	public void exibirFilme(int indiceFilme) 
	{
		Filme filme = filmesSelecionados.get(indiceFilme);
		
		lblTituloIngles.setText(filme.getTituloOriginal());
		lblTituloPortugues.setText(filme.getTituloBrasil());
		lblDataLancamento.setText(Util.localDateToString(filme.getLancamento()));
		lblPoster.setIcon(new ImageIcon(MCU.URL_ICONES + filme.getUrlPoster()));
		
		Float a[] = {3f, 10f, 1f, 0f, 2f};
		
		Arrays.sort(a, (f1, f2) -> f1.compareTo(f2));
	}	
	
	private int obterIndiceFilme(Filme filmeAtual, int proxOuAnt)
	{
		int indiceFilmeAtual = filmesSelecionados.indexOf(filmeAtual);
		
		if(proxOuAnt == PROX)
		{
			if(indiceFilmeAtual == filmesSelecionados.size() - 1)
				return 0;
			
			else
				return indiceFilmeAtual + 1;	
		}
		
		else
		{
			if(indiceFilmeAtual == 0)
				return filmesSelecionados.size()-1;
			
			else
				return indiceFilmeAtual - 1;
		}
	}
}
