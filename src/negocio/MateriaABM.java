package negocio;

import dao.MateriaDao;
import datos.Materia;

public class MateriaABM {
	
private static MateriaABM instancia = null;
	
	protected MateriaABM() {}

	public static MateriaABM getInstance() {
		if(instancia==null) {
			instancia=new MateriaABM();
		}
		return instancia;
	}
	
	public Materia traerMateria(int idMateria) {
		return MateriaDao.getInstance().traerMateria(idMateria);
	}

}
