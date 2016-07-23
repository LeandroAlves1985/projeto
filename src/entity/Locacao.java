package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
@SequenceGenerator(sequenceName = "seq_locacao", name = "seq_locacao")
public class Locacao {

	@Id
	@GeneratedValue(generator = "seq_locacao")
	private Integer idLocacao;
	@Temporal(TemporalType.DATE)
	private Date dataLocacao;
	@Temporal(TemporalType.DATE)
	private Date dataDevolucao;
	private transient String status;
	@ManyToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@OneToMany(mappedBy="locacao", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Mensagem> mensagens;

	public Locacao() {
		// TODO Auto-generated constructor stub
	}

	public Locacao(Integer idLocacao, Date dataLocacao, Date dataDevolucao) {
		super();
		this.idLocacao = idLocacao;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
	}

	public Locacao(Integer idLocacao, Date dataLocacao, Date dataDevolucao,
			Livro livro, Cliente cliente, List<Mensagem> mensagens) {
		super();
		this.idLocacao = idLocacao;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.livro = livro;
		this.cliente = cliente;
		this.mensagens = mensagens;
	}

	@Override
	public String toString() {
		return "Locacao [idLocacao=" + idLocacao + ", dataLocacao="
				+ dataLocacao + ", dataDevolucao=" + dataDevolucao
				+ ", status=" + status + ", mensagens=" + mensagens + "]";
	}

	public Integer getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Integer idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

}
