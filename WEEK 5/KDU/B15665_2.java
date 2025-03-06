// 문제: 백준 15665번 문제제목 : n과 m(11)
// 링크: https://www.acmicpc.net/problem/15665
// 시간: 420ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B15666_2 {

	static StringBuilder sb;
	static List<Integer> list; //기본 수열을 저장하기 위한 list
	static int[] sel; //뽑아낸 수열을 저장하기 위한 배열
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		//list와 set 초기화
		list = new ArrayList<>();
		sel = new int[m];
		
		//기본 수열 list 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		//출력 시 순서대로 출력하기 위해 미리 정렬 진행
		Collections.sort(list);

        //백트래킹을 포함한 perm 메소드를 새로 실행
		perm(0,-1);


		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	
	public static void perm(int sidx, int prev) {
		if (sidx == m) {
			//출력해야하는 기저조건 때 temp에 수열을 미리 저장한 다음
			//set에 다시 새로 넣으면서 .trim()을 통해 중복 수열 제거
			for (int i : sel) {
				sb.append(i + " ");
			}sb.append("\n");
			return;
		}
		
		
		/* 이 문제의 경우 중복 순열을 진행함
		 * 중복 순열 : 순서가 있으며, 중복 선택이 가능하도록 원소들을 정렬함
		 * 순열은 모든 원소를 한 번씩 다 선택해가면서 경우의 수를 만들기 때문에 for문을 쓰는 게 더 직관적
		 * 조합은 남은 원소를 고려하면서 선택/비선택을 나누어 탐색해야 하기 때문에 재귀를 2번 호출하는 방식이 적절
		 * */
		
		/* 이전 풀이 진행 시 실행 시간이 오래 걸리는 이유
		 * 1. LinkedHashSet<String>을 사용하여 중복을 제거하면 문자열 변환과 저장 과정에서 불필요한 연산이 발생
		 * 2. 같은 수가 연속해서 나오면 중복을 제거하는 계산이 여러번 수행되서 실행 시간이 오래 걸림
		 * -> 같은 숫자가 나왔던 경우는 미리 저장해놓고 다음 실행 시 비교하여 같으면 건너뛰도록 해야함(백트래킹)
		 * */
		
		int lastUsed = -1; //중복을 방지하기 위해 숫자를 저장하는 변수
		for (int i = 0; i < n; i++) {
			//sel배열에 리스트의 값을 넣어주고 다음원소에 접근함
			//이번 문제의 경우 중복 순열이므로 방문체크는 진행하지 않음
			if(lastUsed == list.get(i)) {
				continue; //같은 깊이(숫자가 동일한 경우)에서 똑같은 숫자가 나오면 스킵
			}
			sel[sidx] = list.get(i);
			lastUsed = list.get(i); //이전에 선택한 값을 저장함
			perm(sidx + 1,list.get(i)); //이전에 선택한 값을 재귀로 넘겨 재확인
		}
	}
}
