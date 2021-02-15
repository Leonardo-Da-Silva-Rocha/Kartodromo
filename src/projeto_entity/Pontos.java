package projeto_entity;

import javax.persistence.*;

@Entity
public class Pontos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPontos;
	
	private double pontuacao;
	
	private int colocacao;
	
	@ManyToOne
	private Campeonato campeonato;

	public int getIdPontos() {
		return idPontos;
	}

	public void setIdPontos(int idPontos) {
		this.idPontos = idPontos;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getColocacao() {
		return colocacao;
	}

	public void setColocacao(int colocacao) {
		this.colocacao = colocacao;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Pontos() {
		
	}

	public Pontos(int idPontos, double pontuacao, int colocacao, Campeonato campeonato) {
		
		this.idPontos = idPontos;
		this.pontuacao = pontuacao;
		this.colocacao = colocacao;
		this.campeonato = campeonato;
	}

	
	
	
	
	
	
}
