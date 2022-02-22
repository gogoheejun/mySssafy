import java.util.Arrays;

public class DisJointSetTest {

	static int N;
	static int[] parents;
	
	//단위집합(원소 하나만 있는애) 생성
	public static void makeSet() {
		parents = new int[N];
		
		//자신의 부모노드로 자신을 지정
		for(int i=0; i<N; i++) {
			parents[i]= i;
		}
	}
	
	//a의 집합 찾기: a의 대표자 찾기
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);//path compression!!
	}
	
	//a,b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false; //대표 같으면 이미 같은집합임
		
		parents[bRoot] = aRoot;//b의 짱을 a짱 아래에 붙임(=bRoot의 부모가 aRoot이다)
		return true;
	}
	
	public static void main(String[] args) {
		N = 5;
		makeSet();
		
		System.out.println(Arrays.toString(parents));
		System.out.println("union(0, 1)"+union(0, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println("union( 2, 1)"+union(2, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println("union(3, 2)"+union(3, 2));
		System.out.println(Arrays.toString(parents));
		System.out.println("union(4, 3)"+union(4, 3));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("========find=========");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
	}

	
}
