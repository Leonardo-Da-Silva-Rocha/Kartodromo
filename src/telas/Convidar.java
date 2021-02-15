package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import projeto_bo.ConviteBo;
import projeto_bo.PilotoBo;
import projeto_bo.PilotoDoCampeonatoBo;
import projeto_entity.Campeonato;
import projeto_entity.Convite;
import projeto_entity.Piloto;
import projeto_entity.PilotoDoCampeonato;

public class Convidar extends JFrame {

	private JPanel contentPane;
	private JTextField textApelidoPiloto;
	private JTextField textNomeCidade;
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Convidar frame = new Convidar(new Campeonato(), new Piloto());
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
	public Convidar(Campeonato campeonato, Piloto piloto) {
		setTitle("Convidar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JButton btnTornarAdministrador = new JButton("Tornar administrador");
		btnTornarAdministrador.setForeground(new Color(255, 255, 0));
		btnTornarAdministrador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tornarAdm(campeonato, piloto);
				
			}
		});
		btnTornarAdministrador.setBackground(new Color(0, 0, 102));
		btnTornarAdministrador.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnTornarAdministrador.setBounds(493, 510, 234, 23);
		contentPane.add(btnTornarAdministrador);
		
		JButton btnNewButton_2 = new JButton("Convidar");
		btnNewButton_2.setForeground(new Color(255, 255, 0));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				convidar(piloto, campeonato);
			}

			
		});
		btnNewButton_2.setBackground(new Color(0, 0, 102));
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton_2.setBounds(288, 510, 141, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setForeground(new Color(255, 255, 0));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new OpcoesCampeonato1(campeonato, piloto).setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 102));
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton_1.setBounds(38, 510, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 106, 439, 377);
		contentPane.add(scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Apelido", "Data nascimento", "Cidade","ADM"
			}
		));
		scrollPane.setViewportView(table);
		
		textNomeCidade = new JTextField();
		textNomeCidade.setBounds(38, 154, 200, 20);
		contentPane.add(textNomeCidade);
		textNomeCidade.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(new Color(0, 0, 102));
		lblCidade.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblCidade.setBounds(38, 136, 104, 14);
		contentPane.add(lblCidade);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar(piloto, campeonato);
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton.setBounds(38, 200, 200, 23);
		contentPane.add(btnNewButton);
		
		textApelidoPiloto = new JTextField();
		textApelidoPiloto.setBounds(38, 106, 200, 20);
		contentPane.add(textApelidoPiloto);
		textApelidoPiloto.setColumns(10);
		
		JLabel lblConvidarPilotos = new JLabel("Convidar pilotos");
		lblConvidarPilotos.setForeground(Color.YELLOW);
		lblConvidarPilotos.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblConvidarPilotos.setBounds(268, 0, 241, 41);
		contentPane.add(lblConvidarPilotos);
		
		JLabel lblApelido = new JLabel("Apelido");
		lblApelido.setForeground(new Color(0, 0, 102));
		lblApelido.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblApelido.setBounds(38, 79, 116, 30);
		contentPane.add(lblApelido);
		
		JLabel fundo = new JLabel("fundo");
		fundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/azulmarinho.jpg")));
		fundo.setBounds(0, 0, 797, 42);
		contentPane.add(fundo);
		
		
		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(0, 0, 784, 561);
		contentPane.add(kart2);
	}
	
	public void pesquisar(Piloto pilotoParametro, Campeonato campeonato) {
		
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		try {
			
			List<Piloto> piloto = new PilotoBo().listar("pesquisarPesquisar" , this.textApelidoPiloto.getText(), this.textNomeCidade.getText(), pilotoParametro.getIdPiloto(),campeonato.getIdCampeonato()+"");
			
			
			
			for(Piloto adicionarPiloto: piloto){
				
				List<PilotoDoCampeonato> pilotoCampeonato = new PilotoDoCampeonatoBo().listar(campeonato.getIdCampeonato(), adicionarPiloto.getApelido(), 0);
				
				modelo.addRow(new Object[] {adicionarPiloto.getApelido(), adicionarPiloto.getDataNascimento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
						adicionarPiloto.getCidade().getNomeCidade(), new PilotoDoCampeonatoBo().retornarAdm(pilotoCampeonato)});
				
			}
			 
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	private void convidar(Piloto piloto, Campeonato campeonato) {
		
		if(this.table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null,"Selecione um piloto");
		}else if(this.table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null,"Selecione um piloto");
		}
		else {
			
			
			
			int linha = this.table.getSelectedRow();
			String apelidoPiloto = (String)this.table.getValueAt(linha, 0);
			Convite addConvite = new Convite();
			List<Piloto> listaPiloto = new ArrayList<>();
			
			try {
				listaPiloto = new PilotoBo().listar("selecionar", apelidoPiloto, "", 0,"");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			try {

				List<Convite> convite = new ConviteBo().listar(listaPiloto.get(0).getIdPiloto(), "verificarConvite", apelidoPiloto, campeonato.getIdCampeonato());
				
				List<PilotoDoCampeonato> pilotoCampeonato = new PilotoDoCampeonatoBo().listar(campeonato.getIdCampeonato(), piloto.getApelido(), 0);
				new PilotoDoCampeonatoBo().verificarAdm(pilotoCampeonato);
				
				new ConviteBo().verificarConvite(convite);
				
				addConvite.setCampeonato(campeonato);
				addConvite.setPiloto(listaPiloto.get(0));
				addConvite.setDataCorrida(campeonato.getDataInicio());
				addConvite.setIndicativo("Pendentes");
				
				new ConviteBo().salvarAlterar(addConvite);
				
				JOptionPane.showMessageDialog(null, "Convite enviado com sucesso");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}

	}
	
	public void tornarAdm(Campeonato campeonato, Piloto pilotoParametro) {
		
		if(this.table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null,"Selecione um piloto");
		}else if(this.table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null,"Selecione um piloto");
		}
		else {
			
			int linha = this.table.getSelectedRow();
			String apelidoPiloto = (String)this.table.getValueAt(linha, 0);
			List<Piloto> piloto = new ArrayList<>();
			
			try {
				piloto = new PilotoBo().listar("selecionar", apelidoPiloto, "", 0,"");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			
			try {
				
				List<PilotoDoCampeonato> pilotoCampeonato = new PilotoDoCampeonatoBo().listar(campeonato.getIdCampeonato(), "campeonatopiloto", piloto.get(0).getIdPiloto());
				
				List<PilotoDoCampeonato> verificarAdm = new PilotoDoCampeonatoBo().listar(campeonato.getIdCampeonato(), pilotoParametro.getApelido(), 0);
				new PilotoDoCampeonatoBo().verificarAdm(verificarAdm);
				
				new PilotoDoCampeonatoBo().tornarAdm(pilotoCampeonato);
				pilotoCampeonato.get(0).setAdm(true);
				new PilotoDoCampeonatoBo().SalvarAlterar(pilotoCampeonato.get(0), false, false, false, false,0, null);
				JOptionPane.showMessageDialog(null, piloto.get(0).getApelido()+" agora é adiministrador do campeonato "+pilotoCampeonato.get(0).getCampeonato().getNomeCampeonato());
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		
		}
		
	}
	
}
