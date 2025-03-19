/**
 * 문제 : 백준 15787번 기차가 어둠을 헤치고 은하수를
 * 메모리 : 44440KB
 * 시간 : 344ms
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class b15787 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] seat = new int[N];

		for (int i = 0; i < N; i++) {
			seat[i] = 0b00000000000000000000;
		}
		int i = 0;
		int x = 0;
		for (int c = 0; c < M; c++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			switch (command) {
			case 1:
				i = Integer.parseInt(st.nextToken()) - 1;
				x = Integer.parseInt(st.nextToken()) - 1;
				if ((seat[i] & 1 << x) == 0) {
					seat[i] |= 1 << x;
				}
				break;
			case 2:
				i = Integer.parseInt(st.nextToken()) - 1;
				x = Integer.parseInt(st.nextToken()) - 1;
				if ((seat[i] & 1 << x) != 0) {
					seat[i] &= ~(1<<x);
				}
				break;
			case 3:
				i = Integer.parseInt(st.nextToken())-1;
				seat[i] = seat[i]<<1;
				seat[i] &= (1<<20) - 1;
				break;
			case 4:
				i = Integer.parseInt(st.nextToken())-1;
				seat[i] = seat[i]>>1;
				seat[i] &= (1<<20) - 1;
				break;
			}
		}

		Set<Integer> set = new HashSet<>();
		for(int j = 0; j<N; j++) {
			set.add(seat[j]);
		
		}
		System.out.println(set.size());
		
	}
}
