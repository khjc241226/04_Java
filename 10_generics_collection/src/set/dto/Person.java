package set.dto;

import java.util.Objects;

public class Person {

	// [필드 == 멤버 변수]
	private String name; // 인스턴스 변수
	private int age;
	private char gender;
	// public static int natinalCode; // 클래스 변수
	
	// [생성자]
	public Person() {} // 기본 생성자
	
	// 매개 변수가 있는 생성자
	public Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	// equals(), hashCode() 오버라이딩 예정
	@Override
	public int hashCode() {
		return Objects.hash(age, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && gender == other.gender && Objects.equals(name, other.name);
	}


	
	
	
	
	
	
}
