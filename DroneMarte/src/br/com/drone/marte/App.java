package br.com.drone.marte;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import br.com.drone.marte.paineis.PainelCadastro;
import br.com.drone.marte.paineis.PainelLista;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	private PainelCadastro abaCadastro = new PainelCadastro();
	private PainelLista abaLista = new PainelLista();
	private JTabbedPane abas = new JTabbedPane();
	
	public static void main(String[] args) {
		App app = new App();
		app.init();
	}

	private void init() {
		abas.add("Cadastro", abaCadastro);
		abas.add("Lista", abaLista);

		add(abas);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);		
	}
}
