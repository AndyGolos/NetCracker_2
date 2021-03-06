package entities;

public class BillEntity extends AbstractEntity {

	private int id;
	private int money;
	private String password;

	public BillEntity() {
	}

	public BillEntity(int id, int money, String password) {
		super();
		this.id = id;
		this.money = money;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
