package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName = "seq_endereco", name = "seq_endereco")
public class Endereco {

	@Id
	@GeneratedValue(generator = "seq_endereco")
	private Integer idEndereco;
	@Column(length=50)
	private String rua;
	@Column(length=35)
	private Integer casa;
	@Column(length=35)
	private String bairro;
	@Column(length=35)
	private String cidade;
	@Column(length=2)
	private String uf;
	@Column(length=10)
	private String cep;
	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco(Integer idEndereco, String rua, Integer casa,
			String bairro, String cidade, String uf, String cep) {
		super();
		this.idEndereco = idEndereco;
		this.rua = rua;
		this.casa = casa;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public Endereco(Integer idEndereco, String rua, Integer casa,
			String bairro, String cidade, String uf, String cep, Pessoa pessoa) {
		super();
		this.idEndereco = idEndereco;
		this.rua = rua;
		this.casa = casa;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return idEndereco + ";" + rua + ";" + casa + ";" + bairro + ";" + cidade + ";" + uf + ";" + cep;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getCasa() {
		return casa;
	}

	public void setCasa(Integer casa) {
		this.casa = casa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
