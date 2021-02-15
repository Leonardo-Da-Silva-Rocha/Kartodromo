package telas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import projeto_bo.CidadeBo;
import projeto_entity.Cidade;
import projeto_entity.Kartodromo;
import projeto_entity.Piloto;

public class Cidade1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCidade;
	private Cidade cidade;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cidade1 frame = new Cidade1(new Piloto());
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
	public Cidade1(Piloto piloto) {
		setTitle("Salvar cidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		cidade = new Cidade();
		
		JButton btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(new Color(255, 255, 0));
		btnVoltar.setBackground(new Color(0, 0, 102));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaInicial().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnVoltar.setBounds(10, 467, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblCidade = new JLabel("Salvar Cidade");
		lblCidade.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblCidade.setForeground(Color.yellow);
		lblCidade.setBounds(292, 0, 201, 42);
		contentPane.add(lblCidade);
		
		JLabel lblNome = new JLabel("Nome da cidade");
		lblNome.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNome.setForeground(new Color(0, 0, 102));
		lblNome.setBounds(10, 70, 201, 20);
		contentPane.add(lblNome);
		
		txtNomeCidade = new JTextField();
		txtNomeCidade.setBounds(10, 90, 201, 20);
		contentPane.add(txtNomeCidade);
		txtNomeCidade.setColumns(10);
		
		JButton btnCadastrarCidade = new JButton("Salvar cidade");
		btnCadastrarCidade.setForeground(new Color(255, 255, 0));
		btnCadastrarCidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salvar();
			}
		});
		btnCadastrarCidade.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnCadastrarCidade.setBackground(new Color(0, 0, 102));
		btnCadastrarCidade.setBounds(10, 120, 207, 23);
		contentPane.add(btnCadastrarCidade);
		
		JLabel fundo = new JLabel("fundo");
		fundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/azulmarinho.jpg")));
		fundo.setBounds(0, 0, 797, 42);
		contentPane.add(fundo);
		
		
		JLabel kart2= new JLabel("New label");
		kart2.setIcon(new ImageIcon(TelaInicial.class.getResource("/telas/kart2.jpg")));
		kart2.setBounds(0, 0, 784, 561);
		contentPane.add(kart2);
		
	
	}
	
	public void salvar() {
		
		this.cidade.setNomeCidade(this.txtNomeCidade.getText());
		
		try {
			String resultado = new CidadeBo().salvar(cidade);
			JOptionPane.showMessageDialog(null, resultado);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	
}
