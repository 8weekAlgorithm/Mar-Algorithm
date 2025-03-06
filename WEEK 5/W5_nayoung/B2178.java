// 문제: 백준 2178번 미로 탐색
// 메모리: 14756KB
// 시간: 112ms

import java.io.*;
import java.util.*;

public class B2178 {
    static char[][] arr; //N행 M열 배열
    static int N, M; //N행 M열
    static boolean[][] visited; //방문표시배열
    static int[][] dist; //(i,j)좌표까지 가기 위한 거리. (0,0)부터 1이다.
    static int minCnt; //최단거리

    static int[] dr = {-1,1,0,0}; //상하좌우
    static int[] dc = {0,0,-1,1}; //상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //배열값 입력
        arr = new char[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = str.charAt(j);
            }
        }

        //각 static 값들 초기화
        visited = new boolean[N][M];
        minCnt = Integer.MAX_VALUE;
        dist = new int[N][M];
        bfs(0,0); //bfs호출(최단거리문제이므로)

        bw.write(minCnt+"");

        bw.flush();
        bw.close();
        br.close();
    }//main

    static void bfs(int nStart, int mStart){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nStart,mStart}); //처음 좌표 큐에 저장
        visited[nStart][mStart] = true; //처음 좌표 방문표시
        dist[nStart][mStart]=1; //초기 좌표 이동거리를 1로 설정

        while(!queue.isEmpty()){ //큐가 비어 있기 전까지 반복
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if(r==N-1 && c==M-1) {
                minCnt = dist[r][c];
                break;
            }

            //상하좌우 탐색하며 각 칸까지의 최소비용 저장(델타 이용)
            for(int d=0;d<4;d++){
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M){ //인덱스 초과 방지
                    if(arr[nr][nc]=='1' && !visited[nr][nc]){ //이동가능한 칸이고 이미 방문하지 않은 칸이면
                        queue.offer(new int[]{nr,nc}); //큐에 넣고
                        dist[nr][nc] = dist[r][c]+1;   //최소비용 저장한다.
                        visited[nr][nc] = true; //방문표시한다.
                    }
                }
            }

        }



    }
}
