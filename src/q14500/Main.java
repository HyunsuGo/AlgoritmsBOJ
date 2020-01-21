package q14500;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //Ç®ÀÌ½Ã°£ 42ºÐ
	static Pair[][] blocks = {
				{new Pair(0, 1), new Pair(1, 0), new Pair(1, 1)}, //¤±
				{new Pair(0, 1), new Pair(0, 2), new Pair(0, 3)}, //¤Ñ
				{new Pair(1, 0), new Pair(2, 0), new Pair(3, 0)},
				{new Pair(1, 0), new Pair(2, 0), new Pair(2, 1)}, //¤¤
				{new Pair(1, 0), new Pair(0, 1), new Pair(0, 2)},
				{new Pair(0, 1), new Pair(1, 1), new Pair(2, 1)},
				{new Pair(0, 1), new Pair(0, 2), new Pair(-1, 2)},
				{new Pair(1, 0), new Pair(2, 0), new Pair(2, -1)}, //¤¤´ëÄª
				{new Pair(1, 0), new Pair(1, 1), new Pair(1, 2)},
				{new Pair(0, 1), new Pair(1, 0), new Pair(2, 0)},
				{new Pair(0, 1), new Pair(0, 2), new Pair(1, 2)},
				{new Pair(1, 0), new Pair(1, 1), new Pair(2, 1)}, //¤©
				{new Pair(0, 1), new Pair(-1, 1), new Pair(-1, 2)},
				{new Pair(1, 0), new Pair(1, -1), new Pair(2, -1)}, //¤©´ëÄª
				{new Pair(0, 1), new Pair(1, 1), new Pair(1, 2)},
				{new Pair(0, 1), new Pair(0, 2), new Pair(-1, 1)}, //¤Ç
				{new Pair(1, 0), new Pair(2, 0), new Pair(1, 1)},
				{new Pair(0, 1), new Pair(0, 2), new Pair(1, 1)},
				{new Pair(1, 0), new Pair(2, 0), new Pair(1, -1)},
			};
	
	static class Pair {
		int y, x;
		Pair(int y, int x) {
			this.y=y; this.x=x;
		}
	}
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q14500/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int p=0; p<blocks.length; p++) {
					int sum = map[i][j];
					for(int q=0; q<3; q++) {
						if(i+blocks[p][q].y<0 || i+blocks[p][q].y>n-1 
							|| j+blocks[p][q].x<0 || j+blocks[p][q].x>m-1) break;
						sum += map[i+blocks[p][q].y][j+blocks[p][q].x];
					}
					ans = Math.max(ans, sum);
				}
			}
		}
		System.out.println(ans);
	}
}
