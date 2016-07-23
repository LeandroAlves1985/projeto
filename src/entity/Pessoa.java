package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(sequenceName = "seq_pessoa", name = "seq_pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seq_pessoa")
	private Integer idPessoa;
	@Column(length = 35, nullable = false)
	private String nome;
	@Column(length = 14, nullable = false, unique=true)
	private String cpf;
	@Column(length = 50, nullable = false, unique=true)
	private String email;
	@OneToOne(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Endereco endereco;
	@OneToOne(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Telefone telefone;
	

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer idPessoa, String nome, String cpf, String email) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public Pessoa(Integer idPessoa, String nome, String cpf, Endereco endereco,
			Telefone telefone, String email) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	@Override
	public String toString() {
		return idPessoa + ";" + nome + ";" + cpf + ";" + email + ";" + endereco + ";" + telefone;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
