package projeto_entity;

import java.time.LocalDate;
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
public class Kartodromo {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKartodromo;
	
	private LocalDate dataCadastro;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String telefone;
	
	private String rua;
	
	private String cnpj;
	
	private LocalTime horarioDeAbertura;
	
	private LocalTime HorarioDeFechamento;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "kartodromo")
	private List<Bateria> bateria;
	
	@ManyToOne
	private Cidade cidade;

	public int getIdKartodromo() {
		return idKartodromo;
	}

	public void setIdKartodromo(int idKartodromo) {
		this.idKartodromo = idKartodromo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LocalTime getHorarioDeAbertura() {
		return horarioDeAbertura;
	}

	public void setHorarioDeAbertura(LocalTime horarioDeAbertura) {
		this.horarioDeAbertura = horarioDeAbertura;
	}

	public LocalTime getHorarioDeFechamento() {
		return HorarioDeFechamento;
	}

	public void setHorarioDeFechamento(LocalTime horarioDeFechamento) {
		HorarioDeFechamento = horarioDeFechamento;
	}

	public List<Bateria> getBateria() {
		return bateria;
	}

	public void setBateria(List<Bateria> bateria) {
		this.bateria = bateria;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Kartodromo(int idKartodromo, LocalDate dataCadastro, String nome, String email, String senha,
			String telefone, String rua, String cnpj, LocalTime horarioDeAbertura, LocalTime horarioDeFechamento,
			List<Bateria> bateria, Cidade cidade) {
		
		this.idKartodromo = idKartodromo;
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.rua = rua;
		this.cnpj = cnpj;
		this.horarioDeAbertura = horarioDeAbertura;
		HorarioDeFechamento = horarioDeFechamento;
		this.bateria = bateria;
		this.cidade = cidade;
	}

	public Kartodromo() {
		
	}

	
	
	
}
