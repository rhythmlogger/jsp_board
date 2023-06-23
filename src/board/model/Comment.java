package board.model;

public class Comment {
	private int num;
	private int cnum;
	private String contents;
	private String id;

	public Comment(int num, String id, String contents) {
		this.num=num;
		this.id=id;
		this.contents=contents;
	}
	public Comment() {
		
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
