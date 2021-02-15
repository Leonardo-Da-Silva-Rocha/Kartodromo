package projeto_testes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import projeto_bo.PilotoBo;
import projeto_entity.Piloto;

public class TestePiloto {

	public static void main(String[] args) {
		
		Piloto piloto = new Piloto();
		
		
		piloto.setNome("a");
		piloto.setApelido("a");
		piloto.setCelular("41 99744-2343");
		piloto.setCpf("122112");
		piloto.setEmail("leo@gmail.com");
	    piloto.setSenha("123");
	    piloto.setCidade("araucaria");
	   
	 
	    DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    piloto.setDataNascimento(LocalDate.parse("07/03/2000".replaceAll("/", "-"),formatar));
	    
	   
	    try {
	    	
	    	String resultado = new PilotoBo().salvarAlterar(piloto, "123");
	    	System.out.println(resultado);
	    	
	    }catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}

}
