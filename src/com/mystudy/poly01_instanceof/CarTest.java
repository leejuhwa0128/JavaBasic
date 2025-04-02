package com.mystudy.poly01_instanceof;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("=== Car 클래스 ===");
		Car car = new Car();
		car.type = "자동차(Car)";
		System.out.println("타입 : " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("=== Ambulance 클래스 ===");
		Ambulance am = new Ambulance();
		am.type = "구급차(Ambulance)";
		System.out.println("타입 : " + am.type);
		am.drive();
		am.stop();
		
		am.siren();
		
		System.out.println("=== FireEngine 클래스 ===");
		FireEngine fe = new FireEngine();
		fe.type = "소방차(FireEngine)";
		System.out.println("타입 : " + fe.type);
		fe.drive();
		fe.stop();
		
		fe.siren();
		fe.water();
		
		System.out.println("=================");
		//형변환
		Car carTemp = car;  // Car <--- Car
		//carTemp = am; // Car <- Ambulance
		//carTemp = fe; // Car <- FireEnging
		System.out.println("자동차타입 : " + carTemp.type);
		
		System.out.println("--- 타입확인(instanceof) ---");
		if (carTemp instanceof Object) {
			System.out.println(">> Object 타입이다");
		}
		if (carTemp instanceof Car) {
			System.out.println("-->> Car 타입이다");
			carTemp.drive();
			carTemp.stop();
		}
		if (carTemp instanceof Ambulance) {
			System.out.println("---->> Ambulance 타입이다");
			carTemp.drive();
			carTemp.stop();
			((Ambulance) carTemp).siren();
		}
		if (carTemp instanceof FireEngine) {
			System.out.println("---->> FireEngine 타입이다");
			carTemp.drive();
			carTemp.stop();
			((FireEngine) carTemp).siren(); // Car -> FireEngine 형변환 후 siren()
			((FireEngine) carTemp).water();
		}
		
		System.out.println("========================");
		System.out.println("---Car 타입객체 전달 사용 --");
		typeCheck(car); // Car
		
		System.out.println("---Ambulance 타입객체 전달 사용 --");
		typeCheck(am); // Ambulance
		
		System.out.println("---FireEngine 타입객체 전달 사용 --");
		typeCheck(fe); //FireEngine
		
		
	}
	//메소드 오버로딩(overloading)
	static void typeCheck(Car car) {
		System.out.println(":: Car 타입입니다");
		car.drive();
		car.stop();
	}
	
	static void typeCheck(Ambulance am) {
		System.out.println(":: Car 타입입니다");
		am.drive();
		am.stop();
		
		System.out.println(":: Ambulance 타입입니다");
		am.siren();
	}
	
	static void typeCheck(FireEngine fe) {
		System.out.println(":: Car 타입입니다");
		fe.drive();
		fe.stop();
		
		System.out.println(":: FireEngine 타입입니다");
		fe.siren();
		fe.water();
	}
	
	
	
	

}














