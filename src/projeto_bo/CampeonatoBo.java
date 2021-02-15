package projeto_bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import projeto_dao.CampeonatoDao;
import projeto_entity.Campeonato;

public class CampeonatoBo {
	
	public String salvarAlterar(Campeonato campeonato, String dataCampeonato) throws Exception {
		verificarDados(campeonato, dataCampeonato);
		try {
			return new CampeonatoDao().salvarAlterar(campeonato);
		}catch(Exception e) {
			throw new Exception(e.getMessage());	
		}
	}
	
	public List<Campeonato> listar(int id, String pesquisa, String nomeCampeonato, LocalDate dataInicio, String status) throws Exception{
			
		try {
			
			return new CampeonatoDao().listar(id, pesquisa, nomeCampeonato, dataInicio, status);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		
	}
	
	public void verificarDados(Campeonato campeonato, String dataCampeonato) throws Exception {
	
		if(campeonato.getDataFim() != null) {
			
			campeonato.setDataFim(LocalDate.now());
			
			
		}
		else {
			
			if(campeonato.getNomeCampeonato().equals("")) {
				throw new Exception("ERRO, INSIRA O NOME DO CAMPEONATO");
			}
			
			if(dataCampeonato.equals("")) {
				throw new Exception("ERRO, INSIRA A DATA DO CAMPEONATO");
			}else {
				campeonato.setDataInicio(formatarData(dataCampeonato));
			}
			
			if(campeonato.getDataInicio().isBefore(LocalDate.now()) || campeonato.getDataInicio().isEqual(LocalDate.now())) {
				throw new Exception("ERRO, DATA INVALIDA");
			}
			
			if(campeonato.getPontuacaoMaisLideranca() <= 0 || campeonato.getPontuacaoMaisLideranca() > 5 ) {
				throw new Exception("INSIRA A PONTUAÇÂO DE MAIS LIDERANÇA VALIDA");
			}
			
			if(campeonato.getPontuacaoPoli() <= 0 || campeonato.getPontuacaoPoli() > 5) {
				throw new Exception("INSIRA A PONTUAÇÂO DE POLE VALIDA");
			}
			
			if(campeonato.getPontuacaoVoltaMaisRapida() <= 0 || campeonato.getPontuacaoVoltaMaisRapida() > 5) {
				throw new Exception("INSIRA A PONTUAÇÂO DAVOLTA MAIS RAPIDA VALIDA");
			}
			
			if(campeonato.getPunicaoPorFalta() <= 0 || campeonato.getPunicaoPorFalta() > 5) {
				throw new Exception("INSIRA A PUNIÇÂO POR FALTA VALIDA");
			}
			
		}
		
	}
	
	public static LocalDate formatarData(String dataCampeonato) {
		
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		return LocalDate.parse(dataCampeonato.replaceAll("/","-"), formatar);
	}
	
}