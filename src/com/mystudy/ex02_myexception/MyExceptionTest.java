package com.mystudy.ex02_myexception;

public class MyExceptionTest {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 -----");
		try {
			firstMethod(true);
		} catch (MyException e) {
			e.printStackTrace();
			System.out.println(">> main-catch문 실행");
			System.out.println("::오류메시지 : " + e.getMessage());
		}
		System.out.println("--- main() 끝 -----");
	}

	private static void firstMethod(boolean ex) throws MyException {
		System.out.println("-- firstMethod() 시작 --");
		System.out.println(">>firstMethod() 실행중");
		secondMethod(ex);
		System.out.println("-- firstMethod() 끝 --");
	}

	private static void secondMethod(boolean ex) throws MyException {
		System.out.println("---- secondMethod() 시작 ----");
		System.out.println(">>secondMethod() 실행중");
		if (ex) {
			//예외 발생 시키기
			throw new MyException("예외발생-secondMethod 실행중");
		}
		System.out.println("---- secondMethod() 끝 ----");
	}

}





