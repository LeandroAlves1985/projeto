package manager;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import persistence.LivroDao;
import entity.Livro;

@ManagedBean(name = "mbLivro")
@RequestScoped
public class MBLivro {

	private Livro livro;
	private List<Livro> listaLivro;
	private Livro livroAltera;
	private DataModel listaLivro2;

	@PostConstruct
	public void init() {
		livro = new Livro();
		livroAltera = new Livro();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getListaLivro() {
		listaLivro = new LivroDao().findAll();
		return listaLivro;
	}

	public void setListaLivro(List<Livro> listaLivro) {
		this.listaLivro = listaLivro;
	}

	public Livro getLivroAltera() {
		return livroAltera;
	}

	public void setLivroAltera(Livro livroAltera) {
		this.livroAltera = livroAltera;
	}

	public DataModel getListaLivro2() {
		listaLivro2 = new ListDataModel(new LivroDao().findAll());
		return listaLivro2;
	}

	public void setListaLivro2(DataModel listaLivro2) {
		this.listaLivro2 = listaLivro2;
	}

	public void cadastrar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new LivroDao().create(livro);
			init();
			fc.addMessage("form1", new FacesMessage("Livro Cadastrado"));

		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Erro " + e.getMessage()));
		}
	}
	
	public void altera(){
		livroAltera = (Livro) listaLivro2.getRowData();
	}
	
	public void atualizar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new LivroDao().update(livroAltera);
			init();
			fc.addMessage("form1", new FacesMessage("Livro Alterado"));
			
		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Erro " + e.getMessage()));
		}
	}
	
	public void excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			LivroDao ld = new LivroDao();
			ld.delete((Livro) listaLivro2.getRowData());
			fc.addMessage("form1", new FacesMessage("Livro Excluído"));
			
		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Erro " + e.getMessage()));
		}
		
		
	}

}
