package projeto_entity;

import javax.persistence.*;

@Entity
public class PilotoDaBateria {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPilotoDaBatera;
	
	private boolean voltaMaisRapida;
	
	private boolean poli;
	
	private boolean maisLideranca;
	
	private boolean faltou;
	
	private int colocacao;

	@ManyToOne
	private Piloto piloto;
	@ManyToOne
	private Bateria bateria;
	public int getIdPilotoDaBatera() {
		return idPilotoDaBatera;
	}
	public void setIdPilotoDaBatera(int idPilotoDaBatera) {
		this.idPilotoDaBatera = idPilotoDaBatera;
	}
	public boolean isVoltaMaisRapida() {
		return voltaMaisRapida;
	}
	public void setVoltaMaisRapida(boolean voltaMaisRapida) {
		this.voltaMaisRapida = voltaMaisRapida;
	}
	public boolean isPoli() {
		return poli;
	}
	public void setPoli(boolean poli) {
		this.poli = poli;
	}
	public boolean isMaisLideranca() {
		return maisLideranca;
	}
	public void setMaisLideranca(boolean maisLideranca) {
		this.maisLideranca = maisLideranca;
	}
	public boolean isFaltou() {
		return faltou;
	}
	public void setFaltou(boolean faltou) {
		this.faltou = faltou;
	}
	public int getColocacao() {
		return colocacao;
	}
	public void setColocacao(int colocacao) {
		this.colocacao = colocacao;
	}
	public Piloto getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	public Bateria getBateria() {
		return bateria;
	}
	public void setBateria(Bateria bateria) {
		this.bateria = bateria;
	}
	
	
	public PilotoDaBateria() {
		
	}
	
	public PilotoDaBateria(int idPilotoDaBatera, boolean voltaMaisRapida, boolean poli, boolean maisLideranca,
			boolean faltou, int colocacao, Piloto piloto, Bateria bateria) {
		
		this.idPilotoDaBatera = idPilotoDaBatera;
		this.voltaMaisRapida = voltaMaisRapida;
		this.poli = poli;
		this.maisLideranca = maisLideranca;
		this.faltou = faltou;
		this.colocacao = colocacao;
		this.piloto = piloto;
		this.bateria = bateria;
	}
	
}
