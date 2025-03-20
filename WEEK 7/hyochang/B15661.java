
//15661 링크와 스타트
//메모리 19104kb
//시간 584ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15661 {
	static int n;
	static int ans = Integer.MAX_VALUE;
	static int[][] abil;
	static boolean[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		abil = new int[n][n];
		sel = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				abil[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n / 2; i++) {
			comb(0, 0, i);
			if (ans == 0)
				break;
		}

		System.out.println(ans);
	}

	static void comb(int idx, int cnt, int target) {
		if (cnt == target) {
			calc();
			return;
		}

		for (int i = idx; i < n; i++) {
			sel[i] = true;
			comb(i + 1, cnt + 1, target);
			sel[i] = false;
			if (ans == 0)
				return;
		}
	}

	static void calc() {
		int start = 0;
		int link = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (sel[i] && sel[j])
					start += abil[i][j] + abil[j][i];
				else if (!sel[i] && !sel[j])
					link += abil[i][j] + abil[j][i];
			}
		}
		ans = Math.min(ans, Math.abs(start - link));
	}
}
