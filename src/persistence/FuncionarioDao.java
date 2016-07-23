package persistence;

import java.util.List;

import manager.Criptografia;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Funcionario;

public class FuncionarioDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Funcionario f) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		f.setSenha(Criptografia.criptografaSenha(f));
		transaction = session.beginTransaction();
		session.save(f);
		transaction.commit();
		session.close();
	}

	public void update(Funcionario f) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		f.setSenha(Criptografia.criptografaSenha(f));
		transaction = session.beginTransaction();
		session.update(f);
		transaction.commit();
		session.close();
	}

	public void delete(Funcionario f) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(f);
		transaction.commit();
		session.close();
	}

	public Funcionario findByCode(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Funcionario f = (Funcionario) session.get(Funcionario.class, cod);
		session.close();
		return f;
	}

	public List<Funcionario> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Funcionario.class);
		List<Funcionario> lista = criteria.list();
		session.close();
		return lista;
	}

	public Funcionario logar(Funcionario f) {
		session = HibernateUtil.getSessionFactory().openSession();
		f.setSenha(Criptografia.criptografaSenha(f));
		query = session
				.createQuery("from Funcionario where email=:param1 and senha=:param2");
		query.setString("param1", f.getEmail());
		query.setString("param2", f.getSenha());
		Funcionario resp = (Funcionario) query.uniqueResult();
		session.close();
		return resp;
	}

	public List<Funcionario> findByNome(Funcionario f) {
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Funcionario f where f.nome like :param1");
			query.setString("param1", f.getNome() + "%");
			List<Funcionario> lst = query.list();
		session.close();
		return lst;
	}
	
	public Funcionario findByEmail(Funcionario f) {
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Funcionario f where f.email= :param1");
			query.setString("param1", f.getEmail());
		Funcionario func = (Funcionario) query.uniqueResult();
		session.close();
		return func;
	}

}
