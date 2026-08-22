package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="etiquetas")
public class Etiqueta {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long etiqueta_id;
	@Column(name="nombre")
	private String name;
	@Column(name="color")
	private String color;
	
	@ManyToMany(mappedBy = "etiquetas")
	private Set<Tarea> tareas = new HashSet<Tarea>();
	
	public Etiqueta(Long etiqueta_id, String name, String color) {
		super();
		this.etiqueta_id = etiqueta_id;
		this.name = name;
		this.color = color;
	}

	public Etiqueta() {
		super();
	}

	public Long getEtiqueta_id() {
		return etiqueta_id;
	}

	public void setEtiqueta_id(Long etiqueta_id) {
		this.etiqueta_id = etiqueta_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(etiqueta_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etiqueta other = (Etiqueta) obj;
		return Objects.equals(etiqueta_id, other.etiqueta_id);
	}

	@Override
	public String toString() {
		return "Etiqueta [etiqueta_id=" + etiqueta_id + ", name=" + name + ", color=" + color + "]";
	}
	
}
