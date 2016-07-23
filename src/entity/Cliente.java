package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Cliente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Locacao> locacoes;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer idPessoa, String nome, String cpf, String email) {
		super(idPessoa, nome, cpf, email);
	}

	public Cliente(Integer idPessoa, String nome, String cpf,
			Endereco endereco, Telefone telefone, String email) {
		super(idPessoa, nome, cpf, endereco, telefone, email);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

}
