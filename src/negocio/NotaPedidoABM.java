package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.NotaPedidoDao;
import datos.Curso;
import datos.Materia;
import datos.NotaPedido;

public class NotaPedidoABM {
	
private static NotaPedidoABM instancia = null;
	
	protected NotaPedidoABM() {}

	public static NotaPedidoABM getInstance() {
		if(instancia==null) {
			instancia=new NotaPedidoABM();
		}
		return instancia;
	}
	
	public NotaPedido traerNotaPedidoConMateria(int idNotaPedido) {
		
		return NotaPedidoDao.getInstance().traerNotaPedidoConMateria(idNotaPedido);
	}

	public List<NotaPedido> traer(LocalDate fecha){
		return NotaPedidoDao.getInstance().traer(fecha);
	}

	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta){
		return NotaPedidoDao.getInstance().traerFinales(desde, hasta);
	}
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta, Materia materia){
		return NotaPedidoDao.getInstance().traerFinales(desde, hasta, materia);
	}
	public int agregar(LocalDate fecha, int cantEstudiantes, Materia materia, String codCurso){
		
		NotaPedido notaPedido = new Curso(fecha, cantEstudiantes, materia, codCurso);
		return NotaPedidoDao.getInstance().agregar(notaPedido);
		
		
		
	}
}