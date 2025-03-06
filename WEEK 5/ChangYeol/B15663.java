// 문제: 백준 15663번 N과 M (9)
// 링크: https://www.acmicpc.net/problem/15663
// 시간: 200ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums, select;
	static List<int[]> result;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		select = new int[M];
		result = new ArrayList<>();
		check = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		perm(0);
		
		for (int i = 0; i < result.size(); i++) {
			int[] arr = result.get(i);
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		
	}
	
	static void perm(int idx) {
		if(idx == M) {
//			for(int i = 0; i < M; i++) {
//				System.out.print(result[i] + " ");
//			}
//			System.out.println();
			result.add(select.clone());
			return;
		}
		
		int prev = -1;
		for(int i = 0; i < N; i++) {
			if(check[i] || nums[i] == prev) {
				continue;
			}
			check[i] = true;
			select[idx] = nums[i];
			prev = nums[i];
			perm(idx+1);
			check[i] = false;
		}
	}
}
