package test;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClientEcho222 {
	public static void main(String[] args) {
		System.out.println(">> 클라이언트 시작");

		try (Socket socket = new Socket(InetAddress.getLocalHost(), 10000);
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); // true : 자동 flush()
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				Scanner sc = new Scanner(System.in)) {
			
			System.out.println(":: 서버 접속 성공!!!");
			System.out.println("q 입력시 종료됩니다.\n");
			while (true) {
				System.out.print(">>[Client - 보낼 메세지] : ");
				String msg = sc.nextLine();
				pw.println(msg);
				
				if (msg.equalsIgnoreCase("q")) {
					System.out.println("\n>> 종료 요청 전송.\n");
					String response = br.readLine();
//                    System.out.println("[Client - 받은 메시지] " + response);

					// 서버에서 추가로 보낸 메시지 받기
					String finalMessage = br.readLine();
					System.out.println("[Client - 서버의 마지막 메시지] " + finalMessage);
					break;
				} 

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n>> 클라이언트 종료");
	}
}
