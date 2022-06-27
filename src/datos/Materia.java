package datos;

public class Materia {
	private int idMateria;
	private String nombre;
	private String carrera;
	public Materia(String nombre, String carrera) {
		super();
		this.nombre = nombre;
		this.carrera = carrera;
	}
	public Materia() {
		super();
	}
	public int getIdMateria() {
		return idMateria;
	}
	protected void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	@Override
	public String toString() {
		return "Materia [idMateria=" + idMateria + ", nombre=" + nombre + ", carrera=" + carrera + "]";
	}
	
	

}
