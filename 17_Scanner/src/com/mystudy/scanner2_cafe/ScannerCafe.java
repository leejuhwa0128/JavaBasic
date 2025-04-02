package com.mystudy.scanner2_cafe;

import java.util.Scanner;

// 카페 음료 주문처리
// 음료의 종류
// 1.아메리카노(3000)  2.카페라떼(3500)   3.카페모카(4000)  4. 과일주스(5000)
//-------------------------
// 입력값 : 메뉴번호, 주문수량, 입금액(고객이 낸 돈)
// 처리 : 판매액(단가 * 수량), 잔액(입금액 - 판매액)
// 출력 : 입금액, 판매액, 잔액
//------------------------------
/*
1.아메리카노(3000)  2.카페라떼(3500)   3.카페모카(4000)  4.과일주스(5000)  0.종료
> 메뉴선택(1~4) : 1
> 주문수량 : 3
> 입금액 : 10000
----------------
입금액 : 10000
판매액 : 9000
잔액 : 1000
=================== */
public class ScannerCafe {
	private Scanner scan = new Scanner(System.in);
	
	//(개인별실습) 메뉴별 단가(배열, List, Map 중 선택 사용)
	private static final int AMERICANO = 3000;
	private static final int CAFE_LATTE = 3500;
	private static final int CAFE_MOCA = 4000;
	private static final int JUICE = 5000;
	
	//(개인별실습) 선택메뉴별 판매 데이터를 기록해볼 것(판매순서대로)
	//선택메뉴명, 단가, 수량, 판매액 등 저장 관리
	private int inMoney; //입금액
	private int totMoney; //판매액
	private int change; //잔액
	private int todayIncome; //일 매출총액
	
	private int select; //선택메뉴값
	private int count; //선택수량

	public void openCafe() {
		
		while (true) {
			boolean isExit = inputData();
			if (isExit) {
				System.out.println(">> 영업종료~~~");
				System.out.println(":: 오늘 판매총액 : " + todayIncome);
				break;
			}
			
			//계산처리(판매액, 잔액)  ----------
			process();
			
			//계산결과 출력 ----------------
			//displayResult(inMoney, totMoney, change, todayIncome);
			displayResult();
			
		}// while끝
		
		
	} //메소드끝
	
	private void process() {	
		switch (select) {
		case 1: totMoney = AMERICANO * count; break;
		case 2: totMoney = CAFE_LATTE * count; break;
		case 3: totMoney = CAFE_MOCA * count; break;
		case 4: totMoney = JUICE * count; break;
		}
		change = inMoney - totMoney;
		todayIncome += totMoney; //일매출 기록
	}

	private boolean inputData() {
		System.out.println("1.아메리카노(3000)  2.카페라떼(3500)   3.카페모카(4000)  4.과일주스(5000)  0.종료");
		System.out.print("> 메뉴선택(1~4) : ");
		select = scan.nextInt();
		
		if (select == 0) {
			return true;
		}
		
		System.out.print("> 주문수량 : ");
		count = scan.nextInt();
		
		System.out.print("> 입금액 : ");
		inMoney = scan.nextInt();
		
		return false;
	}
	
	private void displayResult() {
		System.out.println("---------");
		System.out.println("입금액 : " + inMoney);
		System.out.println("판매액 : " + totMoney);
		System.out.println("잔액 : " + change);
		System.out.println();
		System.out.println(":: 오늘 판매총액 : " + todayIncome);
		System.out.println();
	}

	private void displayResult(int inMoney, int totMoney, int change, int todayIncome) {
		System.out.println("---------");
		System.out.println("입금액 : " + inMoney);
		System.out.println("판매액 : " + totMoney);
		System.out.println("잔액 : " + change);
		System.out.println();
		System.out.println(":: 오늘 판매총액 : " + todayIncome);
		System.out.println();
		
	}


}//class 끝






