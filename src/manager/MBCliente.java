package manager;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.lavieri.modelutil.cep.WebServiceCep;

import persistence.ClienteDao;
import persistence.EnderecoDao;
import persistence.TelefoneDao;
import entity.Cliente;
import entity.Endereco;
import entity.Telefone;

@ManagedBean(name = "mbCliente")
@RequestScoped
public class MBCliente {

	private Cliente cliente;
	private Endereco endereco;
	private Telefone telefone;
	private String MBcep = "";
	private List<Cliente> listaCliente;
	private DataModel listaCliente2;
	private Cliente clienteAltera;

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		endereco = new Endereco();
		telefone = new Telefone();
		clienteAltera = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getMBcep() {
		return MBcep;
	}

	public void setMBcep(String mBcep) {
		MBcep = mBcep;
	}

	public List<Cliente> getListaCliente() {
		listaCliente = new ClienteDao().findAll();
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public DataModel getListaCliente2() {
		listaCliente2 = new ListDataModel(new ClienteDao().findAll());
		return listaCliente2;
	}

	public void setListaCliente2(DataModel listaCliente2) {
		this.listaCliente2 = listaCliente2;
	}

	public Cliente getClienteAltera() {
		return clienteAltera;
	}

	public void setClienteAltera(Cliente clienteAltera) {
		this.clienteAltera = clienteAltera;
	}

	public void buscarCep() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			WebServiceCep busca = WebServiceCep.searchCep(MBcep);
			if (busca.wasSuccessful()) {
				endereco.setRua(busca.getLogradouro());
				endereco.setBairro(busca.getBairro());
				endereco.setCidade(busca.getCidade());
				endereco.setUf(busca.getUf());
				endereco.setCep(MBcep);
			} else {
				endereco = new Endereco();
				MBcep = "";
				fc.addMessage("form2", new FacesMessage(
						"Endereço não encontrado!"));
			}

		} catch (Exception e) {
			fc.addMessage("form2", new FacesMessage("Error " + e.getMessage()));
		}

	}

	public void cadastrar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			cliente.setEndereco(endereco);
			cliente.setTelefone(telefone);
			endereco.setPessoa(cliente);
			telefone.setPessoa(cliente);
			new ClienteDao().create(cliente);
			new EnderecoDao().create(endereco);
			new TelefoneDao().create(telefone);
			init();
			fc.addMessage("form2", new FacesMessage("Cliente Cadastrado"));

		} catch (Exception e) {
			fc.addMessage("form2", new FacesMessage("Erro " + e.getMessage()));
		}
	}
	
	public void altera(){
		clienteAltera = (Cliente) listaCliente2.getRowData();
		endereco = clienteAltera.getEndereco();
		telefone = clienteAltera.getTelefone();
	}
	
	public void atualizar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			clienteAltera.setEndereco(endereco);
			clienteAltera.setTelefone(telefone);
			endereco.setPessoa(clienteAltera);
			telefone.setPessoa(clienteAltera);
			new ClienteDao().update(clienteAltera);
			new EnderecoDao().update(endereco);
			new TelefoneDao().update(telefone);
			init();
			fc.addMessage("form1", new FacesMessage("Cliente Alterado"));
			
		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Erro " + e.getMessage()));
		}
	}
	
	public void excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			ClienteDao cd = new ClienteDao();
			cd.delete((Cliente) listaCliente2.getRowData());
			fc.addMessage("form1", new FacesMessage("Cliente Excluído"));
			
		} catch (Exception e) {
			fc.addMessage("form1", new FacesMessage("Erro " + e.getMessage()));
		}
	}

}
