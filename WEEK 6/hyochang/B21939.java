//문제 : 21939 문제 추천 시스템 Version 1
//메모리 : 61996kb
//시간 : 596ms
import java.io.*;
import java.util.*;

public class B21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, TreeSet<Integer>> coding = new TreeMap<>();
        HashMap<Integer, Integer> reverse = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());

            coding.putIfAbsent(diff, new TreeSet<>(Comparator.reverseOrder())); // 내림차순 정렬
            coding.get(diff).add(problem);
            reverse.put(problem, diff);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "add":
                    int problem = Integer.parseInt(st.nextToken());
                    int diff = Integer.parseInt(st.nextToken());

                    coding.putIfAbsent(diff, new TreeSet<>(Comparator.reverseOrder())); // 내림차순 정렬
                    coding.get(diff).add(problem);
                    reverse.put(problem, diff);
                    break;

                case "recommend":
                    int x = Integer.parseInt(st.nextToken());

                    if (x == 1) {
                        sb.append(coding.lastEntry().getValue().first()).append("\n"); // 가장 어려운 문제 중 최대 문제 번호
                    } else {
                        sb.append(coding.firstEntry().getValue().last()).append("\n"); // 가장 쉬운 문제 중 최소 문제 번호
                    }
                    break;

                case "solved":
                    int solvedProblem = Integer.parseInt(st.nextToken());

                    if (reverse.containsKey(solvedProblem)) { // 문제 존재 확인
                        int diffToRemove = reverse.remove(solvedProblem);
                        coding.get(diffToRemove).remove(solvedProblem);
                        if (coding.get(diffToRemove).isEmpty()) {
                            coding.remove(diffToRemove);
                        }
                    }
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
