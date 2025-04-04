package com.mystudy.ex02_buffered_filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyBufferedTest {

	public static void main(String[] args) {
		// 경과시간 비교
		// BufferedInputStream, BufferedOutputStream 적용
		// 파일복사(binary) : img30.jpg(원본) --> img30_copy_buf.jpg(복사본)
		// File -> FileInputStream -> BufferedInputStream
		// File -> FileOutputStream -> BufferedOutputStream
		//---------------------------------
		//버퍼없이 : FileInputStream, FileOutputStream
		System.out.println("=== FileInputStream, FileOutputStream 사용 ===");
		File inputFile = new File("file/img30.jpg");
		File outputFile = new File("file/img30_copy.jpg");
		
		long copingTime = filCopy(inputFile, outputFile);
		System.out.println("byte 단위 복사시간 : " + copingTime + "(밀리초)");
			
		
		//버퍼사용 : BufferedInputStream, BufferedOutputStream
		System.out.println("=== BufferedInputStream, BufferedOutputStream 사용 ===");
		String inputPath = inputFile.getPath();
		String outputPath = "file/img30_copy_buf2.jpg";
		System.out.println("inputPath : " + inputPath);
		
		copingTime = filCopy(inputPath, outputPath);
		System.out.println("buffer 사용 복사시간 : " + copingTime + "(밀리초)");
		
	}
	
	private static long filCopy(File inputFile, File outputFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//1. 파일을 읽고, 쓰기용 객체 생성(FileInputStream, FileOutputStream)
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			
			//2. 1 byte 읽고, 1 byte 쓰기 - read(), write(데이터) 반복
			long startTime = System.currentTimeMillis();
			
			while (true) {
				int readValue = fis.read();
				if (readValue == -1) break;
				fos.write(readValue);
			}
			
			long endTime = System.currentTimeMillis();
			
			return endTime - startTime;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용객체 닫기(close)
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {}
			try {
				if (fos != null) fos.close();
			} catch (IOException e) {}
		}
		
		return -1;
	}
	private static long filCopy(String inputPath, String outputPath) {
		
		//입력용, 출력용 객체 생성
		try (BufferedInputStream bis 
				= new BufferedInputStream(new FileInputStream(inputPath), 1000);
			 BufferedOutputStream bos
				= new BufferedOutputStream(new FileOutputStream(outputPath), 1000)) {
			
			long startTime = System.currentTimeMillis();
			
			int readValue = bis.read();
			while (readValue != -1) {
				bos.write(readValue);
				readValue = bis.read();
			}
			
			long endTime = System.currentTimeMillis();
			
			return endTime - startTime;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return -1;
	}



}
