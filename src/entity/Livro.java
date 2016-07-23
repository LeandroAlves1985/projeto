package entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(sequenceName = "seq_livro", name = "seq_livro")
public class Livro {

	@Id
	@GeneratedValue(generator = "seq_livro")
	private Integer idLivro;
	@Column(length = 35, nullable = false)
	private String nomeLivro;
	@Temporal(TemporalType.DATE)
	private Date dataPublicacao;
	@Column(length = 35)
	private String nomeAutor;
	@Column(length = 35)
	private String nomeEditora;
	@OneToMany(mappedBy = "livro", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Locacao> locacoes;

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(Integer idLivro, String nomeLivro, Date dataPublicacao,
			String nomeAutor, String nomeEditora) {
		super();
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.dataPublicacao = dataPublicacao;
		this.nomeAutor = nomeAutor;
		this.nomeEditora = nomeEditora;
	}

	public Livro(Integer idLivro, String nomeLivro, Date dataPublicacao,
			String nomeAutor, String nomeEditora, List<Locacao> locacoes) {
		super();
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.dataPublicacao = dataPublicacao;
		this.nomeAutor = nomeAutor;
		this.nomeEditora = nomeEditora;
		this.locacoes = locacoes;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", nomeLivro=" + nomeLivro
				+ ", dataPublicacao=" + dataPublicacao + ", nomeAutor="
				+ nomeAutor + ", nomeEditora=" + nomeEditora + ", locacoes="
				+ locacoes + "]";
	}
	
	public String toStringGravar(){
		return idLivro + ";" + nomeLivro + ";" + nomeAutor + ";" + nomeEditora + ";" + dataPublicacao;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

}
