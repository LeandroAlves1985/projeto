package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName = "seq_telefone", name = "seq_telefone")
public class Telefone {

	@Id
	@GeneratedValue(generator = "seq_telefone")
	private Integer idTelefone;
	@Column(length=13)
	private String convencional;
	@Column(length=14)
	private String celular;
	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	public Telefone() {
		// TODO Auto-generated constructor stub
	}

	public Telefone(Integer idTelefone, String convencional, String celular) {
		super();
		this.idTelefone = idTelefone;
		this.convencional = convencional;
		this.celular = celular;
	}

	public Telefone(Integer idTelefone, String convencional, String celular,
			Pessoa pessoa) {
		super();
		this.idTelefone = idTelefone;
		this.convencional = convencional;
		this.celular = celular;
		this.pessoa = pessoa;
	}

	

	@Override
	public String toString() {
		return idTelefone + ";" + convencional + ";" + celular +"\n";
	}

	public Integer getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getConvencional() {
		return convencional;
	}

	public void setConvencional(String convencional) {
		this.convencional = convencional;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
