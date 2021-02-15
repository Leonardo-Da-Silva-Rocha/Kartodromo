package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import projeto_bo.CidadeBo;
import projeto_bo.PilotoBo;
import projeto_entity.Cidade;
import projeto_entity.Kartodromo;
import projeto_entity.Piloto;

public class CadastroPiloto extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JFormattedTextField txtcpf;
	private JFormattedTextField txtDataNasc;
	private JFormattedTextField txtTelefone;
	private JTextField txtemail;
	private Piloto piloto;
	private JTextField textApelido;
	private JTextField textSenha;
	private JTextField textConfirmarSenha;
	private JComboBox comboBox;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPiloto frame = new CadastroPiloto(new Piloto());
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
	 * @throws ParseException 
	 */
	public CadastroPiloto(Piloto pilotoParametro) throws ParseException {
		setTitle("Salvar piloto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		 
		piloto = new Piloto();
		
		JButton btnAvancar = new JButton("Salvar");
		btnAvancar.setForeground(new Color(255, 255, 0));
		btnAvancar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnAvancar.setBackground(new Color(0, 0, 102));
		btnAvancar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				salvar();
			}
		});
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Logar().setVisible(true);;
			}
		});
		 
		 textConfirmarSenha = new JPasswordField();
		 textConfirmarSenha.setBounds(524, 195, 188, 19);
		 contentPane.add(textConfirmarSenha);
		 textConfirmarSenha.setColumns(10);
		 
		 JLabel lblConfirmar = new JLabel("Confirmar Senha");
		 lblConfirmar.setForeground(new Color(0, 0, 102));
		 lblConfirmar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		 lblConfirmar.setBounds(524, 179, 188, 14);
		 contentPane.add(lblConfirmar);
		 
		 textSenha = new JPasswordField();
		 textSenha.setBounds(524, 145, 188, 19);
		 contentPane.add(textSenha);
		 textSenha.setColumns(10);
		 
		 JLabel lblSenha = new JLabel("Senha");
		 lblSenha.setForeground(new Color(0, 0, 102));
		 lblSenha.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		 lblSenha.setBounds(524, 128, 72, 14);
		 contentPane.add(lblSenha);
		 
		 textApelido = new JTextField();
		 textApelido.setBounds(524, 99, 188, 19);
		 contentPane.add(textApelido);
		 textApelido.setColumns(10);
		 
		 JLabel lblApelido = new JLabel("Apelido");
		 lblApelido.setForeground(new Color(0, 0, 102));
		 lblApelido.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		 lblApelido.setBounds(524, 82, 72, 14);
		 contentPane.add(lblApelido);
		 
		 JButton AdicionarCidade = new JButton();
		 AdicionarCidade.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 AdicionarCidade.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		SalvarAtributosTemporarios();
		 		dispose();
		 		new Cidade1(piloto).setVisible(true);
		 	}
		 });
		 AdicionarCidade.setForeground(Color.WHITE);
		 AdicionarCidade.setIcon(new ImageIcon(CadastroPiloto.class.getResource("/telas/mais.png")));
		 AdicionarCidade.setBounds(202, 332, 26, 21);
		 contentPane.add(AdicionarCidade);
		 
		 comboBox = new JComboBox();
		 comboBox.setBounds(12, 332, 180, 21);
		 contentPane.add(comboBox);
		 
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(new Color(0, 0, 102));
		lblCidade.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblCidade.setBounds(12, 318, 72, 14);
	    contentPane.add(lblCidade);
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton.setBounds(12, 532, 99, 21);
		contentPane.add(btnNewButton);
		btnAvancar.setBounds(524, 239, 188, 23);
		contentPane.add(btnAvancar);
		
		JLabel lblCadastrarPiloto = new JLabel("Salvar novo piloto");
		lblCadastrarPiloto.setForeground(Color.YELLOW);
		lblCadastrarPiloto.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblCadastrarPiloto.setBounds(284, 0, 255, 45);
		contentPane.add(lblCadastrarPiloto);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNome.setForeground(new Color(0, 0, 102));
		lblNome.setBounds(12, 82, 70, 14);
		contentPane.add(lblNome);
		
		txtnome = new JTextField();
		txtnome.setBounds(12, 99, 216, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblCpf.setForeground(new Color(0, 0, 102));
		lblCpf.setBounds(12, 128, 48, 14);
		contentPane.add(lblCpf);
		
		txtcpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtcpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtcpf.setBounds(12, 145, 216, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data de nascimento");
		lblDataNascimento.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblDataNascimento.setForeground(new Color(0, 0, 102));
		lblDataNascimento.setBounds(12, 179, 188, 14);
		contentPane.add(lblDataNascimento);
		
		txtDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtDataNasc.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataNasc.setBounds(12, 195, 216, 20);
		contentPane.add(txtDataNasc);
		txtDataNasc.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblTelefone.setForeground(new Color(0, 0, 102));
		lblTelefone.setBounds(12, 229, 119, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		txtTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		txtTelefone.setBounds(12, 243, 216, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblEmail.setForeground(new Color(0, 0, 102));
		lblEmail.setBounds(12, 273, 72, 14);
		contentPane.add(lblEmail);
		
		txtemail = new JTextField();
		txtemail.setHorizontalAlignment(SwingConstants.LEFT);
		txtemail.setBounds(12, 288, 216, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroPiloto.class.getResource("/telas/azulmarinho.jpg")));
		lblNewLabel.setBounds(0, 0, 797, 42);
		contentPane.add(lblNewLabel);
		
		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(CadastroPiloto.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(0, 0, 784, 561);
		contentPane.add(kart2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(130, 261, 45, 13);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(523, 315, 45, 13);
		contentPane.add(label_1);
		
		carregarCombo();
		carregarAtributosPiloto(pilotoParametro);
		
	}
	
	public void salvar() {
		
		List<Cidade> cidade = new ArrayList<>();
		
		try {
			
			cidade = new CidadeBo().lista(this.comboBox.getSelectedItem().toString());
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		piloto.setNome(this.txtnome.getText());
		piloto.setCpf(this.txtcpf.getText());
		piloto.setCelular(this.txtTelefone.getText());	
		piloto.setEmail(this.txtemail.getText());
		piloto.setCidade(cidade.get(0));
		piloto.setApelido(this.textApelido.getText());
		piloto.setSenha(this.textSenha.getText());
		
		try {
			
			piloto.setDataNascimento(new PilotoBo().verificarDataNascimento(this.txtDataNasc.getText()));
			String resultado = new PilotoBo().salvarAlterar(piloto, this.textConfirmarSenha.getText());
			
			JOptionPane.showMessageDialog(null, "Cadastrado");
			new Logar().setVisible(true);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	   
		
	}
	
	
	public void SalvarAtributosTemporarios() {
		
		piloto.setApelido(this.textApelido.getText());
		piloto.setNome(this.txtnome.getText());
		piloto.setCpf(this.txtnome.getText());
		piloto.setCelular(this.txtTelefone.getText());
		piloto.setSenha(this.textSenha.getText());
		piloto.setEmail(this.txtemail.getText());
		
		if(this.txtDataNasc.getText().equals("") == false) {
			piloto.setDataNascimento(new PilotoBo().formatarData(this.txtDataNasc.getText()));
		}
		
	}
	
	public void carregarAtributosPiloto(Piloto piloto) {
		
		this.txtcpf.setText(piloto.getCpf());
		this.txtemail.setText(piloto.getEmail());
		this.txtnome.setText(piloto.getNome());
		this.textApelido.setText(piloto.getApelido());
		this.textSenha.setText(piloto.getSenha());
		this.txtTelefone.setText(piloto.getCelular());
		
		if(new PilotoBo().retornarData(piloto) == true) {
			
			this.txtDataNasc.setText(piloto.getDataNascimento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		}
		
	}
	
	public void carregarCombo() {
		
		List<Cidade> cidade = new  ArrayList<>();
		
		try {
			cidade = new CidadeBo().lista("");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		for(Cidade addCidade: cidade) {
			this.comboBox.addItem(addCidade.getNomeCidade());
		}
		
	}
	

	
}
