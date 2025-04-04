package com.mystudy.thread02_runnable;

class Parent {
	void print() {
		System.out.println("Parent : 나는 Parent 클래스");
	}
}

// Object가 아닌 다른 클래스를 이미 상속 받은경우
// Thread를 상속받을 수 없을 경우 Runnable 인터페이스 구현
class RunnableImpl extends Parent implements Runnable {

	@Override
	public void run() {
		super.print();
		System.out.println("RunnableImpl run() : Runnable 인터페이스 구현");
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
}

public class RunnableImplThread {

	public static void main(String[] args) {
		System.out.println("---- main() 시작 ------");
		
		RunnableImpl runnableImpl = new RunnableImpl();
		runnableImpl.run();
		
		// Thread 클래스의 Thread(runnable) 생성자에 주입해서 생성한다.
		Thread th1 = new Thread(runnableImpl);
		th1.start();
		System.out.println("---- main() 끝 ------");
	}

}









