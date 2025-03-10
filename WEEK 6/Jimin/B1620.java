// 문제 : 1620 나는야 포켓몬 마스터 이다솜
// 메모리 : 44668 KB
// 시간 : 476 ms

package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> name = new HashMap<>();
		String[] num = new String[N + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			name.put(str, i);
			num[i] = str;
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
				bw.write(num[Integer.parseInt(str)] + "\n");
			} else {
				bw.write(name.get(str) + "\n");
			}
		}
		br.close();
		bw.flush();
		bw.flush();
	}
}
