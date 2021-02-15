package projeto_testes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import projeto_bo.ConviteBo;
import projeto_entity.Campeonato;
import projeto_entity.Convite;
import projeto_entity.Piloto;

public class ConvidarPilotoTeste {

	public static void main(String[] args) {
		
		Piloto piloto = new Piloto();
		Campeonato campeonato = new Campeonato();
		Convite convite = new Convite();
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		piloto.setIdPiloto(2);
		campeonato.setIdCampeonato(2);
		convite.setPiloto(piloto);
		convite.setCampeonato(campeonato);
		
		convite.setDataCorrida(LocalDate.parse("25/07/2020".replaceAll("/","-"), formatar));
		
		try {
			String resultado  =  new ConviteBo().salvarAlterar(convite);
			System.out.println(resultado);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
