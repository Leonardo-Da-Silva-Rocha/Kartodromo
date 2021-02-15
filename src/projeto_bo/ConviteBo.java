package projeto_bo;

import java.util.List;

import projeto_dao.ConviteDao;
import projeto_entity.Convite;

public class ConviteBo {
	
	public String salvarAlterar(Convite convite) throws Exception {
		verificarDados(convite);
		try {
			return new ConviteDao().salvarAlterar(convite);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<Convite> listar(int id, String pesquisa, String parametro, int idCampeonato) throws Exception{
		try {
			return new ConviteDao().lista(id, pesquisa, parametro, idCampeonato);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void verificarConvite(List<Convite> convite) throws Exception {
		if(convite.size() > 0) {
			throw new Exception("Piloto já convidado para este campeonato");
		}
	}
	
	public void verificarDados(Convite convite) throws Exception {
		if(convite.getCampeonato().getIdCampeonato() == 0) {
			throw new Exception("Salve um campeonato antes de convidar");
		}
		
		
	}
}
