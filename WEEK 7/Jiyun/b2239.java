// 문제: 2239 스도쿠 
// 메모리: 19556 KB
// 시간: 340 ms

import java.io.*;

public class b2239 {
	static int[][] board;
	static int[] row, col, box;
	static BufferedWriter bw;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		board = new int[9][9];
		row = new int[9];
		col = new int[9];
		box = new int[9];

		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				int n = input.charAt(j) - '0';

				board[i][j] = n;

				// 비트로 숫자 저장
				row[i] |= (1 << n - 1);
				col[j] |= (1 << n - 1);
				int boxIndex = (i / 3) * 3 + (j / 3);
				box[boxIndex] |= (1 << n - 1);
			}
		}

		sudoku(0, 0);
	}

	static void sudoku(int x, int y) throws IOException {

		// 다음줄로 이동
		if (y > 8) {
			x += 1;
			y = 0;
		}

		// 전부 채웠으면
		if (x == 9) {
			for (int[] bo : board) {
				for (int b : bo)
					sb.append(b);
				sb.append('\n');
			}
			bw.write(sb.toString());
			bw.flush();
			System.exit(0);
		}

		// 이미 채워진 칸이면 다음 칸으로
		if (board[x][y] != 0) {
			sudoku(x, y + 1);
			return;
		}

		for (int i = 0; i < 9; i++) {
			// 가로, 세로, 박스 모두에 해당 숫자가 없으면 채우기
			if ((row[x] & (1 << i)) == 0 && (col[y] & (1 << i)) == 0 && (box[(x / 3) * 3 + (y / 3)] & (1 << i)) == 0) {
				board[x][y] = i + 1;
				row[x] |= (1 << i);
				col[y] |= (1 << i);
				box[(x / 3) * 3 + (y / 3)] |= (1 << i);

				sudoku(x, y + 1);

				board[x][y] = 0;
				row[x] &= ~(1 << i);
				col[y] &= ~(1 << i);
				box[(x / 3) * 3 + (y / 3)] &= ~(1 << i);
			}
		}
	}

}
