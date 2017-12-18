package entities;

import java.sql.Timestamp;

public class UsageHistoryEntity extends AbstractEntity {

	private int id;
	private int cardId;
	private Timestamp operationTime;
	private String valueChange;

    public UsageHistoryEntity() {
    }

	public UsageHistoryEntity(int id, int cardId, Timestamp operationTime, String valueChange) {
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
