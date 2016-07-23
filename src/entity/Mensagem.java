package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(sequenceName = "seq_mensagem", name = "seq_mensagem")
public class Mensagem {
	@Id
	@GeneratedValue(generator = "seq_mensagem")
	private Integer idMensagem;
	@Column
	private String para;
	@Column
	private String assunto;
	@Column
	private String texto;
	@Temporal(TemporalType.DATE)
	private Date dataEnvio;
	@ManyToOne
	@JoinColumn(name = "id_locacao")
	private Locacao locacao;

	public Mensagem() {
		// TODO Auto-generated constructor stub
	}

	public Mensagem(Integer idMensagem, String para, String assunto,
			String texto, Date dataEnvio) {
		super();
		this.idMensagem = idMensagem;
		this.para = para;
		this.assunto = assunto;
		this.texto = texto;
		this.dataEnvio = dataEnvio;
	}

	public Mensagem(Integer idMensagem, String para, String assunto,
			String texto, Date dataEnvio, Locacao locacao) {
		super();
		this.idMensagem = idMensagem;
		this.para = para;
		this.assunto = assunto;
		this.texto = texto;
		this.dataEnvio = dataEnvio;
		this.locacao = locacao;
	}

	@Override
	public String toString() {
		return "Mensagem [idMensagem=" + idMensagem + ", para=" + para
				+ ", assunto=" + assunto + ", texto=" + texto + ", dataEnvio="
				+ dataEnvio + "]";
	}

	public Integer getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

}
