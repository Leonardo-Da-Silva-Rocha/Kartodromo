package projeto_entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bateria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBateria;
	
	private LocalDate data;
	
	private LocalTime hora;
	
	private String indicativo;
	
	@ManyToOne
	private Piloto pilotoCriador;
	
	@ManyToOne
	private Campeonato campeonato;
	
	@ManyToOne
	private Kartodromo kartodromo;

	@OneToMany(cascade= CascadeType.ALL, mappedBy = "bateria")
	private List<PilotoDaBateria> pilotoDaBateria;

	public int getIdBateria() {
		return idBateria;
	}

	public void setIdBateria(int idBateria) {
		this.idBateria = idBateria;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getStatus() {
		return indicativo;
	}

	public void setIndicativo(String indicativo) {
		this.indicativo = indicativo;
	}

	public Piloto getPilotoCriador() {
		return pilotoCriador;
	}

	public void setPilotoCriador(Piloto pilotoCriador) {
		this.pilotoCriador = pilotoCriador;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Kartodromo getKartodromo() {
		return kartodromo;
	}

	public void setKartodromo(Kartodromo kartodromo) {
		this.kartodromo = kartodromo;
	}

	public List<PilotoDaBateria> getPilotoDaBateria() {
		return pilotoDaBateria;
	}

	public void setPilotoDaBateria(List<PilotoDaBateria> pilotoDaBateria) {
		this.pilotoDaBateria = pilotoDaBateria;
	}

	public Bateria() {
		
	}

	public Bateria(int idBateria, LocalDate data, LocalTime hora, String indicativo, Piloto pilotoCriador,
			Campeonato campeonato, Kartodromo kartodromo, List<PilotoDaBateria> pilotoDaBateria) {
		
		this.idBateria = idBateria;
		this.data = data;
		this.hora = hora;
		this.indicativo = indicativo;
		this.pilotoCriador = pilotoCriador;
		this.campeonato = campeonato;
		this.kartodromo = kartodromo;
		this.pilotoDaBateria = pilotoDaBateria;
	}	
	
}
