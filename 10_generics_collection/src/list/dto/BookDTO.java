package list.dto;

public class BookDTO {
	private String title;  // 제목
	private String author; // 저자
	private int price;     // 가격
	private String publisher; // 출판사
	
	public BookDTO() {} // 기본 생성자

	public BookDTO(String title, String author, int price, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", author=" + author + ", price=" + price + ", publisher=" + publisher + "]";
	}
	
}
