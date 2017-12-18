package entities;

import java.time.LocalDate;

public class CardEntity extends AbstractEntity {

	private int id;
	private int userId;
	private int billId;
	private int cardType;
	private String password;
	private boolean status;
	private LocalDate registration;
	private LocalDate validity;

	public CardEntity() {
	}

	public CardEntity(int id, int userId, int billId, int cardType, String password, boolean status,
			LocalDate registration, LocalDate validity) {
		super();
		this.id = id;
		this.userId = userId;
		this.billId = billId;
		this.cardType = cardType;
		this.password = password;
		this.status = status;
		this.registration = registration;
		this.validity = validity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
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

	public LocalDate getRegistration() {
		return registration;
	}

	public void setRegistration(LocalDate registration) {
		this.registration = registration;
	}

	public LocalDate getValidity() {
		return validity;
	}

	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}
}
