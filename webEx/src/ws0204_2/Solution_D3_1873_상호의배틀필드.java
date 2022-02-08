package ws0204_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_D3_1873_상호의배틀필드 {

	static String str = "1\n" + "3 7\n" + "***....\n" + "*-..#**\n" + "#<.****\n" + "23\n" + "SURSSSSUSLSRSSSURRDSRDS";

//	상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			String s = in.readLine();
			int H = Integer.parseInt(s.split(" ")[0]);// 3
			int W = Integer.parseInt(s.split(" ")[1]);// 7
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = in.readLine().toCharArray();
			}

//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map[i].length; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}

			//1.탱크의 위치찾기--------------------------------------------------
			int[] tank = new int[2];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					switch (map[i][j]) {
					case '<':
					case '^':
					case '>':
					case 'v':
						tank[0] = i;
						tank[1] = j;
					}
				}
			}
//			System.out.println(tank[0] + " " + tank[1]);
			
			//2. 탱크 이동, 슛------------------------------------------------
			int N = Integer.parseInt(in.readLine());
			String act = in.readLine();
			for (int i = 0; i < N; i++) {
				char c = act.charAt(i);
				switch (c) {
				case 'U':
					map[tank[0]][tank[1]] = '^';
					move(map, tank, 0);
					break;
				case 'D':
					map[tank[0]][tank[1]] = 'v';
					move(map, tank, 1);
					break;
				case 'L':
					map[tank[0]][tank[1]] = '<';
					move(map, tank, 2);
					break;
				case 'R':
					map[tank[0]][tank[1]] = '>';
					move(map, tank, 3);
					break;
				case 'S':
					shoot(map, tank);
					break;
				}
			}

			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void shoot(char[][] map, int[] tank) {
		int d = 0;
		switch (map[tank[0]][tank[1]]) {
		case '^':
			d = 0;
			break;
		case 'v':
			d = 1;
			break;
		case '<':
			d = 2;
			break;
		case '>':
			d = 3;
			break;
		}
		int cr = tank[0];
		int cc = tank[1];
		while(true) {
			cr = cr + dr[d];
			cc = cc + dc[d];
			if(cr < 0 || cr >= map.length || cc < 0 || cc >= map[0].length) return;
			if(map[cr][cc] == '*') {
				map[cr][cc] = '.';
				return;
			} else if(map[cr][cc] == '#') {
				return;
			}
		}
	}

	private static void move(char[][] map, int[] tank, int d) {
		int mr = tank[0] + dr[d];
		int mc = tank[1] + dc[d];
		if (mr < 0 || mr >= map.length || mc < 0 || mc >= map[0].length)
			return;
		if (map[mr][mc] == '.') {
			map[mr][mc] = map[tank[0]][tank[1]]; // 지도상에서 탱크의 위치를 변경
			map[tank[0]][tank[1]] = '.';         // 탱크의 이전 위치를 평지로 변경
			tank[0] = mr;                        // 탱크의 행좌표 변경
			tank[1] = mc;                        // 탱크의 열좌표 변경
		}
	}
}
//------------------------------------------------------------------------
/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D3_1873_상호의배틀필드 {
	static int[] dh = { -1, 1, 0, 0 };   //행
	static int[] dw = { 0, 0, -1, 1 };   //열

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/ws0204/input1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];  	// 전차의 위치를 두칸짜리 1차원배열에 저장

			int[] pos = new int[2];             // 전차가 발견되면 전차의 위치를 기억
			for (int i = 0; i < H; i++) {
				String c = sc.next();  				
				map[i] = c.toCharArray();
				for (int j = 0; j < map[i].length; j++) {
					switch (map[i][j]) {
					case '<':
					case '>':
					case '^':
					case 'v':         //탱크 위치를 저장
						pos[0] = i;
						pos[1] = j;
						break;
					}
				}
			}

			//명령을 입력받음
			int N = sc.nextInt();
			String oper = sc.next();
			for (int i = 0; i < oper.length(); i++) {
				char c = oper.charAt(i);
				switch (c) {
				case 'U':
					map[pos[0]][pos[1]] = '^';
					move(map, pos, 0);
					break;
				case 'D':
					map[pos[0]][pos[1]] = 'v';
					move(map, pos, 1);
					break;
				case 'L':
					map[pos[0]][pos[1]] = '<';
					move(map, pos, 2);
					break;
				case 'R':
					map[pos[0]][pos[1]] = '>';
					move(map, pos, 3);
					break;
				case 'S':
					shoot(map, pos);
					break;
				}
			}
			System.out.print("#" + tc + " ");

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}

		}
	}
	
	static void shoot(char[][] map, int[] pos) {
		int dir = 0;
		//현재 전차의 모양을 보고 방향을 결정
		switch (map[pos[0]][pos[1]]) {
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		}
		
		//nph npw는 대포알이 날아가는 위치
		int nph = pos[0];
		int npw = pos[1];
		while (true) {
			//방향으로 계속 이동
			nph = nph + dh[dir];
			npw = npw + dw[dir];
			
			//밖으로 나가면 끝
			if (nph < 0 || npw < 0 || nph >= map.length || npw >= map[0].length)
				return;
				
			
			if (map[nph][npw] == '*') {     //벽을 만나면 평지로 바꾸고 리턴
				map[nph][npw] = '.';
				return;
			
			} else if (map[nph][npw] == '#')  //강벽을 만나면 리턴
				return;
		}
	}

	static void move(char[][] map, int[] pos, int dir) {
		//해당 방향으로 이동
		int nph = pos[0] + dh[dir];
		int npw = pos[1] + dw[dir];
		
		//밖으로 나가면 리턴
		if (nph < 0 || npw < 0 || nph >= map.length || npw >= map[0].length)
			return;
		//이동하는 위치가 평지여야 이동가능
		if (map[nph][npw] == '.') {  
			map[nph][npw] = map[pos[0]][pos[1]];  //새로 이동하는 자리에 현재 전차를 갖다 놓고
			
			map[pos[0]][pos[1]] = '.';            //원래있던 자리를 평지로 바꿈
			pos[0] = nph;                         //전차의 위치 갱신
			pos[1] = npw;
		}
	}
}
*/