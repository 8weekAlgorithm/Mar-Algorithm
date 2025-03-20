import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//메모리 314544  시간 1004ms
//https://www.acmicpc.net/problem/11723
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int start = 0;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {      //입력에 맞는 명령을 비트연산으로 수행
                case "add":
                    int num1 = Integer.parseInt(st.nextToken());
                    start = start | (1 << num1 - 1);
                    break;
                case "remove":
                    int num2 = Integer.parseInt(st.nextToken());
                    start = start & ~(1 << num2 - 1);
                    break;
                case "check":
                    int num3 = Integer.parseInt(st.nextToken());
                    if ((start & (1 << num3 - 1)) == 0) {
                        sb.append(0 + "\n");
                    } else {
                        sb.append(1 + "\n");
                    }
                    break;
                case "toggle":
                    int num4 = Integer.parseInt(st.nextToken());
                    start ^= (1 << (num4 - 1));
                    break;
                case "all":
                    start |= (~0);
                    break;
                case "empty":
                    start &= 0;
                    break;
            }

        }
        System.out.println(sb);

    }
}