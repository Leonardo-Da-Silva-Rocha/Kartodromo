package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projeto_bo.PilotoDaBateriaBo;
import projeto_entity.Bateria;
import projeto_entity.Campeonato;
import projeto_entity.Piloto;
import projeto_entity.PilotoDaBateria;

public class ClassificacaoBaterias extends JFrame {

	private JPanel contentPane;
	private final JTable tabelaClassificacao = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassificacaoBaterias frame = new ClassificacaoBaterias(new Bateria(), new Piloto());
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
	public ClassificacaoBaterias(Bateria bateria, Piloto piloto) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EncontrarCorrida(new Campeonato(), piloto).setVisible(true);
			}
		});
		btnVoltar.setForeground(new Color(255, 255, 0));
		btnVoltar.setBackground(new Color(0, 0, 102));
		btnVoltar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnVoltar.setBounds(24, 527, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblDataBateria = new JLabel("Data bateria:");
		lblDataBateria.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblDataBateria.setForeground(new Color(0, 0, 102));
		lblDataBateria.setBounds(410, 73, 191, 15);
		contentPane.add(lblDataBateria);
		
		JLabel lblNomeCampeonato = new JLabel("Nome campeonato:");
		lblNomeCampeonato.setForeground(new Color(0, 0, 102));
		lblNomeCampeonato.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNomeCampeonato.setBounds(24, 70, 356, 20);
		contentPane.add(lblNomeCampeonato);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 114, 737, 395);
		contentPane.add(scrollPane);
		tabelaClassificacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tabelaClassificacao);
		tabelaClassificacao.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Apelido piloto", "Posição" , "Pole position", "Volta mais r\u00E1pida", "Mais lidere\u00E7a"
			}
		));
		
		JLabel lblClassificaoBateria = new JLabel("Classifica\u00E7\u00E3o bateria");
		lblClassificaoBateria.setForeground(Color.YELLOW);
		lblClassificaoBateria.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblClassificaoBateria.setBounds(248, 0, 287, 41);
		contentPane.add(lblClassificaoBateria);
		
		JLabel fundo = new JLabel("fundo");
		fundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/azulmarinho.jpg")));
		fundo.setBounds(0, 0, 797, 42);
		contentPane.add(fundo);
		
		
		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(0, 0, 784, 561);
		contentPane.add(kart2);
		
		
		
		carregarTabela(bateria);
	}
	
	public void carregarTabela(Bateria bateria) {
		
		DefaultTableModel modelo = (DefaultTableModel)this.tabelaClassificacao.getModel();
		modelo.setRowCount(0);
		this.tabelaClassificacao.setModel(modelo);
		
		try {
			List<PilotoDaBateria> listaBateria = new PilotoDaBateriaBo().listar("classificacao", bateria.getIdBateria(), null);
			
			for(PilotoDaBateria piloto : listaBateria) {
				modelo.addRow(new Object[] {piloto.getPiloto().getApelido(), piloto.getColocacao()+"°",new PilotoDaBateriaBo().verificarPole(piloto),
						new PilotoDaBateriaBo().verificarVoltaMaisRapida(piloto),
						new PilotoDaBateriaBo().verificarMaisLideranca(piloto)});
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}
}
