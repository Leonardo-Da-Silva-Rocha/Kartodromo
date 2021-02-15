package projeto_entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCidade;
	
	private String nomeCidade;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "cidade")
	private List<Piloto> piloto;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "cidade")
	private List<Kartodromo> kartodromo;


	public int getIdCidade() {
		return idCidade;
	}


	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}


	public String getNomeCidade() {
		return nomeCidade;
	}


	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}


	public List<Piloto> getPiloto() {
		return piloto;
	}


	public void setPiloto(List<Piloto> piloto) {
		this.piloto = piloto;
	}


	public List<Kartodromo> getKartodromo() {
		return kartodromo;
	}


	public void setKartodromo(List<Kartodromo> kartodromo) {
		this.kartodromo = kartodromo;
	}


	public Cidade() {
		
	}


	public Cidade(int idCidade, String nomeCidade, List<Piloto> piloto, List<Kartodromo> kartodromo) {
		
		this.idCidade = idCidade;
		this.nomeCidade = nomeCidade;
		this.piloto = piloto;
		this.kartodromo = kartodromo;
	}

	
	
	
}
