package beans.userbeans;

import java.time.LocalDate;
import java.util.List;

import beans.UserRole;

public class User {

	private int id;
	private String name;
	private String surname;
	private String lastname;
	private String email;
	private int password;
	private List<UserRole> role;
	private LocalDate registration;
	private LocalDate dateOfBirth;

	public User() {
	}

	/**
	 * @param id
	 * @param name
	 * @param surname
	 * @param lastname
	 * @param email
	 * @param password
	 * @param role
	 * @param registration
	 * @param dateOfBirth
	 */
	public User(int id, String name, String surname, String lastname, String email, int password, List<UserRole> role,
			LocalDate registration, LocalDate dateOfBirth) {
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public int getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(int password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public List<UserRole> getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(List<UserRole> role) {
		this.role = role;
	}

	/**
	 * @return the registration
	 */
	public LocalDate getRegistration() {
		return registration;
	}

	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(LocalDate registration) {
		this.registration = registration;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
