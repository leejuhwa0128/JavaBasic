
public class Ex07_for_star_exam {

	public static void main(String[] args) {
		// 문제1 --------------
		//***** : * 5번 + 줄바꿈
		//****  : * 4번 + 줄바꿈
		//***   : * 3번
		//**    : * 2번
		//*     : * 1번
		//----------------------------
		int starCnt = 5;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= starCnt; j++) {
				System.out.print("*");
			}
			System.out.println();
			starCnt--;
		}
		System.out.println("-----------");
		starCnt = 5;
		
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;
		
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;
		
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;

		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;
		
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;
		
		System.out.println("----------------");	
		int lineCnt = 5;
		starCnt = lineCnt;
		String dispStr = "*";
		
		for (int line = 1; line <= lineCnt; line++) {
			for (int star = 1; star <= starCnt; star++) {
				System.out.print(dispStr);
			}
			System.out.println();
			starCnt--;
		}
		
		System.out.println("문제2 =============");
		// 문제2 -------------
		//    *  : 빈칸4 + "*" 1개 + 줄바꿈
		//   **  : 빈칸3 + "*" 2개 + 줄바꿈
		//  ***  : 빈칸2 + "*" 3개 + 줄바꿈
		// ****
		//*****
		//----------------------
		

		System.out.println("문제3 =============");
		//문제3 -------------
		//*****  : 빈칸0 + "*" 5개 + 줄바꿈
		// ****  : 빈칸1 + "*" 4개 + 줄바꿈
		//  ***  : 빈칸2 + "*" 3개 + 줄바꿈
		//   **  : 빈칸3 + "*" 2개 + 줄바꿈
		//    *
		//----------------------
		
		System.out.println("문제4 =============");
		//문제4 -------------
		//1        : (1 + 빈칸1) + 줄바꿈
		//1 2      : (1 + 빈칸1) + (2 + 빈칸1) + 줄바꿈
		//1 2 3    : (1 + 빈칸1) + (2 + 빈칸1) + (3 + 빈칸1) + 줄바꿈
		//1 2 3 4 
		//----------------------	

		System.out.println("문제5 =============");
		//문제5 -------------
		//1        : (1 + 빈칸1) + 줄바꿈
		//2 3      : (2 + 빈칸1) + (3 + 빈칸1) + 줄바꿈
		//4 5 6    : (4 + 빈칸1) + (5 + 빈칸1) + (6 + 빈칸1) + 줄바꿈
		//7 8 9 10 
		//----------------------		
		
		
		
			
	}

}
