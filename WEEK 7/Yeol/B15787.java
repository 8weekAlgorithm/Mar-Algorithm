// 문제: 백준 15787번 기차가 어둠을 헤치고 은하수를
// 메모리: 39152KB
// 시간: 336ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] train = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                train[i] |= (1 << (x - 1)); // x번째 좌석을 1로 설정
            } else if (command == 2) {
                int x = Integer.parseInt(st.nextToken());
                train[i] &= ~(1 << (x - 1)); // x번째 좌석을 0으로 설정
            } else if (command == 3) {
                train[i] <<= 1; // 왼쪽으로 한 칸 이동
                train[i] &= ~(1 << 20); // 21번째 비트 제거 (20번째 좌석 탈락)
            } else if (command == 4) {
                train[i] >>= 1; // 오른쪽으로 한 칸 이동
            }
        }

        // 서로 다른 기차 상태 개수 구하기
        Set<Integer> uniqueTrains = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            uniqueTrains.add(train[i]);
        }

        sb.append(uniqueTrains.size());
        System.out.println(sb);
    }
}

