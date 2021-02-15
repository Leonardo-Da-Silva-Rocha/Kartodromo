package projeto_dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import projeto_entity.Bateria;

public class BateriaDao {
	
	public String salvarAlterar(Bateria bateria) throws Exception {
		
		try {
			
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			if(bateria.getIdBateria() == 0) {
				
				em.persist(bateria);
				em.getTransaction().commit();
				return "Bateria Salva";
				
			}else {
				em.merge(bateria);
				em.getTransaction().commit();
				return "Bateria Alterada";
			}
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public List<Bateria> listar(String parametro, String nome, LocalDate data, String hora, int id, Bateria bateria) {

		EntityManager em = Fabrica.getEntityManager();
		Query consulta = null;
		
		
		
		em.getTransaction().begin();
		
		if(nome.equals("") && parametro.equals("")) {
			
			consulta = em.createQuery("select b from Bateria b");
			
		}
		else if(nome.equals("selecionarDataHora")) {
			
			consulta = em.createQuery("select b from Bateria b where data = :parametro");
			consulta.setParameter("parametro", bateria.getData());
			
		}
		else if(nome.equals("resultadoBateria")) {
			
			consulta = em.createQuery("select b from Bateria b inner join Kartodromo k on b.kartodromo.idKartodromo = k.idKartodromo"
					+ " where k.nome = :nome and data = :parametro and hora = " + "'1970-01-01 " + bateria.getHora()+"'");
			
			consulta.setParameter("parametro", bateria.getData());
			consulta.setParameter("nome",parametro);
		}
		else if(nome.equals("baterias")) {
			consulta = em.createQuery("select b from Bateria b inner join Campeonato c on c.idCampeonato = b.campeonato.idCampeonato "
					+ "inner join PilotoDoCampeonato pc on c.idCampeonato = pc.campeonato.idCampeonato "
					+ "inner join Piloto p on p.idPiloto = pc.piloto.idPiloto where b.indicativo = 'ativo' and pc.piloto.idPiloto = :id ");
			consulta.setParameter("id", id);
		}
		else if(parametro.equals("listaCampeonato")) {
			
			if(nome.equals("")) {
				consulta = em.createQuery("SELECT DISTINCT b FROM Bateria b INNER JOIN Campeonato c on b.campeonato.idCampeonato = c.idCampeonato "
						+ "INNER JOIN PilotoDoCampeonato pc on pc.campeonato.idCampeonato = c.idCampeonato "
						+ "INNER JOIN Piloto p on pc.piloto.idPiloto = p.idPiloto where b.data = :data");
				consulta.setParameter("data", data);
			}
			else {
				consulta = em.createQuery("SELECT  DISTINCT b FROM Bateria b INNER JOIN Campeonato c on b.campeonato.idCampeonato = c.idCampeonato "
						+ "INNER JOIN PilotoDoCampeonato pc on pc.campeonato.idCampeonato = c.idCampeonato "
						+ "INNER JOIN Piloto p on pc.piloto.idPiloto = p.idPiloto where c.nomeCampeonato = :nome");
				consulta.setParameter("nome", nome);
			}
			
		}
		else if(parametro.equals("pesquisaKartodormo")) {
			
			if(nome.equals("") == false) {
				
				consulta = em.createQuery("select b from Bateria b inner join Campeonato c on b.campeonato.idCampeonato = c.idCampeonato "
						+ "inner join Kartodromo k on b.kartodromo.idKartodromo = k.idKartodromo "
						+ "where c.nomeCampeonato = :nome and k.idKartodromo = :id and b.indicativo = 'ativo'");
				
				consulta.setParameter("nome", nome);
				consulta.setParameter("id", id);
				
			}
			if(hora.equals("") == false) {
				consulta = em.createQuery("select DISTINCT b from Bateria b inner join Campeonato c on b.campeonato.idCampeonato = c.idCampeonato "
						+ "inner join Kartodromo k on b.kartodromo.idKartodromo = k.idKartodromo "
						+ "inner join PilotoDaBateria pb on b.pilotoCriador.idPiloto = pb.piloto.idPiloto "
						+ "where b.pilotoCriador.apelido = :nome and k.idKartodromo = :id and b.indicativo = 'ativo'");
				consulta.setParameter("nome",hora);
				consulta.setParameter("id", id);
			}
			if(bateria.getData() != null) {
				consulta = em.createQuery("select DISTINCT b from Bateria b inner join Campeonato c on b.campeonato.idCampeonato = c.idCampeonato "
						+ "inner join Kartodromo k on b.kartodromo.idKartodromo = k.idKartodromo "
						+ "where b.data = :data and k.idKartodromo = :id and b.indicativo = 'ativo'");
				consulta.setParameter("data", bateria.getData());
				consulta.setParameter("id", id);
			}
		}
		else {
			consulta = em.createQuery("select b from Bateria b where campeonato_idCampeonato = :id and indicativo = 'ativo' order by data");
			consulta.setParameter("id", id);
		}
		
		List<Bateria> lista = consulta.getResultList();

		em.getTransaction().commit();
		em.close();

		return lista;

	}
	
	public void atualizar(Bateria bateria) throws Exception {
		
		try {
			
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.merge(bateria);
			em.getTransaction().commit();
	
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}

