package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cliente;
import entity.Telefone;

public class TelefoneDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Telefone t) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		session.close();
	}

	public void update(Telefone t) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
	}

	public void delete(Telefone t) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		session.close();
	}

	public Telefone findByCode(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Telefone t = (Telefone) session.get(Telefone.class, cod);
		session.close();
		return t;
	}

	public List<Telefone> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Telefone.class);
		List<Telefone> lista = criteria.list();
		session.close();
		return lista;
	}

	
}
