package com.mystudy.reader_writer_filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCharacterExamTWR {

	public static void main(String[] args) {
		// (실습)FileReader, FileWriter 사용해서 파일복사
		// 원본파일 : file/test_char.txt
		// 복사파일 : file/test_char_copy.txt
		// 처리 : 원본파일에서 읽어서 복사파일에 쓰기/저장(문자단위처리)
		//--------------------------
		
		//0. 사용할 파일객체 생성
		File readFile = new File("file/test_char.txt");
		File writeFile = new File("file/test_char_copy.txt");
		
		//1. FileReader, FileWriter 객체 생성 + 자동닫기 처리
		try (FileReader fr = new FileReader(readFile);
			 FileWriter fw = new FileWriter(writeFile);) {
			//2. 반복작업(원본 파일에서 읽고, 복사파일에 쓰기)
			System.out.println(">> 파일 읽기, 쓰기 시작 ---");
			while (true) {
				int readValue = fr.read();
				if (readValue == -1) break;
				System.out.println(readValue);
				fw.write(readValue);
			}
			
			System.out.println(">> 파일 읽기, 쓰기 끝 ---");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		

	}

}
