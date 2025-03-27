import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//메모리 14312KB 시간 104ms 
//https://www.acmicpc.net/problem/11047
public class B11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int coinNum = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());

		Stack<Integer> coins = new Stack<>(); //스택을 쓴 이유는 문제 풀 당시 스택 수업이었어서..
		for (int i = 0; i < coinNum; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		while (true) {
			int a = coins.pop(); //스택으로 뒤에서 부터 값을 빼면 
			answer += money / a; //금액 보다 큰 값이면 0을 더하고 아니면 나눈만큼 더함
			money = money % a; //남은 금액으로 다시 반복
			if (money == 0) {  //0이면 탈출
				break;
			}
		}
		sb.append(answer);
		System.out.println(sb);
	}

}
