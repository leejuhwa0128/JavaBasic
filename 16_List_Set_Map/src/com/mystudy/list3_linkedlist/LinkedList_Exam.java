package com.mystudy.list3_linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedList_Exam {

	public static void main(String[] args) {
		// LinkedList : List 속성
		LinkedList<String> list = new LinkedList<String>();
		list.add("홍길동"); //0번 인덱스
		list.add("홍길동"); //1번 인덱스
		list.add("김유신");
		list.add("강감찬");
		System.out.println("list : " + list);
		System.out.println("size : " + list.size());
		
		list.remove("홍길동");
		System.out.println("list : " + list);
		
		System.out.println("---------------");
		String str = "홍길동,홍길동,김유신,강감찬,을지문덕,홍경래,김유신,홍길동";
		String[] names = str.split(",");
		System.out.println("names : " + Arrays.toString(names));
		
		//배열에 있는 데이터를 리스트에 추가
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}
		System.out.println("list : " + list);
		
		//list : 홍길동, 김유신, 강감찬, 홍길동, 홍길동, 김유신, 강감찬, 을지문덕, 홍경래, 김유신, 홍길동
		//-----------
		//(실습) 리스트에 있는 데이터 변경하기
		//1. 홍길동 모두 삭제(Delete)
		//2. 김유신 -> 김유신2 모두 수정(Update)
		//---------------
		
		//1. 홍길동 모두 삭제(Delete)
		System.out.println("list.contains(\"홍길동\") : " + list.contains("홍길동"));
		
		String name = "홍길동";
//		while (list.contains(name)) {
//			list.remove(name);
//		}
		
		//System.out.println("list.remove(\"홍길동999\") : " + list.remove("홍길동999"));
//		while (list.remove(name)) {
//			System.out.println(name + " 삭제");
//		}
		
		System.out.println("list.indexOf(\"홍길동\") : " + list.indexOf("홍길동"));
//		int idx;
//		while ((idx = list.indexOf(name)) != -1) {
//			list.remove(idx);
//		}
		
		//기본 반복문 사용 데이터 비교 후 삭제 처리
		System.out.println("--- for 문 사용 뒤에서 부터 찾아서 삭제 ---");
		int lastIndex = list.size() - 1;
		for (int i = lastIndex; i >= 0; i--) {
			System.out.println(i + " - list: " + list);
			if ("홍길동".equals(list.get(i))) {
				list.remove(i);
			}
		}
		System.out.println("삭제후 list : " + list);
		
		System.out.println("\n======= 김유신 -> 김유신2 변경(수정) ===========");
		//2. 김유신 -> 김유신2 모두 수정(Update)
		// 모든 데이터를 1번만 확인해서 처리
/*		
		for (int i = 0; i < list.size(); i++) {
			if ("김유신".equals(list.get(i))) {
				list.set(i, "김유신2");
				//break; //첫번째만 변경처리시
			}
		}
*/
		// 데이터 위치 확인 후 삭제
/*		
		while (list.indexOf("김유신") != -1) {
			System.out.println("김유신 있음 : " + list.indexOf("김유신"));
			list.set(list.indexOf("김유신"), "김유신2");
		}
		System.out.println("list.indexOf(\"김유신\") : " + list.indexOf("김유신"));
*/
		// 데이터 위치 확인 후 삭제
		while (true) {
			int idx = list.indexOf("김유신");
			if (idx == -1) break;
			list.set(idx, "김유신2");
		}
		System.out.println("변경후 list : " + list);
		

	}

}











