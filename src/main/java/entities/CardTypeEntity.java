package entities;

public class CardTypeEntity extends AbstractEntity {

	private int id;
	private String type;

	public CardTypeEntity() {
	}

	/**
	 * @param id
	 * @param type
	 */
	public CardTypeEntity(int id, String type) {
		super();
		this.id = id;
		this.type = type;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
