package com.mystudy.poly03_abstract_class;

class TypeTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.eat();
		cat.sleep();
		cat.sound();
		
		Dog dog = new Dog();
		dog.sound();
		
		
		System.out.println("--------");
		sound(cat);
		sound(dog);

	}
	
	static void sound(AbstractAnimal animal) {
		animal.sound();
	}
	
	

}
