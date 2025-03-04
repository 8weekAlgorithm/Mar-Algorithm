import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260 {  //시간 280 Ms
    static List<Integer>[] dfs;        //값을 담을 배열과 방문처리 배열을 각각 선언
    static List<Integer>[] bfs;
    static boolean[] visit;
    static boolean[] visitBfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int connect = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visit = new boolean[size + 1];  //인덱스 편하게 하고 싶어서 전부 +1
        visitBfs = new boolean[size + 1];
        dfs = new ArrayList[size + 1];
        bfs = new ArrayList[size + 1];
        for (int i = 0; i < size + 1; i++) {
            dfs[i] = new ArrayList<>();
            bfs[i] = new ArrayList<>();
        }
        for (int i = 0; i < connect; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st1.nextToken());
            int value = Integer.parseInt(st1.nextToken());
            dfs[idx].add(value);
            dfs[value].add(idx);
            Collections.sort(dfs[idx]);  //정점 번호가 작은 곳을 먼저 방문 해야 해서 정렬 해준다,
            Collections.sort(dfs[value]);
            bfs[idx].add(value);
            bfs[value].add(idx);
            Collections.sort(bfs[idx]);
            Collections.sort(bfs[value]);
        }
        StringBuilder a = returnDfs(start);
        sb.append(a).append("\n");
        StringBuilder b = returnBfs(start);
        sb.append(b);
        System.out.println(sb);
    }


    public static StringBuilder returnDfs(int start) {
        StringBuilder sb = new StringBuilder();
        sb.append(start).append(" ");
        visit[start] = true;

        if (!dfs[start].isEmpty()) {  //해당 정점에 자식이 있으면
            for (int i = 0; i < dfs[start].size(); i++) {
                int idx = dfs[start].get(i);
                if (!visit[idx]) { //방문 안한곳으로 재귀 방문을 다했으면 빠져나옴
                    sb.append(returnDfs(idx));
                }
            }
        }
        return sb;
    }

    public static StringBuilder returnBfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(start);
        visitBfs[start] = true;


        while (!(q.isEmpty())) {  //큐가 빌때 까지 반복
            int a = q.poll();
            sb.append(a + " ");
            if (!bfs[a].isEmpty()) {
                for (int idx : bfs[a]) {
                    if (!visitBfs[idx]) {  //정점에 자식이 있고 아직 방문 안한 곳이 있다면
                        visitBfs[idx] = true;
                        q.offer(idx); //큐에 넣는다. 
                    }
                }
            }
        }
        return sb;
    }
}
