// 문제: 백준 15787번 
// 문제제목 : 기차가 어둠을 헤치고 은하수를
// 링크: https://www.acmicpc.net/problem/15787
// 메모리 : 39460KB
// 시간: 340ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B15787 {
	static StringBuilder sb;
	static StringTokenizer st;
	static int[] train;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		train = new int[N]; // 기차들의 상태(비트마스크크)를 저장하는 배열
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int seq_train = Integer.parseInt(st.nextToken()) - 1;
			switch (com) {
			case 1: // 사람 태우기
				int seq_seat = Integer.parseInt(st.nextToken()) - 1;
				train[seq_train] |= (1 << seq_seat);
				break;
			case 2: // 사람 하차
				int seq_seat2 = Integer.parseInt(st.nextToken()) - 1;
				train[seq_train] &= ~(1 << seq_seat2);
				break;
			case 3: // 모두 한칸씩 뒤로
                // 비트는 오른쪽부터 채워지기 때문에 한칸씩 뒤로 간다는 의미는 왼쪽으로 shift한다는 말!
				train[seq_train] <<= 1;
				train[seq_train] &= ((1 << 20) - 1); // 20번째 비트까지만 쓰겠다!
				break;
			case 4: // 모두 한칸씩 앞으로
                // 비트는 오른쪽부터 채워지기 때문에 한칸씩 앞으로 간다는 의미는 오른쪽으로 shift한다는 말!
				train[seq_train] >>= 1;
				train[seq_train] &= ((1 << 20) - 1); // 20번째 비트까지만 쓰겠다!
				break;
			}
		}

        // set을 사용하면 중복된 값을 막을 수 있으므로 자연스럽게 중복체크가 됨
        // 이후 set의 사이즈를 체크하면 은하수를 건널 수 있는 기차의 수를 체크할 수 있음!
		Set<Integer> bitmask = new HashSet<>();
		for (int num : train) {
			bitmask.add(num);
		}
		System.out.println(bitmask.size());
	}// 메인함수
}
