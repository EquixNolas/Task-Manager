package entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usuario_id")
	private Long userId;
	@Column(name="nombre")
	private String name;
	@Column(name="apellido_1")
	private String lastName;
	@Column(name="apellido_2")
	private String secondLastName;
	@Column(name="email")
	private String email;
	@Column(name="password_hash")
	private String passwordHash;
	@Column(name="fecha_alta")
	private LocalDateTime registrationDate;
	
	public Usuario(Long userId, String name, String lastName, String secondLastName, String passwordHash, String email,
			LocalDateTime registrationDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.passwordHash = passwordHash;
		this.email = email;
		this.registrationDate = registrationDate;
	}

	public Usuario() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Usuario [userId=" + userId + ", name=" + name + ", lastName=" + lastName + ", secondLastName="
				+ secondLastName + ", passwordHash=" + passwordHash + ", email=" + email + ", registrationDate="
				+ registrationDate + "]";
	}
	
	
}
