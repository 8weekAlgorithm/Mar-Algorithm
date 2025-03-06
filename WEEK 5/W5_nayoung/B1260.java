// 문제: 백준 1260번 DFS와 BFS
// 메모리: 20608KB
// 시간: 232ms

import java.io.*;
import java.util.*;


public class B1260 {

    static ArrayList<Integer>[] graph; //배열리스트를 요소로 갖는 배열!
    static boolean[] visited;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점의 개수 N(1 ≤ N ≤ 1,000)
        int M = Integer.parseInt(st.nextToken()); //간선의 개수 M(1 ≤ M ≤ 10,000)
        int V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호 V

        /*제네릭 배열을 직접 만들 수 없기 때문에,
        ArrayList<Integer>[] graph = new ArrayList[5]; 처럼 배열을 생성한 후,
        각 요소에 대해 ArrayList를 명시적으로 초기화하는 방식이 자주 사용된다.*/
        graph = new ArrayList[N+1]; //0~N까지의 정점 정보 저장
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){ //간선의 개수만큼 for문 돌기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b); //a번째 배열리스트에 b값 추가
            graph[b].add(a); //b번째 배열리스트에 a값 추가
        }

        for(ArrayList<Integer> e: graph){
            Collections.sort(e); //각 배열리스트를 오름차순 정렬 - 정점 번호가 작은 것을 먼저 방문하기 위해
        }

//        System.out.println(Arrays.toString(graph)); //확인용 - 이후 주석 처리

        sb = new StringBuilder();
        visited = new boolean[N+1];
        dfs(V);
        bw.write(sb.toString()+" ");

        sb = new StringBuilder();
        visited = new boolean[N+1];
        bfs(V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }//main

    static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");

        for(int next: graph[start]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }//dfs

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        visited[start]=true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            sb.append(curr).append(" ");
            for(int next: graph[curr]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }//bfs


}
