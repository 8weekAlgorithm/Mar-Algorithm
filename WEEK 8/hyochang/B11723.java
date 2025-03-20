
//문제 11723 집합
//메모리 : 313004kb
//시간 : 1052ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int S = 0; // 비트로 관리할 집합

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x;

            switch (command) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    // x번째 비트를 1로 설정
                    S |= (1 << (x - 1));
                    break;

                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    // x번째 비트를 0으로 설정
                    S &= ~(1 << (x - 1));
                    break;

                case "check":
                    x = Integer.parseInt(st.nextToken());
                    // x번째 비트가 1이면 1, 아니면 0
                    sb.append(((S & (1 << (x - 1))) != 0) ? 1 : 0).append("\n");
                    break;

                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    // x번째 비트를 뒤집기
                    S ^= (1 << (x - 1));
                    break;

                case "all":
                    // 비트 0~19 (20개) 전부 1로 설정
                    S = (1 << 20) - 1;
                    break;

                case "empty":
                    // 비트 전부 0으로
                    S = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}
