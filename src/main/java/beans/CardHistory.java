package beans;

import java.time.LocalDate;

public class CardHistory {

	private int id;
	private int cardId;
	private LocalDate operationTime;
	private String valueChange;

	public CardHistory() {
	}

	/**
	 * @param id
	 * @param cardId
	 * @param operationTime
	 * @param valueChange
	 */
	public CardHistory(int id, int cardId, LocalDate operationTime, String valueChange) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.operationTime = operationTime;
		this.valueChange = valueChange;
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
	 * @return the cardId
	 */
	public int getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the operationTime
	 */
	public LocalDate getOperationTime() {
		return operationTime;
	}

	/**
	 * @param operationTime the operationTime to set
	 */
	public void setOperationTime(LocalDate operationTime) {
		this.operationTime = operationTime;
	}

	/**
	 * @return the valueChange
	 */
	public String getValueChange() {
		return valueChange;
	}

	/**
	 * @param valueChange the valueChange to set
	 */
	public void setValueChange(String valueChange) {
		this.valueChange = valueChange;
	}
}
