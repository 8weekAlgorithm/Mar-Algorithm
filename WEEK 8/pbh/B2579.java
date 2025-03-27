import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//메모리 14260kb  시간 100ms
//https://www.acmicpc.net/problem/2579
public class B2579 {

	static int max;
	static int N;
	static int[][] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N + 1][3]; //두 칸 전 계단까지 고려해야 해서 크기를 1늘려줌 
		for (int i = 1; i < N + 1; i++) {
			nums[i][0] = Integer.parseInt(br.readLine());
		}
		nums[1][1] = nums[1][0]; //첫번째 계단에 값을 넣어줌
		nums[1][2] = nums[1][0]; //[1][1]은 바로 전 계단에서 올라온 값 [1][2]는 두 칸 전 계단에서 올라온 값
		for (int i = 2; i <= N; i++) {//다음 계단에서 계산을 할 수 있게 값을 입력해줌 
			nums[i][1] = nums[i - 1][0] + nums[i][0]; //이전 계단의 값 +현재 계단의 값
			nums[i][2] = nums[i - 2][0] + nums[i][0]; //두 칸 전 계단의 값+현재 계단의 값
			nums[i][0] = Math.max(nums[i - 2][0] + nums[i][0], nums[i - 1][2] + nums[i][0]);
			//0 에는 그 계단에서의 최댓값을 구함 두칸전에서 올라와다면 그 계단에서의 최댓값을 더해줌 
			//세번 연속으로 계단을 오르지 못하기에 전 칸에서 올라온 값은 그 계단의 2칸 전에서 건너온 값일것이다.
			//이 둘중 큰 값을 0에 최댓값으로 저장
		}

		sb.append(nums[N][0]);
		System.out.println(sb);

	}

}