//문제 2579 계단 오르기
//메모리 : 14332kb
//시간 : 112ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {
	// 2579 - 계단 오르기
	// 시작점에서부터 규칙에 따라 계단을 올라갓을 때의 최댓값을 구하기

	// 그냥 갈때마다 최댓값이 있는 쪽으로 가야하나?
	// 연속 세번인지 확인하는 변수가 있어야하나?
	// 그냥 값 입력을 받고 이전 분기에 값 받은애 안받은애 하고
	// 받은애는 3번 연속인지 확인해야할듯?
	// 걍 화분처럼 두줄로 내려가는 배열이면될거같은데->실패...
	// DP배열을 만듬 배열에 들어갈 값은 밟았을때
	// 밟을 수 있는 경우는 n-2에서 두칸 올라왓을때 n-3 에서 2칸올라와 n-1에오고 그후 왓을때만

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] steps = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			steps[i] = Integer.parseInt(br.readLine());
		}
		if (n == 1) {
			System.out.println(steps[1]);
			return;
		}
		if (n == 2) {
			System.out.println(steps[1] + steps[2]);
			return;
		}

		dp[1] = steps[1];
		dp[2] = steps[1] + steps[2];

		for (int i = 3; i < n + 1; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + steps[i - 1]) + steps[i];
		}

		System.out.println(dp[n]);

	}

}