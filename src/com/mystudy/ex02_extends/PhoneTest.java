package com.mystudy.ex02_extends;

class PhoneTest {

	public static void main(String[] args) {
		// Phone 객체(인스턴스) 생성 후 기능 테스트
		System.out.println("==== Phone =====");
		Phone ph1 = new Phone("010-1111-1111");
		ph1.view();
		ph1.call();
		ph1.receiveCall();
		
		System.out.println("=== Mp3Phone ====");
		Mp3Phone mp3Ph = new Mp3Phone("010-2222-2222");
		mp3Ph.view(); // Phone 기능
		mp3Ph.call(); // Phone 기능
		mp3Ph.receiveCall(); // Phone 기능
		
		mp3Ph.playMusic(); // Mp3Phone 기능
		
		System.out.println("=== WebPhone ====");
		//WebPhone webPhone = new WebPhone("삼성갤럭시", "010-3333-3333");
		WebPhone webPhone = new WebPhone("010-3333-3333");
		webPhone.view(); // Phone 기능
		webPhone.call(); // Phone 기능
		webPhone.receiveCall(); // Phone 기능
		
		webPhone.webSearch();

	}

}







