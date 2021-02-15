package projeto_bo;

import java.util.List;

import projeto_dao.CidadeDao;
import projeto_entity.Cidade;

public class CidadeBo {

	
	public void verificarDados(Cidade cidade) throws Exception {
		if(cidade.getNomeCidade().toUpperCase().equals("")) {
			throw new Exception("ERRO!!! CIDADE EM BRANCO");
		}
		else {
			for(Cidade cid : new CidadeDao().lista(cidade.getNomeCidade())) {
				if(cid.getNomeCidade().toUpperCase().equals(cidade.getNomeCidade().toUpperCase()) == true) {
					throw new Exception("cidade ja cadastrada");
				}
			}
		}
	}
	
	public String salvar(Cidade cidade) throws Exception {
		verificarDados(cidade);
		try {
			return new CidadeDao().salvar(cidade);
			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Cidade> lista(String nomeCidade) throws Exception{
		
		try {
			return new CidadeDao().lista(nomeCidade);
			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		
	}
}
