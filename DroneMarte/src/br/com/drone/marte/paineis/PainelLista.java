package br.com.drone.marte.paineis;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
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
	
	private JLabel lista = new JLabel("Para editar qualquer item, selecione e clique duas vezes, após finalizar clique em editar.");
	
	public PainelLista() {
		init();
	}

	private void init() {
		
		modelo.addColumn("Id");
		modelo.addColumn("pressao");
		modelo.addColumn("velocidade");
		modelo.addColumn("duracao");
		modelo.addColumn("altitude");
		modelo.addColumn("rota");
		carregarDados();
		
		TitledBorder title = BorderFactory.createTitledBorder("Lista de voos");
		
		
		JScrollPane painelTabela = new JScrollPane(tabela);
		add(painelTabela);
		painelTabela.setBorder(title);
		add(lista);
		
		JPanel botoes = new JPanel();
		botoes.add(editar);
		botoes.add(apagar);
		botoes.add(carregar);
		
		add(botoes, BorderLayout.SOUTH);
		
		editar.addActionListener(this);
		carregar.addActionListener(this);
		apagar.addActionListener(this);

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
