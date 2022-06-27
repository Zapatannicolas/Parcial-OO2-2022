package datos;

import java.time.LocalDate;

public class Final extends NotaPedido {
	private LocalDate fechaExamen;

	public Final(LocalDate fecha, int cantEstudiantes, Materia materia, LocalDate fechaExamen) {
		super(fecha, cantEstudiantes, materia);
		this.fechaExamen = fechaExamen;
	}
	
	public Final() {
		
	}
	

	public LocalDate getFechaExamen() {
		return fechaExamen;
	}

	public void setFechaExamen(LocalDate fechaExamen) {
		this.fechaExamen = fechaExamen;
	}

	@Override
	public String toString() {
		return "Final [fechaExamen=" + fechaExamen + ", idNotaPedido=" + idNotaPedido + ", fecha=" + fecha
				+ ", cantEstudiantes=" + cantEstudiantes + ", materia=" + materia + "]";
	}

	
	

}
