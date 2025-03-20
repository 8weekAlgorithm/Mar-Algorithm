
//12865 평범한 배낭
//메모리 15692kb
//시간 148ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865_1 {

	// 12865 - 평범한 배낭
	// n개의 물품의 무게가 k이상 되지 않게 넣었을 때 최대 v(행복)이 되는 경우 v 출력

	// 넣고 안넣고? 넘어가면 삭제?
	// 매번 넣고 안넣고로 처리하면 될듯?
	// n*n하고 누적합처럼 ㄱㄱ
	// 해당 분기마다 선택하고 안하고를 더함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }

        System.out.println(dp[k]);
    }
}
