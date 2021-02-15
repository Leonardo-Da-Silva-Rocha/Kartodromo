package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import projeto_bo.BateriaBo;
import projeto_bo.PilotoDoCampeonatoBo;
import projeto_entity.Bateria;
import projeto_entity.Kartodromo;
import projeto_entity.PilotoDoCampeonato;

public class KartodromoHorarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeADM;
	private JFormattedTextField dataInicio;
	private final JTable tabelaBateria = new JTable();
	private Bateria bateria;
	private JTextField txtNomecampeonato;
	private final JTable tabelaPiloto = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KartodromoHorarios frame = new KartodromoHorarios(new Kartodromo());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KartodromoHorarios(Kartodromo kart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		this.bateria = new Bateria();
		
		try {
			dataInicio = new JFormattedTextField(new MaskFormatter("##/##/####"));
			dataInicio.setHorizontalAlignment(SwingConstants.CENTER);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnVerificarPilotosDa = new JButton("Verificar Pilotos");
		btnVerificarPilotosDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verificarPiloto(kart);
			}
		});
		btnVerificarPilotosDa.setForeground(Color.YELLOW);
		btnVerificarPilotosDa.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnVerificarPilotosDa.setBackground(new Color(0, 0, 102));
		btnVerificarPilotosDa.setBounds(10, 329, 265, 23);
		contentPane.add(btnVerificarPilotosDa);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(335, 332, 410, 221);
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(tabelaPiloto);
		tabelaPiloto.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Apelido", "Nome", "Telefone", "CPF"
				}
			));
		
		JLabel lblBaterias = new JLabel("Baterias");
		lblBaterias.setForeground(new Color(0, 0, 102));
		lblBaterias.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblBaterias.setBounds(334, 81, 215, 14);
		contentPane.add(lblBaterias);
		
		txtNomecampeonato = new JTextField();
		txtNomecampeonato.setBounds(10, 236, 265, 19);
		contentPane.add(txtNomecampeonato);
		txtNomecampeonato.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new LoginKartodromo().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnVoltar.setBackground(new Color(0, 0, 102));
		btnVoltar.setForeground(Color.YELLOW);
		btnVoltar.setBounds(10, 530, 113, 23);
		contentPane.add(btnVoltar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar(kart);
			}
		});
		btnPesquisar.setBackground(new Color(0, 0, 102));
		btnPesquisar.setForeground(new Color(255, 255, 0));
		btnPesquisar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnPesquisar.setBounds(10, 281, 265, 23);
		contentPane.add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(335, 96, 410, 208);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tabelaBateria);
		tabelaBateria.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Campeonato", "Data", "Hora", "Piloto", "CPF do piloto"
				}
			));
		
		JLabel lblNewLabel_1 = new JLabel("Nome do campeonato");
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 216, 215, 14);
		contentPane.add(lblNewLabel_1);
		dataInicio.setBounds(10, 167, 265, 20);
		contentPane.add(dataInicio);
		dataInicio.setColumns(10);
		
		JLabel lblDataDeInicio = new JLabel("Data de inicio do campeonato");
		lblDataDeInicio.setForeground(new Color(0, 0, 102));
		lblDataDeInicio.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblDataDeInicio.setBounds(10, 151, 277, 14);
		contentPane.add(lblDataDeInicio);
		
		txtNomeADM = new JTextField();
		txtNomeADM.setBounds(10, 109, 265, 20);
		contentPane.add(txtNomeADM);
		txtNomeADM.setColumns(10);
		
		JLabel lblNomeAdmCampeonato = new JLabel("Apelido ADM campeonato");
		lblNomeAdmCampeonato.setForeground(new Color(0, 0, 102));
		lblNomeAdmCampeonato.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNomeAdmCampeonato.setBounds(10, 94, 227, 14);
		contentPane.add(lblNomeAdmCampeonato);
		
		JLabel lblNewLabel = new JLabel("Hor\u00E1rios agendados");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(249, -5, 277, 42);
		contentPane.add(lblNewLabel);
		
		JLabel fundo = new JLabel("fundo");
		fundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/azulmarinho.jpg")));
		fundo.setBounds(0, 0, 784, 42);
		contentPane.add(fundo);
		
		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(5, 5, 774, 551);
		contentPane.add(kart2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(180, 395, 45, 13);
		contentPane.add(label);
	}
	
	public void pesquisar(Kartodromo kartodormo) {
		
		DefaultTableModel modelo = (DefaultTableModel)this.tabelaBateria.getModel();
		modelo.setRowCount(0);
		tabelaBateria.setModel(modelo);
		
		this.bateria.setData(new BateriaBo().converterData(this.dataInicio.getText()));

		try {
			
			List<Bateria> lista = new BateriaBo().listar("pesquisaKartodormo", this.txtNomecampeonato.getText(), null, this.txtNomeADM.getText(), kartodormo.getIdKartodromo(), this.bateria);
			for(Bateria bateria :lista) {
				modelo.addRow(new Object[] {bateria.getCampeonato().getNomeCampeonato(), bateria.getData().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)), bateria.getHora(), bateria.getPilotoCriador().getApelido(),
						bateria.getPilotoCriador().getCpf()});
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	public void verificarPiloto(Kartodromo kartodromo) {
		
		if (tabelaBateria.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione uma bateria");			
		}				
		else if (tabelaBateria.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "selecione uma bateria");
		}
		else {
			
			DefaultTableModel modelo = (DefaultTableModel)this.tabelaPiloto.getModel();
			modelo.setRowCount(0);
			tabelaPiloto.setModel(modelo);
			
			List<Bateria> lista = new ArrayList<>();
			
			int linha = tabelaBateria.getSelectedRow();
			String data = tabelaBateria.getValueAt(linha, 1).toString();
			String hora = tabelaBateria.getValueAt(linha, 2).toString();
			
			this.bateria.setData(new BateriaBo().converterData(data));
			this.bateria.setHora(LocalTime.parse(hora));
			
			try {
				
				lista = new BateriaBo().listar(kartodromo.getNome(), "resultadoBateria", null, null, 0, this.bateria);
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			try {
				
				List<PilotoDoCampeonato> listaPiloto = new PilotoDoCampeonatoBo().listar(lista.get(0).getCampeonato().getIdCampeonato(), "listar", 0);
				
					for(PilotoDoCampeonato piloto : listaPiloto) {
						modelo.addRow(new Object[] {piloto.getPiloto().getApelido(), piloto.getPiloto().getNome(), piloto.getPiloto().getCelular(),
								piloto.getPiloto().getCpf()});
					}
					
				
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}
		
	}
}
