
//11047 동전 0
//메모리 14196kb
//시간 104ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n];
		int idx = -1;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		for (int i = n-1; i >= 0; i--) {
			ans += k / coin[i];
			k %= coin[i];
			if (k == 0)
				break;
		}

		System.out.println(ans);
	}
}