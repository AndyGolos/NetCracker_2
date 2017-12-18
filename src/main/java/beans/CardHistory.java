package beans;

import java.sql.Timestamp;

public class CardHistory {

	private int id;
	private int cardId;
	private Timestamp operationTime;
	private String valueChange;

	public CardHistory() {
	}

	public CardHistory(int id, int cardId, Timestamp operationTime, String valueChange) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.operationTime = operationTime;
		this.valueChange = valueChange;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public Timestamp getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Timestamp operationTime) {
		this.operationTime = operationTime;
	}

	public String getValueChange() {
		return valueChange;
	}

	public void setValueChange(String valueChange) {
		this.valueChange = valueChange;
	}
}
