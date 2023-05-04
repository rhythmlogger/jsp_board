package board.model;

public class Comment {
	private int num;
	private int rnum;
	private String contents;
	private String id;

	public Comment(int num, String contents, String id) {
		this.num=num;
		this.contents=contents;
		this.id=id;
	}
	public Comment() {
		
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
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
