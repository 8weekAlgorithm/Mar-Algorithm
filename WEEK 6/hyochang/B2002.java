//2002 추월
//메모리 15740kb
//시간 164ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B2002 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> police = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            String car = br.readLine();
            police.put(car, i);
        }

        String[] exit = new String[n];
        for (int i = 0; i < n; i++) {
            exit[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (police.get(exit[i]) > police.get(exit[j])) {
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
