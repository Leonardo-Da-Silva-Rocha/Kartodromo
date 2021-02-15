package projeto_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto_entity.Cidade;

public class CidadeDao {
	
	public String salvar(Cidade cidade) throws Exception {
		
		try {
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			if(cidade.getIdCidade() == 0) {
				em.persist(cidade);
				em.getTransaction().commit();
				return "CIDADE SALVA";
				
			}
			else {
				em.merge(cidade);
				em.getTransaction().commit();
				return "Cidade Alterada";
			}
			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Cidade> lista(String parametro){
		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		Query consulta = null;
		
		if(parametro.equals("")) {
			consulta = em.createQuery("select c from Cidade c");
			
		}
		else {
			consulta = em.createQuery("select c from Cidade c where nomeCidade = :nome");
			consulta.setParameter("nome", parametro);
		}
		
		
		em.getTransaction().commit();
		
		List<Cidade> lista = consulta.getResultList();
		
		return lista;
		
	}
}
