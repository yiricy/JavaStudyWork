package com.javaoop.xsb;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int[] input = new int[3];
		String judge = "";
		while (flag) {
			System.out.println("请输入第一条边");
			input[0] = sc.nextInt();
			System.out.println("请输入第二条边");
			input[1] = sc.nextInt();
			System.out.println("请输入第三条边");
			input[2] = sc.nextInt();
			
			TriangleJudge triangleJudge = new TriangleJudge(input);
			
			
			if (triangleJudge.isTriangle()) {
				System.out.println(triangleJudge.shape());
			}else {
				System.out.println("这不能构成三角形");
			}
			
			while (true) {
				System.out.println("要继续吗？（y/n）");
				judge = sc.next();
				if (judge.equals("n") || judge.equals("N")) {
					return;
				}else if (judge.equals("y") || judge.equals("Y")) {
					flag = true;
					break;
				}else {
					System.out.println("请输入正确指令！");
				}
			}
			
			
		}
		
		sc.close();
	}
}
