package com.mystudy.ex04_interface2;

//(실습) WebPhone 클래스를 정의하고 기능 구현
// I_WebPhone 인터페이스 기능을 모두 구현하기
//-----------------
// Mp3Phone 클래스를 상속확장(extends)해서 적용하고
// I_WebPhone 인터페이스를 구현(implements)해서 만들기
class WebPhone extends Mp3Phone implements I_WebPhone {

	public WebPhone(String type, String phoneNo) {
		super(type, phoneNo);
	}

	@Override
	public void searchWeb() {
		System.out.println("WebPhone>> 웹검색~~");
	}


}
