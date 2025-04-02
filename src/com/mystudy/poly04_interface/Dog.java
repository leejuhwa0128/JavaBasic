package com.mystudy.poly04_interface;

class Dog extends AbstractAnimal {

	public Dog() {
		super("개");
	}
	
	@Override
	public void sound() {
		System.out.println(">>멍멍~~");
	}

}
