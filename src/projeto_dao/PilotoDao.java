package projeto_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto_entity.Piloto;

public class PilotoDao {
	
	public String salvarAlterar(Piloto piloto) throws Exception {
		
		try {
			
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			if(piloto.getIdPiloto() == 0){
				em.persist(piloto);
				em.getTransaction().commit();
				return "PILOTO SALVO! ";
			}else {
				em.merge(piloto);
				em.getTransaction().commit();
				return "PILOTO ALTERADO COM SUCESSO!";
			}
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	public List<Piloto> listar(String pesquisa, String parametro, String parametro2, int id, String nomeCampeonato){
		
		EntityManager em = Fabrica.getEntityManager();
		em.getTransaction().begin();
		Query consulta = null;
		if(pesquisa.equals("logar")) {
			
			consulta = em.createQuery("select p from Piloto p where apelido = :nome and senha = :senha");
			consulta.setParameter("nome", parametro);
			consulta.setParameter("senha",parametro2);
			
		}
		else if(pesquisa.equals("piloto")) {
			consulta = em.createQuery("select p from Piloto p order by apelido ");
		}
		else if(pesquisa.equals("selecionar")) {
			consulta = em.createQuery("select p from Piloto p where apelido = :nome");
			consulta.setParameter("nome", parametro);
		}
		else if(pesquisa.equals("pilotoDoCampeonato")) {
			consulta = em.createQuery("select p from Piloto p where idPiloto = :id");
			consulta.setParameter("id", id);
		}
		else if(pesquisa.equals("pesquisa")) {
			
			if(parametro2.equals("")) {
				consulta = em.createQuery("select  p from Piloto p inner join PilotoDoCampeonato pc on p.idPiloto = pc.piloto.idPiloto "
						+ "where apelido like :nome and idPiloto != :id order by p.apelido");
				consulta.setParameter("nome", parametro+"%");
				consulta.setParameter("id", id);
				
			}else if(parametro.equals("")) {
				consulta = em.createQuery("select p from Piloto p inner join PilotoDoCampeonato pc on p.idPiloto = pc.piloto.idPiloto "
						+ "inner join Cidade cd on p.cidade.idCidade = cd.idCidade "
						+ "where cd.nomeCidade like :nome and idPiloto != :id order by p.apelido");
				consulta.setParameter("nome", parametro2+"%");
				consulta.setParameter("id", id);
			}
		}
		else if(pesquisa.equals("pesquisarPesquisar")) {
			
			if(parametro.equals("")) {
				consulta = em.createQuery("select p from Piloto p inner join Cidade c on p.cidade.idCidade = c.idCidade "
						+ "where c.nomeCidade like :cidade and p.idPiloto != :id");
				consulta.setParameter("cidade", parametro2+"%");
				consulta.setParameter("id", id);
			}
			else if(parametro2.equals("")) {
				consulta = em.createQuery("select p from Piloto p "
						+ "where p.apelido like :nome and p.idPiloto != :id");
				
				consulta.setParameter("nome", parametro+"%");
				consulta.setParameter("id", id);
			}
			
			
			
			
		}
		else if(pesquisa.equals("convite")) {
			if(parametro2.equals("")) {
				consulta = em.createQuery("select distinct p from Piloto p inner join Cidade c on p.cidade.idCidade = c.idCidade where p.apelido Like :nome and idPiloto != :id");
				consulta.setParameter("nome", parametro+"%");
				consulta.setParameter("id", id);
			}
			else{
				consulta = em.createQuery("select distinct p from Piloto p inner join Cidade c on p.cidade.idCidade = c.idCidade where c.nomeCidade Like :nome and idPiloto != :id");
				consulta.setParameter("nome", parametro2+"%");
				consulta.setParameter("id", id);
			}
			
			
		}
		
		em.getTransaction().commit();
		
		List<Piloto> lista = consulta.getResultList();
		
		return lista;		
	}
}