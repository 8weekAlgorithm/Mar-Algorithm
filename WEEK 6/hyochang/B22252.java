//문제 22252 정보 상인 호석
//메모리 : 177536kb
//시간 : 1480ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());
        HashMap<String, ArrayList<Integer>> black = new HashMap<>();
        long hoseok = 0;

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                String goril = st.nextToken();
                int a = Integer.parseInt(st.nextToken());

                ArrayList<Integer> temp = black.getOrDefault(goril, new ArrayList<>());

                for (int j = 0; j < a; j++) {
                    temp.add(Integer.parseInt(st.nextToken()));
                }

                Collections.sort(temp, Collections.reverseOrder());
                black.put(goril, temp);

            } else if (command == 2) {
                String goril = st.nextToken();
                int b = Integer.parseInt(st.nextToken());

                if (black.containsKey(goril)) {
                    ArrayList<Integer> temp = black.get(goril);
                    int size = temp.size();

                    int take = Math.min(b, size); 
                    for (int j = 0; j < take; j++) {
                        hoseok += temp.remove(0); 
                    }
                }
            }
        }
        System.out.println(hoseok);
    }
}
