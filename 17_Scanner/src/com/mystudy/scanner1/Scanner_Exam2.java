package com.mystudy.scanner1;

import java.util.Scanner;

public class Scanner_Exam2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력 : ");
		String name = sc.next();
		
		System.out.print("국어 영어 점수 입력(예:10 20 30):");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
		double avg = (double)sum / 3;
		
		System.out.println("\n<<성적처리결과>>");
		System.out.println("국어: " + kor + "\n영어: " + eng + "\n수학: " + math);
		System.out.println("-----------");
		System.out.printf("총점: %d\n평균: %.2f", sum, avg);
	}

}
