package com.mystudy.socket02_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientEcho {
	public static void main(String[] args) {
		/* 클라이언트측 : 쓰고, 읽기
		 * 서버쪽으로 메시지를 1번 보내기 - PrintWriter
		 * 서버쪽에서 보내온 메시지를 받기 - BufferedReader
		 * PrintWriter <- OutputStream
		 * BufferedReader <- InputStreamReader <- InputStream
		 */
		System.out.println(">> 클라이언트 시작");
		
		Socket socket = null;
		
		try {
			//1. 소켓(Socket) 생성 : 접속할 IP주소, 포트(port) 정보로 서버 접속
			socket = new Socket(InetAddress.getLocalHost(), 10000);
			System.out.println(":: 서버 접속 성공!!!");
			
			// 2. 소켓으로부터 입/출력 객체 생성 - InputStream, OutputStream
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			// 5. 전송(out)할 데이터가 있으면 쓰기(write)
			Scanner sc = new Scanner(System.in);
			
			System.out.print(">>[Client - 보낼 메세지] : ");
			String msg = sc.nextLine();
			pw.println(msg);
			
			System.out.println("[Client - 보낸 메세지] : " + msg);
			pw.flush(); // 버퍼 데이터 출력
	
			
			//4. 받을 메시지가 있으면 읽기
			String msg2 = br.readLine();
			System.out.println("[Client - 받은 메시지] " + msg2);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) socket.close();
			}catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		
		System.out.println(">> 클라이언트 종료");
	}

}
