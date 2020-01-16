package q15685;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main { //풀이시간 117분
	static int[][] map = new int[101][101];
	static int[] dy = {0, -1, 0, 1}; //0동 1북 2서 3남
	static int[] dx = {1, 0, -1, 0}; // 북   서   남   동
	
	static void show() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static int checkAns() {
		int ans=0;
		for(int i=0; i<map.length-1; i++) {
			for(int j=0; j<map[0].length-1; j++) {
				if(map[i][j]==1&&map[i][j+1]==1&&map[i+1][j]==1&&map[i+1][j+1]==1) ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q15685/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 시작점 / 시작방향 / 세대
		
		int n = Integer.parseInt(br.readLine());
		//x열 y행 d시작방향 g세대
		//d 0오 1 위 2왼 3아래
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int size=(int) Math.pow(2, g);
			int[] list = new int[size];
			list[0]=d;
			
			for(int j=1; j<=g; j++) {
				int index=0;
				for(int k=(int)Math.pow(2, j)-1; k>(int)Math.pow(2, j-1)-1; k--) {
					list[k]=(list[index]+1)%4;
					index++;
				}
			}
			for(int j=0; j<list.length; j++) {
				map[y][x]=1;
				y += dy[list[j]];
				x += dx[list[j]];
			}
			map[y][x]=1;
		}
//		show();
		System.out.println(checkAns());
	}
}
