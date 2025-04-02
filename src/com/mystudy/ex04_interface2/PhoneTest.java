package com.mystudy.ex04_interface2;

class PhoneTest {

	public static void main(String[] args) {
		// Phone 객체(인스턴스) 생성 후 기능 테스트
		System.out.println("==== Phone =====");
		Phone ph1 = new Phone("010-1111-1111");
		ph1.view();
		ph1.call();
		ph1.receiveCall();
		ph1.sendMsg();
		ph1.receiveMsg();
		
		System.out.println("=== Mp3Phone ====");
		Mp3Phone mp3Ph = new Mp3Phone("010-2222-2222");
		mp3Ph.view(); // Phone 기능
		mp3Ph.call(); // Phone 기능
		mp3Ph.receiveCall(); // Phone 기능
		mp3Ph.sendMsg();
		mp3Ph.receiveMsg();
		
		mp3Ph.playMusic(); // Mp3Phone 기능
		
		System.out.println("=== WebPhone ====");
		WebPhone webPhone = new WebPhone("WebPhone", "010-3333-3333");
		//I_Phone 기능
		webPhone.view(); // Phone 기능
		webPhone.call(); // Phone 기능
		webPhone.receiveCall(); // Phone 기능
		webPhone.sendMsg();
		webPhone.receiveMsg();
		
		//I_Mp3Phone
		webPhone.playMusic();
		
		//I_WebPhone
		webPhone.searchWeb();

	}

}







