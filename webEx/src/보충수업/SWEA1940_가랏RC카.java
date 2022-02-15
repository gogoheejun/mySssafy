package 보충수업;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA1940_가랏RC카 {

	 static int res = 0;
	    public static void main(String[] args) throws FileNotFoundException {
//	        System.setIn(new FileInputStream("input.txt"));
	        Scanner sc = new Scanner(System.in);
	        int TC = sc.nextInt();
	        //        int res = 0;
	        for(int t = 1; t <= TC ; t++) {
	            res = 0;
	            int speed = 0;
	            int N = sc.nextInt();
	            int val;
	            for(int i = 0; i < N; i++) {
	                int cmd = sc.nextInt();
	                switch(cmd) {
	                case 0 : // 현상유지
//	                    sc.nextInt();
	                    break;
	                case 1 : // 가속
	                    val= sc.nextInt();
	                    speed = speed + val;
	                    break;
	                case 2 : // 감속
	                    val= sc.nextInt();
	                    speed = speed - val;
	                    if(speed < 0) {
	                        speed = 0;
	                    }
	                    break;
	                }
	                res += speed;
	                
	            }
	            System.out.println("#" + t + " " + res);
	        }

	    }
}
