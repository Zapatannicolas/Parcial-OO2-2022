package datos;

import java.time.LocalDate;

public class Curso extends NotaPedido{
	private String codCurso;
	
	
	public Curso() {
		
	}

	public Curso(LocalDate fecha, int cantEstudiantes, Materia materia, String codCurso) {
		super(fecha, cantEstudiantes, materia);
		this.codCurso = codCurso;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	@Override
	public String toString() {
		return "Curso [codCurso=" + codCurso + "]";
	}
	

}
