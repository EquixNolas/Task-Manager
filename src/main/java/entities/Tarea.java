package entities;

import java.time.LocalDateTime;
import java.util.HashSet;
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

}
