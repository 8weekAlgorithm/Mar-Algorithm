// 문제: 백준 2644번 촌수계산 => A에서 B까지 연결된 경우는 한 경우뿐(또는 아예 친척 아님)이므로 dfs가 효율적
// 메모리: 14176KB
// 시간: 108ms

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2644 {
    static ArrayList<Integer>[] graph;
    static int N; //전체 사람의 수
    static int A, B; //촌수를 계산해야 하는 서로 다른 두 사람의 번호
    static int M; //부모 자식들 간의 관계의 개수(간선 수)
    static boolean[] visited; //방문배열
    static int cnt; //촌수(나 자신은 방문으로 안친다)
    static boolean isRelated; //촌수계산 가능 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        //입력값 받아서 graph만들기
        graph = new ArrayList[N+1]; //0~N까지 저장가능한 배열리스트
        for(int i=0;i<N+1;i++){
            graph[i] = new ArrayList<>(); //각 요소에 대해 ArrayList를 명시적으로 초기화
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }//그래프 완성

        visited = new boolean[N+1];
        isRelated = false; //촌수 계산 가능 유무 초기화
        dfs(A); //A방문은 방문으로 안치기 때문에 visited[A]==false인 상태로 유지.
        if(isRelated){
            bw.write(cnt+"");
        }else{
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

    static void dfs(int start){
        int curr = start; //현재 노드번호
        //종료조건(1)
        if(curr==B){ //B까지 탐색했을때의 촌수 구한 후 return;
            cnt=0;
            for(int i=1;i<=N;i++){
                if(visited[i]) cnt++;
            }
            isRelated = true;
            return;
        }
        //현재노드의 인접노드들에 대해
        for(int next: graph[curr]){ //종료조건(2) - 이걸로 종료되면 isRelated는 false!!
            if(!visited[next]){ //이미 방문하지 않은 노드라면
                visited[next]=true; //방문표시 후
                dfs(next); //재귀조건: 그 인접노드에 대해 다시 dfs
                visited[next]=false; //백트래킹하면서 방문표시 다시 지워줘야함
            }
        }
    }


}
