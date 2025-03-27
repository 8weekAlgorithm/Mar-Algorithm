import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 문제: 가장 긴 증가하는 부분 수열 (Longest Increasing Subsequence, LIS)
// 메모리 14588kb 시간 128ms 
// https://www.acmicpc.net/problem/11053

public class B11053 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 입력을 받기 위한 BufferedReader와 출력용 BufferedWriter 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 결과를 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 수열의 크기 T 입력
        int T = Integer.parseInt(br.readLine());

        // 수열의 값과 LIS 길이를 저장할 배열 (배열 크기는 T+1)
        // nums[i][0]은 수열의 i번째 원소
        // nums[i][1]은 그 원소를 끝으로 하는 가장 긴 증가하는 부분 수열의 길이
        int[][] nums = new int[T + 1][2];

        // 수열의 0번째 인덱스 값 초기화 (실제로 사용되지는 않음)
        nums[0][0] = 0;
        nums[0][1] = 0;

        // 수열의 값 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= T; i++) {
            int a = Integer.parseInt(st.nextToken());
            nums[i][0] = a; // 수열의 i번째 값 저장
        }

        // 가장 긴 증가하는 부분 수열의 길이를 저장할 변수
        int maxLength = 0;

        // LIS 계산 (DP 방식)
        for (int i = 1; i <= T; i++) {
            int a = nums[i][0];  // 현재 수열의 i번째 원소
            int max = 0;         // 증가하는 부분 수열의 길이를 저장할 변수

            // i번째 원소 이전의 모든 원소를 확인
            for (int j = 0; j < i; j++) {
                // 만약 i번째 원소가 j번째 원소보다 크다면 LIS 가능
                if (nums[i][0] > nums[j][0]) {
                    // j번째 원소까지의 LIS와 i번째 원소를 포함시킨 LIS의 길이 계산
                    max = Math.max(max, nums[j][1]);
                }
            }

            // i번째 원소를 포함한 LIS의 길이 계산
            nums[i][1] = max + 1;

            // 가장 긴 증가하는 부분 수열의 길이 갱신
            maxLength = Math.max(maxLength, nums[i][1]);
        }

        // 결과 출력 (가장 긴 증가하는 부분 수열의 길이)
        bw.write(String.valueOf(maxLength));
        bw.flush();  // 버퍼에 저장된 내용을 출력
    }
}
