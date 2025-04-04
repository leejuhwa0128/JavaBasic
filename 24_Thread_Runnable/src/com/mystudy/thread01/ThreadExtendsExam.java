package com.mystudy.thread01;

// 쓰레드로 동작하는 클래스 만들기
// Thread 클래스를 상속확장(extends)해서 만들기
class MyThread extends Thread{
	int count = 10;
	public MyThread(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		/* Thread 클래스의 run() 메서드를 오버라이딩(Overriding)해서
		 * 쓰레드로 하려는 작업 작성(구현)
		 */
		System.out.println(this.getId() + " : " + this.getName() + " - run() 시작");
		
		for(int i = 1; i <= 10; i++) {
			System.out.println((this.getName() + " : " + i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
public class ThreadExtendsExam {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== main() 시작 ===");
		
		Thread mainThread = Thread.currentThread(); // 현재 실행중인 쓰레드
		System.out.println("mainThread : " + mainThread);
		
		MyThread th1 = new MyThread(10);
		th1.setName("MyThread(내가만든)-1"); // 쓰레드 이름
		th1.setPriority(Thread.MAX_PRIORITY); // 가중치
		System.out.println("th1 : " + th1);
		// th1.run(); // 단순 메서드 호출
		th1.start(); // 쓰레드로 동작시키려면 start() 호출
		
		// ----------------------------
		MyThread th2 = new MyThread(10);
		th2.setName("MyThread(내가만든)-22");
		th2.setPriority(Thread.MIN_PRIORITY);
		System.out.println("th2 : " + th2);
		th2.start();
		// ----------------------------
		th1.join();
		
		
		System.out.println("=== main() 끝 ===");
	}

}
