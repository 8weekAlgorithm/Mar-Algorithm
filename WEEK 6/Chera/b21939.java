/**
 * 문제 : 백준 21939번 문제 추천 시스템 Version 1
 * 메모리 : 61048KB
 * 시간 : 592ms
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class b21939 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>(); // 난이도별 문제
		Map<Integer, Integer> list = new HashMap<>(); // 각각의 문제

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); // 문제 번호
			int L = Integer.parseInt(st.nextToken()); // 난이도
			list.put(P, L);
			map.put(L, map.getOrDefault(L, new TreeSet<>()));
			map.get(L).add(P);
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("add")) {
				int P = Integer.parseInt(st.nextToken()); // 문제 번호
				int L = Integer.parseInt(st.nextToken()); // 난이도
				list.put(P, L);
				map.put(L, map.getOrDefault(L, new TreeSet<>()));
				map.get(L).add(P);
			}
			if (command.equals("recommend")) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					int problem = map.lastKey();

					sb.append(map.get(problem).last() + "\n");

				} else {
					int problem = map.firstKey();
					sb.append(map.get(problem).first() + "\n");
				}
			}
			if (command.equals("solved")) {
				int problem = Integer.parseInt(st.nextToken());
				int difficulty = list.get(problem);
				map.get(difficulty).remove(problem);
				if (map.get(difficulty).isEmpty()) {
					map.remove(difficulty);
				}
				list.remove(problem);
			}

		}
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}

}
