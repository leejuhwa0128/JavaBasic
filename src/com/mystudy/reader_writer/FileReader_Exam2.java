package com.mystudy.reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Exam2 {

	public static void main(String[] args) {
		// (실습) FileReader_Exam1 내용을 반복문으로 처리(모두 읽고 출력)
		File file = new File("file/test_char.txt");
		FileReader fr = null;

		try {
			fr = new FileReader(file);
			int value = fr.read();
			while (true) {
				if (value == -1)break;
				System.out.println("(int):" + value + "\t(char):" + (char) value);
				value = fr.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
