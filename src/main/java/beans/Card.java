package beans;

import java.time.LocalDate;
import java.util.List;

public class Card {

	private int id;
	private User user;
	private CardBill bill;
	private String password;
	private boolean status;
	private CardType type;
	private LocalDate timeOfRegistration;
	private LocalDate validity;
	private List<CardHistory> history;

	public Card() {
	}

	public Card(int id, User user, CardBill bill, String password, boolean status, CardType type,
			LocalDate timeOfRegistration, LocalDate validity, List<CardHistory> history) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CardBill getBill() {
		return bill;
	}

	public void setBill(CardBill bill) {
		this.bill = bill;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	public LocalDate getTimeOfRegistration() {
		return timeOfRegistration;
	}

	public void setTimeOfRegistration(LocalDate timeOfRegistration) {
		this.timeOfRegistration = timeOfRegistration;
	}

	public LocalDate getValidity() {
		return validity;
	}

	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}

	public List<CardHistory> getHistory() {
		return history;
	}

	public void setHistory(List<CardHistory> history) {
		this.history = history;
	}
}
