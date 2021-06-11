package br.com.drone.marte.paineis;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.drone.marte.dao.Dao;
import br.com.drone.marte.model.Drone;

public class PainelLista extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JButton carregar = new JButton("carregar");
	private JButton apagar = new JButton("apagar");
	private JButton editar = new JButton("editar");
	private JTable tabela = new JTable(modelo);
	
	private JLabel lista = new JLabel("Lista de voos");
	
	public PainelLista() {
		init();
	}

	private void init() {
		add(lista);
		modelo.addColumn("Id");
		modelo.addColumn("pressao");
		modelo.addColumn("velocidade");
		modelo.addColumn("duracao");
		modelo.addColumn("altitude");
		modelo.addColumn("rota");

		carregarDados();
		
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setSize(180,150);
		add(painelTabela);
		
		JPanel botoes = new JPanel();
		botoes.add(editar);
		botoes.add(apagar);
		botoes.add(carregar);
		
		add(botoes, BorderLayout.SOUTH);
		
		editar.addActionListener(this);
		carregar.addActionListener(this);
		apagar.addActionListener(this);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setSize(400, 200);
		setVisible(true);
	}
	
	public void carregarDados() {
		modelo.setNumRows(0);
		
		Dao dao = new Dao();
		List<Drone> lista = dao.buscarTodos();
		
		for (Drone drone : lista) {
			String[] linha = { 
			    drone.getId().toString(),
			    drone.getPressao(),
			    drone.getVelocidade(), 
			    drone.getDuracao(),
			    drone.getAltitude(),
			    drone.getRota()
			};
			modelo.addRow(linha);
		}
		
	}

	private void apagar() {
		Dao dao = new Dao();
		int linha = tabela.getSelectedRow();
		String id = tabela.getValueAt(linha, 0).toString();
		Drone drone = dao.buscarPorId(Long.valueOf(id));
		int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que quer apagar o drone selecionado?");
		//dao.apagarPeloId(Long.valueOf(id));
		if (resposta == JOptionPane.YES_OPTION) {
			dao.apagar(drone);
			carregarDados();
		}
	}

	private void editar() {
		Dao dao = new Dao();
		int linha = tabela.getSelectedRow();
		String id = tabela.getValueAt(linha, 0).toString();
		String pressao = tabela.getValueAt(linha, 1).toString();
		Drone drone = dao.buscarPorId(Long.valueOf(id));
		int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que quer editar o drone selecionado?");
		if (resposta == JOptionPane.YES_OPTION) {
			drone.setPressao(pressao);
			dao.editar(drone);
			carregarDados();
		}
	}
	
	//@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == carregar) carregarDados();		
		if (e.getSource() == apagar) apagar();
		if (e.getSource() == editar) editar();
	}
	
}
