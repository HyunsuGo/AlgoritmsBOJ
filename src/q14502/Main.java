package q14502;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //풀이시간 68분
	static int[][] map;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int ans = Integer.MIN_VALUE;
	
	static ArrayList<Pair> viruses = new ArrayList<>();
	
	static class Pair {
		int y, x;
		Pair(int y, int x) {
			this.y=y; this.x=x;
		}
	}

	static int calculate(int[][] tMap) {
		int sum = 0;
		for(int i=0; i<tMap.length; i++) {
			for(int j=0; j<tMap[0].length; j++) {
				if(tMap[i][j]==0) sum++;
			}
		}
		return sum;
	}
	
	static void go(int y, int x, int[][] tMap) {
		if(y<0 || y>tMap.length-1 || x<0 || x>tMap[0].length-1) return;
		if(tMap[y][x]!=0)return;
		tMap[y][x]=2;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
//			System.out.println("ny : " + ny + "   nx : " + nx);
			go(ny, nx, tMap);
		}
	}
	
	static void buildWall(int y, int x, int index) {
		if(index==3) {
			int[][] tMap = new int[map.length][map[0].length];
			for(int i=0; i<map.length; i++) tMap[i]=Arrays.copyOf(map[i], map[i].length);
			for(int i=0; i<viruses.size(); i++) {
				int vy = viruses.get(i).y;
				int vx = viruses.get(i).x;
				for(int j=0; j<4; j++) {
					int ny = vy + dy[j];
					int nx = vx + dx[j];
					go(ny, nx, tMap);
				}
			}
			for(int i=0; i<tMap.length; i++) {
				for(int j=0; j<tMap[0].length; j++) {
					System.out.print(tMap[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			int temp = calculate(tMap);
			if(ans<temp) ans = temp;
			return;
		}
		
		if(map[y][x]!=0) return;  //0이 아니면 벽을 세울수 없으므로
		map[y][x]=1; //벽세우고
		int sy=y, sx=x;
		if(sx==map[0].length-1 && sy<map.length-1) {
			sx=0; sy++;
		} else if(sx==map[0].length-1 && sy==map.length-1) return;
		else sx++;
		for(int i=sy; i<map.length; i++) {
			for(int j=sx; j<map[0].length; j++) {
				buildWall(i, j, index+1); //다음벽으로 진행
			}
		}
		map[y][x]=0; //벽 안세우고
		
		return;
	}
	
	public static void main(String[] args) throws Exception {
		File file = new File ("src/q14502/test.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) viruses.add(new Pair(i, j));
			}
		}
		
		for (int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
					buildWall(i, j, 0);
			}
		}
		System.out.println(ans);
		
	}
}
