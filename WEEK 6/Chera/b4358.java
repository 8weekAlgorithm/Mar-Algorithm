/**
 * 문제 : 백준 4358번 생태학
 * 메모리 : 120948KB
 * 시간 : 840ms
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class b4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<String, Double> map = new TreeMap<>();
        int sum = 0;

        while (true) {
            String tree = br.readLine();
            if(tree==null){
                break;
            }
            map.put(tree, map.getOrDefault(tree, 0.0) + 1);
            sum++;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            double percent = Math.round((entry.getValue() / sum) * 100 * 10000) / 10000.0;
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", percent)).append("\n"); // 소수점 4자리까지 출력
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
