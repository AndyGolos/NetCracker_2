package entities;

import java.time.LocalDate;

public class UserEntity extends AbstractEntity {

	private int id;
	private String name;
	private String surname;
	private String lastname;
	private String email;
	private String password;
	private LocalDate dateOfBirth;
	private LocalDate registration;

	public UserEntity() {
	}

	public UserEntity(int id, String name, String surname, String lastname, String email, String password,
			LocalDate dateOfBirth, LocalDate registration) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.registration = registration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getRegistration() {
		return registration;
	}

	public void setRegistration(LocalDate registration) {
		this.registration = registration;
	}
}
