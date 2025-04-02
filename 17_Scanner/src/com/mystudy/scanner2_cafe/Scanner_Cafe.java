package com.mystudy.scanner2_cafe;

import java.util.Scanner;

public class Scanner_Cafe {
	
	public static void main(String[] args) {
		/*
		 * 카페 음료 주문처리 음료의 종류 1. 아메리카노(3000) 2. 카페라떼(3500) 3. 카페모카(4000) 4. 과일주스(5000)
		 * 입력값 : 메뉴번호, 주문수량, 입금액(고객이 낸 돈) 처리 : 판매액(단가 * 수량), 잔액(입금액) 출력 : 입금액, 판매액, 잔액
		 * 1. 아메리카노(3000) 2. 카페라떼(3500) 3. 카페모카(4000) 4. 과일주스(5000) 
		 * > 메뉴선택(1~4) : ?? 
		 * > 주문수량 : ?? 
		 * > 입금액 : ?? 
		 * ================== 
		 * 입금액 : ?? (출력) 
		 * 판매액 : ?? (출력) 
		 * 잔액 : ?? (출력)
		 */
		Scanner sc = new Scanner(System.in);
		int input;
		int sum = 0;
		int cnt = 0;
		int pay = 0;
		
		while (true) {
			// 메뉴 입력받기
			System.out.println("<< Cafe Menu >>");
			System.out.println("0.종료하기  1.아메리카노(3000)  2.카페라떼(3500)  3.카페모카(4000)  4.과일주스(5000)");
			System.out.print("> 주문 : ");
			input = sc.nextInt();
			
			// 0 누르면 종료
			if (input == 0) {
				System.out.println("\n종료합니다.");
				break;
			}

			System.out.print("> 수량 선택 : ");
			cnt = sc.nextInt();
			
			// sum 초기화 (이전 주문 금액 누적 방지)
            sum = 0;
            
            // 주문 금액 계산
			switch (input) {
			case 1:
				sum += (cnt * 3000);
				break;
			case 2:
				sum += (cnt * 3500);
				break;
			case 3:
				sum += (cnt * 4000);
				break;
			case 4:
				sum += (cnt * 5000);
				break;
			default:
				System.out.println("잘못된 입력입니다.다시 선택하세요.");
				continue;
			}
			System.out.println("금액은 " + sum + "원입니다.");
			
			// 입금액 입력
			System.out.print("> 입금액 : ");
			pay = sc.nextInt();
			System.out.println("==================================");
			
			// 추가 입금 필요할 때 반복
			System.out.println("<< 추가 금액 지불 >>");
            while (pay < sum) {
                System.out.printf("금액이 부족합니다. 현재 입금액: %d원\n", pay);
                System.out.print("> 추가 입금: ");
                pay += sc.nextInt();
            }
            
            // 최종 결제 정보 출력
            System.out.println("==================================");
            System.out.println("<< 영수증 >>");
			System.out.printf("입금액 : %d\n판매액 : %d\n잔액 : %d", pay, sum, pay - sum);
			System.out.println("\n==================================");
		} // while문 끝
		

	}
}