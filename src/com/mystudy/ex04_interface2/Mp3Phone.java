package com.mystudy.ex04_interface2;

/* Mp3Phone 기능 구현(반드시 I_Phone, I_Mp3Phone 구현해라)
   전화정보확인, 전화걸고, 전화받고, 문자주고, 문자받고
   음악플레이
----------- */
// Phone 클래스 상속확장하고, I_Mp3Phone 인터페이스 기능 구현
class Mp3Phone extends Phone implements I_Mp3Phone {

	public Mp3Phone(String phoneNo) {
		super("Mp3Phone", phoneNo);
	}
	
	public Mp3Phone(String type, String phoneNo) {
		super(type, phoneNo);
	}

	@Override
	public void playMusic() {
		System.out.println("Mp3Phone>>> 음악플레이");
	}
	
	
}




