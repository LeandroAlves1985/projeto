package manager;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import persistence.FuncionarioDao;
import entity.Funcionario;

@ManagedBean(name = "mbl")
@RequestScoped
public class MBLogin {
	
	private Funcionario funcionario;
	private Funcionario funcionarioLogado;
	
	@PostConstruct
	public void init(){
		funcionario = new Funcionario();
		funcionarioLogado = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}
	
	public String logar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			Criptografia.criptografaSenha(funcionario);
			funcionarioLogado = new FuncionarioDao().logar(funcionario);
			if(funcionarioLogado!=null){
				HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
				HttpSession session = request.getSession(true);
				session.setAttribute("funcionarioLogado", funcionarioLogado);
				return "/logado/menu.jsf?faces-redirect=true";
			} else{
				funcionario = new Funcionario();
				throw new Exception("Acesso Negado");
			}
			
		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Erro " + e.getMessage()));
		}
		return null;
	}
	
	public String deslogar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("funcionarioLogado");
			session.invalidate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/login.jsf";
	}
	
	public void filtrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			if(session.getAttribute("funcionarioLogado")==null){
				fc.getExternalContext().redirect("login.jsf?erro=true");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
