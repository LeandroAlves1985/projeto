package insert;
import persistence.EnderecoDao;
import persistence.FuncionarioDao;
import persistence.TelefoneDao;
import entity.Endereco;
import entity.Funcionario;
import entity.Telefone;

public class MainCadastroFuncionario {
	public static void main(String[] args) {

		Funcionario f = new Funcionario();
		Endereco e = new Endereco();
		Telefone t = new Telefone();
		FuncionarioDao fd = new FuncionarioDao();
		EnderecoDao ed = new EnderecoDao();
		TelefoneDao td = new TelefoneDao();
		
		try {
			f.setIdPessoa(null);
			f.setNome("Leandro Alves");
			f.setCpf("114.475.637-51");
			f.setEmail("leandro@gmail.com");
			f.setSenha("lejoba");
			e.setIdEndereco(null);
			e.setRua("Marques de Baependi");
			e.setCasa(578);
			e.setBairro("Jardim Primavera");
			e.setCidade("Duque de Caxias");
			e.setUf("RJ");
			e.setCep("25223360");
			t.setConvencional("2133334444");
			t.setCelular("21988490513");
			
			f.setEndereco(e);
			f.setTelefone(t);
			e.setPessoa(f);
			t.setPessoa(f);
			
			fd.create(f);
			ed.create(e);
			td.create(t);
			
			System.out.println("Dados Gravados");
			
			
		} catch (Exception e2) {
			System.out.println("Erro " + e2.getMessage());
		}
		
	}
	
	

}
