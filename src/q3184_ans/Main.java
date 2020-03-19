package q3184_ans;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int first;
	int second;
	Pair (int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n, m;
	static String[] a = new String[250];
	static boolean[][] check = new boolean[250][250];
	static int[][] d = new int[250*250][2]; //0은 늑대    1은 양
	
	static void bfs(int sx, int sy, int cnt) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(sx, sy));
		check[sx][sy]=true;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.first;
			int y = p.second;
			if(a[x].charAt(y)=='v') {	//늑대와 양을 해당 cnt에 따라 갯수를 세어줌
				d[cnt][0]+=1;			//cnt는 인덱스
			} else if (a[x].charAt(y)=='o') {
				d[cnt][1]+=1;
			}
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;	//다음칸이 맵을 벗어나면 생략
				if(a[nx].charAt(ny)=='#')continue; //다음칸이 벽이면 생략
				if(check[nx][ny]) continue; //다음칸을 방문한적이 있으면 생략
				q.add(new Pair(nx, ny));
				check[nx][ny]=true; //다음칸 방문 체크
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i=0; i<n; i++) {
			a[i]=sc.next();
		}
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i].charAt(j)!='#' && check[i][j]==false) { //벽이 아니고 해당칸에 간적이 없을경우
					cnt += 1;									//해당칸은 빈칸, 양, 늑대중 하나
					bfs(i, j, cnt);								//cnt은 인덱스를 위해 존재
//					for(int p=0; p<n; p++) {
//						for(int q=0; q<m; q++) {
//							System.out.print(check[p][q]+" ");
//						}
//						System.out.println();
//					}
//					System.out.println();
				}
			}
		}
		int v=0;
		int o=0;
		for (int i=1; i<=cnt; i++) {
			if(d[i][0]>=d[i][1]) {
				v += d[i][0];
			} else {
				o +=d[i][1];
			}
		}
		
//		for(int i=1; i<=cnt; i++) {
//			System.out.println(d[i][0]+" "+d[i][1]);
//		}
		System.out.println(o + " " + v);
	}
}
