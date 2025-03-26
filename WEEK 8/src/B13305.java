import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//메모리 34316kb 시간 316ms  
//https://www.acmicpc.net/problem/13305
public class B13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer dis = new StringTokenizer(br.readLine());
        StringTokenizer oil = new StringTokenizer(br.readLine());
        long sumOil = 0;
        long minOil = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) { //마지막 도시의 비용은 의미가 없으므로 그냥 제외 
            minOil = Math.min(minOil, Integer.parseInt(oil.nextToken())); //도시를 건널 때 마다 비교해서 비용이 적으면 그 기름의 비용을 유지
            sumOil += minOil * Integer.parseInt(dis.nextToken()); //해당 비용으로 계속해서 도시를 건넘
        }
        sb.append(sumOil);
        System.out.println(sb);
    }
}