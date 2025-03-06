// 문제: 백준 2667번 단지번호붙이기 => 경로탐색이므로 dfs
// 메모리: 16052KB
// 시간: 120ms

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2667 {
    static int[][] arr; //지도 배열
    static int N; //지도의 크기
    static int[][] visited; //방문배열
    static int num; //단지개수(단지번호)
    static boolean hasChange; //변화유무

    static int[] dr = {-1,1,0,0}; //상하좌우
    static int[] dc = {0,0,-1,1}; //상하좌우


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        //배열값 입력
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        //dfs탐색
        num = 0; //단지번호
        visited = new int[N][N];
        hasChange = false; //변화 유무
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]==0&&arr[i][j]==1){ //집이 있는데 단지 번호 안붙은 곳에 대해
                    num++; //1부터 시작하도록
                    visited[i][j]=num; //단지 번호 붙이고 시작
                    dfs(i,j); //dfs 탐색
                }
            }
        }

        int[] cnt = new int[num+1]; //모든 단지 번호들(1~num)을 저장하는 카운팅배열 만들기
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]>0) { //*문제3) 이게 없다면 cnt[0]의 값이 커져서 이후 정렬시 어려움
                    cnt[visited[i][j]]++; //해당 단지번호에 해당하는 카운팅배열값 +1
                }
            }
        }
        Arrays.sort(cnt); //*문제2) 각 단지내 집의수를 오름차순 정렬

        bw.write(num+"\n"); //단지수 출력
        for(int i=1;i<=num;i++){
            bw.write(cnt[i]+"\n"); //각 단지에 속하는 집의 수 출력
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

    static void dfs(int n,int m) {
        int r = n;
        int c = m;
        if(visited[r][c]==num){ //*문제1) 이게 없다면 연결되어 있지 않은 단지까지 탐색함*
            //상하좌우 탐색하며 각 칸까지의 최소비용 저장(델타 이용)
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) { //인덱스 초과 방지
                    if (visited[nr][nc] == 0 && arr[nr][nc] == 1) { //집은있는데 단지번호 안붙은 경우에 대해
                        visited[nr][nc] = num; //단지번호 붙여주기
                        dfs(nr, nc); //재귀호출
                    }
                }
            }
        }
    }//dfs끝
}
