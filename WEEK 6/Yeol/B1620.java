// 문제: 백준 1620번 나는야 포켓몬 마스터 이다솜
// 메모리: 58728KB
// 시간: 520ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        int M = Integer.parseInt(st.nextToken()); // 질문 개수

        HashMap<String, Integer> name_num = new HashMap<>(); //문자를 입력받으면 숫자를 반환하게
        HashMap<Integer, String> num_name = new HashMap<>(); //숫자를 입력받으면 문자를 반환하게

        // N개의 포켓몬 입력받아서 Map에 저장
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            name_num.put(name, i);
            num_name.put(i, name);
        }

        // M개의 질문 처리
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                // 숫자로 들어오면 Integer로 변환 후 이름 출력
                int number = Integer.parseInt(str);
                sb.append(num_name.get(number)).append("\n");
            } else {
                // 문자열이면 번호 출력
                sb.append(name_num.get(str)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
