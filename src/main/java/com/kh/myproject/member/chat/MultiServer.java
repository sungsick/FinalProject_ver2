package com.kh.myproject.member.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiServer {

	public static void main(String[] args) {
		MultiServer multiServer = new MultiServer();
		multiServer.start();
	}

	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(8000);
			while (true) {
				System.out.println("[클라이언트 연결대기중]");
				socket = serverSocket.accept(); // ServerSocket객체의 accept의 반환 객체는 Socket객체이다.
				// Socket객체가 직접적으로 TCP와 IO 를 주고받는 객체이다.
				// ServerSocket은 포트번호와 객체를 연결 시켜주는 것 뿐이다. accept는 새현재 설정한 serversocket객체의 포트번호로
				// 다른 소켓이 연결되지 않으

				// client가 접속할때마다 새로운 스레드 생성
				System.out.println("multi server의 start메서드 실행");
				ReceiveThread receiveThread = new ReceiveThread(socket);
				receiveThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket!=null) {
				try {
					serverSocket.close();
					System.out.println("[서버종료]");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("[서버소켓통신에러]");
				}
			}
		}
	}
}

class ReceiveThread extends Thread {

	static List<PrintWriter> list =
			Collections.synchronizedList(new ArrayList<PrintWriter>());

	Socket socket = null;
	BufferedReader in = null;
	PrintWriter out = null;

	public ReceiveThread (Socket socket) {
		this.socket = socket;
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			list.add(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		String name = "";
		try {
			// 최초1회는 client이름을 수신
			name = in.readLine();
			System.out.println("[" + name + " 새연결생성]");
			sendAll("[" + name + "]님이 들어오셨습니다.");

			while (in != null) { // in이 null이 아닐 동안 계속 해서 메시지를 받을 수 있게끔 대기한다. 즉 서버는 최초에 1회 실행된 이후로
				// 계속 이 while문 안에 있는 것.
				String inputMsg = in.readLine();
				if("quit".equals(inputMsg)) break;
				sendAll(name + ">>" + inputMsg);
			}
		} catch (IOException e) {
			System.out.println("[" + name + " 접속끊김]");
		} finally {
			sendAll("[" + name + "]님이 나가셨습니다");
			list.remove(out);
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[" + name + " 연결종료]");
	}

	private void sendAll (String s) {
		for (PrintWriter out: list) {
			out.println(s);
			out.flush();
		}
	}
}