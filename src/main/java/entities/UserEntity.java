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

	/**
	 * @param name
	 * @param surname
	 * @param lastname
	 * @param email
	 * @param password
	 * @param dateOfBirth
	 * @param registration
	 */
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
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
	 * @param surname
	 *            the surname to set
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
	 * @param lastname
	 *            the lastname to set
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the registration
	 */
	public LocalDate getRegistration() {
		return registration;

	}

	/**
	 * @param registration
	 *            the registration to set
	 */
	public void setRegistration(LocalDate registration) {
		this.registration = registration;
	}
}
