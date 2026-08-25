package entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="proyectos")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="proyecto_id")
	private Long projectId;
	
	@ManyToMany(mappedBy="proyectos")
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	
	@Column(name="tittle")
	private String tittle;
	@Column(name="descripcion")
	private String description;
	@Column(name="fecha_creacion")
	private LocalDateTime creationDate;
	@Column(name="fecha_vencimiento")
	private LocalDateTime releaseDate;
	
	public Proyecto(Long projectId, Set<Usuario> usuarios, String tittle, String description,
			LocalDateTime creationDate, LocalDateTime releaseDate) {
		super();
		this.projectId = projectId;
		this.usuarios = usuarios;
		this.tittle = tittle;
		this.description = description;
		this.creationDate = creationDate;
		this.releaseDate = releaseDate;
	}

	public Proyecto() {
		super();
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
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

	@Override
	public int hashCode() {
		return Objects.hash(projectId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		return Objects.equals(projectId, other.projectId);
	}

	@Override
	public String toString() {
		return "Proyecto [projectId=" + projectId + ", usuarios=" + usuarios + ", tittle=" + tittle + ", description="
				+ description + ", creationDate=" + creationDate + ", releaseDate=" + releaseDate + "]";
	}
}