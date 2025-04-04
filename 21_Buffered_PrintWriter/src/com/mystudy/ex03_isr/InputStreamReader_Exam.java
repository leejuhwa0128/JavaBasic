package com.mystudy.ex03_isr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_Exam {

	public static void main(String[] args) {
		/* InputStream --> Reader
		 * byte 처리 계열 --> 문자(Charecter) 처리 계열 전환
		 * InputStreamReader : InputStream -> Reader 전환
		 * OutputStreamWriter : OutputStream -> Writer 전환
		 */
		File file = new File("file/test_isr.txt");
		
		FileInputStream fis = null;
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream(file);
			
//			int readByte = fis.read(); // 1 byte 읽기
//			System.out.println("readByte : " + (char)readByte );
//			readByte = fis.read(); // 1 byte 읽기
//			System.out.println("readByte : " + (char)readByte ); // 한글 깨짐
			
			// byte 처리계열을 문자 처리계열로 변경
			isr = new InputStreamReader(fis);
			
			int readIsr = isr.read(); // 1문자 읽기
			System.out.println("isr : " + (char)readIsr);
			
			readIsr = isr.read();
			System.out.println("isr : " + (char)readIsr);
			
			// 버퍼기능 사용해서 라인단위 읽기
			br = new BufferedReader(isr); // 버퍼기능 사용 + 문자단위 처리 + 파일로부터 읽기
			String str = br.readLine();
			System.out.println("str : " + str);
			
			while(true) {
				if(str == null) break;
				str = br.readLine();
				System.out.println("str : " + str);	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
