import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
//메모리 39172 시간 344ms
//https://www.acmicpc.net/problem/15787
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tr = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tr.nextToken());
        int M = Integer.parseInt(tr.nextToken());
        int[] thomas = new int[N + 1]; // 1-based index로 처리하기 위해 N+1 크기로

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "1":
                    int thomasIdx = Integer.parseInt(st.nextToken());
                    int seatIdx = Integer.parseInt(st.nextToken());
                    if ((thomas[thomasIdx] & (1 << (seatIdx - 1))) == 0) {
                        thomas[thomasIdx] |= (1 << (seatIdx - 1)); // 1처리
                    }
                    break;
                case "2":
                    int thomasIdx2 = Integer.parseInt(st.nextToken());
                    int seatIdx2 = Integer.parseInt(st.nextToken());
                    if ((thomas[thomasIdx2] & (1 << (seatIdx2 - 1))) != 0) {
                        thomas[thomasIdx2] &= ~(1 << (seatIdx2 - 1)); // 0처리
                    }
                    break;
                case "3":
                    int thomasIdx3 = Integer.parseInt(st.nextToken());
                    thomas[thomasIdx3] &= ~(1 << (19)); //KJY선생님께서 int는 기본적으로 32비트라 앞에 12개의 0이 있다고 하셔서  20번째 좌석의 승객을 하차시켜주고 앞으로 당김
                    thomas[thomasIdx3] <<= 1; // 좌석을 왼쪽으로 한 칸 밀기 ==뒤로 가기
                    break;
                case "4":
                    int thomasIdx4 = Integer.parseInt(st.nextToken());
                    thomas[thomasIdx4] >>= 1; // 좌석을 오른쪽으로 한 칸 밀기 ==앞으로 가기
                    break;
            }
        }

        HashSet<Integer>answer=new HashSet<>(); //값이 중복이면 안되니까 SET에 갖다 박음
        for(int i=1;i<=N;i++) {
            answer.add(thomas[i]);
        }
        sb.append(answer.size());
        System.out.println(sb); // 결과 출력
    }
}