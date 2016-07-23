package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Mensagem;

public class MensagemDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	public void create(Mensagem m)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(m);
			transaction.commit();
		session.close();
	}
	
	public void delete(Mensagem m)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.delete(m);
			transaction.commit();
		session.close();
	}
	
	public List<Mensagem> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
			List<Mensagem> lista = session.createCriteria(Mensagem.class).list();
		session.close();
		return lista;		
	}
	
	public Mensagem findByCode(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
			Mensagem m = (Mensagem) session.get(Mensagem.class, cod);
		session.close();
		return m;
	}
	
	

}
