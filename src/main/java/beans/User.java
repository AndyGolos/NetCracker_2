package beans;

import java.time.LocalDate;
import java.util.List;

public class User {

	private int id;
	private String name;
	private String surname;
	private String lastname;
	private String email;
	private String password;
	private List<UserRole> role;
	private LocalDate registration;
	private LocalDate dateOfBirth;

	public User() {
	}

	public User(int id, String name, String surname, String lastname, String email, String password,
			List<UserRole> role, LocalDate registration, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.registration = registration;
		this.dateOfBirth = dateOfBirth;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getRole() {
		return role;
	}

	public void setRole(List<UserRole> role) {
		this.role = role;
	}

	public LocalDate getRegistration() {
		return registration;
	}

	public void setRegistration(LocalDate registration) {
		this.registration = registration;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
