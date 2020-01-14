package q14499;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //풀이시간 53분
	static int[][] map;
	static int[] dice = new int[6];
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	static int x, y;
	static int[][] index = {
			{0, 1, 2, 3, 4, 5}, //기본
			{0, 5, 1, 2, 4, 3}, //동
			{0, 2, 3, 5, 4, 1}, //서
			{2, 1, 4, 3, 5, 0}, //북
			{5, 1, 0, 3, 2, 4} //남
	};
	
	static void move(int dir) { //주사위 움직임
		int tmp[] = new int[6];
		for(int i=0; i<6; i++) tmp[i]=dice[index[dir][i]];
		dice = Arrays.copyOf(tmp, 6);
		
		if (map[x][y]==0) { //이동한칸 0 -> 바닥면쓰여있는수가 칸에 복사
			map[x][y]=dice[5];
		} else { //0이 아닌경우 -> 칸에 쓰여있는수가 바닥으로복사 & 칸에쓰여있는수는 0으로
			dice[5]=map[x][y];
			map[x][y]=0;
		}
		System.out.println(dice[2]);
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q14499/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //세로
		int m = Integer.parseInt(st.nextToken()); //가로
		x = Integer.parseInt(st.nextToken()); //세로
		y = Integer.parseInt(st.nextToken()); //가로
		int k = Integer.parseInt(st.nextToken()); //명령의 개수
		
		map  = new int[n][m];
		for(int i=0; i<n; i++) { //맵 입력 (주사위가 놓여있는 칸은 무조건 0)
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()); //명령입력
		
		for (int i=0; i<k; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int nx = x + dx[dir]; int ny = y + dy[dir];
			if (nx==-1 || nx==n || ny==-1 || ny==m) continue; //지도를 벗어나면 무시
			x=nx; y=ny;
			move(dir);
		}	
	}
}
