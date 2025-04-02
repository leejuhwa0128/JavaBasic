
public class Ex04_break_continue {

	public static void main(String[] args) {
		// 반복제어문 : break, continue
		// break : 중단(반복을 중단하고 현재 실행중인 반복문 빠져나감)
		// continue : 이어서 다음 반복 처리
		//-----------------------
		
		// 1~10 까지 출력하되 8은 출력하지 않는다
		System.out.println("--- continue 문 사용 안한 경우 ----");
		for (int i = 1; i <= 10; i++) {
			if (i != 8) {
				System.out.print(i + " ");
			} 
		}
		System.out.println(); //단순 줄바꿈
		
		System.out.println("--- continue 문 사용 -----");
		for (int i = 1; i <= 10; i++) {
			if (i == 8) continue; // 다음 반복 진행(건너뜀)
			System.out.print(i + " ");
		}
		
		// \n : 줄바꿈(New Line)
		System.out.println("\n================");
		
		System.out.println("--- break 사용 ---");
		// 1~10 출력중 8을 만나면 처리 중단
		for (int i = 1; i <= 10; i++) {
			if (i == 8) break; //현재 반복 중단하고 빠져나감
			System.out.print(i + " ");
		}
		System.out.println();

	}

}









