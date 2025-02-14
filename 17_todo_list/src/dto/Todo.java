package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Todo implements Serializable { // 직렬화
	private String title;						// 할 일 제목
	private String detail;					// 상세 내용
	private boolean complete;				// 완료 여부
	private LocalDateTime regDate;	// 등록 날짜
	
	// java.time 패키지
	// LocalDateTime : 날짜, 시간을 나타내는 클래스
	// LocalDateTime.now() : 현재 시간 반환
	
  // 날짜와 시간을 원하는 포맷으로 출력하기
  //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  //  String formattedDateTime = currentDateTime.format(formatter);
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}

	public Todo(String title, String detail, boolean complete, LocalDateTime regDate) {
		super();
		this.title = title;
		this.detail = detail;
		this.complete = complete;
		this.regDate = regDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Todo [title=" + title + ", detail=" + detail + ", complete=" + complete + ", regDate=" + regDate + "]";
	}
	
	
	
}
