import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B22252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Map<String, PriorityQueue<Integer>> map = new HashMap<>();

		// 쿼리의 개수
		int Q = Integer.parseInt(br.readLine());
		long count = 0;

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());

			if (query == 1) {
				String name = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if (map.containsKey(name)) {
					for (int j = 0; j < n; j++) {
						map.get(name).add(Integer.parseInt(st.nextToken()));
					}
				} else {
					PriorityQueue<Integer> ts = new PriorityQueue<>(Collections.reverseOrder());
					for (int j = 0; j < n; j++) {
						ts.add(Integer.parseInt(st.nextToken()));
					}
					map.put(name, ts);
				}
			} else {
				String name = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if(!map.containsKey(name)) continue;
				if (map.get(name).size() < n)
					n = map.get(name).size();
				for (int j = 0; j < n; j++) {
					count += map.get(name).poll();
				}
			}
		}

		bw.write(String.valueOf(count));
		br.close();
		bw.flush();
		bw.close();
	}
}
