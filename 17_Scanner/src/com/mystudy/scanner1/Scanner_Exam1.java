package com.mystudy.scanner1;

import java.util.Scanner;

public class Scanner_Exam1 {

	public static void main(String[] args) {
		// Scanner : 주로 콘솔(화면)에서 데이터 읽어오기
		Scanner sc = new Scanner(System.in);

//		System.out.print("문자열 입력1: ");
//		String str1 = sc.nextLine(); // 줄바꿈앞의 문자를 읽어서 버림처리
//		System.out.println(">> str1 : " + str1);
//
//		System.out.print("문자열 입력2: ");
//		String str2 = sc.next();
//		System.out.println(">> str2 : " + str2);
//		System.out.println("============================");

		System.out.print("정수 2개 입력(예시: 3 5):");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = Integer.parseInt(sc.nextLine());
		System.out.printf("num1: %d, num2: %d\nnum1 + num2 = %d", num1, num2, num1 + num2);
		System.out.println("\n>> main() 끝");
	}

}
