package projeto_entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Convite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate dataCorrida;
	
	private String indicativo;
	
	private LocalDate dataResposta;
	
	@ManyToOne
	private Piloto piloto;
	
	@ManyToOne
	private Campeonato campeonato;

	public LocalDate getDataCorrida() {
		return dataCorrida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String isIndicativo() {
		return indicativo;
	}

	public void setIndicativo(String indicativo) {
		this.indicativo = indicativo;
	}

	public LocalDate getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(LocalDate dataResposta) {
		this.dataResposta = dataResposta;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public void setDataCorrida(LocalDate dataCorrida) {
		this.dataCorrida = dataCorrida;
	}

	public Convite() {
		
	}

	public Convite(int id, LocalDate dataCorrida, String indicativo, LocalDate dataResposta, Piloto piloto,
			Campeonato campeonato) {
		
		this.id = id;
		this.dataCorrida = dataCorrida;
		this.indicativo = indicativo;
		this.dataResposta = dataResposta;
		this.piloto = piloto;
		this.campeonato = campeonato;
	}

	@Override
	public String toString() {
		return "Convite [id=" + id + ", dataCorrida=" + dataCorrida + ", indicativo=" + indicativo + ", dataResposta="
				+ dataResposta + ", piloto=" + piloto + ", campeonato=" + campeonato + "]";
	}

	
	
}
