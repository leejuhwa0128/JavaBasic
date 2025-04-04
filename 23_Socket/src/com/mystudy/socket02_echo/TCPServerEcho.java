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
import java.util.Scanner;

public class TCPServerEcho {
	public static void main(String[] args) {
		/* 서버측 : 읽고, 쓰기
		 * 클라이언트에서 보내온 메시지를 1번 받고 - BufferedReader
		 * 받은 메시지를 클라이언트에게 다시 보내기 - PrintWriter
		 * BufferedReader <- InputStreamReader <- InputStream
		 * PrintWriter <- OutputStream
		 */
		System.out.println(":: 서버 시작");

		
		ServerSocket server = null;

		try {
			// 1. ServerSocket 객체 생성
			server = new ServerSocket(10000);
			System.out.println(":: 서버(ServerSocket) 대기중~~~");
			
			Socket socket = server.accept();
			System.out.println(">> 클라이언트 접속");
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			//4. 받을 메시지가 있으면 읽기
			String msg = br.readLine();
			System.out.println("[Server - 받은 메시지] " + msg);
			
			Scanner sc = new Scanner(System.in);
			// 5. 전송(out)할 데이터가 있으면 쓰기(write)
//			String msg2 = "서버에서 클라이언트한테 보내는 문장";
//			System.out.println("[Server - 보낸메시지] " + msg2);
			System.out.print(">>[Server - 보낼 메세지] : ");
			msg = sc.nextLine();
			pw.println(msg);
			System.out.println("[Server - 보낸 메세지] : " + msg);
			
			pw.flush(); // 버퍼 데이터 출력
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null) server.close();
			}catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		System.out.println(":: 서버 종료");
	}
}
