package com.xsb.file;


import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * 输入路径判断该路径下有多少行java代码
 * 空行不算，注释不算
 * @author yiricy
 * @date 2020年11月11日
 */
public class IOConutJava {
	
	static int line = 0;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		File file = new File(sc.next());

		IOConutJava io = new IOConutJava();
		io.findJAVAFile(file);
		System.out.println(line);
	}

	public void findJAVAFile(File file) throws IOException  {
		
		String fileName = null;
		String readLine = null;
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				if (file2.isFile()) {
					fileName = file2.getName();
					if (fileName.endsWith(".java")) {
						FileReader fr = null;
						fr = new FileReader(file2);
						BufferedReader br = new BufferedReader(fr);
						while ((readLine = br.readLine()) != null) {
							if (readLine.equals("") || readLine.startsWith("//") || readLine.startsWith("/**") || readLine.startsWith("*") || readLine.startsWith("/*") || readLine.endsWith("*/")) {
								continue;
							}
							line ++;
						}
						br.close();
						fr.close();
					}
					
				}else {
					findJAVAFile(file2);
				}
			}
		
		}else {
			fileName = file.getName();
			if (fileName.endsWith(".java")) {
				FileReader fr = null;
				fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				while ((readLine = br.readLine()) != null) {
					line ++;
				}
				br.close();
				fr.close();
			}
		}

	}
}
