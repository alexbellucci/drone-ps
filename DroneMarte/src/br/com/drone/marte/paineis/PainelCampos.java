package br.com.drone.marte.paineis;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

public class PainelCampos extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField pressao = new JTextField();
	private JTextField velocidade = new JTextField();
	private JTextField duracao = new JTextField();
	private JTextField altitude = new JTextField();
	private String[] rotas = {"A1","B2","C3","D4"};
	private JComboBox<String> rota = new JComboBox<String>(rotas);
	
	public PainelCampos() {
		setLayout(new GridLayout(6, 1));
		setBorder(new EmptyBorder(20, 15, 20, 10));
		init();
	}

	private void init() {
		add(new JLabel("Pressao"));
		add(getPressao());
		add(new JLabel("Velocidade"));
		add(getVelocidade());
		add(new JLabel("Duracao"));
		add(getDuracao());
		add(new JLabel("Altitude"));
		add(getAltitude());
		add(new JLabel("Rotas"));
		add(getRota());
		
	}

	public JTextField getPressao() {
		return pressao;
	}

	public JTextField getVelocidade() {
		return velocidade;
	}

	public JTextField getDuracao() {
		return duracao;
	}

	public JTextField getAltitude() {
		return altitude;
	}

	public JComboBox<String> getRota() {
		return rota;
	}

}
