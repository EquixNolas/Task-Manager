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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="proyectos")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="proyecto_id")
	private Long projectId;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", nullable=false)
	private Usuario owner;
	
	@ManyToMany
	@JoinTable(
			name="usuario_proyecto",
			joinColumns = @JoinColumn(name="proyecto_id"),
			inverseJoinColumns = @JoinColumn(name="usuario_id")
	)
	private Set<Usuario> members = new HashSet<Usuario>();
	
	@Column(name="tittle")
	private String tittle;
	@Column(name="descripcion")
	private String description;
	@Column(name="fecha_creacion")
	private LocalDateTime creationDate;
	@Column(name="fecha_vencimiento")
	private LocalDateTime releaseDate;
	
	public Proyecto(Long projectId, Usuario owner, Set<Usuario> members, String tittle, String description,
			LocalDateTime creationDate, LocalDateTime releaseDate) {
		super();
		this.projectId = projectId;
		this.owner = owner;
		this.members = members;
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

	public Usuario getOwner() {
		return owner;
	}

	public void setOwner(Usuario owner) {
		this.owner = owner;
	}

	public Set<Usuario> getMembers() {
		return members;
	}

	public void setMembers(Set<Usuario> members) {
		this.members = members;
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
		return "Proyecto [projectId=" + projectId + ", owner=" + owner + ", members=" + members + ", tittle=" + tittle
				+ ", description=" + description + ", creationDate=" + creationDate + ", releaseDate=" + releaseDate
				+ "]";
	}
	
}