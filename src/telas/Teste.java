package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;

public class Teste extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
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
	public Teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 556);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(0, 0, 819, 519);
		contentPane.add(tabbedPane);
		
		JFormattedTextField txtData = null;
		JPanel panel = new JPanel();
		tabbedPane.addTab("Campeonato", null, panel, null);
		panel.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 45, 186, 20);
		panel.add(textField_2);
		
		JLabel lblNomeDoCampeonato = new JLabel("Nome");
		lblNomeDoCampeonato.setForeground(new Color(0, 0, 102));
		lblNomeDoCampeonato.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNomeDoCampeonato.setBounds(10, 25, 61, 14);
		panel.add(lblNomeDoCampeonato);
		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		txtData.setColumns(10);
		txtData.setBounds(10, 96, 125, 19);
		panel.add(txtData);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 75, 53, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Puni\u00E7\u00E3o falta");
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_2.setBounds(79, 209, 162, 13);
		panel.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setColumns(10);
		textField_3.setBounds(79, 222, 81, 19);
		panel.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pontua\u00E7\u00E3o poli");
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_4.setBounds(79, 256, 147, 13);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setColumns(10);
		textField_4.setBounds(79, 279, 81, 19);
		panel.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pontua\u00E7\u00E3o VR");
		lblNewLabel_5.setForeground(new Color(0, 0, 102));
		lblNewLabel_5.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_5.setBounds(78, 308, 277, 13);
		panel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setColumns(10);
		textField_5.setBounds(79, 331, 81, 19);
		panel.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pontua\u00E7\u00E3o ML");
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_6.setBounds(79, 161, 239, 13);
		panel.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setColumns(10);
		textField_6.setBounds(79, 184, 81, 19);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(439, 45, 125, 19);
		panel.add(textField_7);
		
		JLabel lblNewLabel_1 = new JLabel("Total corridas");
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_1.setBounds(442, 28, 134, 13);
		panel.add(lblNewLabel_1);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.YELLOW);
		btnSalvar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnSalvar.setBackground(new Color(0, 0, 102));
		btnSalvar.setBounds(439, 110, 147, 21);
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Convite", null, panel_1, null);
		
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(31, 159, 143, 124);
		panel_1.add(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(104, 64, 96, 19);
		panel_1.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("Apelido Do Piloto");
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setBounds(10, 67, 86, 13);
		panel_1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 93, 96, 19);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Cidade Do Piloto");
		lblNewLabel_3_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_3_1.setBounds(10, 96, 86, 13);
		panel_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.setBounds(169, 133, 134, 21);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Pontua\u00E7\u00E3o", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNomeCampeonato = new JLabel("Nome campeonato: <dynamic>");
		lblNomeCampeonato.setForeground(Color.YELLOW);
		lblNomeCampeonato.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNomeCampeonato.setBounds(40, 46, 318, 14);
		panel_2.add(lblNomeCampeonato);
		
		JLabel lblData = new JLabel("Data inicio: <dynamic>");
		lblData.setForeground(Color.YELLOW);
		lblData.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblData.setBounds(354, 62, 213, 14);
		panel_2.add(lblData);
		
		JLabel lblTotalCorridas = new JLabel("Total corridas: 0");
		lblTotalCorridas.setForeground(Color.YELLOW);
		lblTotalCorridas.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblTotalCorridas.setBounds(57, 99, 166, 14);
		panel_2.add(lblTotalCorridas);
		
		JLabel lblPosicao = new JLabel("Posi\u00E7\u00E3o");
		lblPosicao.setForeground(Color.YELLOW);
		lblPosicao.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblPosicao.setBounds(563, 137, 96, 14);
		panel_2.add(lblPosicao);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(563, 157, 156, 20);
		panel_2.add(textField_8);
		
		JLabel lblPontuacao = new JLabel("Pontua\u00E7\u00E3o");
		lblPontuacao.setForeground(Color.YELLOW);
		lblPontuacao.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblPontuacao.setBounds(563, 195, 96, 14);
		panel_2.add(lblPontuacao);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(563, 219, 156, 20);
		panel_2.add(textField_9);
		
		
		JLabel kart2= new JLabel("New label");
		kart2.setBounds(0, -14, 825, 506);
		kart2.setIcon(new ImageIcon(CriarCampeonato1.class.getResource("/telas/kart2.jpg")));
		panel.add(kart2);
		
	}
}
