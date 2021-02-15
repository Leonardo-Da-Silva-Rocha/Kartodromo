 package projeto_testes;

import projeto_bo.CidadeBo;
import projeto_entity.Cidade;

public class TesteCidade {

	public static void main(String[] args) {
		Cidade cidade = new Cidade();
		cidade.setNomeCidade("Curitiba");
		
		CidadeBo bo = new CidadeBo();
		try {
			String resultado = bo.salvar(cidade);
			System.out.println(resultado);
			
		}
		catch(Exception e) {
			System.out.println("ERROO" +e.getMessage());
		}

	}

}
