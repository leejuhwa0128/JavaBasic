package test;

import java.util.Scanner;

class Num implements Runnable{
	int num1;
	int num2;
	
	@Override
	public void run() {
		ones(num1, num2);
		Sleep(1000);
		tens(num1, num2);
		Sleep(1000);
		hundreds(num1, num2);
		Sleep(1000);
		cal(num1, num2);
		
	}

	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	private void Sleep(int milliseconds) {
		try {
			Thread.currentThread().sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void cal(int num1, int num2) {
		System.out.printf("결과:\t\t%5d\n",num1 * num2);
	}
	
	void ones(int num1, int num2) {
		System.out.printf("1의자리:\t\t%5d\n",num1 * (num2%10));
	}
	
	void tens(int num1, int num2) {
		System.out.printf("10의자리:\t\t%5d\n", num1 * ((num2%100)/10));
	}
	
	void hundreds(int num1, int num2) {
		System.out.printf("100의자리:\t  %d\n",num1 * (num2/100));
	}
	
	
}
public class three_three {

	public static void main(String[] args) {
		System.out.println(">> main() 시작");
		
		Num num = new Num();
		System.out.println("num1 : " + num.num1 + "\tnum2 : " + num.num2);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 두개를 입력(123 456) : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		num.setNum1(n1);
		num.setNum2(n2);
		
		Thread th1 = new Thread(num);
		th1.start();
		
		System.out.println(">> main() 끝");

	}

}
