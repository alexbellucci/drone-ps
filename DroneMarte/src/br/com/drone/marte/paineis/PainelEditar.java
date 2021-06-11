package br.com.drone.marte.paineis;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PainelEditar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private PainelCampos campos = new PainelCampos();
	private PainelBotoes botoes = new PainelBotoes(this);
	
	public PainelEditar() {
		setLayout(new BorderLayout());
		init();
	}
	
	private void init() {
		add(getCampos(), BorderLayout.CENTER);
		add(botoes, BorderLayout.SOUTH);
		
	}

	public PainelCampos getCampos() {
		return campos;
	}
}
