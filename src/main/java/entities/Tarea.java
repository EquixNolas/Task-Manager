package entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tareas")
public class Tarea {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tareaId;
	@Column(name="titte", nullable = false, length = 100)
	private String tittle;
	@Column(name="description")
	private String description;
	@Column(name="fecha_creacion", updatable = false)
	private LocalDateTime creationDate;
	@Column(name="fecha_vencimiento")
	private LocalDateTime releaseDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado", length=20)
	private Estado estado;
	
	@Enumerated(EnumType.STRING)
	@Column(name="prioridad", length=20)
	private Prioridad prioridad;
	
	@ManyToOne
	@JoinColumn(name="proyecto_id")
	private Proyecto proyecto;
	
	@ManyToMany
	@JoinTable(
			name = "tarea_etiqueta",
			joinColumns = @JoinColumn(name="tarea_id"),
			inverseJoinColumns = @JoinColumn(name="etiqueta_id")
		)
	private Set<Etiqueta> etiquetas = new HashSet<>();
	//Set evita duplicados y hashSet inicializa el conjunto vacio etiquetas[]

	public Tarea(Long tareaId, String tittle, String description, LocalDateTime creationDate, LocalDateTime releaseDate,
			Estado estado, Prioridad prioridad, Proyecto proyecto, Set<Etiqueta> etiquetas) {
		super();
		this.tareaId = tareaId;
		this.tittle = tittle;
		this.description = description;
		this.creationDate = creationDate;
		this.releaseDate = releaseDate;
		this.estado = estado;
		this.prioridad = prioridad;
		this.proyecto = proyecto;
		this.etiquetas = etiquetas;
	}
	public Tarea() {
		super();
	}
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
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
	public Set<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
	@Override
	public int hashCode() {
		return Objects.hash(tareaId, tittle);
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
		return Objects.equals(tareaId, other.tareaId) && Objects.equals(tittle, other.tittle);
	}
	@Override
	public String toString() {
		return "Tarea [tareaId=" + tareaId + ", tittle=" + tittle + ", description=" + description + ", creationDate="
				+ creationDate + ", releaseDate=" + releaseDate + ", estado=" + estado + ", prioridad=" + prioridad
				+ ", proyecto=" + proyecto + ", etiquetas=" + etiquetas + "]";
	}

}
