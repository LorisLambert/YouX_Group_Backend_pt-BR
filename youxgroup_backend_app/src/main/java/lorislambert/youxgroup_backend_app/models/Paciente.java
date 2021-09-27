package lorislambert.youxgroup_backend_app.models;

import java.sql.Date;

public class Paciente {
	
	private int id;
	
	private String nome;

	private String cpf;
	
	private Date datanascimento;
	
	private String altura;
	
	private String peso;
	
	private String uf;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return datanascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.datanascimento = dataNascimento;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
