// 문제: 17419 비트가 넘쳐흘러
// 메모리: 20200 KB
// 시간: 220 ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B17419 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		String K = br.readLine();
		
		for(int i = 0; i < N; i++) {
			if(K.charAt(i) == '1') count++; 
		}
		bw.write(String.valueOf(count));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
