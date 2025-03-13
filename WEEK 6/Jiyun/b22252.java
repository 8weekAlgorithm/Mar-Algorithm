// 문제: 백준 22252 정보 상인 호석
// 메모리: 119628 KB
// 시간: 2484 ms

import java.io.*;
import java.util.*;

public class b22252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		// 해시맵, 우선순위큐(최대힙) 활용
		HashMap<String, PriorityQueue<Integer>> gorilla = new HashMap<>();
		long answer = 0;

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int action = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int count = Integer.parseInt(st.nextToken());

			if (action == 1) { // 고릴라가 정보 구매
				if (!gorilla.containsKey(name)) // 처음보는 고릴라면 추가
					gorilla.put(name, new PriorityQueue<>(Collections.reverseOrder()));

				// 고릴라가 구매한 정보 추가
				PriorityQueue<Integer> info = gorilla.get(name);
				for (int i = 0; i < count; i++)
					info.add(Integer.parseInt(st.nextToken()));

			} else { // 호석이가 정보 구매
				PriorityQueue<Integer> info = gorilla.get(name);
				if (info == null) continue;

				for (int i = 0; i < count; i++) {
					if (!info.isEmpty())
						answer += info.poll();
				}
			}
		}
		System.out.println(answer);
	}
}
