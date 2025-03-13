// 문제: 백준 21939 문제 추천 시스템 Version 1
// 메모리: 69676 KB
// 시간: 2528 ms

import java.io.*;
import java.util.*;

public class b21939 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 문제 저장
		HashMap<Integer, Integer> problems = new HashMap<>();

		// 난이도가 key, 문제번호가 value
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			problems.put(P, L);
			if (!map.containsKey(L))
				map.put(L, new ArrayList<>());
			map.get(L).add(P);
		}

		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("recommend")) {

				int option = Integer.parseInt(st.nextToken());
				if (option == 1) { // 어려운 문제
					List<Integer> list = map.lastEntry().getValue();
					sb.append(Collections.max(list)).append('\n');
				} else { // 쉬운 문제
					List<Integer> list = map.firstEntry().getValue();
					sb.append(Collections.min(list)).append('\n');
				}

			} else if (command.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());

				problems.put(P, L);
				if (!map.containsKey(L))
					map.put(L, new ArrayList<>());
				map.get(L).add(P);

			} else if (command.equals("solved")) {
				int P = Integer.parseInt(st.nextToken());
				int L = problems.get(P);

				map.get(L).remove(Integer.valueOf(P));
				if (map.get(L).isEmpty())
					map.remove(L);
			}
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
