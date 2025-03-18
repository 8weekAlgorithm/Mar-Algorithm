// 문제: 15787 기차가 어둠을 헤치고 은하수를
// 메모리: 39280 KB
// 시간: 348 ms

import java.io.*;
import java.util.*;

public class b15787 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] train = new int[N];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

			switch (command) {

			case 1: // 탑승
				train[i] |= (1 << x);
				break;

			case 2: // 하차
				train[i] &= ~(1 << x);
				break;

			case 3: // 한 칸씩 뒤로
				train[i] <<= 1;
				train[i] &= ((1 << 21) - 1);
				break;

			case 4: // 한 칸씩 앞으로
				train[i] >>= 1;
				train[i] &= ~1;
				break;
			}
		}

		// set으로 중복 제거
		Set<Integer> set = new HashSet<>();
		for (int t : train) {
			System.out.println(t + " " + Integer.toBinaryString(t));
			set.add(t);
		}

		System.out.println(set.size());
	}
}
