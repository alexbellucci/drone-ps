package br.com.drone.marte.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.drone.marte.dao.Dao;
import br.com.drone.marte.model.Drone;
import br.com.drone.marte.paineis.PainelCadastro;
import br.com.drone.marte.paineis.PainelEditar;

public class BotaoEditarListener implements ActionListener {

	private PainelEditar painelEditar;
	private Dao dao = new Dao();
	
	public BotaoEditarListener(PainelEditar painelEditar) {
		this.painelEditar = painelEditar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Drone drone = new Drone();
		drone.setPressao(painelEditar.getCampos().getPressao().getText());
		drone.setVelocidade(painelEditar.getCampos().getVelocidade().getText());
		drone.setDuracao(painelEditar.getCampos().getDuracao().getText());
		drone.setAltitude(painelEditar.getCampos().getAltitude().getText());
		drone.setRota(String.valueOf(painelEditar.getCampos().getRota().getSelectedItem()));
		
		System.out.println(drone);	
		
		dao.editar(drone);
	
	}
}
