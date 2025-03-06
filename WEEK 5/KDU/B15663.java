// 문제: 백준 15665번 문제제목 : n과 m(9)
// 링크: https://www.acmicpc.net/problem/15663
// 시간: 244ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B15663 {

	static StringBuilder sb;
	static List<Integer> list;
	static int[] sel;
	static boolean[] visited; //방문 체크를 위한 boolean 배열
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		sel = new int[m];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		perm(0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void perm(int idx) {
		if (idx == m) {
			for (int i : sel) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		/* 이 문제의 경우 순열을 진행함
		 * 순열 : 순서가 있으며, 중복 선택이 가능하지 않도록 원소들을 정렬함
		 * 순열은 모든 원소를 한 번씩 다 선택해가면서 경우의 수를 만들기 때문에 for문을 쓰는 게 더 직관적
		 * 조합은 남은 원소를 고려하면서 선택/비선택을 나누어 탐색해야 하기 때문에 재귀를 2번 호출하는 방식이 적절
		 * */
		
		// 방문 체크 및 백트레킹 적용
		int lastused = -1; //중복을 방지하기 위해 숫자를 저장하는 변수
		for (int i = 0; i < n; i++) {
			//이번 문제의 경우 순열이므로 방문체크 진행
			if (!visited[i]) {
				if (lastused == list.get(i)) {
					continue; //같은 깊이(숫자가 동일한 경우)에서 똑같은 숫자가 나오면 스킵
				}
				visited[i] = true;
				sel[idx] = list.get(i); //sel배열에 리스트의 값을 넣어주고 다음원소에 접근함
				lastused = list.get(i); //이전에 선택한 값을 저장함
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}
}
