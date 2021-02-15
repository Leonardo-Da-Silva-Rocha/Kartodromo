package projeto_entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Campeonato {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCampeonato;
	
	private String nomeCampeonato;
	
	private LocalDate dataInicio;
	
	private LocalDate dataFim;
	
	private int totalCorridas;
	
	private String situacao;
	
	private double pontuacaoPoli;
	
	private double pontuacaoMaisLideranca;
	
	private double pontuacaoVoltaMaisRapida;
	
	private double punicaoPorFalta;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "campeonato")
	private List<Convite> convite;
	
	@ManyToOne
	private Piloto piloto;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "campeonato")
	private List<PilotoDoCampeonato> pilotoDoCampeonato;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "campeonato")
	private List<Bateria> bateria;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "campeonato")
	private List<Pontos> pontos;

	public int getIdCampeonato() {
		return idCampeonato;
	}

	public void setIdCampeonato(int idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public int getTotalCorridas() {
		return totalCorridas;
	}

	public void setTotalCorridas(int totalCorridas) {
		this.totalCorridas = totalCorridas;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public double getPontuacaoPoli() {
		return pontuacaoPoli;
	}

	public void setPontuacaoPoli(double pontuacaoPoli) {
		this.pontuacaoPoli = pontuacaoPoli;
	}

	public double getPontuacaoMaisLideranca() {
		return pontuacaoMaisLideranca;
	}

	public void setPontuacaoMaisLideranca(double pontuacaoMaisLideranca) {
		this.pontuacaoMaisLideranca = pontuacaoMaisLideranca;
	}

	public double getPontuacaoVoltaMaisRapida() {
		return pontuacaoVoltaMaisRapida;
	}

	public void setPontuacaoVoltaMaisRapida(double pontuacaoVoltaMaisRapida) {
		this.pontuacaoVoltaMaisRapida = pontuacaoVoltaMaisRapida;
	}

	public double getPunicaoPorFalta() {
		return punicaoPorFalta;
	}

	public void setPunicaoPorFalta(double punicaoPorFalta) {
		this.punicaoPorFalta = punicaoPorFalta;
	}

	public List<Convite> getConvite() {
		return convite;
	}

	public void setConvite(List<Convite> convite) {
		this.convite = convite;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public List<PilotoDoCampeonato> getPilotoDoCampeonato() {
		return pilotoDoCampeonato;
	}

	public void setPilotoDoCampeonato(List<PilotoDoCampeonato> pilotoDoCampeonato) {
		this.pilotoDoCampeonato = pilotoDoCampeonato;
	}

	public List<Bateria> getBateria() {
		return bateria;
	}

	public void setBateria(List<Bateria> bateria) {
		this.bateria = bateria;
	}

	public List<Pontos> getPontos() {
		return pontos;
	}

	public void setPontos(List<Pontos> pontos) {
		this.pontos = pontos;
	}

	public Campeonato() {
		
	}

	public Campeonato(int idCampeonato, String nomeCampeonato, LocalDate dataInicio, LocalDate dataFim,
			int totalCorridas, String situacao, double pontuacaoPoli, double pontuacaoMaisLideranca,
			double pontuacaoVoltaMaisRapida, double punicaoPorFalta, List<Convite> convite, Piloto piloto,
			List<PilotoDoCampeonato> pilotoDoCampeonato, List<Bateria> bateria, List<Pontos> pontos) {
		
		this.idCampeonato = idCampeonato;
		this.nomeCampeonato = nomeCampeonato;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.totalCorridas = totalCorridas;
		this.situacao = situacao;
		this.pontuacaoPoli = pontuacaoPoli;
		this.pontuacaoMaisLideranca = pontuacaoMaisLideranca;
		this.pontuacaoVoltaMaisRapida = pontuacaoVoltaMaisRapida;
		this.punicaoPorFalta = punicaoPorFalta;
		this.convite = convite;
		this.piloto = piloto;
		this.pilotoDoCampeonato = pilotoDoCampeonato;
		this.bateria = bateria;
		this.pontos = pontos;
	}	
	
}
