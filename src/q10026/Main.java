package q10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main { //57min
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	
	static int go1(char[][] map) {
		int[][] check = new int[map.length][map[0].length];
		Queue<Integer> q = new LinkedList<>();
		int n = map.length;
		int index = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(check[i][j]!=0) continue;
				q.add(i); q.add(j);
				check[i][j]=index;
				while(!q.isEmpty()) {
					int y = q.remove();
					int x = q.remove();
					for(int k=0; k<4; k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];
						if( ny<0 || ny>=n || nx<0 || nx>=n ) continue;
						if(check[ny][nx]!=0) continue;
						if(map[y][x]==map[ny][nx]) {
							q.add(ny); q.add(nx);
							check[ny][nx]=index;
						}
					}
				}
				index++;
			}
		}
		return index-1;
	}
	
	static int go2(char[][] map) {
		int[][] check = new int[map.length][map[0].length];
		Queue<Integer> q = new LinkedList<>();
		int n = map.length;
		int index = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]=='R' || map[i][j]=='G') {
					if(check[i][j]!=0) continue;
					q.add(i); q.add(j);
					check[i][j]=index;
					while(!q.isEmpty()) {
						int y = q.remove();
						int x = q.remove();
						for(int k=0; k<4; k++) {
							int ny = y + dy[k];
							int nx = x + dx[k];
							if( ny<0 || ny>=n || nx<0 || nx>=n ) continue;
							if(check[ny][nx]!=0) continue;
							if(map[ny][nx]=='R' || map[ny][nx]=='G') {
								q.add(ny); q.add(nx);
								check[ny][nx]=index;
							}
						}
					}
					index++;
				} else {
					if(check[i][j]!=0) continue;
					q.add(i); q.add(j);
					check[i][j]=index;
					while(!q.isEmpty()) {
						int y = q.remove();
						int x = q.remove();
						for(int k=0; k<4; k++) {
							int ny = y + dy[k];
							int nx = x + dx[k];
							if( ny<0 || ny>=n || nx<0 || nx>=n ) continue;
							if( check[ny][nx]!=0) continue;
							if(map[ny][nx]==map[y][x]) {
								q.add(ny); q.add(nx);
								check[ny][nx]=index;
							}
						}
					}
				index++;
				}
			}
		}
		return index-1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			
			for(int j=0; j<n; j++) {
				map[i][j]=tmp.charAt(j);
			}
		}
		System.out.println(go1(map) + " " + go2(map));
	}
}
