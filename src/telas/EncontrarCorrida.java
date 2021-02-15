package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projeto_bo.BateriaBo;
import projeto_bo.CampeonatoBo;
import projeto_bo.PilotoDoCampeonatoBo;
import projeto_entity.Bateria;
import projeto_entity.Campeonato;
import projeto_entity.Piloto;
import projeto_entity.PilotoDoCampeonato;

public class EncontrarCorrida extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeCampeonato;
	private JTextField textData;
	private final JTable table = new JTable();
	private Bateria bateria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncontrarCorrida frame = new EncontrarCorrida(new Campeonato(), new Piloto());
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
	public EncontrarCorrida(Campeonato campeonato, Piloto piloto) {
		setTitle("Pesquisar bateria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		bateria = new Bateria();
		
		JButton btnNewButton_1 = new JButton("voltar");
		btnNewButton_1.setForeground(new Color(255, 255, 0));
		btnNewButton_1.setBackground(new Color(0, 0, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OpcoesCampeonato1(new Campeonato(), piloto).setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 pesquisar();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Classifica\u00E7\u00E3o");
		btnNewButton_2.setForeground(new Color(255, 255, 0));
		btnNewButton_2.setBackground(new Color(0, 0, 102));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				selecinarBateria();
				ClassificacaoBateria(piloto);
			}
		});
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton_2.setBounds(201, 500, 246, 21);
		contentPane.add(btnNewButton_2);
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton.setBounds(10, 196, 171, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Salvar Resultado");
		btnNewButton_1_1.setForeground(new Color(255, 255, 0));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecinarBateria();
				Salvar(campeonato, piloto, bateria);
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton_1_1.setBackground(new Color(0, 0, 102));
		btnNewButton_1_1.setBounds(457, 499, 291, 23);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton_1.setBounds(10, 499, 171, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(201, 91, 547, 381);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome Campeonato", "Nome Kartdromo", "Data", "Hora", "Indicativo"
				}
			));
		
		textData = new JTextField();
		textData.setBounds(10, 166, 171, 20);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblDataDaBateria = new JLabel("Data da bateria");
		lblDataDaBateria.setForeground(new Color(0, 0, 102));
		lblDataDaBateria.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblDataDaBateria.setBounds(10, 152, 156, 14);
		contentPane.add(lblDataDaBateria);
		
		textNomeCampeonato = new JTextField();
		textNomeCampeonato.setBounds(10, 111, 171, 20);
		contentPane.add(textNomeCampeonato);
		textNomeCampeonato.setColumns(10);
		
		JLabel lblNomeCampeonato = new JLabel("Nome campeonato");
		lblNomeCampeonato.setForeground(new Color(0, 0, 102));
		lblNomeCampeonato.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNomeCampeonato.setBounds(10, 91, 185, 22);
		contentPane.add(lblNomeCampeonato);
		
		JLabel lblPesquisarBateria = new JLabel("Pesquisar bateria");
		lblPesquisarBateria.setForeground(Color.YELLOW);
		lblPesquisarBateria.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblPesquisarBateria.setBounds(262, 0, 309, 42);
		contentPane.add(lblPesquisarBateria);
		
		
		

		JLabel fundo = new JLabel("fundo");
		fundo.setIcon(new ImageIcon(EncontrarCorrida.class.getResource("/telas/azulmarinho.jpg")));
		fundo.setBounds(0, 0, 797, 42);
		contentPane.add(fundo);
		
		
		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(EncontrarCorrida.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(0, 0, 784, 561);
		contentPane.add(kart2);
	}
	
	public void pesquisar() {
	
		DefaultTableModel modelo =(DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		List<Bateria> listaBateria = new ArrayList<>();
		
		try {
			listaBateria = new BateriaBo().listar("listaCampeonato", this.textNomeCampeonato.getText(),null, this.textData.getText(), 0, null);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}


		for(Bateria bateria :listaBateria) {
			modelo.addRow(new Object[]{bateria.getCampeonato().getNomeCampeonato(), bateria.getKartodromo().getNome(),
					bateria.getData().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
					bateria.getHora().toString(),bateria.getStatus()});
		}
	}
	
	
	public void Salvar(Campeonato campeonatoParametro,Piloto piloto, Bateria bateria) {
		
		if(table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione uma bateria");
		}else if(table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione uma bateria");
			
		}else {
			
			int linha = table.getSelectedRow();
			String status =  (String)table.getValueAt(linha, 4);
			if(status.equals("encerrada")) {
				JOptionPane.showMessageDialog(null, "Bateria encerrada impossivel salvar o resultado novamente");
			}
			else {
				
				String nomeCampeonato = (String)table.getValueAt(linha, 0);
				List<Campeonato> campeonato = new ArrayList<>();
				try {
					campeonato = new CampeonatoBo().listar(0, "aceitar", nomeCampeonato, null, "");
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				try {
					
					List<PilotoDoCampeonato> pilotoCampeonato = new PilotoDoCampeonatoBo().listar(campeonato.get(0).getIdCampeonato(), "campeonatopiloto" ,piloto.getIdPiloto());
					
					new PilotoDoCampeonatoBo().verificarAdm(pilotoCampeonato);
					dispose();
					new InfResultCorridasCamp1(campeonato.get(0), piloto, bateria).setVisible(true); 
				
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
			
		}
		
	}
	
	public void selecinarBateria() {
		 
		if(table.getRowCount() != 0 && table.getSelectedRowCount() != 0) {
			
			int linha = table.getSelectedRow();
			String data = table.getValueAt(linha, 2).toString();
			String hora = table.getValueAt(linha, 3).toString();
			String nomeKartodromo = table.getValueAt(linha, 1).toString();
			
			DateTimeFormatter formatador =DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			this.bateria.setData(LocalDate.parse(data.replaceAll("/","-"),formatador));
			this.bateria.setHora(LocalTime.parse(hora));
			
			try {
				
				List<Bateria> bateria = new BateriaBo().listar(nomeKartodromo, "resultadoBateria", LocalDate.parse(data.replaceAll("/","-"),formatador), hora, 0, this.bateria);
				this.bateria.setIdBateria(bateria.get(0).getIdBateria());
				this.bateria.setCampeonato(bateria.get(0).getCampeonato());
				this.bateria.setKartodromo(bateria.get(0).getKartodromo());
				
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
	}
	
	public void ClassificacaoBateria(Piloto piloto) {
		
		if(table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione uma bateria");
		}else if(table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione uma bateria");
			
		}else {
			
			int linha = table.getSelectedRow();
			String status =  (String)table.getValueAt(linha, 4);
			if(status.equals("ativo")) {
				JOptionPane.showMessageDialog(null, "Selecione uma bateria encerrada");
			}
			else {
				
				new ClassificacaoBaterias(this.bateria, piloto).setVisible(true);
				
			}
			
		}
		
	}
}	