package br.com.drone.marte.paineis;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.drone.marte.listener.BotaoListener;

public class PainelBotoes extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton salvar = new JButton("Salvar");
	private JButton cancelar = new JButton("Cancelar");
	private PainelCadastro painelCadastro;
	
	public PainelBotoes(PainelCadastro painelCadastro) {
		
		this.painelCadastro = painelCadastro;
		init();
	}
	
	private void init() {
		
		add(salvar);
		add(cancelar);
		
		salvar.addActionListener(new BotaoListener(painelCadastro));
	}
}
