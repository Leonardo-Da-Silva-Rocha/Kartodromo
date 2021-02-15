package projeto_testes;

import java.time.LocalDate;
import java.time.LocalTime;

import projeto_bo.KartodromoBo;
import projeto_entity.Cidade;
import projeto_entity.Kartodromo;

public class TesteKartodromo {
	public static void main(String args[]) {
		
		
		Cidade cidade = new Cidade();
		cidade.setIdCidade(1);
		
		
		Kartodromo kartodromo = new Kartodromo();
		kartodromo.setNome("son");
		kartodromo.setEmail("king@gma.com");
		kartodromo.setRua("los angeles");
		kartodromo.setSenha("123");
		kartodromo.setQantidade_minima(10);
		kartodromo.setQuantidade_maxima(20);
		kartodromo.setTelefone("2323-2323");
		kartodromo.setCnpj("1212122123");
		kartodromo.setCidade(cidade);
		kartodromo.setHorarioAbertura(LocalTime.parse("09:00"));
		kartodromo.setHoraFechamento(LocalTime.parse("17:00"));
		
		
		kartodromo.setDataCadastro(LocalDate.now());
		
		try {
			String resultado = new KartodromoBo().salvarAlterar(kartodromo,"123");
			System.out.println(resultado);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
