package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.Todo;

public class TodoListDAOImpl implements TodoListDAO{
	
	private final String FILE_PATH = "TodoList.bin";
	
	private List<Todo> todoList = null;
	
	private ObjectOutputStream oos = null;
	private ObjectInputStream	 ois = null;
	
	
	// 기본 생성자
	public TodoListDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// TodoList.bin 파일이 없으면 새로운 List 생성, 있으면 읽어오기
		File file = new File(FILE_PATH);
		
		if(!file.exists()) {
			
		} else {
				// 객체 생성 시 외부 파일에 작성된 List<Todo> 객체를 입력 받아 todoList에 대입
				
		}
		
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	/* TodoList를 파일로 저장 */
	@Override
	public void saveFile() throws FileNotFoundException, IOException {
		// 예외는 throws를 던져 버리기 때문에 catch문 불필요
		
		try {
			
		}finally {
			
		}
		
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	// 할 일 목록 반환 
	@Override
	public List<Todo> todoListFullView() {
		return todoList;
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	// 전달 받은 index 번째 todo를 반환, 없으면 null
	@Override
	public Todo todoDetailView(int index) {
		
		return null;
	}
	

	
	//-------------------------------------------------------------------------------------------------
	
	
	// 할 일 추가, 추가된 인덱스 번호 반환
	@Override
	public int todoAdd(Todo todo) throws FileNotFoundException, IOException {
		
		return 0;
	}

	
	//-------------------------------------------------------------------------------------------------
	
	// 할 일 완료 여부 변경 (O <-> X)
	// 해당 index 요소의 완료 여부가 변경되면 true, index 요소가 없으면 false
	@Override
	public boolean todoComplete(int index) throws FileNotFoundException, IOException {
		
		return false;
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	// 할 일 수정
	// 성공 시 true, 실패 시 false
	@Override
	public boolean todoUpdate(int index, String title, String detail) throws FileNotFoundException, IOException {
		
		return false;
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	// 할 일 삭제
	// 성공 시 삭제된 할 일(Todo) 반환,	인덱스 범위 초과로 실패 시 null 반환 
	@Override
	public Todo todoDelete(int index) throws FileNotFoundException, IOException{
		
		return null;
	}
	
	

}
