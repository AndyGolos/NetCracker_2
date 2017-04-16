package beans;

public class CardStatus {

	private boolean status;

	public CardStatus() {
	}

	/**
	 * @param status
	 */
	public CardStatus(boolean status) {
		super();
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
}
