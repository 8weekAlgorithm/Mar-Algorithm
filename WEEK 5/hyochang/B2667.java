//문제 2667 단지번호붙이기
//메모리 15856kb
//시간 120ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class B2667 {
    static int n;
    static int[][] village;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static List<Integer> note = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        village = new int[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                village[i][j] = temp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (village[i][j] == 1) {
                    note.add(bfs(i, j));
                }
            }
        }

        Collections.sort(note); 
        bw.write(note.size() + "\n");

        for (int num : note) {
            bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int bfs(int i, int j) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i * n + j); 
        village[i][j] = 0;  
        int cnt = 1;  

        while (!queue.isEmpty()) {
            int num = queue.poll();
            int y = num / n;  
            int x = num % n;  

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n && village[ny][nx] == 1) {
                    village[ny][nx] = 0;  
                    queue.add(ny * n + nx); 
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
