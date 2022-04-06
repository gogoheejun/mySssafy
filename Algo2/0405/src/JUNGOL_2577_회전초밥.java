
import java.io.*;
import java.util.StringTokenizer;

public class JUNGOL_2577_회전초밥 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //원형으로 이어져있는 그릇
        int [] sushi = new int[N+k];
        // 먹은 초밥
        int [] v = new int[d+1];

        for (int i = 0; i< N; i++) {
            sushi[i] = Integer.parseInt(in.readLine());
        }
        for (int i = N; i < N+k; i++) {
            sushi[i] = sushi[i-N];
        }

        int answer = -1;
        // 쿠폰에 해당되는 초밥 접시의 개수
        int count = 0;
        int coupon = 0;
        // 슬라이딩 윈도우 사용
        for (int i = 0; i < N+k; i++) {
            // 접시 k개를 선택한 상태에서 다음 선택으로 넘어갔을때
            if (i >= k){
                // 맨 뒤 접시 빼기
                if (--v[sushi[i-k]] == 0) count--;
                if (sushi[i-k] == c) coupon--;
            }
            // 현재 접시 추가
            if (++v[sushi[i]] == 1) count++;
            if (sushi[i] == c) coupon++;
            if (i >= k)
                answer = Math.max(answer, coupon == 0 ? count + 1: count);
        }
        System.out.println(answer);
    }
}