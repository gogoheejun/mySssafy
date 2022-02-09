package ws0209;

//https://www.acmicpc.net/problem/16935
import java.util.*;

public class Main_BJ_16935_배열돌리기3 {
	static int N; // 배열크기 행
	static int M; // 배열크기 열
	static int R; // 연산의 수
	static int[][] map; // 배열
	static int[][] transMap; // 결과 저장 배열
	static int num; // 연산번호

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 배열크기 행
		M = sc.nextInt(); // 배열크기 열
		R = sc.nextInt(); // 연산의 수
		map = new int[N][M]; // 배열

		// 배열값 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 연산의 수만큼 반복
		for (int i = 0; i < R; i++) {
			num = sc.nextInt();                   // 연산번호
			switch (num) {
				case 1:	upDown();        break;   // 상하반전
				case 2:	leftRight();     break;   // 좌우반전
				case 3: rightRotation(); break;   // 오른쪽 90도 회전
				case 4: leftRotation();  break;   // 왼쪽 90도 회전
				case 5:	fiveMove(); 	 break;   // 1->2, 2->3, 3->4, 4->1 이동
				case 6:	sixMove();	     break;   // 1->4, 4->3, 3->2, 2->1 이동
			}
		}

		// 배열 결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	// 상하반전 1---------------------------------------------------------
	public static void upDown() {
		int[][] transMap = new int[N][M]; // 결과 저장 배열

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// N-i-1을 하면 거꾸로 입력이 된다.
				transMap[N - i - 1][j] = map[i][j];
			}
		}
		map = transMap;
	}
	// 좌우반전 2---------------------------------------------------------
	public static void leftRight() {
		transMap = new int[N][M]; // 결과 저장 배열

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// M-j-1을 하면 맨 뒤의 열부터 채워진다.
				transMap[i][M - j - 1] = map[i][j];
			}
		}
		map = transMap;
	}
	// 오른쪽 90도 회전 3-----------------------------------------------------
	public static void rightRotation() {
		transMap = new int[M][N]; // 결과 저장 배열

		int C = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				transMap[j][C] = map[i][j];
			}
			C--;
		}

		// 크기 변환
		int temp = N;
		N = M;
		M = temp;

		map = transMap;
	}
	// 왼쪽 90도 회전 4------------------------------------------------------
	public static void leftRotation() {
		transMap = new int[M][N]; // 결과 저장 배열

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				transMap[M - j - 1][i] = map[i][j];
			}
		}

		// 크기 변환
		int temp = N;
		N = M;
		M = temp;

		map = transMap;
	}
	// 1->2, 2->3, 3->4, 4->1 이동 5----------------------------------------
	public static void fiveMove() {
		transMap = new int[N][M]; // 결과 저장 배열

		int N_mid = N / 2; // 행 중앙값
		int M_mid = M / 2; // 열 중앙값

		// 1->2
		for (int i = 0; i < N_mid; i++) {
			for (int j = 0; j < M_mid; j++) {
				transMap[i][M_mid + j] = map[i][j];
			}
		}

		// 2->3
		for (int i = 0; i < N_mid; i++) {
			for (int j = M_mid; j < M; j++) {
				transMap[N_mid + i][j] = map[i][j];
			}
		}

		// 3->4
		for (int i = N_mid; i < N; i++) {
			int C = 0;
			for (int j = M_mid; j < M; j++, C++) {
				transMap[i][C] = map[i][j];
			}
		}

		// 4->1

		int Row = 0;
		for (int i = N_mid; i < N; i++, Row++) {
			for (int j = 0; j < M_mid; j++) {
				transMap[Row][j] = map[i][j];
			}
		}
		map = transMap;
	}
	// 1->4, 4->3, 3->2, 2->1 이동 6--------------------------------------------
	public static void sixMove() {
		transMap = new int[N][M]; // 결과 저장 배열

		int N_mid = N / 2; // 행 중앙값
		int M_mid = M / 2; // 열 중앙값

		// 1->4
		for (int i = 0; i < N_mid; i++) {
			for (int j = 0; j < M_mid; j++) {
				transMap[N_mid + i][j] = map[i][j];
			}
		}

		// 4->3
		for (int i = N_mid; i < N; i++) {
			for (int j = 0; j < M_mid; j++) {
				transMap[i][M_mid + j] = map[i][j];
			}
		}

		// 3->2
		int Row = 0;
		for (int i = N_mid; i < N; i++, Row++) {
			for (int j = M_mid; j < M; j++) {
				transMap[Row][j] = map[i][j];
			}
		}

		// 2->1
		for (int i = 0; i < N_mid; i++) {
			int C = 0;
			for (int j = M_mid; j < M; j++, C++) {
				transMap[i][C] = map[i][j];
			}
		}
		map = transMap;
	}
}
/*
[입력]
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
1

[출력]
4 5 1 9 8 2 1 3
1 3 2 8 7 9 2 1
2 1 3 8 6 3 9 2
5 9 2 1 9 6 1 8
9 7 8 2 1 4 5 3
3 2 6 3 1 2 9 7
*/
/*
import java.util.Scanner;

public class Main_BJ_16935_배열돌리기3 {
  static int N;//배열의 행크기	
  static int M;//배열의 열크기
  static int R;//연산의 횟수
  static int operNum;//연산종류
  static final int topBottomReverse=1, leftRightReverse=2, 
		           rightRotation=3,leftRotation=4,
		           subArrRightRotation=5, subArrLeffRotation=6; 
  
  public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 N=sc.nextInt();
	 M=sc.nextInt();
	 R=sc.nextInt();
	 
	 int [][]array = new int[N][M];
	 for (int i = 0; i < N; i++) {
	    for (int j = 0; j < M; j++) {
	      array[i][j]=sc.nextInt();
	    }
	 }
	 
	 int t;
	 for(int i=0; i<R; i++) {
		 operNum = sc.nextInt();
		 switch(operNum) {
		    case topBottomReverse:    topBottomReverse(array);break;
		    case leftRightReverse:    leftRightReverse(array);break;		    	
		    case rightRotation:       array=rightRotation(array); t=N;N=M;M=t;break;		    	
		    case leftRotation:        array=leftRotation(array); t=N;N=M;M=t;break;		    	
		    case subArrRightRotation: array=subArrRightRotation(array);break;		    	
		    case subArrLeffRotation:  array=subArrLeffRotation(array);break;		    	
		 }
	 }
	 //결과출력
	 printArray(array);	 
	 sc.close();	 
  }//main

  
  private static void printArray(int[][] array) {
	  for (int i = 0; i < array.length; i++) {
		  for (int j = 0; j < array[i].length; j++) {
			  System.out.print(array[i][j]+" ");
		  }
		  System.out.println();
	  }
  }


  private static void topBottomReverse(int[][] array) {	
	for(int i=0,j=N-1; i<N/2; i++,j--) {//i:배열 상위 절반의 행, j:배열 하위 절반의 행
	   for(int k=0; k<M; k++) {//열 인덱스
		   int tmp=array[i][k];
		   array[i][k]=array[j][k];
		   array[j][k]=tmp;
	   }
	}
  }
  
  private static void leftRightReverse(int[][] array) {	
	  for(int i=0,j=M-1; i<M/2; i++,j--) {//i:배열 좌측 절반의 열, j:배열 우측 절반의 열
		  for(int k=0; k<N; k++) {//행 인덱스
			  int tmp=array[k][i];
			  array[k][i]=array[k][j];
			  array[k][j]=tmp;
		  }
	  }
  }
  
  private static int[][]rightRotation(int[][] array) {
	  int [][]oArray=new int[M][N];
	  for(int i=0; i<M; i++) {                //i:array열 ,   oArray행
		  for(int j=N-1, k=0; j>=0; j--,k++) {//j:array행 , k:oArray열
			  oArray[i][k]=array[j][i];			  
		  }
	  }
	  return oArray;
  }
  
  private static int[][]leftRotation(int[][] array) {
	  int [][]oArray=new int[M][N];
	  for(int i=0,k=M-1; i<M; i++,k--) { //i:array열 , k:oArray행
		  for(int j=0; j<N; j++) {       //j:array행 ,   oArray열
			  oArray[k][j]=array[j][i];
		  }
	  }
	  return oArray;
  }
  
  private static int[][]subArrRightRotation(int[][] array) {
	  int [][]oArray=new int[N][M];
	  int yhalf=N/2;
	  int xhalf=M/2;
	  
	  //좌상-->우상
	  for(int i=0,y=0; i<yhalf; i++,y++) { 
		 for(int j=0,x=xhalf; j<xhalf; j++,x++) {      
			oArray[y][x]=array[i][j];
		 }
	  }
	  //우상-->우하
	  for(int i=0,y=yhalf; i<yhalf; i++,y++) { 
		  for(int j=xhalf,x=xhalf; j<M; j++,x++) {      
			  oArray[y][x]=array[i][j];
		  }
	  }
	  //우하-->좌하
	  for(int i=yhalf,y=yhalf; i<N; i++,y++) { 
		  for(int j=xhalf,x=0; j<M; j++,x++) {      
			  oArray[y][x]=array[i][j];
		  }
	  }
	  //좌하-->좌상
	  for(int i=yhalf,y=0; i<N; i++,y++) { 
		  for(int j=0,x=0; j<xhalf; j++,x++) {      
			  oArray[y][x]=array[i][j];
		  }
	  }
	  return oArray;
  }
  
  private static int[][]subArrLeffRotation(int[][] array) {
	  int [][]oArray=new int[N][M];
	  int yhalf=N/2;
	  int xhalf=M/2;
	  
	  //좌상-->좌하
	  for(int i=0,y=yhalf; i<yhalf; i++,y++) { 
		  for(int j=0,x=0; j<xhalf; j++,x++) {      
			  oArray[y][x]=array[i][j];
		  }
	  }
	  //우상-->좌상
	  for(int i=0,y=0; i<yhalf; i++,y++) { 
		  for(int j=xhalf,x=0; j<M; j++,x++) {      
			  oArray[y][x]=array[i][j];
		  }
	  }
	  //우하-->우상
	  for(int i=yhalf,y=0; i<N; i++,y++) { 
		  for(int j=xhalf,x=xhalf; j<M; j++,x++) {      
			  oArray[y][x]=array[i][j];
		  }
	  }
	  //좌하-->우하
	  for(int i=yhalf,y=yhalf; i<N; i++,y++) { 
		  for(int j=0,x=xhalf; j<xhalf; j++,x++) {      
			  oArray[y][x]=array[i][j];
		  }
	  }
	  return oArray;
  }
  
}//end class

*/






