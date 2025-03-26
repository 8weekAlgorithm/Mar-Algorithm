import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//메모리 14548kb 시간 124ms
//https://www.acmicpc.net/problem/12865
public class B12865 { //dfs로 풀었는데 시간 초과 나서 dp는 GPT로 찾았는데 저도 잘 모르겠어요
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(nk.nextToken());
        int K = Integer.parseInt(nk.nextToken());

        int[] weights = new int[N];
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            // 뒤에서부터 돌려야 같은 물건을 두 번 선택하는 걸 막을 수 있음!
            for (int w = K; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
        //얼추 이해는 했는데 설명은 못하겠습니다. 
        System.out.println(dp[K]);
    }
}
