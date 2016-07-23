package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cliente;
import entity.Locacao;

public class ClienteDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Cliente c) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		session.close();
	}

	public void update(Cliente c) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(c);
		transaction.commit();
		session.close();
	}

	public void delete(Cliente c) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(c);
		transaction.commit();
		session.close();
	}

	public Cliente findByCode(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Cliente c = (Cliente) session.get(Cliente.class, cod);
		session.close();
		return c;
	}

	public List<Cliente> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Cliente.class);
		List<Cliente> lista = criteria.list();
		session.close();
		return lista;
	}

	public List<Cliente> findByNome(Cliente c) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session
				.createQuery("from Cliente c where c.nome like :param1");
		query.setString("param1", c.getNome() + "%");
		List<Cliente> lst = query.list();
		session.close();
		return lst;
	}
	
	public Cliente findByCpf(Cliente c) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("from Cliente c where c.cpf= :param1");
		query.setString("param1", c.getCpf());
		Cliente cli = (Cliente) query.uniqueResult();
		session.close();
		return cli;
	}
	



}
