package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projeto_bo.BateriaBo;
import projeto_entity.Bateria;
import projeto_entity.Campeonato;
import projeto_entity.Piloto;

public class Baterias extends JFrame {

	private JPanel contentPane;
	private final JTable tabelaBateria = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Baterias frame = new Baterias(new Piloto(), new Campeonato());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Baterias(Piloto piloto, Campeonato campeonato) {
		setTitle("Baterias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OpcoesCampeonato1(campeonato, piloto).setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Apelido:" + piloto.getApelido());
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel.setBounds(39, 65, 203, 25);
		contentPane.add(lblNewLabel);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton.setBounds(39, 517, 113, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 100, 692, 386);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tabelaBateria);
		tabelaBateria.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Campeonato", "Data", "Hora", "Kartodromo", "Cidade", "Endereço"
				}
			));
		
		JLabel lblNewLabel_1 = new JLabel("Baterias");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(337, 1, 123, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel fundo = new JLabel("fundo");
		fundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/azulmarinho.jpg")));
		fundo.setBounds(0, 0, 797, 42);
		contentPane.add(fundo);
		
		
		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(0, 0, 784, 561);
		contentPane.add(kart2);
		
		carregarTabela(piloto);
	}
	
	public void carregarTabela(Piloto piloto) {
		
		List<Bateria> pilotoBateria = new ArrayList<>();
		
		try {
			
			
			pilotoBateria = new BateriaBo().listar("","baterias", null, null,piloto.getIdPiloto(), null);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		DefaultTableModel modelo = (DefaultTableModel)this.tabelaBateria.getModel();
		modelo.setRowCount(0);
		tabelaBateria.setModel(modelo);
		
		for(Bateria bateria : pilotoBateria) {
			
			modelo.addRow(new Object[] {bateria.getCampeonato().getNomeCampeonato(), bateria.getData(), bateria.getHora(), bateria.getKartodromo().getNome(),
					bateria.getKartodromo().getCidade().getNomeCidade(), bateria.getKartodromo().getRua()});
		}
		
	}
}
