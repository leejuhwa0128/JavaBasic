package com.mystudy.scanner3_bank;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
■ 클래스명 : BankATM
● 속성 : 통장금액(money)
● 필수기능
  - 메뉴표시(showMenu)
  - 메뉴별처리(processJob)
  - 입금기능(inputMoney) 
  - 출금기능(outputMoney) 
  - 잔액확인(showMoney)
*/
public class BankATM {
	Scanner scan = new Scanner(System.in);
	private int money;

	public void startBank() {
		System.out.println(">> ATM기 사용시작~~~");
		while (true) {
			if (!isRunningATM()) {
				System.out.println(":::ATM 사용 종료:::");
				break;
			}
		}
		System.out.println(">> ATM기 사용끝------");
	}

	private boolean isRunningATM() {
		showMenu();
		
		int select = -1;
		try {
			select = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(":: 잘못된 값 입력, 메뉴(0~3) 숫자만 입력하세요");
			return true; //다시시작
		} finally {
			scan.nextLine(); //빈문자열 읽어서 버리기
		}
		//System.out.println("select : " + select);
		
		if (select == 0) return false; //작업끝
		
		//선택값에 따른 작업처리
		processJob(select);
		
		return true;
	}
	private void showMenu() {
		System.out.println("----------------------------------");
		System.out.println("1.입금  2.출금  3.통장확인  0.종료");
		System.out.println("----------------------------------");
		System.out.print(">>작업선택 : ");
	}
	
	private void processJob(int select) {
		if (select == 1) {
			//System.out.println("::입금 처리~~");
			inputMoney();
			showMoney();
		} else if (select == 2) {
			//System.out.println("::출금 처리~~");
			outputMoney();
			showMoney();
		} else if (select == 3) {
			//System.out.println("::통장확인 처리~~");
			showMoney();
		} else {
			System.out.println("::메뉴(0~3) 중에서 선택하세요");
		}
		
	}

	public void showMoney() {
		System.out.println("::통장잔액 : " + money);
	}

	private void inputMoney() {
		while (true) {
			System.out.print(">>입금액 : ");
			try {
				money += Integer.parseInt(scan.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("::잘못된 값 입력, 숫자(0~9)만 입력하세요");
			}
		}
	}
	public void inputMoney(int money) {
		this.money += money;
		showMoney();
	}
	
	private void outputMoney() {
		while (true) {
			System.out.print(">>출금액 : ");
			try {
				money -= Integer.parseInt(scan.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("::잘못된 값 입력, 숫자(0~9)만 입력하세요");
			}
		}
	}


	
	
	
	
}









