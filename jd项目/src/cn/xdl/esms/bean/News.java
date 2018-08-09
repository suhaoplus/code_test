package cn.xdl.esms.bean;

import java.sql.Timestamp;

public class News {

	private int id;
	private String title;
	private String content;
	/**
	 * 发布时间
	 */
	private Timestamp release_time;
	/**
	 * 是否置顶'y'   'n'
	 */
	private String sticky;

	public News() {
		super();
	}

	public News(int id, String title, String content, Timestamp release_time, String sticky) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.release_time = release_time;
		this.sticky = sticky;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRelease_time() {
		return release_time;
	}

	public void setRelease_time(Timestamp release_time) {
		this.release_time = release_time;
	}

	public String getSticky() {
		return sticky;
	}

	public void setSticky(String sticky) {
		this.sticky = sticky;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", release_time=" + release_time
				+ ", sticky=" + sticky + "]";
	}



}
