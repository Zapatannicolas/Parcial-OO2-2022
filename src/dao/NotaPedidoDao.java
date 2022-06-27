package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Final;
import datos.Materia;
import datos.NotaPedido;
import javassist.expr.Instanceof;

public class NotaPedidoDao {
	
	private static Session session;
	private Transaction tx;
	private static NotaPedidoDao instancia=null;
	
	protected NotaPedidoDao() {
		
	}
	public static NotaPedidoDao getInstance() {
		if(instancia==null) {
			instancia=new NotaPedidoDao();
		}
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException { 
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	protected void manejaExcepcion(HibernateException he) throws HibernateException { 
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	public NotaPedido traerNotaPedidoConMateria(int idNotaPedido) {
		NotaPedido objeto = null;
		try {
			iniciaOperacion();
			
			objeto = (NotaPedido)session.createQuery("from NotaPedido p  where p.idNotaPedido="+idNotaPedido).uniqueResult();
			Hibernate.initialize(objeto.getMateria());
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<NotaPedido> traer(LocalDate fecha){
		List<NotaPedido> objeto = null;

		try {
			iniciaOperacion();
			objeto = session.createQuery("from NotaPedido n inner join fetch n.materia a where fecha='"+fecha+"'").list();
			
			
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta){
		
		List<NotaPedido> objeto = null;
		List<NotaPedido> lista = new ArrayList<NotaPedido>();

		try {
			iniciaOperacion();
			objeto = session.createQuery("from NotaPedido n inner join fetch n.materia a").list();
			for(NotaPedido nota:objeto) {
				if(nota instanceof Final) {
					if(((Final)nota).getFechaExamen().isAfter(desde.minusDays(1)) && ((Final)nota).getFechaExamen().isBefore(hasta.plusDays(1))) {
						lista.add(nota);
					}
				}
			}
			
		}finally {
			session.close();
		}
		return lista;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta, Materia materia){
		
		List<NotaPedido> objeto = null;
		List<NotaPedido> lista = new ArrayList<NotaPedido>();

		try {
			iniciaOperacion();
			objeto = session.createQuery("from NotaPedido n inner join fetch n.materia m where m.idMateria="+materia.getIdMateria()).list();
			for(NotaPedido nota:objeto) {
				if(nota instanceof Final) {
					if(((Final)nota).getFechaExamen().isAfter(desde.minusDays(1)) && ((Final)nota).getFechaExamen().isBefore(hasta.plusDays(1))) {
						lista.add(nota);
					}
				}
			}
			
		}finally {
			session.close();
		}
		return lista;
		
	}
	
	public int agregar(NotaPedido objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
			
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw(he);
		}finally {
			session.close();
		}
		return id;
	}
	
	

}
