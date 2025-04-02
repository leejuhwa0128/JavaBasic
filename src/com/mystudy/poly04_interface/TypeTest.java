package com.mystudy.poly04_interface;

public class TypeTest {

	public static void main(String[] args) {
		Cat cat = new Cat("마이고양이");
		//Cat cat = new Cat();
		System.out.println("cat name : " + cat.getName());
		
		cat.eat();
		cat.sleep();
		cat.sound();
		cat.jump();
		
		System.out.println("--- Dog ---");
		Dog dog = new Dog();
		System.out.println("dog name : " + dog.getName());
		dog.eat();
		dog.sleep();
		dog.sound();
		
		System.out.println("--- Pig ---");
		Pig pig = new Pig();
		pig.eat();
		pig.sleep();
		pig.sound();
		
		
		System.out.println("===== Animal(인터페이스) 타입 사용 ====");
		// 인터페이스 타입으로 형변환시 인터페이스에 정의된 기능(메소드)만 사용 가능
		Animal animal = new Cat();
		animal.eat();
		animal.sleep();
		animal.sound();
		//animal.jump(); // Cat 고유기능은 사용 못함
		
		System.out.println("---- Animal에 다양한 데이터 저장 사용 ---");
		soundPoly(cat);
		soundPoly(dog);
		soundPoly(pig);
		
		System.out.println("-------");
		eat(cat);
		eat(dog);
		eat(pig);

	}
	
	// Animal 인터페이스 타입으로 데이터를 받아서
	// 정의된 sound() 메소드 호출(실행)
	// (메소드 오버라이딩에 의해 저장된 객체의 메소드 호출된다)
	static void soundPoly(Animal animal) {
		animal.sound();
	}
	
	//Animal 인터페이스로 전달받아 eat() 메소드 실행
	static void eat(Animal animal) {
		animal.eat();
	}
	
	

}















