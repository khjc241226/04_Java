package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.TodoListDAO;
import dao.TodoListDAOImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService{

	private TodoListDAO dao = null;
	
	// 기본 생성자
	public TodoListServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		// 객체 생성 시 TodoListDAO 객체 생성
		dao = new TodoListDAOImpl();
	}
	
	// 할 일 목록 반환 서비스 + 완료 개수
	@Override
	public Map<String, Object> todoListFullView() {
		
		// 할 일 목록 얻어오기 
		List<Todo> todoList = dao.todoListFullView();
		
		
		// 완료된 할 일 개수 카운트
		int completeCount = 0;

		for(Todo todo : todoList) {
			if(todo.isComplete()) {
				completeCount++;
			}
		}
		
		// 메서드에서 반환은 하나의 값 또는 객체 밖에 할 수 없기 때문에
		// Map이라는 컬렉션을 이용해 여러 값을 한 번에 담아서 반환
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		return map;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	@Override
	public String dateFormat(LocalDateTime regDate) {
		
    // 날짜와 시간을 원하는 포맷으로 출력하기
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = regDate.format(formatter);
		
    return formattedDateTime;
	}
	
	//-------------------------------------------------------------------------------------------------
	
	// 전달 받은 index 번째 todo를 String 형태로 가공해서 반환
	@Override
	public String todoDetailView(int index) {
		Todo todo = dao.todoDetailView(index);
		
		if(todo == null) return null;
		
		StringBuilder sb = new StringBuilder(); 
		
		sb.append("--------------------------------------------\n");
		sb.append( String.format("제목 : %s\n", todo.getTitle()) );
		sb.append( String.format("등록일 : %s\n", dateFormat(todo.getRegDate())) );		
		sb.append( String.format("완료여부 : %s\n", todo.isComplete() ? "O" : "X") );
		sb.append("\n[세부 내용]\n");
		sb.append("--------------------------------------------\n");
		sb.append( String.format("%s\n", todo.getDetail()) );
		
		return sb.toString();
	}
	
	//-------------------------------------------------------------------------------------------------
	
	
	// 할 일 추가
	// 성공 시 추가된 index 번호 반환, 실패 시 -1 반환
	@Override
	public int todoAdd(String title, String detail) throws FileNotFoundException, IOException {
		
		Todo todo = new Todo(title, detail, false, LocalDateTime.now());
		
		return dao.todoAdd(todo);
	}

	
	//-------------------------------------------------------------------------------------------------
	
	// 할 일 완료 여부 변경 (O <-> X)
	// 변경 성공 시 true, 실패시 false
	@Override
	public boolean todoComplete(int index) throws FileNotFoundException, IOException {
		return dao.todoComplete(index);
	}
	
	
	//-------------------------------------------------------------------------------------------------
		
	// 할 일 수정
	// 수정 성공 true, 실패 시 false
	@Override
	public boolean todoUpdate(int index, String title, String detail) throws FileNotFoundException, IOException {
		
		return dao.todoUpdate(index, title, detail);
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	// 할 일 삭제
	// 삭제 성공 시 삭제된 할 일의 제목 반환, 실패 시 null 반환
	@Override
	public String todoDelete(int index) throws FileNotFoundException, IOException {
		
		Todo deleteTarget = dao.todoDelete(index);
		
		if(deleteTarget != null) 	return deleteTarget.getTitle();
		return null;
	}
	
	
	
}
