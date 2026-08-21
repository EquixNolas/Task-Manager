package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Proyecto {
	
	private Long projectId;
	private String tittle;
	private String description;
	private LocalDateTime creationDate;
	private LocalDateTime releaseDate;
	
	private Usuario usuario;

	public Proyecto(Long projectId, String tittle, String description, LocalDateTime creationDate,
			LocalDateTime releaseDate, Usuario usuario) {
		super();
		this.projectId = projectId;
		this.tittle = tittle;
		this.description = description;
		this.creationDate = creationDate;
		this.releaseDate = releaseDate;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		return "Proyecto [projectId=" + projectId + ", tittle=" + tittle + ", description=" + description
				+ ", creationDate=" + creationDate + ", releaseDate=" + releaseDate + ", usuario=" + usuario + "]";
	}

	
	
}
