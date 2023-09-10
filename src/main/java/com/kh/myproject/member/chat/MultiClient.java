package com.kh.myproject.member.chat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiClient {

	public static void main(String[] args) {
		MultiClient multiClient = new MultiClient();
		multiClient.start();
	}

	public void start() {
		Socket socket = null;
		BufferedReader in = null;
		try {
			socket = new Socket("localhost", 8000);
			// 여기서 서버와 바로 소켓 통신이 이뤄진다.

			System.out.println("[서버와 연결되었습니다]");

			String name = "user" + (int)(Math.random()*10);
			Thread sendThread = new SendThread(socket, name); // 메서드가 실행되면 새로운 스레드를 생성한다.
			// 랜덤으로 생성한 유저 번호와 지정한 포트번호에서 생성된 스레드로 스레드 객체를 생성한다.으
			sendThread.start(); // thread 클래스의 오버라이딩된 start메서드. 여기서 대기중이던 seversockeㅅ과 연결되는 지점이라고 생각된다.

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (in != null) {
				String inputMsg = in.readLine();
				if(("[" + name + "]님이 나가셨습니다").equals(inputMsg)) break;
				System.out.println("From:" + inputMsg);
			}
		} catch (IOException e) {
			System.out.println("[서버 접속끊김]");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[서버 연결종료]");
	}
}

class SendThread extends Thread {
	Socket socket = null;
	String name;

	Scanner scanner = new Scanner(System.in);

	public SendThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			// 최초1회는 client의 name을 서버에 전송
			PrintStream out = new PrintStream(socket.getOutputStream());
			out.println(name);
			out.flush();

			while (true) {
				String outputMsg = scanner.nextLine();
				out.println(outputMsg);
				out.flush();
				if("quit".equals(outputMsg)) break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}