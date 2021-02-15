package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projeto_bo.PontosBo;
import projeto_entity.Campeonato;
import projeto_entity.Piloto;
import projeto_entity.Pontos;
import javax.swing.JScrollPane;

public class CadastrarPontuacao extends JFrame {

	private JPanel contentPane;
	private final JTable table = new JTable();
	private JTextField txtPosicao;
	private JTextField txtPontuacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPontuacao frame = new CadastrarPontuacao(new Piloto(), new Campeonato());
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
	public CadastrarPontuacao(Piloto piloto, Campeonato campeonato) {
		setTitle("Salvar pontua\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JButton btnAnvancar = new JButton("Finalizar");
		btnAnvancar.setForeground(new Color(255, 255, 0));
		btnAnvancar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnAnvancar.setBackground(new Color(0, 0, 102));
		btnAnvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OpcoesCampeonato1(new Campeonato(), piloto).setVisible(true);
			}
		});
		
		JButton btnCadastrar = new JButton("Salvar");
		btnCadastrar.setForeground(new Color(255, 255, 0));
		btnCadastrar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar(campeonato);
				listar(campeonato);
			}
		});
		btnCadastrar.setBackground(new Color(0, 0, 102));
		btnCadastrar.setVisible(true);
		btnCadastrar.setBounds(586, 333, 156, 23);
		contentPane.add(btnCadastrar);
		btnAnvancar.setBounds(586, 514, 156, 23);
		contentPane.add(btnAnvancar);
		
		JLabel lblTitulo = new JLabel("Salvar pontua\u00E7\u00E3o do campeonato");
		lblTitulo.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblTitulo.setBounds(148, 0, 549, 42);
		lblTitulo.setForeground(Color.YELLOW);
		contentPane.add(lblTitulo);
		
		JLabel lblNomeCampeonato = new JLabel("Nome campeonato: " +campeonato.getNomeCampeonato());
		lblNomeCampeonato.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNomeCampeonato.setBounds(25, 109, 318, 14);
		lblNomeCampeonato.setForeground(new Color(0, 0, 102));
		contentPane.add(lblNomeCampeonato);
		
		JLabel lblData = new JLabel("Data inicio: "+campeonato.getDataInicio().toString());
		lblData.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
				
		lblData.setBounds(340, 109, 213, 14);
		lblData.setForeground(new Color(0, 0, 102));
		contentPane.add(lblData);
		
		JLabel lblTotalCorridas = new JLabel("Total corridas: "+campeonato.getTotalCorridas()+"");
		lblTotalCorridas.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblTotalCorridas.setBounds(586, 109, 166, 14);
		lblTotalCorridas.setForeground(new Color(0, 0, 102));
		contentPane.add(lblTotalCorridas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 167, 532, 370);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Colocação", "Pontuação"
			}
		));
		
		JLabel lblPosicao = new JLabel("Posi\u00E7\u00E3o");
		lblPosicao.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblPosicao.setBounds(586, 167, 96, 14);
		lblPosicao.setForeground(new Color(0, 0, 102));
		contentPane.add(lblPosicao);
		
		txtPosicao = new JTextField();
		txtPosicao.setBounds(586, 182, 156, 20);
		contentPane.add(txtPosicao);
		txtPosicao.setColumns(10);
		
		JLabel lblPontuacao = new JLabel("Pontua\u00E7\u00E3o");
		lblPontuacao.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblPontuacao.setBounds(586, 244, 96, 14);
		lblPontuacao.setForeground(new Color(0, 0, 102));
		contentPane.add(lblPontuacao);
		
		txtPontuacao = new JTextField();
		txtPontuacao.setBounds(586, 259, 156, 20);
		contentPane.add(txtPontuacao);
		txtPontuacao.setColumns(10);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon(CadastrarPontuacao.class.getResource("/telas/azulmarinho.jpg")));
		lblNewLabel1.setBounds(0, 0, 797, 42);
		contentPane.add(lblNewLabel1);
		
		
		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(0, 0, 784, 561);
		contentPane.add(kart2);
		
	}
	
	public void salvar(Campeonato campeonato) {
		
		Pontos pontos = new Pontos();
		pontos.setCampeonato(campeonato);
		pontos.setColocacao(Integer.parseInt(txtPosicao.getText()));
		pontos.setPontuacao(Double.parseDouble(txtPontuacao.getText()));
		
		try {
			
			List<Pontos> lis = new PontosBo().listar(campeonato.getIdCampeonato());
			String resultado = new PontosBo().salvar(pontos, lis, Integer.parseInt(txtPosicao.getText()) ,Integer.parseInt(txtPontuacao.getText()));
			JOptionPane.showMessageDialog(null, resultado);
			
		}
		catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public void listar(Campeonato campeonato) {
		
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		try {
			
			List<Pontos> lista = new PontosBo().listar(campeonato.getIdCampeonato());
			
			for(Pontos p : lista) {
				
				modelo.addRow(new Object[] {p.getColocacao()+"°", p.getPontuacao()});
				
			}
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}