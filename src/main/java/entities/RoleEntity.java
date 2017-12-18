package entities;

public class RoleEntity extends AbstractEntity {

	private int id;
	private String role;

	public RoleEntity() {
		super();
	}

	public RoleEntity(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
