package beans;

public class CardBill {
	
	private int id;
	private int money;
	
	public CardBill() {
	}
	
	/**
	 * @param id
	 * @param money
	 */
	public CardBill(int id, int money) {
		super();
		this.id = id;
		this.money = money;
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
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}	
}
