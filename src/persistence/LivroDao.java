package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cliente;
import entity.Livro;
import entity.Locacao;

public class LivroDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Livro l) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(l);
		transaction.commit();
		session.close();
	}

	public void update(Livro l) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(l);
		transaction.commit();
		session.close();
	}

	public void delete(Livro l) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(l);
		transaction.commit();
		session.close();
	}

	public Livro findByCode(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Livro l = (Livro) session.get(Livro.class, cod);
		session.close();
		return l;
	}

	public List<Livro> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Livro.class);
		List<Livro> lista = criteria.list();
		session.close();
		return lista;
	}

	public List<Livro> findByNome(Livro l) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session
				.createQuery("from Livro l where l.nomeLivro like :param1");
		query.setString("param1", l.getNomeLivro() + "%");
		List<Livro> lst = query.list();
		session.close();
		return lst;
	}

}
