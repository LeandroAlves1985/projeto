package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Funcionario;
import entity.Pessoa;

public class PessoaDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Pessoa p) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();
	}

	public void update(Pessoa p) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(p);
		transaction.commit();
		session.close();
	}

	public void delete(Pessoa p) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(p);
		transaction.commit();
		session.close();
	}

	public Pessoa findByCode(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Pessoa p = (Pessoa) session.get(Pessoa.class, cod);
		session.close();
		return p;
	}

	public List<Pessoa> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Pessoa.class);
		List<Pessoa> lista = criteria.list();
		session.close();
		return lista;
	}

}
