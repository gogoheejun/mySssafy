package w0124;

public class Test2 {
	public static void main(String[] args) {
		int[] su = { 45, 80, 68, 19, 34, 55, 27, 60, 27, 18 };
		int tot = 0;
		for (int s : su) {
			tot += s;
		}                                                                          
		double avg = (double) tot / su.length;
		
		double min = Math.abs(su[0] - avg);
		int minp = 0;
		double cha = 0;
		for (int i = 1; i < su.length; i++) {
			cha = Math.abs(su[i] - avg);
			if (min > cha) {
				min = cha;
				minp = i;
			}
		}
		System.out.println(avg + " " + su[minp]);
	}
}
