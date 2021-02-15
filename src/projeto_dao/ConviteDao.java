package projeto_dao;

import java.util.List;

import javax.persistence.*;

import projeto_entity.Convite;

public class ConviteDao {
	public String salvarAlterar(Convite convite) throws Exception {
		try {
			
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			
			if(convite.getId() == 0) {
				em.persist(convite);
				em.getTransaction().commit();
				return "Convite Enviado!";
				
			}else {
				
				em.merge(convite);
				em.getTransaction().commit();
				return "Convite Alterado";
				
			}
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Convite> lista(int id, String pesquisa, String parametro, int idCampeonato){
		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		Query consulta = null;
		
		if(pesquisa.equals("convite")) {
			consulta = em.createQuery("select c from Convite c where campeonato_idCampeonato = :id");
			consulta.setParameter("id", id);
		}
		else if(pesquisa.equals("Pendentes")) {
			
			consulta = em.createQuery("select co from Convite co inner join Campeonato c on co.campeonato.idCampeonato = c.idCampeonato "
					+ "inner join Piloto p on co.piloto.idPiloto = p.idPiloto where co.piloto.idPiloto = :id and co.campeonato.nomeCampeonato = :nome");
			
			consulta.setParameter("id", id);
			
			consulta.setParameter("nome", parametro);
		}
		else if(pesquisa.equals("verificarConvite")) {
			consulta = em.createQuery("select c from Convite c where piloto_idPiloto = :id and campeonato_idCampeonato = :idCampeonato");
			
			consulta.setParameter("idCampeonato", idCampeonato);
			consulta.setParameter("id", id);
		}
		else {
			consulta = em.createQuery("select c from Convite c where piloto_idPiloto = :id and indicativo = "+ "'"+parametro+"'");
			consulta.setParameter("id",id);
			
		}
		
		List<Convite> lista = consulta.getResultList();
		em.getTransaction().commit();
		return lista;
		
	}
}
