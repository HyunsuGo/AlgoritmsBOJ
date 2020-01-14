package q14503;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //풀이시간 57분
	static int[][] map;
	static int[] dirs = {3, 0, 1, 2}; //왼쪽이 청소했을때 방향바꾸는것
	static int[] dy = {0, -1, 0, 1}; //0북 1동 2남 3서 방향에서 이동방향 결정
	static int[] dx = {-1, 0, 1, 0}; //이동방향은 : 0서 1북 2동 3남
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q14503/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m =  Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); //0북 1동 2남 3서 바라보는 방향
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count=0;
		int ans=0;
		while (true) {
			if(map[y][x]==0) {
				map[y][x] = 3; //현재위치 청소
				ans++;
			}
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (map[ny][nx] == 0) { //다음칸이 청소안되어있을 경우
				d = dirs[d]; //방향바꾸고
				y = ny; //그칸으로 이동
				x = nx;
				count=0; //방향전환 초기화
			} else { //다음칸이 청소되어있을경우 또는 벽일경우
				count++;
				d = dirs[d]; //방향 전환함
				if(count==4) { //방향전환 4번하면 
					count=0; //방향전환 초기화
					y = y + dy[(d+3)%4]; //뒤로빠꾸(방향은 그대로)
					x = x + dx[(d+3)%4];
					if(map[y][x]==1) break;
				}
			} 
		}
		System.out.println(ans);
		
	}
}

