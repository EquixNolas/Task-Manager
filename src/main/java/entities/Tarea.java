package entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Tarea {

	private Long tareaId;
	private String tittle;
	private String description;
	private LocalDateTime creationDate;
	private LocalDateTime releaseDate;
	private Prioridad prioridad;
	private Proyecto proyecto;
	
	public Long getTareaId() {
		return tareaId;
	}
	public void setTareaId(Long tareaId) {
		this.tareaId = tareaId;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Prioridad getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(tareaId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		return Objects.equals(tareaId, other.tareaId);
	}
	public Tarea(Long tareaId, String tittle, String description, LocalDateTime creationDate, LocalDateTime releaseDate,
			Prioridad prioridad, Proyecto proyecto) {
		super();
		this.tareaId = tareaId;
		this.tittle = tittle;
		this.description = description;
		this.creationDate = creationDate;
		this.releaseDate = releaseDate;
		this.prioridad = prioridad;
		this.proyecto = proyecto;
	}
	public Tarea() {
		super();
	}
	@Override
	public String toString() {
		return "Tarea [tareaId=" + tareaId + ", tittle=" + tittle + ", description=" + description + ", creationDate="
				+ creationDate + ", releaseDate=" + releaseDate + ", prioridad=" + prioridad + ", proyecto=" + proyecto
				+ "]";
	}
	
	
}
