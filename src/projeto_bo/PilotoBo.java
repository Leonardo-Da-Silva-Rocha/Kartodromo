package projeto_bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import projeto_dao.PilotoDao;
import projeto_entity.Piloto;

public class PilotoBo {

	public String salvarAlterar(Piloto piloto,String confirmar) throws Exception {
		verificarDados(piloto, confirmar);
		try {
			return new PilotoDao().salvarAlterar(piloto);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	public List<Piloto> listar(String pesquisa, String parametro, String parametro2, int campeonato, String nomeCampeonato) throws Exception{
		
		
		try {
			return new PilotoDao().listar(pesquisa, parametro, parametro2, campeonato, nomeCampeonato);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	public boolean retornarData(Piloto piloto) {
		
		if(piloto.getDataNascimento() == null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public LocalDate formatarData(String dataNascimento) {
		
		if(dataNascimento.equals("") == false) {
			
			DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			return LocalDate.parse(dataNascimento.replaceAll("/", "-"), formatar);
		}
		else {
			return null;
		}
	}
	
	
	
	private void verificarDados(Piloto piloto, String confirmar) throws Exception {
			
		
		if(piloto.getNome().equals("")) {
			throw new Exception("ERRO, NOME EM BRANCO");
		}
		
		if(piloto.getCpf().equals("")) {
			throw new Exception("ERRO, CPF EM BRANCO");
		}
		
		if(piloto.getEmail().equals("")) {
			throw new Exception("ERRO, EMAIL EM BRANCO");
		}
		
		if(piloto.getSenha().equals("")) {
			throw new Exception("ERRO, SENHA EM BRANCO");
		}
		
		
		if(piloto.getSenha().equals(confirmar) == false) {
			throw new Exception("ERRO, AS SENHAS NÂO IGUAIS");
		}
		
		if(piloto.getDataNascimento().isAfter(LocalDate.now()) || piloto.getDataNascimento().isEqual(LocalDate.now())) {
			throw new Exception("ERRO, DATA INVALIDA");
		}
		
		if(piloto.getCelular().equals("")) {
			throw new Exception("ERRO, INSIRA UM NUMERO PARA CONTAO");
		}
		
		if(piloto.getApelido().equals("")) {
			throw new Exception("ERRO, INSIRA UM APELIDO");
		}
		else {
			
			for(Piloto lista: new PilotoDao().listar("selecionar", piloto.getApelido(), piloto.getSenha(),0,"")) {
				
				if(lista.getApelido().equals(piloto.getApelido()) == true) {
					
					throw new Exception("ERRO, INSIRA UM APELIDO VALIDO");
					
				}
				
			}
			
		}
		
	}
	
	
	public void verificarLogin(String nome, String senha) throws Exception {
		
		if(nome.equals("") || senha.equals("")) {
			throw new Exception("ERRO, Preencha Todos Os Campos");
		}
		else {
			
			List<Piloto> piloto = new PilotoDao().listar("logar", nome, senha, 0,"");
			
			if(piloto.size() == 0) {
				throw new Exception("Erro, Nome Ou Senha Invalido");
			}
				
		}
	}
	
	
	public LocalDate verificarDataNascimento(String dataNascimento) throws Exception {
		
		if(dataNascimento.equals("")) {
			
			throw new Exception("INSIRA A DATA DE NASCIMENTO");
			
		}
		else {
			
			DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			return LocalDate.parse(dataNascimento.replaceAll("/", "-"), formatar);
			
			
		}
		
		
	}
	
	public String retornarAdm(Piloto piloto) {
		
		if(piloto.getPilotoDoCampeonato().get(0).isAdm() == true) {
			return "Administrador";
		}
		else {
			return "";
		}
	}
}
