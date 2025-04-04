package test;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TCPServerEcho222 {
	public static void main(String[] args) {
		System.out.println(":: 서버 시작");

		try (ServerSocket server = new ServerSocket(10000)) {
			System.out.println(":: 서버(ServerSocket) 대기중~~~");

			try (Socket socket = server.accept();
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)) {
				System.out.println(">> 클라이언트 접속 성공!!!");

				String msg;
				List<String> messageLog = new ArrayList<>();

				while ((msg = br.readLine()) != null) {
					
						System.out.println("[Server - 받은 메시지] " + msg);

					if (msg.equalsIgnoreCase("q")) {
						String lastMsg = messageLog.isEmpty() ? "서버: 받은 메시지 없음."
								: "서버: 마지막 메시지 - " + messageLog.get(messageLog.size() - 1);
						pw.println(lastMsg);
						System.out.println("\n>> 종료 요청 수신.\n");

						Scanner sc = new Scanner(System.in);
						System.out.print(">>[Server - 보낼 메세지] : ");
						String msg2 = sc.nextLine();
						pw.println(msg2);
						//System.out.println("[Server - 보낸 메세지] : " + msg2);
						break;
					}

					messageLog.add(msg);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n:: 서버 종료");
	}
}
