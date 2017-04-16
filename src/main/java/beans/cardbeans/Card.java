package beans.cardbeans;

import java.time.LocalDate;

import beans.CardBill;
import beans.CardHistory;
import beans.CardStatus;
import beans.CardType;
import beans.userbeans.User;

public class Card {

	private int id;
	private User user;
	private CardBill bill;
	private int password;
	private CardStatus status;
	private CardType type;
	private LocalDate timeOfRegistration;
	private LocalDate validity;
	// TODO Возможно нужен лист!
	private CardHistory history;

	public Card() {
	}

	/**
	 * @param id
	 * @param user
	 * @param bill
	 * @param password
	 * @param status
	 * @param type
	 * @param timeOfRegistration
	 * @param validity
	 * @param history
	 */
	public Card(int id, User user, CardBill bill, int password, CardStatus status, CardType type,
			LocalDate timeOfRegistration, LocalDate validity, CardHistory history) {
		super();
		this.id = id;
		this.user = user;
		this.bill = bill;
		this.password = password;
		this.status = status;
		this.type = type;
		this.timeOfRegistration = timeOfRegistration;
		this.validity = validity;
		this.history = history;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the bill
	 */
	public CardBill getBill() {
		return bill;
	}

	/**
	 * @param bill
	 *            the bill to set
	 */
	public void setBill(CardBill bill) {
		this.bill = bill;
	}

	/**
	 * @return the password
	 */
	public int getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(int password) {
		this.password = password;
	}

	/**
	 * @return the status
	 */
	public CardStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(CardStatus status) {
		this.status = status;
	}

	/**
	 * @return the type
	 */
	public CardType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(CardType type) {
		this.type = type;
	}

	/**
	 * @return the timeOfRegistration
	 */
	public LocalDate getTimeOfRegistration() {
		return timeOfRegistration;
	}

	/**
	 * @param timeOfRegistration
	 *            the timeOfRegistration to set
	 */
	public void setTimeOfRegistration(LocalDate timeOfRegistration) {
		this.timeOfRegistration = timeOfRegistration;
	}

	/**
	 * @return the validity
	 */
	public LocalDate getValidity() {
		return validity;
	}

	/**
	 * @param validity
	 *            the validity to set
	 */
	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}

	/**
	 * @return the history
	 */
	public CardHistory getHistory() {
		return history;
	}

	/**
	 * @param history
	 *            the history to set
	 */
	public void setHistory(CardHistory history) {
		this.history = history;
	}
}
