package projeto_bo;

import java.util.List;

import javax.swing.JOptionPane;

import projeto_dao.PilotoDaBateriaDao;
import projeto_entity.PilotoDaBateria;
import projeto_entity.PilotoDoCampeonato;

public class PilotoDaBateriaBo {
	
	public String salvarAlterar(PilotoDaBateria piloto) throws Exception {
		 verificarPresenca(piloto);
		try {
			return new PilotoDaBateriaDao().salvarAlterar(piloto);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public List<PilotoDaBateria> listar(String pesquisa, int idBateria, String dataBateria) throws Exception{
		try {
			
			return new PilotoDaBateriaDao().listar(pesquisa, idBateria, dataBateria);
			
		}catch(Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
		
	}
	
	public void verificarPresenca(PilotoDaBateria piloto) {
		
		if(piloto.isFaltou() == true) {
			
			piloto.setMaisLideranca(false);
			piloto.setVoltaMaisRapida(false);
			piloto.setPoli(false);
		
			
		}
		
	}
	
	
	public String verificarPole(PilotoDaBateria piloto) {
		if(piloto.isPoli() == true) {
			return "Pole Position";
		}
		else {
			return "";
		}
	}
	public String verificarMaisLideranca(PilotoDaBateria piloto) {
		if(piloto.isMaisLideranca() == true) {
			return "Mais Liderança";
		}
		else {
			return "";
		}
	}
	public String verificarVoltaMaisRapida(PilotoDaBateria piloto) {
		if(piloto.isVoltaMaisRapida() == true) {
			return "Volta Mais Rapida";
		}
		else {
			return "";
		}
	}
	
	
	public void verificarPosicao(List<Integer> lista, int posicaoPiloto) throws Exception {
		
		for(Integer posicao : lista) {
			if(posicao == posicaoPiloto) {
				throw new Exception("Erro, esta posicão já foi salva");
			}
		}
		
	}
}