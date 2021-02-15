package projeto_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto_entity.PilotoDaBateria;

public class PilotoDaBateriaDao {
	
	public String salvarAlterar(PilotoDaBateria piloto) throws Exception {
		try {
			
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			
			if(piloto.getIdPilotoDaBatera() == 0) {
				em.persist(piloto);
				em.getTransaction().commit();
				return "PilotoDaBateria salvo";
			}
			else {
				em.merge(piloto);
				em.getTransaction().commit();
				return "PilotoDaBateria alterado";
			}
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	public List<PilotoDaBateria> listar(String pesquisa, int idBateria, String dataBateria){
		
		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		
		Query consulta = null;
				
		if(pesquisa.equals("classificacao")) {
			
			consulta =  em.createQuery("select pb from PilotoDaBateria pb inner join Piloto p on pb.piloto.idPiloto = p.idPiloto "
					+ "and bateria_idBateria = :idbateria and pb.colocacao > 0 order by colocacao");
			consulta.setParameter("idbateria",idBateria);
			
		}


		em.getTransaction().commit();
		
		return consulta.getResultList();
		
	}
}