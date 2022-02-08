package com.ssafy.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IO1_ScannerTest {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			//방법1
			String a = in.readLine();
			System.out.println(a);
			
			//방법2
			char[] ch = in.readLine().toCharArray();
			for(char c: ch) {
				System.out.println(c);
			}
			
			//방법3
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(i+"//"+j);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
