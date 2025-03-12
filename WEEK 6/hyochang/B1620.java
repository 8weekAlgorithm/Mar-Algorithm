//문제 : 1620 나는야 포켓몬 마스터 이다솜
//메모리 : 58812kb
//시간 : 512ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1620 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> map = new HashMap<>();
    HashMap<Integer, String> reverseMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String pokemon = br.readLine();
      map.put(pokemon, i + 1);
      reverseMap.put(i + 1, pokemon);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String command = br.readLine();
      if (isNumeric(command)) {
        sb.append(reverseMap.get(Integer.parseInt(command))).append("\n");
      } else {
        sb.append(map.get(command)).append("\n");
      }
    }
    System.out.print(sb);
  }

  private static boolean isNumeric(String str) {
    for (char c : str.toCharArray()) {
      if (!Character.isDigit(c)) return false;
    }
    return true;
  }
}
