//문제 20291 파일정리
//메모리 65008kb
//시간   704ms


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class B20291{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<String, Integer> file = new TreeMap<>();
		for(int i=0;i<n;i++) {
			String[] temp = (br.readLine()).split("\\.");
			String ext = temp[1];
			file.put(ext, file.getOrDefault(ext, 0)+1);
		}
		for(String f:file.keySet()) {
			sb.append(f).append(" ").append(file.get(f)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}