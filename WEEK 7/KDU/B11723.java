// 문제: 백준 11723번 
// 문제제목 : 집합
// 링크: https://www.acmicpc.net/problem/11723
// 메모리 : 312884KB
// 시간: 1084ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B11723 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int s, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		s = 0;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String set = st.nextToken();
			switch (set) {
			case "add":
				n = Integer.parseInt(st.nextToken());
				add(n);
				break;
			case "remove":
				n = Integer.parseInt(st.nextToken());
				remove(n);
				break;
			case "check":
				n = Integer.parseInt(st.nextToken());
				sb.append(check(n)).append("\n");
				break;
			case "toggle":
				n = Integer.parseInt(st.nextToken());
				toggle(n);
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		System.out.println(sb.toString());
	}

	static void add(int n) {
		if ((s & (1 << n)) == 0) { // 없으면 추가
			s |= (1 << n);
		}
	}

	static void remove(int n) {
		if ((s & (1 << n)) != 0) { // 있으면 제거
			s &= ~(1 << n);
		}

	}

	static int check(int n) {
		if ((s & (1 << n)) != 0) { // 있으면 1출력
			return 1;
		} else { // 없으면 0 출력력
			return 0;
		}
	}

	static void toggle(int n) { // n값에 위치한 비트를 반전시켜 있으면 제거, 없으면 추가시킴
		s ^= (1 << n);

	}

	static void all() {
		s = (1 << 21) - 1; // 1을 21번 이동한 후 -1 하면 20개의 1이 만들어짐 (1~20 포함)
	}

	static void empty() {
		s = 0;
	}

}