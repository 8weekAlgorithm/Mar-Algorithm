// 문제: 11723 집합
// 메모리: 312696 KB
// 시간: 1008 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int bitmask = 0;
		int M = Integer.parseInt(br.readLine()); // 연산의 수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch (cmd) {
			case "add":
				bitmask |= (1 << Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				bitmask &= ~(1 << Integer.parseInt(st.nextToken()));
				break;
			case "check":
				sb.append((bitmask & (1 << Integer.parseInt(st.nextToken()))) != 0 ? "1\n" : "0\n");
				break;
			case "toggle":
				bitmask ^= (1 << Integer.parseInt(st.nextToken()));
				break;
			case "all":
				bitmask = (1 << 21) - 1;
				break;
			case "empty":
				bitmask = 0;
				break;
			}
		}
		System.out.println(sb);
	}
}
