package com.mystudy.poly04_interface;

class Pig extends AbstractAnimal {
	

	@Override
	public void eat() {
		System.out.println(">>많이 무엇이나 다 먹는다~~");
	}
	
	@Override
	public void sound() {
		System.out.println(">>꿀꿀~~");
	}
	
}
