package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 100, nullable = false)
	private String senha;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer idPessoa, String nome, String cpf, String email,
			String senha) {
		super(idPessoa, nome, cpf, email);
		this.senha = senha;
	}

	public Funcionario(Integer idPessoa, String nome, String cpf,
			Endereco endereco, Telefone telefone, String email, String senha) {
		super(idPessoa, nome, cpf, endereco, telefone, email);
		this.senha = senha;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
