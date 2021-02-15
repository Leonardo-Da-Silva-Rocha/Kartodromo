package projeto_bo;

import java.util.List;

import projeto_dao.PilotoDoCampeonatoDao;
import projeto_entity.PilotoDoCampeonato;
import projeto_entity.Pontos;

public class PilotoDoCampeonatoBo {
	
	public String SalvarAlterar(PilotoDoCampeonato piloto, boolean poli, boolean VoltamaisRapida, boolean maisLideranca, boolean faltou, int posicao, List<Pontos> listaPontos) throws Exception {
		verificarPontuacao(piloto, poli, VoltamaisRapida, maisLideranca, faltou, posicao, listaPontos);
		try {
			return new PilotoDoCampeonatoDao().salvarAlterar(piloto);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PilotoDoCampeonato> listar(int idCampeonato, String parametro, int idPiloto) throws Exception{
		
		try {
			
			return new PilotoDoCampeonatoDao().listar(idCampeonato, parametro, idPiloto);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void verificarPontuacao(PilotoDoCampeonato piloto, boolean poli, boolean VoltamaisRapida, boolean maisLideranca, boolean faltou, int posicao, List<Pontos> listaPontos) {
		
		
		
		if(faltou == true) {
			
			if(piloto.getTotalPontos() != 0) {
				
				piloto.setTotalPontos(piloto.getTotalPontos() - piloto.getCampeonato().getPunicaoPorFalta());
				
			}
			
		}
		else {
		
			if(listaPontos != null) {
				for(Pontos pontos :listaPontos) {
					
					if(pontos.getColocacao() == posicao) {
						piloto.setTotalPontos(piloto.getTotalPontos() + pontos.getPontuacao());
					}
					
				}
				piloto.setPosicao(posicao);
			}
			
			
			if(poli == true) {
				piloto.setTotalPontos(piloto.getTotalPontos() + piloto.getCampeonato().getPontuacaoPoli());
			}
			if(VoltamaisRapida == true) {
				piloto.setTotalPontos(piloto.getTotalPontos() + piloto.getCampeonato().getPontuacaoVoltaMaisRapida());
			}
			
			if(maisLideranca == true) {
				piloto.setTotalPontos(piloto.getTotalPontos() + piloto.getCampeonato().getPontuacaoMaisLideranca());
			}
			
		}
		
	}
	
	
	public void verificarAdm(List<PilotoDoCampeonato> piloto) throws Exception {
		
		if(piloto.size() > 0) {
			
			if(piloto.get(0).isAdm() == false) {
				
				throw new Exception("VOCÊ NÂO É ADMINISTRADOR DESTE CAMPEONATO");
			}
		}
		else {
			throw new Exception("VOCÊ NÂO FAZ PARTE DESTE CAMPEONATO");
		}
	
		
	}
	
	public void tornarAdm(List<PilotoDoCampeonato> piloto) throws Exception {
		
		if(piloto.size() == 0) {
			throw new Exception("Este piloto não está no campeonato, impossivel tornar administrador");
		}
		else {
			if(piloto.get(0).isAdm() == true) {
				throw new Exception("Este piloto já é um administrador");
			}
		}
	}
	
	public String retornarAdm(List<PilotoDoCampeonato> piloto) {
		
		if(piloto.size() > 0) {
			if(piloto.get(0).isAdm() == true) {
				return "Administrador";
			}
			else {
				return "";
			}
		}
		else {
			return "";
		}
	}
	
}
