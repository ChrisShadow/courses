package Pila;

public class Tareas {
	private int idTarea;
	private String name;
	private int duracion;
	private String fechaInicio;
	private String fechaFin;
	private int horaInicio;
	private int horaioFin;
	private Estado estado; // atributo de tipo Enum
	
	//
	public Tareas() {
		
	}

	//Calculamos la duración y por ende la fecha fin depende de la fecha inicio
	public Tareas(int idTarea, String name, String fechaInicio, int horaInicio, int horaioFin, Estado estado) {
		this.idTarea = idTarea;
		this.name = name;
		this.fechaInicio = fechaInicio;
		this.horaInicio = horaInicio;
		this.horaioFin = horaioFin;
		this.estado = estado;
	}

	//Duración es calculada y el ID no se modifica. Solo getter de ambos
	public int getIdTarea() {
		return idTarea;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraioFin() {
		return horaioFin;
	}

	public void setHoraioFin(int horaioFin) {
		this.horaioFin = horaioFin;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	//Calcular duración
	public void CalcularDuracion() {
		if(this.getHoraInicio()<this.getHoraioFin()) {
			this.duracion = this.getHoraioFin()- this.getHoraInicio();
		}else if(this.getHoraInicio()>this.getHoraioFin()) {
			this.duracion = this.getHoraInicio()-this.getHoraioFin();
		}else {
			this.duracion =0;
		}
	}
	
	//Secuenciador del Id 
	public int IncrementarID() {
		int keyT=this.getIdTarea();
		
		keyT++;
		
		return keyT;
	}

	//Mostrar validando el formato de la hora
	@Override
	public String toString() {
		if (this.getHoraInicio()<1000 && this.getHoraioFin()<1000) {
			return "Tarea con código: " + getIdTarea() + ", Duracion: " + getDuracion()+" horas" + ", Nombre: " + getName()
			+ ", Fecha de Inicio: " + getFechaInicio() + ", Fecha de finalización: " + getFechaFin() + ", Hora Inicio: 0" 
			+ getHoraInicio() + ", Hora de finalización: 0" + getHoraioFin() + ", Estado: " + getEstado();
		}else if(this.getHoraInicio()<1000 && this.getHoraioFin()>1000) {
			return "Tarea con código: " + getIdTarea() + ", Duracion: " + getDuracion() + ", Nombre: " + getName()
			+ ", Fecha de Inicio: " + getFechaInicio() + ", Fecha de finalización: " + getFechaFin() + ", Hora Inicio: 0" 
			+ getHoraInicio() + ", Hora de finalización: " + getHoraioFin() + ", Estado: " + getEstado();
		}else if(this.getHoraInicio()>1000  && this.getHoraioFin()<1000) {
			return "Tarea con código: " + getIdTarea() + ", Duracion: " + getDuracion() + ", Nombre: " + getName()
			+ ", Fecha de Inicio: " + getFechaInicio() + ", Fecha de finalización: " + getFechaFin() + ", Hora Inicio: " 
			+ getHoraInicio() + ", Hora de finalización: 0" + getHoraioFin() + ", Estado: " + getEstado();
		}else {
			return "Tarea con código: " + getIdTarea() + ", Duracion: " + getDuracion() + ", Nombre: " + getName()
			+ ", Fecha de Inicio: " + getFechaInicio() + ", Fecha de finalización: " + getFechaFin() + ", Hora Inicio: " 
			+ getHoraInicio() + ", Hora de finalización: " + getHoraioFin() + ", Estado: " + getEstado();
		}
		
	}

	
	
	
}
