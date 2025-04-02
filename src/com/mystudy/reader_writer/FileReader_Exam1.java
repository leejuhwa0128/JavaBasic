package com.mystudy.reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Exam1 {

	public static void main(String[] args) {
		/* 문자(char) 단위 입력 처리
		 * FileReader : 파일로 부터 문자단위 데이터 읽기
		 * 문자단위 : A, 1, &, - , 1 byte 문자(또는 2 byte)
		 * 가, 대, 한 - 3byte(또는 2 byte)
		 * UTF-8 방식 : ASCII 코드 1byte, 한글은 3byte
		 * UTF-16 방식 : 모든 문자 2 byte
		 */
		File file = new File("file/test_char.txt");
		FileReader fr = null;
		
		try {
			// 1. 객체 생성
			fr = new FileReader(file);
			
			// 2. 객체 사용 작업 처리
			int readValue = fr.read();
			System.out.println("첫번째 문자값: " + readValue + "\tchar: " + (char)readValue);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 3. 사용객체 닫기(close)
	}

}
