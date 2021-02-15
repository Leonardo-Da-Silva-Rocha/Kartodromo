package projeto_bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import projeto_dao.KartodromoDao;
import projeto_entity.Kartodromo;

public class KartodromoBo {

	public String salvarAlterar(Kartodromo kartodromo, String comparar) throws Exception {
		verificarDados(kartodromo, comparar);
		try {
			return new KartodromoDao().salvarAlterar(kartodromo);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Kartodromo> listar(String pesquisa, String parametro) throws Exception{
		try {
			return new KartodromoDao().Listar(pesquisa,parametro);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	private void verificarDados(Kartodromo kartodromo, String comparar) throws Exception {
		
		if(kartodromo.getNome().equals("")) {
			throw new Exception("Erro, nome em branco");
		}
		
		if(kartodromo.getSenha().equals("")) {
			throw new Exception("Erro, senha em branco");
		}
		else if(kartodromo.getSenha().equals(comparar) == false) {
			throw new Exception("Erro, as senhas não são iguais");
		}
		
		if(kartodromo.getTelefone().equals("")) {
			throw new Exception("Erro, telefone em branco");
		}
		
		if(kartodromo.getEmail().equals("")) {
			throw new Exception("Erro, email em branco");
		}
		if(kartodromo.getCnpj().equals("")) {
			throw new Exception("Erro, insira o cnpj");
		}
		if(kartodromo.getRua().equals("")) {
			throw new Exception("Erro, insira o endereço");
		}
		
		
		
		for(Kartodromo kart : new KartodromoDao().Listar("nome", kartodromo.getNome())) {
			if(kart.getNome().equals(kartodromo.getNome()) ) {
				throw new Exception("Nome do Kartodromo já cadastrado");
			}
		}
		
		
	}
	
	public static void verificarHora(Kartodromo kartodromo, String horarioDeAbertura, String horarioDeFechamento) throws Exception {
		
		if(horarioDeAbertura.equals("") || horarioDeFechamento.equals("")) {
			
			throw new Exception("INSIRA OS HORAIOS PARA O CADASTRO");
		}
		else {
			
			
			kartodromo.setHorarioDeAbertura(LocalTime.parse(horarioDeAbertura));
			kartodromo.setHorarioDeFechamento(LocalTime.parse(horarioDeFechamento));
			
		}
		
	}
	
	public void verificarLogin(List<Kartodromo> lista, String senha) throws Exception {
		
		if(lista.size() == 0) {
			throw new Exception("Nome incorreto");
		}
		else if(lista.get(0).getSenha().equals(senha) == false) {
			throw new Exception("Senha invalida");
		}
	
	}

	
}
