
//문제 13305 주유소
//메모리 : 62864kb
//시간 : 392ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B13305 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] way = new long[n - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			way[i] = Long.parseLong(st.nextToken());
		}
		// 기름 가격을 보고 이전보다 크다면 이전값으로 더해줌 아니면 새로운 값으로 바꿔서

		BigInteger cash = BigInteger.ZERO;

		st = new StringTokenizer(br.readLine());
		long sale = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n; i++) {
			cash = cash.add(BigInteger.valueOf(sale).multiply(BigInteger.valueOf(way[i-1])));
			long oil = Long.parseLong(st.nextToken());
			sale = Math.min(sale, oil);
		}
		System.out.println(cash);
	}
}