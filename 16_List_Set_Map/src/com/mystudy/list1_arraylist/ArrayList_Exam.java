package com.mystudy.list1_arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_Exam {

	public static void main(String[] args) {
		// ArrayList : Array(배열)의 속성을 가진 List(목록)
		// -----------------------
		//ArrayList<Integer> list = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("list.size() : " + list.size());
		System.out.println("list : " + list);
		
		// 입력(C) : 맨 뒤에 추가
		System.out.println("--- add(데이터) : 맨 뒤에 추가 ---");
		list.add(new Integer(5)); // Interger 저장
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(7);
		System.out.println("list : " + list.toString());
		
		//조회(R) : 특정 위치값 확인
		int value = list.get(0);
		System.out.println("list.get(0) : " + list.get(0));
		
		// 입력(C) : 특정 위치에 데이터 추가(입력)
		System.out.println("--- add(index, 데이터) ---");
		list.add(0, 100);
		System.out.println("list : " + list.toString());
		
		// 수정(U) : 지정된 위치에 데이터 수정(변경)
		System.out.println("--- set(index, 데이터) ---");
		list.set(0, 999);
		System.out.println("list : " + list.toString());
		
		// 조회,검색(R) : 특정 위치의 데이터 읽기(조회, 검색, 확인, 선택)
		System.out.println("--- get(index) ---");
		int firstData = list.get(0);
		System.out.println("list.get(0) : " + firstData);
		System.out.println("list.get(1) : " + list.get(1));
		System.out.println("list : " + list);
		
		// 삭제(D) : 특정 위치 데이터 삭제
		System.out.println("--- remove(index) ---");
		int returnValue = list.remove(0);
		System.out.println("list : " + list);
		System.out.println("list.remove(0) return : " + returnValue);
		
		//==============================
		System.out.println("--------------");
		list.add(888);
		System.out.println("list : " + list);
		System.out.println("list.size() : " + list.size());
		
		// remove(int index)
		Integer removedData = list.remove(5); // int 5 전달
		System.out.println("list.remove(5) 실행후 list : " + list);
		System.out.println("list.size() : " + list.size());
		System.out.println("remove 값 : " + removedData);
		
		// remove(Object o)
		boolean removeSuccess = list.remove(Integer.valueOf(5));
		System.out.println("list.remove(Integer 5) 실행후 list : " + list);
		System.out.println("list.size() : " + list.size());
		System.out.println("삭제여부 : " + removeSuccess);
		
		System.out.println("===== 전체 데이터 사용 ====");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		System.out.println("-------");
		
		for (Integer data : list) {
			System.out.println(data);
		}
		
		System.out.println("===== (실습)모든 데이터 삭제(반복문사용 직접삭제) =====");
		//list.clear();
		System.out.println("삭제전 list : " + list);
		System.out.println("삭제전 갯수 : " + list.size());
		
//		int dataCount = list.size();
//		for (int i = 0; i < dataCount; i++) {
//			System.out.println("list : " + list);
//			//list.remove(0); //첫번째 데이터 삭제
//			list.remove(list.size() - 1); //마지막 데이터 삭제
//		}
		
		while (list.size() > 0) {
			System.out.println("list : " + list);
			//list.remove(0); //시작 데이터 삭제
			list.remove(list.size() - 1); //끝 데이터 삭제
		}
		
		System.out.println("----");
		System.out.println("삭제후 list : " + list);
		System.out.println("삭제후 갯수 : " + list.size());
		
		
		
		

	}

}










