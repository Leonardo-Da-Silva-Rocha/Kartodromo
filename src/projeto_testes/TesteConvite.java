package projeto_testes;


import projeto_dao.ConviteDao;
import projeto_entity.Convite;

public class TesteConvite {

	public static void main(String[] args) {
		
		Convite convite = new Convite();
		ConviteDao convDao = new ConviteDao();
		
		
		
		try {
			String retorno = convDao.salvarAlterar(convite);
			System.out.println(retorno);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

