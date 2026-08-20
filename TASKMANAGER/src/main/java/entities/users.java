package entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="")
public class users {

	@Id
	@Column(name="usuario_id")
	private String userId;
	private String name;
	private String lastName;
	private String secondLastName;
	private String email;
	private String pswHash;
	private LocalDate releaseDate;
}