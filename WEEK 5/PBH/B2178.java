import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 { //시간 124ms
    static int min = Integer.MAX_VALUE;
    static int[][] MIRO;         //미로의 값을 세기위해
    static int[][] visited;  //방문처리를 위해
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()) + 1;  //인덱스 편하게 할려고 +1
        M = Integer.parseInt(st.nextToken()) + 1;
        MIRO = new int[N][M];
        visited = new int[N][M];
        for (int i = 1; i < N; i++) {
            String miro = br.readLine();
            for (int j = 1; j < M; j++) {
                MIRO[i][j] = Integer.parseInt(String.valueOf(miro.charAt(j - 1)));
            }
        }
        Escape();   //메서드 실행 후 출력
        sb.append(min);
        System.out.println(sb);
    }

    public static void Escape() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int curX = 1;
        int curY = 1;
        Queue<int[]> queue = new LinkedList<>();  //q에 좌표를 넣어준다
        queue.offer(new int[]{1, 1});
        visited[curX][curY] = 1;     //미로 시작점에 값을 1로 시작
        while (!(queue.isEmpty())) {
            int[] cur = queue.poll();
            curX = cur[0];
            curY = cur[1];
            for (int i = 0; i < 4; i++) {  //q에서 꺼낸 좌표에서 이동이 가능할때
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx > 0 && nx < N && ny > 0 && ny < M) {  //이동 가능한 좌표를 큐에 넣고 해당 좌표에 이전 좌표의  이동 칸수+1을 해서 이차원 배열 MIROdp 저장
                    if (MIRO[nx][ny] == 1 && visited[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = visited[curX][curY] + 1;
                        if (nx == N - 1 && ny == M - 1) { //만약 다음 이동 좌표가 도착점이라면
                            min = Math.min(min, visited[nx][ny]); //최솟값을 비교하여 출력한다.
                        }
                    }
                }
            }
        }
    }
}