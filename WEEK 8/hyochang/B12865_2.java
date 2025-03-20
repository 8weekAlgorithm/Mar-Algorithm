
//12865 평범한 배낭
//메모리 53836kb
//시간 184ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 물건 개수
        int k = Integer.parseInt(st.nextToken()); // 배낭 최대 무게
        
        int[] w = new int[n + 1]; // 무게 배열
        int[] v = new int[n + 1]; // 가치 배열
        int[][] dp = new int[n + 1][k + 1]; // DP 테이블

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (w[i] > j) { // 용량이 넘어간 경우
                    dp[i][j] = dp[i - 1][j];
                } else { // 용량 이하인 경우
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[n][k]); // 최댓값 출력
    }
}