package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Materia;

public class MateriaDao {
	
	private static Session session;
	private Transaction tx;
	private static MateriaDao instancia=null;
	
protected MateriaDao() {
		
	}
	public static MateriaDao getInstance() {
		if(instancia==null) {
			instancia=new MateriaDao();
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
	
	public Materia traerMateria(int idMateria) {
		
		Materia objeto = null;
		try {
			iniciaOperacion();
			objeto = (Materia)session.createQuery("from Materia m where idMateria="+idMateria).uniqueResult();
			
		}finally {
			session.close();
		}
		return objeto;
	}
	

}
