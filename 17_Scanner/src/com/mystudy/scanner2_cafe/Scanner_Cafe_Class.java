package com.mystudy.scanner2_cafe;

import java.util.Scanner;

class Order {
    private int input;
    private int cnt;
    private int total; // 개인이 주문한 총 tot
    private int total2; // 누적 주문금액
    private int[] sales = new int[5];
    private int[] sales2 = new int[5]; 

    // 메뉴 출력
    public void Menu() {
        System.out.println("<< Cafe Menu >>");
        System.out.println("1.아메리카노(3000)  2.카페라떼(3500)  3.카페모카(4000)  4.과일주스(5000)  0.계산하기  8.누적금액 9.프로그램 종료");
    }
    
    // 입력받기
    public void take(Scanner sc) {
        while (true) {
        	Menu();
            System.out.print("> 주문 : ");
            input = sc.nextInt();
            if (input == 0) {
                System.out.println("\n<<계산>>\n판매액 : " + total);
                Pay pay = new Pay();
				pay .process(sc, total);
                total = 0;  // total 초기화
                continue;
            } else if (input == 9) {
                System.out.println("\n프로그램을 종료합니다.");
                System.out.println("<< 총 판매 >>");
                summary();
                System.exit(0);
            } else if (input == 8) {
                summary();
                continue;
            }
            System.out.print("> 수량 선택 : ");
            cnt = sc.nextInt();
            cal();
        }
    }
    
    // 계산하기(주문금액)
    private void cal() {
        int price = 0;
        switch (input) {
            case 1:
                price = 3000;
                break;
            case 2:
                price = 3500;
                break;
            case 3:
                price = 4000;
                break;
            case 4:
                price = 5000;
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
                return;
        }
        total += (cnt * price);
        total2 += (cnt * price);
        sales[input] += cnt;
        sales2[input] += (cnt * price);
        System.out.println("총 금액은 " + total + "원입니다.");
    }
    
    // 정산하기
    private void summary() {
        System.out.println("<< 정산 >>");
        System.out.printf("아메리카노: %d잔\t금액: %d원\n", sales[1], sales2[1]);
        System.out.printf("카페라떼: %d잔\t금액: %d원\n", sales[2], sales2[2]);
        System.out.printf("카페모카: %d잔\t금액: %d원\n", sales[3], sales2[3]);
        System.out.printf("과일주스: %d잔\t금액: %d원\n", sales[4], sales2[4]);
        System.out.println("총 판매 금액: " + total2 + "원\n");
    }

    public int getTotal() {
        return total;
    }
}

class Pay {
	// 입금받기
    public void process(Scanner sc, int total) {
        int pay = 0;
        System.out.print("> 입금액 : ");
        pay = sc.nextInt();

        while (pay < total) {
            System.out.printf("금액이 부족합니다. 현재 입금액: %d원\n", pay);
            System.out.print("> 추가 입금: ");
            pay += sc.nextInt();
        }

        System.out.println("==================================");
        System.out.println("<< 영수증 >>");
        System.out.printf("입금액 : %d\n판매액 : %d\n잔액 : %d\n", pay, total, pay - total);
        System.out.println("==================================");
    }
}

public class Scanner_Cafe_Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        Pay pay = new Pay();

        while (true) {
            order.take(sc);

            if (order.getTotal() > 0) {
                pay.process(sc, order.getTotal());
            }
        }
    }
}
