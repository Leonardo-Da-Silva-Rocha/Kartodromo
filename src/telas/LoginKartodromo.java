package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import projeto_bo.KartodromoBo;
import projeto_entity.Kartodromo;

public class LoginKartodromo extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginKartodromo frame = new LoginKartodromo();
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
	public LoginKartodromo() {
		setTitle("Login kart\u00F3dromo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JButton btnSouNovoAqui = new JButton("Sou novo aqui");
		btnSouNovoAqui.setForeground(new Color(255, 255, 0));
		btnSouNovoAqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCadastrarKartodromo().setVisible(true);;
			}
		});
		
		btnSouNovoAqui.setBackground(new Color(0, 0, 102));
		btnSouNovoAqui.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnSouNovoAqui.setBounds(10, 219, 174, 23);
		contentPane.add(btnSouNovoAqui);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaInicial().setVisible(true);
			}
		});
		btnVoltar.setForeground(new Color(255, 255, 0));
		btnVoltar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnVoltar.setBackground(new Color(0, 0, 102));
		btnVoltar.setBounds(10, 527, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entrar();
				
			}
		});
		btnEntrar.setForeground(new Color(255, 255, 0));
		btnEntrar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnEntrar.setBackground(new Color(0, 0, 102));
		btnEntrar.setBounds(10, 186, 176, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblEntrarComoPiloto = new JLabel("Entrar como kartódromo");
		lblEntrarComoPiloto.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblEntrarComoPiloto.setForeground(Color.YELLOW);
		lblEntrarComoPiloto.setBounds(224, 11, 342, 23);
		contentPane.add(lblEntrarComoPiloto);
		
		JLabel lblNomeDeUsuario = new JLabel("Nome");
		lblNomeDeUsuario.setBackground(new Color(255, 255, 0));
		lblNomeDeUsuario.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNomeDeUsuario.setForeground(new Color(0, 0, 102));
		lblNomeDeUsuario.setBounds(10, 83, 176, 23);
		contentPane.add(lblNomeDeUsuario);
		
		textNome = new JTextField();
		textNome.setBounds(10, 106, 176, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBackground(new Color(240, 240, 240));
		lblSenha.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblSenha.setForeground(new Color(0, 0, 102));
		lblSenha.setBounds(10, 136, 71, 14);
		contentPane.add(lblSenha);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(10, 152, 176, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JLabel fundo = new JLabel("New label");
		fundo.setIcon(new ImageIcon(LoginKartodromo.class.getResource("/telas/azulmarinho.jpg")));
		fundo.setBounds(0, 0, 797, 42);
		contentPane.add(fundo);
		

		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(LoginKartodromo.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(4, 5, 784, 561);
		contentPane.add(kart2);
	}
	
	
	public void entrar() {
		
		try {
			List<Kartodromo> lista = new KartodromoBo().listar("nome", this.textNome.getText());
			new KartodromoBo().verificarLogin(lista, this.textSenha.getText());
			JOptionPane.showMessageDialog(null,"Bem vindo "+ lista.get(0).getNome());
			dispose(); 
			new KartodromoHorarios(lista.get(0)).setVisible(true);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
	}
}