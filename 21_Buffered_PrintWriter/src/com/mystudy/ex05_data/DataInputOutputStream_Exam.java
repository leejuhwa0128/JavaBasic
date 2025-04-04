package com.mystudy.ex05_data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStream_Exam {

	public static void main(String[] args) {
		// DataInputStream, DataOutputStream
		// 기본 데이터 타입(8종류) 형식 쓰고, 읽기
		
		File file = new File("file/data.io_txt");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			// 파일의 쓰기
//			dos = new DataOutputStream(new FileOutputStream(file));
			System.out.println(":: 기본 데이터타입 값 출력");
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			dos.writeBoolean(true); // 1byte
			dos.writeByte(100); // 1byte
			dos.writeShort(999); // 2byte
			dos.writeChar('a'); // 2byte 
			dos.writeInt(100000); // 4byte
			dos.writeDouble(Math.PI); // 8byte 18
			dos.writeUTF("점심"); // 스페이스바(1byte) 1글자 : 3byte  
			System.out.println("파일의 크기: " + file.length() + "(byte)");
			
			// 읽기 위한 객체 생성
//			fis = new FileInputStream(file);
//			dis = new DataInputStream(fis);
			dis = new DataInputStream(new FileInputStream(file));
			System.out.println(":: 기본데이터 형식으로 읽기");
			boolean readBoolean = dis.readBoolean();
			byte readByte = dis.readByte();
			short readShort = dis.readShort();
			char readChar = dis.readChar();
			int readInt = dis.readInt();
			double readDouble = dis.readDouble();
			String readString = dis.readUTF();
			
			System.out.println("<< 읽은 데이터 화면 출력 >>");
			System.out.println("readBoolean : " + readBoolean);
			System.out.println("readByte : " + readByte);
			System.out.println("readShort : " + readShort);
			System.out.println("readChar : " + readChar);
			System.out.println("readInt : " + readInt);
			System.out.println("readDouble : " + readDouble);
			System.out.println("readString : " + readString);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
