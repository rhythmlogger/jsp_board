package board.model;

public class Member {
	private int num;
	private String id;
	private String password;
	private String email;

	public Member() {

	}
	public Member(String id, String password) {
		this.id=id;
		this.password=password;
	}

	public Member(String id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public Member(int num, String id, String password, String email) {
		this.num = num;
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
