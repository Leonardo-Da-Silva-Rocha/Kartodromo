package telas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projeto_bo.CampeonatoBo;
import projeto_bo.PilotoDoCampeonatoBo;
import projeto_entity.Campeonato;
import projeto_entity.Piloto;
import projeto_entity.PilotoDoCampeonato;

public class EncontrarCampeonatoSalvarBateria extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDataInicial;
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncontrarCampeonato1 frame = new EncontrarCampeonato1(new Campeonato(),new Piloto());
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
	public EncontrarCampeonatoSalvarBateria(Campeonato campeonato, Piloto piloto) {
		setTitle("Encontrar campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JButton btnAvancar = new JButton("Adicionar Bateria");
		btnAvancar.setForeground(new Color(255, 255, 0));
		btnAvancar.setBackground(new Color(0, 0, 102));
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAvancar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnAvancar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				avancar(piloto);
			}
		});
		btnAvancar.setBounds(546, 530, 230, 22);
		contentPane.add(btnAvancar);
		
		JLabel lblEncontrarCampeonato = new JLabel("Encontrar campeonato");
		lblEncontrarCampeonato.setForeground(Color.YELLOW);
		lblEncontrarCampeonato.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblEncontrarCampeonato.setBounds(246, 0, 311, 42);
		contentPane.add(lblEncontrarCampeonato);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNome.setForeground(new Color(0, 0, 102));
		lblNome.setBounds(20, 71, 78, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 88, 224, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDataInicial = new JLabel("Data inicial");
		lblDataInicial.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblDataInicial.setForeground(new Color(0, 0, 102));
		lblDataInicial.setBounds(20, 131, 163, 17);
		contentPane.add(lblDataInicial);
		
		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(20, 147, 224, 20);
		contentPane.add(txtDataInicial);
		txtDataInicial.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 193, 492, 327);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Campeonato"
				}
			));
		
		JButton btnVisualizarCampeonato = new JButton("Pesquisar");
		btnVisualizarCampeonato.setForeground(new Color(255, 255, 0));
		btnVisualizarCampeonato.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnVisualizarCampeonato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar();
			}
		});
		btnVisualizarCampeonato.setBounds(269, 88, 175, 23);
		btnVisualizarCampeonato.setBackground(new Color(0, 0, 102));
		contentPane.add(btnVisualizarCampeonato);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 0));
		btnVoltar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new OpcoesCampeonato1(campeonato,piloto).setVisible(true);
			}
		});
		btnVoltar.setBounds(20, 530, 89, 23);
		btnVoltar.setBackground(new Color(0, 0, 102));
		contentPane.add(btnVoltar);
		
		JLabel fundo = new JLabel("fundo");
		fundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/azulmarinho.jpg")));
		fundo.setBounds(0, 0, 797, 42);
		contentPane.add(fundo);
		
		
		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(0, 0, 784, 561);
		contentPane.add(kart2);
		
	}
	
	
	public void pesquisar() {
		
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		List<Campeonato> lista = new ArrayList<Campeonato>();
		
		try {
			
			if(this.txtNome.getText().equals("") == false) {
				lista = new CampeonatoBo().listar(0, "nome", this.txtNome.getText(), null,  "ATIVO");
			}
			else if(this.txtDataInicial.getText().equals("") == false) {
				lista = new CampeonatoBo().listar(0,"data", "", LocalDate.parse(this.txtDataInicial.getText().replaceAll("/", "-"),formatar),  "ATIVO");
			}
			else {
				lista = new CampeonatoBo().listar(0, "ativoouencerrado","", null,  "ATIVO");
			}
			
			
			
			for(Campeonato campeonato : lista) {
				modelo.addRow(new Object[] {campeonato.getNomeCampeonato()});
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}

	public void avancar(Piloto piloto) {
	
		if(this.table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null,"Nenhum Campeonato selecionado");
		}else if(this.table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null,"Nenhum Campeonato selecionado");
		}
		else {
			
			int linha = this.table.getSelectedRow();
			String nomeCampeonato = (String)this.table.getValueAt(linha, 0);
			List<Campeonato>  lista = new ArrayList<>();
			
			try {
				
				lista = new CampeonatoBo().listar(0, "aceitar", nomeCampeonato, null, "");
	
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			

			
			try {
				
				List<PilotoDoCampeonato> pilotoCampeonato = new PilotoDoCampeonatoBo().listar(lista.get(0).getIdCampeonato(),"campeonatopiloto", piloto.getIdPiloto());
				
				new PilotoDoCampeonatoBo().verificarAdm(pilotoCampeonato);
				
				dispose();
				new CadastrarBateria1(piloto, lista.get(0)).setVisible(true);
				
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		
	}
	
	
	
  }
}
