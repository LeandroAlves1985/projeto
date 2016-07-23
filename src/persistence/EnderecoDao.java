package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cliente;
import entity.Endereco;

public class EnderecoDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Endereco e) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(e);
		transaction.commit();
		session.close();
	}

	public void update(Endereco e) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(e);
		transaction.commit();
		session.close();
	}

	public void delete(Endereco e) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(e);
		transaction.commit();
		session.close();
	}

	public Endereco findByCode(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Endereco e = (Endereco) session.get(Endereco.class, cod);
		session.close();
		return e;
	}

	public List<Endereco> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Endereco.class);
		List<Endereco> lista = criteria.list();
		session.close();
		return lista;
	}

	
}
