//문제 : 25192 인사성 밝은 곰곰이
//메모리 : 26076kb
//시간 : 256ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B25192 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String chat = br.readLine();
			if(chat.equals("ENTER")) {
				set.clear();
			}else {
				if(set.contains(chat)) {
					continue;
				}else {
					set.add(chat);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
}
