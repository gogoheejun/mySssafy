package com.ssafy.io;

public class 재귀 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(2,1,2,3);
	}
	
	public static void recursive_print(int i, int[] arr) {
		if(i ==arr.length-1) {
			System.out.print(arr[i]+"\t");
			return;
		}else {
			System.out.println(arr[i]+"\t");
			recursive_print(i+1, arr);
		}
	}
	
	//hanoi는 from에 있는 원판들을 to로 옮겨야 함
	public static void hanoi(int n, int from, int temp, int to) {
		
		if(n == 0) return; 
		
		//n-1개(덩어리) 원판을 temp로 이동. 이땐 임시로 옮기는건데 to를 temp로 씀. temp에다가 n-1개 옮기는게 성공만 하면 돼 일단.
		hanoi(n-1, from, to, temp);
		//n번 원판이동(제일 아래 있는거)
		System.out.println(n+" : "+from+"-> "+to);
		//n-1개(덩어리) 원판을 n번위에다가 다시 이동
		hanoi(n-1, temp, from, to);//현재 원래의 temp가 from이 됨. 원래의 from은 빈기둥이 됨. 직접 ㄱㄱ해봐
	}

}
