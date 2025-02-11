package section01.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileService {
	/* File 클래스
	 * 
	 * - java.io 패키지
	 * 
	 * - 파일/디렉토리(폴더)를 관리하는 클래스
	 *   (파일/디렉토리 존재 유무 관계 없음)
	 *   
	 * - 파일 생성, 제거, 이름, 크기, 마지막 수정일, 존재여부 등의 기능 제공 
	 *   
	 * - File 클래스 메서드
	 * 
	 * boolean  mkdir()          : 디렉토리 생성(1개)
	 * boolean  mkdirs()         : 경로상의 모든 디렉토리 생성
	 * boolean  createNewFile()  : 파일 생성
	 * boolean  delete()         : 파일/디렉토리 삭제
	 * String   getName()        : 파일 이름 반환
	 * String   getParent()      : 파일이 저장된 디렉토리 반환
	 * String   getPath()        : 전체 경로 반환
	 * boolean  isFile()         : 현재 File 객체가 관리하는게 파일이면 true
	 * boolean  isDirectory()    : 현재 File 객체가 관리하는게 디렉토리 true
	 * boolean  exists()         : 파일/디렉토리가 존재하면 true, 아님 false
	 * long     length()         : 파일 크기 반환
	 * long     lastModified()   : 파일 마지막 수정일 (1970.01.01 09:00 부터 현재까지 지난 시간을 ms 단위로 반환)
	 * String[] list()           : 디렉토리 내 파일 목록을 String[] 배열로 반환
	 * File[]   listFiles()      : 디렉토리 내 파일 목록을 File[] 배열로 반환 
	 */
	
	/* [개발 상식]
	 * 
	 * - OS : 운영 체제
	 * 
	 * - 폴더 (Windows) == 디렉토리(Linux/Mac)
	 * 
	 * - 경로 표기 방법 -> 하위 폴더 접근 방법
	 * Windows    : \ (백슬래시)
	 * Linux/Mac  : / (슬래시)
	 * 
	 * ex) Windows : C:\workspace\04_Java\12_io
	 *     Mac     : /Users/OOO/workspace/04_Java/12_io
	 *     
	 * * Java는 모든 운영체제에서 호환된다!!!
	 *  -> 코드에서 경로 표기시 \,/를 신경쓰지 않아도 된다.
	 *   -> JVM이 실행 시 실행되는 운영체제에 맞춰서 해석 
	 *   
	 *       
	 * - 최상위 경로(최상위 폴더, root)
	 * Windows   : C:, D:, E: (다수 존재 가능)
	 * Linux/Mac : / 
	 */
	
	/**
	 * File 클래스를 이용한 객체 생성 + 폴더 관리
	 */
	public void test1() {
		
		// 실제로 파일/폴더의 유무 관계 없이 일단 참조!
		File directory = new File("C:/workspace/04_Java/12_io/io_test/20250211");
		
		System.out.println("폴더 경로 : " + directory.getPath());
		
		// exist : 존재하다
		System.out.println("폴더 유무 확인 : " + directory.exists());
		
		if(!directory.exists()) { // 폴더가 없다면
			
			// 폴더(디렉토리) 생성
			if(directory.mkdirs()) { // 생성 성공 시
				System.out.println("폴더가 생성되었습니다");
			}
	
		} else { // 폴더가 존재 한다면
			
			System.out.println("부모 폴더 : " + directory.getParent());
			File parent = new File(directory.getParent()); // 부모 폴더 참조
			
			// 모든 자식을 File[]로 얻어오기
			File[] files = parent.listFiles();
			
			for(File f : files) {
				f.delete(); // 자식 폴더/파일 삭제
			}
			
			// 부모 폴더 삭제 시 
			// 자식 폴더/파일이 있으면 삭제 불가!
			// -> 해결방법 : 내부 폴더/파일을 모두 지우고 부모 폴더 삭제
			if(parent.delete()) { 
				System.out.println("폴더가 삭제 되었습니다");
			}
		}
	}
	
	/**
	 * 지정된 경로에 파일 생성하기
	 */
	public void test2() {
		
		/* 절대 경로 : 절대적 기준(root폴더) 부터 경로 표기
		 * 
		 * 상대 경로 : 현재 위치/현재 프로젝트 기준으로 경로 표기
		 */
		
		// File 클래스를 이용해서 객체 생성
		File folder = new File("io_test/20250211");
		
		// 폴더가 없다면 폴더 생성
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		// 파일 생성
		File file = new File(folder.getPath() + "/파일생성.txt");
		
		// 파일생성.txt 파일이 없다면
		if(!file.exists()) {
			
			try {
				// 파일 생성
				if( file.createNewFile() ) {
					System.out.println("파일이 생성 되었습니다");
				} 
			}catch(IOException e) {
				System.out.println("--- 파일 생성 중 예외 발생 ---");
				e.printStackTrace(); // 예외 발생 메서드 추적
			}
			
		} else {
			System.out.println("이미 " + file.getName() + " 파일이 존재합니다");
		}
	}
	
	
	/**
	 * 입력 받은 폴더에 존재하는 모든 폴더/파일 목록 출력
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("폴더 경로 입력 : ");
		String path = sc.nextLine();
		
		// 입력 받은 폴더를 참조할 File 객체 생성
		File folder = new File(path);
		
		// 폴더가 없을 경우
		if(!folder.exists()) {
			System.out.println("잘못된 경로가 입력 되었습니다");
			return;
		}
		
		// 폴더 내 모든 폴더/파일을 File[]로 반환 받기
		// -> File[] listFiles();
		File[] files = folder.listFiles();
		
		for(File f : files) {
			
			// 파일명
			String fileName = f.getName();
			
			// 마지막 수정일
			long lastModified = f.lastModified(); 
			// -> 1970.01.01 09:00:00.000 기준으로 
			//    지난 시간 만큼의 ms 값이 반환
			
			// SimpleDateFormat : 간단히 날자 형식을 지정할 수 있는 객체
			SimpleDateFormat sdf 
				= new SimpleDateFormat("yyyy-MM-dd a h:mm");
			
			String date = sdf.format(lastModified); 
			// ms -> 날짜 형식 문자열로 변환
			
			
			// 파일 유형
			String type = null;
			if(f.isFile()) type = "파일";
			else					 type = "폴더";
			
			
			// 파일 크기
			String kb = null;
			if(f.isFile()) { // 파일인 경우에만 크기 측정
				
				long fileSize = f.length(); // 파일의 바이트 크기 반환
				
				// Byte -> KB 변경
				long size = fileSize/1024;
				
				if(size < 1) size = 1; // 1kb 미만은 모두 1로 표기
				
				kb = size + "KB";
			}
			
			
			// 문자열 출력
			System.out.printf(
					"%-20s %-20s %-5s %-10s \n",
					fileName, date, type, kb == null ? "" : kb );
		}
		
	}
	
	
}
