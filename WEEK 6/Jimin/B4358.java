import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class B4358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Map<String, Integer> tm = new TreeMap<>();
		int totalCount = 0;
		while (true) {
			String tree = br.readLine();
			if (tree == null || tree.isEmpty()) break;
			tm.put(tree, tm.getOrDefault(tree, 0) + 1);
			totalCount++;
		}

		for (Map.Entry<String, Integer> entry : tm.entrySet()) {
			double p = entry.getValue() * 100.0 / totalCount;
			bw.write(String.format("%s %.4f\n", entry.getKey(), p));
		}
		br.close();
		bw.flush();
		bw.close();
	}
}