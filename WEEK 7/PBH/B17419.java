import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//메모리 21992 시간 232ms
//https://www.acmicpc.net/problem/17419
public class Main {

	public static void main(String[] args) throws IOException {

		//문제의 연산식을 수행하면 기존 연산자에서 가장 낮은 1을 제거하게 되는 수식이라는 것을 발견할 수 있다.
		//즉 입력값 K에서 1의 개수만큼 연산하는 것이다.
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();

		String a=br.readLine();
		String jinsoo=br.readLine();
		int answer=0;
		for(char i:jinsoo.toCharArray()) {
			if(i=='1') {  //1이면 카운트
				answer++;
			}
		}
			System.out.println(answer);
	}

}
