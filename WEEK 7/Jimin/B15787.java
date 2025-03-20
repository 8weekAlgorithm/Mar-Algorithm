// 문제: 15787 기차가 어둠을 헤치고 은하수를
// 메모리: 38460 KB
// 시간: 320 ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15787 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 기차의 수
		int M = Integer.parseInt(st.nextToken()); // 명령의 수
		int[] bitmasks = new int[N];
		// 2^20개의 상태를 저장하기 위한 비트마스크 배열 (int[] 사용하여 메모리 절약)
        int[] visited = new int[(1 << 20) / 32];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			switch (cmd) {
			case 1:
				bitmasks[idx] |= (1 << Integer.parseInt(st.nextToken()) - 1);
				break;
			case 2:
				bitmasks[idx] &= ~(1 << Integer.parseInt(st.nextToken()) - 1);
				break;
			case 3:
				bitmasks[idx] <<= 1;
				bitmasks[idx] &= ((1 << 20) - 1); // 21번 좌석 초과 방지
				break;
			case 4:
				bitmasks[idx] >>>= 1;
				break;
			}
		}

		int uniqueCount = 0;
        for (int train : bitmasks) {
            int wordIndex = train / 32;
            int bitIndex = train % 32;

            if ((visited[wordIndex] & (1 << bitIndex)) == 0) {
                visited[wordIndex] |= (1 << bitIndex);
                uniqueCount++;
            }
        }
		bw.write(String.valueOf(uniqueCount));

		br.close();
		bw.flush();
		bw.close();
	}
}
