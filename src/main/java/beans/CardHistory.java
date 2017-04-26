package beans;

import java.sql.Timestamp;

public class CardHistory {

	private int id;
	private int cardId;
	private Timestamp operationTime;
	private String valueChange;

	public CardHistory() {
	}

	/**
	 * @param id
	 * @param cardId
	 * @param operationTime
	 * @param valueChange
	 */
	public CardHistory(int id, int cardId, Timestamp operationTime, String valueChange) {
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
	 * @param id
	 *            the id to set
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
	 * @param cardId
	 *            the cardId to set
	 */
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the operationTime
	 */
	public Timestamp getOperationTime() {
		return operationTime;
	}

	/**
	 * @param operationTime
	 *            the operationTime to set
	 */
	public void setOperationTime(Timestamp operationTime) {
		this.operationTime = operationTime;
	}

	/**
	 * @return the valueChange
	 */
	public String getValueChange() {
		return valueChange;
	}

	/**
	 * @param valueChange
	 *            the valueChange to set
	 */
	public void setValueChange(String valueChange) {
		this.valueChange = valueChange;
	}
}
