package projeto_entity;

import java.time.*;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Piloto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPiloto;
	
	private String apelido;
	
	private String senha;
	
	private String email;
	
	private String nome;
	
	private String celular;
	
	private String cpf;
	
	private LocalDate dataNascimento;
	
	
    @ManyToOne
	private Cidade cidade;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "piloto")
	private List<Convite> convite;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "piloto")
	private List<Campeonato> campeonato;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "piloto")
	private List<PilotoDoCampeonato> pilotoDoCampeonato;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "pilotoCriador")
	private List<Bateria> bateria;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "piloto")
	private List<PilotoDaBateria> pilotoDaBateria;

	public int getIdPiloto() {
		return idPiloto;
	}

	public void setIdPiloto(int idPiloto) {
		this.idPiloto = idPiloto;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Convite> getConvite() {
		return convite;
	}

	public void setConvite(List<Convite> convite) {
		this.convite = convite;
	}

	public List<Campeonato> getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(List<Campeonato> campeonato) {
		this.campeonato = campeonato;
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

	public List<PilotoDaBateria> getPilotoDaBateria() {
		return pilotoDaBateria;
	}

	public void setPilotoDaBateria(List<PilotoDaBateria> pilotoDaBateria) {
		this.pilotoDaBateria = pilotoDaBateria;
	}

	public Piloto() {
		
	}

	public Piloto(int idPiloto, String apelido, String senha, String email, String nome, String celular, String cpf,
			LocalDate dataNascimento,Cidade cidade, List<Convite> convite,
			List<Campeonato> campeonato, List<PilotoDoCampeonato> pilotoDoCampeonato, List<Bateria> bateria,
			List<PilotoDaBateria> pilotoDaBateria) {
		
		this.idPiloto = idPiloto;
		this.apelido = apelido;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.celular = celular;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.convite = convite;
		this.campeonato = campeonato;
		this.pilotoDoCampeonato = pilotoDoCampeonato;
		this.bateria = bateria;
		this.pilotoDaBateria = pilotoDaBateria;
	}

	
	
	

	
}
