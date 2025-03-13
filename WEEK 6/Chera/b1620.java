/**
 * 문제 : 백준 1620번 나는야 포켓몬 마스터 이다솜
 * 메모리 : 63716KB
 * 시간 : 544ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //포켓몬의 개수
		int M = Integer.parseInt(st.nextToken()); // 맞춰야하는 문제의 개수
		Map<String, String> map = new HashMap<>();
		
		for(int i = 1; i<=N; i++) {
			String name = br.readLine();
			map.put(String.valueOf(i), name);
			map.put(name, String.valueOf(i));
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<M; i++) {
			sb.append(map.get(br.readLine())+"\n");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
	
}
