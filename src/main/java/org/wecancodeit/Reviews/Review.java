package org.wecancodeit.Reviews;

public class Review {

	private long id;
	private String title;
	private String imageUrl;
	private String category;
	private String content;
	private int star;

	public Review(long id, String title, String imageUrl, String category, String content, int star) {
		this.id = id;
		this.imageUrl = imageUrl;
		this.title = title;
		this.category = category;
		this.content = content;
		this.star = star;

	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return imageUrl;
	}

	public String getCategory() {
		return category;
	}
	public String getContent() {
		return content;
	}
	public int getStar() {
		return star;
	}
}
