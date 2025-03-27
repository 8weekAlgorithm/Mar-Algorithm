// 문제: 11047 동전 0
// 메모리: 14196 KB
// 시간: 104 ms


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] money = new int[N];

		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			if(K == 0) break;
            if (K >= money[i]) {
				count += K / money[i];
				K %= money[i];
			}
		}
		System.out.println(count);
	}
}
