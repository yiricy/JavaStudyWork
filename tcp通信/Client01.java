package com.xsb.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client01 {
	public static void main(String[] args) throws Exception {
		// 创建服务器01
		Socket client01 = new Socket("localhost", 2009);
		System.out.println("客户端创建成功！");
		// 创建输入输出流
		DataInputStream dis = new DataInputStream(client01.getInputStream());
		DataOutputStream dos = new DataOutputStream(client01.getOutputStream());
		Scanner sc = new Scanner(System.in);

		// 接收信息
		new Thread(() -> {
			while (true) {
				String readUTF = "";
				try {
					readUTF = dis.readUTF();
				} catch (IOException e) {
					System.out.println("服务器已关闭！");
					break;
				}
				System.out.println(readUTF);
			}
		}).start();

		// 发送信息
		while (true) {
			dos.writeUTF(sc.nextLine());
		}

	}
}
