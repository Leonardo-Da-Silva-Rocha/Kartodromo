package projeto_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import projeto_entity.PilotoDoCampeonato;

public class PilotoDoCampeonatoDao {
	public String salvarAlterar(PilotoDoCampeonato piloto) throws Exception {
		try {
			
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			if(piloto.getId() == 0) {
				em.persist(piloto);
				em.getTransaction().commit();
				return "Piloto Do Campeonato Salvo";
			}
			else {
				em.merge(piloto);
				em.getTransaction().commit();
				return "Piloto Do Campeonato Alterado";
			}
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
}	

	
	public List<PilotoDoCampeonato> listar(int idCampeonato, String parametro, int idPiloto){
		
		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		
		Query consulta = null;
		if(parametro.equals("listar")){
			consulta = em.createQuery("select p from PilotoDoCampeonato p where campeonato_idCampeonato = :id");
			consulta.setParameter("id", idCampeonato);
		}
		
		else if(parametro.equals("administrar")) {
			consulta = em.createQuery("select p from PilotoDoCampeonato p where piloto_idPiloto = :id and adm = 1");
			consulta.setParameter("id", idPiloto);
		}
		else if(idPiloto == 0){
			
			consulta = em.createQuery("select pc from PilotoDoCampeonato pc inner join Piloto p on p.idPiloto = pc.piloto.idPiloto "
					+ "inner join Campeonato c on c.idCampeonato = pc.campeonato.idCampeonato "
					+ "inner join Pontos pt on pt.campeonato.idCampeonato = c.idCampeonato "
					+ "and pc.campeonato.idCampeonato = :idca and pc.piloto.apelido = :apelido");
			
			consulta.setParameter("apelido", parametro);
			consulta.setParameter("idca", idCampeonato);
		}
		else if(parametro.equals("campeonatopiloto")) {
			
			
			consulta = em.createQuery("select p from PilotoDoCampeonato p where piloto_idPiloto = :piloto and campeonato_idCampeonato = :id");
			consulta.setParameter("id", idCampeonato);
			consulta.setParameter("piloto", idPiloto);
			
		}
		else if(parametro.equals("classificacao")) {
			
			consulta = em.createQuery("select p from PilotoDoCampeonato p where piloto_idPiloto = :id ");
			consulta.setParameter("id", idPiloto);
		}
		else if(idPiloto == -1) {
			
			consulta = em.createQuery("SELECT pc FROM PilotoDoCampeonato pc INNER JOIN Piloto p ON pc.piloto.idPiloto = p.idPiloto "
					+ "INNER JOIN Campeonato c ON pc.campeonato.idCampeonato = c.idCampeonato and pc.campeonato.nomeCampeonato = :nome "
					+ "order by pc.totalPontos desc");
			
			consulta.setParameter("nome", parametro);
		}
		else {
			
			consulta = em.createQuery("SELECT pc FROM PilotoDoCampeonato pc inner join Piloto p on pc.piloto.idPiloto = p.idPiloto "
					+ "inner join Campeonato c on pc.campeonato.idCampeonato = c.idCampeoanto "
					+ "where c.nomeCampeonato = :nome");
			consulta.setParameter("nome", parametro);
			
		}
		List<PilotoDoCampeonato> lista = consulta.getResultList();
		em.getTransaction().commit();
			
		return lista;
		
		
	}
}
