package manager;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import persistence.ClienteDao;
import persistence.LivroDao;
import persistence.LocacaoDao;
import persistence.MensagemDao;
import entity.Cliente;
import entity.Livro;
import entity.Locacao;
import entity.Mensagem;

@ManagedBean(name = "mbLocacao")
@RequestScoped
public class MBLocacao {

	private Locacao locacao;
	private Cliente cliente;
	private Livro livro;
	private Integer idCliente;
	private Integer idLivro;
	private List<Locacao> listaLoc;
	private DataModel listaPend;
	private Locacao locacaoAltera;
	private Email email = new SimpleEmail();
	private Mensagem mensagem;
	private List<Mensagem> listaMensagem;

	@PostConstruct
	public void init() {
		locacao = new Locacao();
		cliente = new Cliente();
		livro = new Livro();
		locacaoAltera = new Locacao();
		mensagem = new Mensagem();
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Locacao> getListaLoc() {
		listaLoc = new LocacaoDao().findAll();
		return listaLoc;
	}

	public void setListaLoc(List<Locacao> listaLoc) {
		this.listaLoc = listaLoc;
	}

	public DataModel getListaPend() {
		listaPend = new ListDataModel(new LocacaoDao().findByDataDevolucao());
		return listaPend;
	}

	public void setListaPend(DataModel listaPend) {
		this.listaPend = listaPend;
	}

	public Locacao getLocacaoAltera() {
		return locacaoAltera;
	}

	public void setLocacaoAltera(Locacao locacaoAltera) {
		this.locacaoAltera = locacaoAltera;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public List<Mensagem> getListaMensagem() {
		return listaMensagem;
	}

	public void setListaMensagem(List<Mensagem> listaMensagem) {
		this.listaMensagem = listaMensagem;
	}

	public void alugar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			cliente = new ClienteDao().findByCode(idCliente);
			livro = new LivroDao().findByCode(idLivro);
			locacao.setCliente(cliente);
			locacao.setLivro(livro);
			new LocacaoDao().create(locacao);
			init();
			fc.addMessage("form1",
					new FacesMessage("Livro Alugado com Sucesso"));

		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Erro " + e.getMessage()));
		}
	}

	public void altera() {
		locacaoAltera = (Locacao) listaPend.getRowData();
		cliente = locacaoAltera.getCliente();
		livro = locacaoAltera.getLivro();
	}

	public void devolver() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			locacaoAltera.setCliente(cliente);
			locacaoAltera.setLivro(livro);
			new LocacaoDao().update(locacaoAltera);
			init();
			fc.addMessage("form1", new FacesMessage("Livro Devolvido"));

		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Erro " + e.getMessage()));
		}
	}

	public void preparaEmail() {
		locacaoAltera = (Locacao) listaPend.getRowData();
		cliente = locacaoAltera.getCliente();
	}

	public void enviar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			mensagem.setPara(cliente.getEmail());
			mensagem.setDataEnvio(new Date());
			String hostname = "smtp.gmail.com";
			String username = "leandroalves22@gmail.com";
			String password = "goletitout";
			Email email = new SimpleEmail();
			email.setHostName(hostname);
			email.setSmtpPort(465);
			email.setAuthentication(username, password);
			email.setTLS(true);
			email.setSSL(true);
			email.setFrom(username, username);
			email.setSubject(mensagem.getAssunto());
			email.addTo(mensagem.getPara());
			email.setMsg(mensagem.getTexto());
			email.send();

			mensagem.setLocacao(locacaoAltera);
			new MensagemDao().create(mensagem);
			init();
			fc.addMessage("form1", new FacesMessage("Mensagem Enviada"));

		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Erro " + e.getMessage()));
		}
	}

	public void verEmail() {
		locacaoAltera = (Locacao) listaPend.getRowData();
		listaMensagem = locacaoAltera.getMensagens();
	}

}
