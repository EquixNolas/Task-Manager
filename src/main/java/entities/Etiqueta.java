package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
}
