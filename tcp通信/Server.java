package com.xsb.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception {

		// 客户端连接集合
		ArrayList<Socket> sockets = new ArrayList<>();

		// 1、创建服务器
		ServerSocket server = new ServerSocket(2009);
		System.out.println("服务器创建成功！");
		System.out.println("等待连接...");
		Scanner sc = new Scanner(System.in);
		// 2、循环接收客户端连接，并执行操作
		new Thread(() -> {
			while (true) {
				// 接收客户端连接
				Socket client = null;
				try {
					client = server.accept();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				sockets.add(client);// 添加client进ArrayList
				System.out.println(client.getRemoteSocketAddress() + ": 客户端连接成功！");
				// 解决lamda表达式嵌套时中报错“client必须是final类型”
				final Socket socket = client;

				// 接收信息
				new Thread(() -> {
					// 创建输入流
					DataInputStream dis = null;
					try {
						dis = new DataInputStream(socket.getInputStream());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					while (true) {
						String readUTF = "";
						try {
							readUTF = dis.readUTF();
						} catch (IOException e) {
							System.out.println(socket.getRemoteSocketAddress() + ": 断开连接！");
							break;
						}
						System.out.println(socket.getRemoteSocketAddress() + ":" + readUTF);
					}

				}).start();
			}
		}).start();

		// 发公告
		String message = sc.nextLine();
		for (Socket socket : sockets) {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF("服务器公告：" + message);
		}

	}
}
