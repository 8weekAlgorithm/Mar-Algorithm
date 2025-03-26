// 문제: 백준 1931번 회의실 배정
// 메모리: 44700KB
// 시간: 448ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//회의 수
		
		int[][] meetings = new int[N][2];
				
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//정렬할건데
		Arrays.sort(meetings, new Comparator<int[]>() {
			
			//끝나는 시간 기준으로 오름차순 정렬(빠른 순), 끝나는 시간이 같으면 시작 시간 기준으로 오름차순 정렬(빠른 순)
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1] == b[1]) return a[0] - b[0];
				return a[1] - b[1];
			}
			
		});
		
		
		int cnt = 0; //가능한 회의 수
		int lastEndTime = 0; //가장 최근 회의가 끝난 시간
		
		for(int i = 0; i < N; i++) {
			if(meetings[i][0] >= lastEndTime) {//이번 회의의 시작 시간이 가장 최근 회의가 끝난 시간이랑 같거나 늦으면
				lastEndTime = meetings[i][1]; //가장 최근 회의가 끝난 시간을 이번 회의가 끝나는 시간으로 갱신
				cnt++; //회의 수 증가
			}
		}
		System.out.println(cnt);
	}
}
