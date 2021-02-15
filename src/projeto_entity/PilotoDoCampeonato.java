package projeto_entity;

import javax.persistence.*;

@Entity
public class PilotoDoCampeonato {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Piloto piloto;
	
	@ManyToOne
	private Campeonato campeonato;
	
	private int posicao;
	
	private double totalPontos;
	
	private boolean adm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public double getTotalPontos() {
		return totalPontos;
	}

	public void setTotalPontos(double totalPontos) {
		this.totalPontos = totalPontos;
	}

	public boolean isAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}

	public PilotoDoCampeonato() {
	
	}

	public PilotoDoCampeonato(int id, Piloto piloto, Campeonato campeonato, int posicao, double totalPontos,
			boolean adm) {
		
		this.id = id;
		this.piloto = piloto;
		this.campeonato = campeonato;
		this.posicao = posicao;
		this.totalPontos = totalPontos;
		this.adm = adm;
	}

	
	
	
	
	
	
}
