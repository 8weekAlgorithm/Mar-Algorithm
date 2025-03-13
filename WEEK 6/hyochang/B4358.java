//문제 4358 생태학
//메모리 86492kb
//시간 812ms
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class B4358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		TreeMap<String, Integer> tree = new TreeMap<>();
		int total = 0;
		
		while(true) {

			String spec=br.readLine();
			if(spec==null)
				break;
			tree.put(spec, tree.getOrDefault(spec, 0)+1);
			total++;
		}
		for(String t:tree.keySet()) {
			double percent = (double) tree.get(t)/total*100;
			sb.append(t).append(" ").append(String.format("%.4f", percent)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}