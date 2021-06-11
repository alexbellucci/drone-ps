package br.com.drone.marte.paineis;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.drone.marte.listener.BotaoEditarListener;
import br.com.drone.marte.listener.BotaoListener;

public class PainelBotoes extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton salvar = new JButton("Salvar");
	private JButton cancelar = new JButton("Cancelar");
	private PainelCadastro painelCadastro;
	private PainelEditar painelEditar;
	
	public PainelBotoes(PainelCadastro painelCadastro) {
		
		this.painelCadastro = painelCadastro;
		init();
	}
	
    public PainelBotoes(PainelEditar painelEditar) {
		
		this.painelEditar = painelEditar;
		init();
	}

	private void init() {
		
		add(salvar);
		add(cancelar);
		
		salvar.addActionListener(new BotaoListener(painelCadastro));
		//salvar.addActionListener(new BotaoEditarListener(painelEditar));
	}
}
