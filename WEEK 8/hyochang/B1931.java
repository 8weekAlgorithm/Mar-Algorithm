
//문제 1931 회의실 배정
//메모리 : 44936kb
//시간 : 484ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] talk = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			talk[i][0] = Integer.parseInt(st.nextToken());
			talk[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(talk, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] != o2[1]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
		// [0]를 기준으로 정렬하고 같은 경우 [1]을 보았을 때는 여러 분기를 고려해야함
		// [1]을 기준으로 정렬하여 빨리 끝나고 그 이후에 고를 수 있는걸 카운트
		int cnt = 0;
		int vaild = 0;
		for (int i = 0; i < n; i++) {
			if (talk[i][0] >= vaild) {
				cnt++;
				vaild = talk[i][1];
			}
		}
		System.out.println(cnt);
	}
}