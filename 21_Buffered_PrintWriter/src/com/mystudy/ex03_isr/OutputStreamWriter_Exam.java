package com.mystudy.ex03_isr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_Exam {

	public static void main(String[] args) {
		/* InputStream --> Reader
		 * byte 처리 계열 --> 문자(Charecter) 처리 계열 전환
		 * InputStreamReader : InputStream -> Reader 전환
		 * OutputStreamWriter : OutputStream -> Writer 전환
		 */
		
		System.out.println(">> main() 시작");
		File file = new File("file/test_osr.txt");

		FileOutputStream fos = null; // byte 단위
		OutputStreamWriter osw = null;

		try {
			fos = new FileOutputStream(file);
			fos.write('a'); // 정상출력
			fos.write('가'); // 출력 x : 한글(3byte)은 출력 안됨
			fos.write('\n');
			fos.write('@');

			osw = new OutputStreamWriter(fos);
			osw.write("\n가나다라마다");
			osw.write("\n마지막close");

			osw.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (osw != null)
					osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(">> main() 끝");
	}

}
