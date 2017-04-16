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

	/**
	 * @param id
	 * @param userId
	 * @param billId
	 * @param cardTypeId
	 * @param password
	 * @param status
	 * @param registration
	 * @param validity
	 */
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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the billId
	 */
	public int getBillId() {
		return billId;
	}

	/**
	 * @param billId
	 *            the billId to set
	 */
	public void setBillId(int billId) {
		this.billId = billId;
	}

	/**
	 * @return the cardTypeId
	 */
	public int getCardType() {
		return cardType;
	}

	/**
	 * @param cardTypeId
	 *            the cardTypeId to set
	 */
	public void setCardType(int cardType) {
		this.cardType = cardType;
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
	 * @return the status
	 */
	public boolean getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
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

}
