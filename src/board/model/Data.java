package board.model;

public class Data {
	public Data() {
		
	}
	private int hit;
	private int num;
	private String title;
	private String contents;
	private String id;
	
	public Data(String id, String title, String contents) {
		this.title=title;
		this.contents=contents;
		this.id=id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
