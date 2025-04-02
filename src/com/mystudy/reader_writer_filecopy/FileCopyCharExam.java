package com.mystudy.reader_writer_filecopy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCharExam {
    public static void main(String[] args) {
        /*
         * FileReader, FileWriter 사용해서 파일 복사
         * 원본파일 : file/test_char.txt
         * 복사파일 : file/test_char_copy.txt
         * 처리 : 원본파일에서 읽어서 복사파일에 쓰기/저장(문자 단위 처리)
         */

        File file = new File("file/test_char.txt");
        File file_w = new File("file/test_char_copy.txt");

		try (FileReader fr = new FileReader(file); FileWriter fw = new FileWriter(file_w);) {

			int value;
			while ((value = fr.read()) != -1) {
				System.out.println("(int):" + value + "\t(char):" + (char) value);
				fw.write(value);
			}
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(">> main() 끝 <<");
	}
}
