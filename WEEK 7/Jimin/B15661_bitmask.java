// 문제: 15661 링크와 스타트
// 메모리: 15460 KB
// 시간: 308 ms

import java.io.*;
import java.util.*;

public class B15661_bitmask {
    static int N, min = Integer.MAX_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 절반만 탐색하여 중복 제거
        for (int i = 1; i < (1 << (N - 1)); i++) { 
            // start 팀의 크기가 너무 작거나 너무 크면 제외
            int teamSize = Integer.bitCount(i);
            if (teamSize < 1 || teamSize > N - 1) continue;

            min = Math.min(min, getAbilityDifference(i));

            if (min == 0) break; // 최소 차이가 0이면 바로 종료
        }

        bw.write(String.valueOf(min));
        br.close();
        bw.flush();
        bw.close();
    }

    // 비트마스킹을 활용한 능력치 차이 계산
    private static int getAbilityDifference(int bitmask) {
        int startSum = 0, linkSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (((bitmask & (1 << i)) != 0) && ((bitmask & (1 << j)) != 0)) {
                    startSum += arr[i][j] + arr[j][i]; // 둘 다 start 팀
                } else if (((bitmask & (1 << i)) == 0) && ((bitmask & (1 << j)) == 0)) {
                    linkSum += arr[i][j] + arr[j][i]; // 둘 다 link 팀
                }
            }
        }
        return Math.abs(startSum - linkSum);
    }
}