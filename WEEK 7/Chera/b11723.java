/**
 * 문제 : 백준 11723번 집합
 * 메모리 : 313508 KB
 * 시간 : 1016ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int visited = 0;
		visited = 0b000000000000000000000;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = 0;
			switch(command) {
			case "add" :
				x = Integer.parseInt(st.nextToken());
				if((visited&(1<<x))!=0) continue;
				visited |= (1<<x);
				break;
			case "remove" :
				x = Integer.parseInt(st.nextToken());
				if((visited&(1<<x))==0) continue;
				visited &= ~(1<<x);
				break;
			case "check" :
				x = Integer.parseInt(st.nextToken());
				if((visited&(1<<x))!=0) { // x번째 노드가 true(있음!!)
					sb.append(1 + "\n");
				}else {
					sb.append(0+"\n");
				}
				break;
			case "toggle" :
				x = Integer.parseInt(st.nextToken());
				if((visited&(1<<x))!=0) {
					visited &= ~(1<<x);
				}else {
					visited |= (1<<x);
				}
				break;
			case "all" :
				visited &= (1<<N);
				visited |= (1<<N)-1;
				break;
			case "empty":
				visited &= (1<<N);
				break;
			}
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}
