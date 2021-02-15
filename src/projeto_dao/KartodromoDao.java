package projeto_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto_entity.Kartodromo;

public class KartodromoDao {

	public String salvarAlterar(Kartodromo kartodromo) throws Exception {
		
		try {
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			
			if(kartodromo.getIdKartodromo() == 0) {
				em.persist(kartodromo);
				em.getTransaction().commit();
				return "KARTODROMO SALVO!";
			}else {
				em.merge(kartodromo);
				em.getTransaction().commit();
				return "KARTODROMO ALTERADO COM SUCESSO !";
			}
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Kartodromo> Listar(String pesquisa, String parametro) {
		
		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		
		Query consulta = null;
		
		if(pesquisa.equals("combo")) {
			
			consulta = em.createQuery("select k from Kartodromo k");
			
		}
		else if(pesquisa.equals("nome")) {
			consulta = em.createQuery("select k from Kartodromo k where nome = :nome");
			consulta.setParameter("nome", parametro);
		}
		else {
			consulta = em.createQuery("select k from Kartodromo k");
		}
		
		
		List<Kartodromo> lista = consulta.getResultList();
		em.getTransaction().commit();
		return lista;
		
		
	}
	
	
}
