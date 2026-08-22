package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="tarea_etiqueta")
public class TareaEtiqueta {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tareaId;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long etiquetaId;
	
	
}
