package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.Days;

import entity.Locacao;

public class LocacaoDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Locacao l) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(l);
		transaction.commit();
		session.close();
	}

	public void update(Locacao l) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(l);
		transaction.commit();
		session.close();
	}

	public void delete(Locacao l) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(l);
		transaction.commit();
		session.close();
	}

	public Locacao findByCode(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Locacao l = (Locacao) session.get(Locacao.class, cod);
		session.close();
		return l;
	}

	public List<Locacao> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Locacao.class);
		List<Locacao> lista = criteria.list();
		session.close();
		return lista;
	}
	
	public List<Locacao> findByDataDevolucao() {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("from Locacao l where dataDevolucao=null");
		List<Locacao> lst = query.list();
		List<Locacao> resp = new ArrayList<Locacao>();
		for(Locacao l :lst){
			Locacao l1 = new Locacao();
				l1.setCliente(l.getCliente());
				l1.setDataDevolucao(l.getDataDevolucao());
				l1.setDataLocacao(l.getDataLocacao());
				l1.setIdLocacao(l.getIdLocacao());
				l1.setLivro(l.getLivro());
				l1.setMensagens(l.getMensagens());
				DateTime inicial = new DateTime(l1.getDataLocacao());
				DateTime fim = new DateTime(new Date());
				int dias = Days.daysBetween(inicial, fim).getDays();
				if (dias > 21) {
					l1.setStatus("Pendente");
				} else {
					l1.setStatus("Em Dia");
				}
				resp.add(l1);				
		}
		session.close();
		return resp;
	}
	
	public List<Locacao> findByData(Locacao l1, Locacao l2){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Locacao l where l.dataLocacao between :param1 and :param2");
			query.setDate("param1", l1.getDataLocacao());
			query.setDate("param2", l2.getDataLocacao());			
			List<Locacao> lista = query.list();
		session.close();
		return lista;
	}
	
}
