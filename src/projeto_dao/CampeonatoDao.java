package projeto_dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto_entity.Campeonato;

public class CampeonatoDao {
	
	public String salvarAlterar(Campeonato campeonato) throws Exception {
		
		try {
			
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			if(campeonato.getIdCampeonato() == 0) {
				em.persist(campeonato);
				em.getTransaction().commit();
				return "campeonato criado com sucesso!";
			}
			else {
				em.merge(campeonato);
				em.getTransaction().commit();
				return "campeonato alterado com sucesso!";
			}
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public List<Campeonato> listar(int id, String pesquisa, String nomeCampeonato, LocalDate dataInicio, String status) {
		
		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		Query consulta = null;
		
		if(pesquisa.equals("aceitar") || pesquisa.equals("Recusar")) {
			consulta = em.createQuery("select c from Campeonato c where nomeCampeonato = :nome ");
			consulta.setParameter("nome", nomeCampeonato);
		}
		else if(pesquisa.equals("nome")) {
			
			consulta = em.createQuery("select c from Campeonato c where nomeCampeonato = :nome and situacao = :situacao");
			consulta.setParameter("nome", nomeCampeonato);
			consulta.setParameter("situacao", status);
			
		}
		else if(pesquisa.equals("data")) {
			
			consulta = em.createQuery("select c from Campeonato c where dataInicio = :data and situacao = :situacao");
			consulta.setParameter("data", dataInicio);
			consulta.setParameter("situacao", status);
			
		}
		else if(pesquisa.equals("ativoouencerrado")) {
			
			consulta = em.createQuery("select c from Campeonato c where situacao = :situacao");
			consulta.setParameter("situacao", status);
			
		}
		else if(pesquisa.equals("classificacao")) {
			
			consulta = em.createQuery("select c from Campeonato c inner join PilotoDoCampeonato p on c.idCampeonato = campeonato_idCampeonato "
					+ "and nomeCampeonato = :nome order by p.totalPontos desc");
			
			consulta.setParameter("nome", nomeCampeonato);
			
		}
		else {
			
			consulta = em.createQuery("select c from Campeonato c where idCampeonato = :id");
			consulta.setParameter("id", id);
			
		}
		
		List<Campeonato> lista = consulta.getResultList();
		em.getTransaction().commit();
		
		return lista;
	}
	
}
