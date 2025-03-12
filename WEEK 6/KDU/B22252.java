// 문제: 백준 22252번 문제제목 : 정보 장인 호석
// 링크: https://www.acmicpc.net/problem/22252
// 메모리 : 155884KB
// 시간: 1072ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B22252 {

	/*
	 * 방향성 : 우선순위 큐를 사용하여 순서와 상관없이 가진 값을 우선 뽑을 수 있도록 설정하자 처음 숫자가 1인 경우 -> 다음 들어오는
	 * 문자열의 이름을 가진 우선순위 큐를 생성하고 다음 들어오는 숫자들을 저장해줌 처음 숫자가 2인 경우 -> 다음 들어오는 문자열의 이름을
	 * 가진 우선순위 큐를 찾아서 다음 들어오는 숫자만큼 poll을 진행하고 count에 누적으로 더해줌
	 * 
	 * Map<String, priorityqueue<Integer>>로 생성해야 String별로 매칭이 되지 않을까?
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Map<String, PriorityQueue<Integer>> gorila = new HashMap<>();

		int q = Integer.parseInt(br.readLine());
		long count = 0;

		for (int c = 0; c < q; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int select = Integer.parseInt(st.nextToken());
			String gorila_name = st.nextToken();
			if (select == 1) { // 1이 들어올 경우 : 우선순위 큐 생성

				// 그냥 큐를 만들어 버리면 동일한 key에 대한 데이터가 여러번 들어오면 기존 값이 유지되지 않고 사라져버림
				// Map의 String Key값을 찾아서 있는 경우에만 실행하도록 설정정
//				if (!gorila.containsKey(gorila_name)) {
//					gorila.put(gorila_name, new PriorityQueue<>(Collections.reverseOrder()));
//				}

				// computeifabsent 메소드를 사용해도 됨
				PriorityQueue<Integer> pq = gorila.computeIfAbsent(gorila_name,
						k -> new PriorityQueue<>(Collections.reverseOrder()));

				int t = Integer.parseInt(st.nextToken());

				for (int i = 0; i < t; i++) {
					if (st.hasMoreTokens()) { // 입력 개수가 부족한 경우 방지
						pq.add(Integer.parseInt(st.nextToken()));
					}
				}
			} else if (select == 2) { // 2가 들어올 경우 : 해당하는 우선순위 큐를 찾아서 poll 진행
				int k = Integer.parseInt(st.nextToken());

				// 0개를 추출하는 경우 예외처리
				if (k == 0) continue;

				// get으로 받는 값 자체가 우선순위 큐가 됨
				// 밑에 get메소드를 너무 많이 사용해서 따로 선언해놓음음
				PriorityQueue<Integer> pq = gorila.get(gorila_name);
				// 키에 해당하는 값이 존재하지 않거나(키에 저장된 값이 없음), 우선순위 큐가 비어있는 경우에도 PASS해줘야됨
				// or의 성질에 의해 pq == null를 먼저 조건에 걸어줘서 항상 먼저 검사해서 nullpointerexception을 피할 수 있음음
				if (pq == null || pq.isEmpty()) {
					continue;
				}
				// k번 poll() 실행, pq가 비면 멈춤
				for (int i = 0; i < k && !pq.isEmpty(); i++) {
					count += pq.poll();
				}
			}
		}
		sb.append(count).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}