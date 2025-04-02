package com.mystudy.scanner1;

import java.util.Scanner;

public class Scanner_Exam {

	public static void main(String[] args) {
		// Scanner : 주로 콘솔(화면)에서 데이터 읽어오기
		Scanner scan = new Scanner(System.in);
/**/		
		System.out.print("문자열 입력1 : ");
		String str1 = scan.nextLine();
		System.out.println("> str1 : " + str1);
		System.out.println("---");
		
		System.out.print("문자열 입력2 : ");
		String str2 = scan.nextLine();
		System.out.println("> str2 : " + str2);
/**/		
		System.out.println("=====================");
		
		System.out.println("정수값을 2개를 입력하면 더한 결과 출력");
		//int num1 = 100;
		//int num2 = 200;
		
		System.out.print("숫자입력1 : ");
		int num1 = Integer.parseInt(scan.nextLine()); //문자로 읽고 숫자로 형변환
		
		System.out.print("숫자입력2 : ");
		int num2 = scan.nextInt();
		scan.nextLine(); // 줄바꿈 문자 앞의 문자를 읽어서 버림처리
		
		int sum = num1 + num2;
		System.out.println("합계 : " + sum);
		
		System.out.print("문자열 입력 : ");
		String msg = scan.nextLine();
		System.out.println("msg : " + msg);
		
		System.out.println("\n>> main() 끝 ----------");
	}

}










