package br.com.drone.marte.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.drone.marte.dao.Dao;
import br.com.drone.marte.model.Drone;
import br.com.drone.marte.paineis.PainelCadastro;
import br.com.drone.marte.paineis.PainelEditar;

public class BotaoListener implements ActionListener {

	private PainelCadastro painelCadastro;
	private Dao dao = new Dao();
	
	public BotaoListener(PainelCadastro painelCadastro) {
		this.painelCadastro = painelCadastro;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		Drone drone = new Drone();
		drone.setPressao(painelCadastro.getCampos().getPressao().getText());
		drone.setVelocidade(painelCadastro.getCampos().getVelocidade().getText());
		drone.setDuracao(painelCadastro.getCampos().getDuracao().getText());
		drone.setAltitude(painelCadastro.getCampos().getAltitude().getText());
		drone.setRota(String.valueOf(painelCadastro.getCampos().getRota().getSelectedItem()));
		
		System.out.println(drone);	
		
		dao.criar(drone);
		
		painelCadastro.getCampos().getPressao().setText(null);
		painelCadastro.getCampos().getVelocidade().setText(null);
		painelCadastro.getCampos().getDuracao().setText(null);
		painelCadastro.getCampos().getAltitude().setText(null);
	}
}
