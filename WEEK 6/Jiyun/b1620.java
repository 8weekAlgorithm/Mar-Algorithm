// 문제: 백준 1620 나는야 포켓몬 마스터 이다솜
// 메모리: 58272 KB
// 시간: 460 ms

import java.io.*;
import java.util.*;

public class b1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> num = new HashMap<>(); // 숫자가 key
		HashMap<String, Integer> name = new HashMap<>(); // 이름이 key

		for (int n = 1; n <= N; n++) {
			String input = br.readLine();
			num.put(n, input);
			name.put(input, n);
		}

		for (int m = 0; m < M; m++) {
			String input = br.readLine();
			if (Character.isDigit(input.charAt(0))) {
				sb.append(num.get(Integer.parseInt(input))).append('\n');
			} else {
				sb.append(name.get(input)).append('\n');
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}
}