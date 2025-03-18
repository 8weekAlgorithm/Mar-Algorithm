// 문제: 11723 집합 
// 메모리: 313340 KB
// 시간: 1064 ms

import java.io.*;
import java.util.*;

public class b11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int S = 0;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("all")) {
				S = (1 << 21) - 1;
			} else if (command.equals("empty")) {
				S = 0;

			} else {
				int n = Integer.parseInt(st.nextToken());
				switch (command) {

				case "add":
					S |= (1 << n);
					break;

				case "remove":
					S &= ~(1 << n);
					break;

				case "check":
					sb.append((S & (1 << n)) != 0 ? 1 : 0).append('\n');
					break;

				case "toggle":
					S ^= (1 << n);
					break;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
