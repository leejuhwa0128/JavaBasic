package com.mystudy.ex05_interface3;

// 인터페이스(interface)의 구성요소 
// - static final 상수 : public static final 변수
// - 추상메소드 : public abstarct 메소드
//----------------------------
// 자바8(JDK8)에서 추가된 요소 : 구현부(body)가 있는 메소드
// - public default 메소드 : public default 메소드명() { }
//     정의된 기능을 사용하거나, 재정의 해서 사용한다
// - public static 메소드 : 재정의 없이 인터페이스명으로 참조해서 사용
interface Phone {
	//상수화된 변수 : public static final 변수
	public static final boolean SUCESS_CALL = true;
	boolean FAIL_CALL = true; //public static final 변수
	
	// 인터페이스에 정의된 추상메소드는 모두 public abstract 메소드
	public abstract void view(); //전화정보 확인
	public void call(); //전화걸기 - abstract 생략됨
	void receiveCall(); //전화받기 - public abstract 생략됨
	void sendMsg(); //메시지 보내기 - public abstract 생략됨
	void receiveMsg(); //메시지 받기 - public abstract 생략됨
	
	//public default 메소드 -----------
	//구현 클래스에서 구현을 해도 되고 안해도 되는 메소드(기능)
	//재정의 해서 사용할 경우만 구현하면됨
	default void defaultMethod() {
		System.out.println("Phone 인터페이스의 default 메소드 실행~~~");
	}
	
	//public static 메소드 ----------
	static void staticMethod() {
		System.out.println("Phone 인터페이스의 static 메소드~~~");
	}
	
}








