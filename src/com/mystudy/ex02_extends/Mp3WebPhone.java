package com.mystudy.ex02_extends;

//기능 : 전화걸고, 받고, 전화정보보기 + 음악플레이 + 웹검색 기능
// ctrl + T : 상속관계 확인
class Mp3WebPhone extends Mp3Phone {

	public Mp3WebPhone(String phoneNo) {
		super("Mp3WebPhone", phoneNo);
	}
	
	public Mp3WebPhone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	//-------------------
	public void webSearch() {
		System.out.println(">>Mp3WebPhone - 웹 검색");
	}

}
