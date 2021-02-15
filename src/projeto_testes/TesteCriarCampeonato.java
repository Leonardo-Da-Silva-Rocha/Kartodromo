package projeto_testes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import projeto_bo.CampeonatoBo;
import projeto_bo.PilotoDoCampeonatoBo;
import projeto_entity.Campeonato;
import projeto_entity.Convite;
import projeto_entity.Piloto;
import projeto_entity.PilotoDoCampeonato;

public abstract class TesteCriarCampeonato {

	public static void main(String[] args) {
		
		Piloto piloto = new Piloto();
		
		Campeonato campeonato = new Campeonato();
		
		Convite convite = new Convite();
		
		PilotoDoCampeonato pilotocam = new PilotoDoCampeonato();
		
		piloto.setIdPiloto(1);
		
		campeonato.setNomeCampeonato("cheveteiros");
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		campeonato.setData(LocalDate.parse("25/07/2020".replaceAll("/", "-"), formatar));
		campeonato.setPontuacaoMaisLideranca(20);
		campeonato.setPontuacaopoli(20);
		campeonato.setTotalCorridas(8);
		campeonato.setSituacao("nao ocorrido");
		campeonato.setPiloto(piloto);

		
		try {
			String resultado = new CampeonatoBo().salvarAlterar(campeonato);
			System.out.println(resultado);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		pilotocam.setPiloto(piloto);
		pilotocam.setCampeonato(campeonato);
		pilotocam.setAdm(true);
		
		try {
			String resultado = new PilotoDoCampeonatoBo().SalvarAlterar(pilotocam);
			System.out.println(resultado);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
