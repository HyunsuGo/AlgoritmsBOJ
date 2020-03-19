package q5213_ans;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Pair {
	int first;
	int second;
	Pair(int first, int second) {
		this.first=first;
		this.second=second;
	}
}

public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n;
	static int[][][] a = new int[500][500][2];
	static boolean[][] check = new boolean[500][500];
	static Pair[][] from = new Pair[500][500];
	static int[][] dist = new int[500][500];
	static int[] dx0 = {-1, -1, 0, 0, 1, 1};
	static int[] dy0 = {-1, 0, -1, 1, -1, 0};
	static int[] dx1 = {-1, -1, 0, 0, 1, 1};
	static int[] dy1 = {0, 1, -1, 1, 0 ,1};
	
	static boolean ok(int x, int y) {
		if(x<0 || x>=n) return false;
		if(x%2==0) {
			return y>=0 && y<n;
		} else {
			return y>=0 && y<n-1;
		}
	}
	
	static boolean go(int x1, int y1, int x2, int y2) {
		if(x1==x2) { //같은 Row에 있을때
			if(y1<y2) { //다음 column이 이전 다음에 있을때
				return a[x1][y1][1]==a[x2][y2][0];
			} else { //다음 column이 전보다 더 전에 있을때
				return a[x1][y1][0]==a[x2][y2][1];
			}
		} else { //다른 Row에 있을때
			if(x1%2==0) { //짝수Row
				if(y1==y2) {
					return a[x1][y1][1]==a[x2][y2][0];
				} else {
					return a[x1][y1][0]==a[x2][y2][1];
				}
			} else { //홀수 Row
				if(y1==y2) {
					return a[x1][y1][0]==a[x2][y2][1];
				} else {
					return a[x1][y1][1]==a[x2][y2][0];
				}
			}
		}
	}
	
	static int num(int x, int y) { //타일 번호 계산
		int ans = x/2 * (n*2-1);
		if (x%2==1) { //홀수번째 줄일경우
			ans += n;
		}
		ans += y+1;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				a[i][j][0]=sc.nextInt();
				a[i][j][1]=sc.nextInt();
			}
			if(i%2==0) { //짝수번째줄은 마지막 한개씩 더 입력
				a[i][n-1][0]=sc.nextInt();
				a[i][n-1][1]=sc.nextInt();
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		check[0][0]=true;
		dist[0][0] = 1;
		q.add(new Pair(0, 0));
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.first;
			int y = p.second;
			for(int k=0; k<6; k++) {
				int nx, ny;
				if(x%2==0) { //짝수번째줄
					nx=x+dx0[k];
					ny=y+dy0[k];
				} else { //홀수번째줄
					nx=x+dx1[k];
					ny=y+dy1[k];
				}
				if (ok(nx, ny)==false) continue; //판을 벗어나는경우 생략
				if (go(x, y, nx, ny)==false) continue; //구 주소와 신 주소의 값이 다르면 생략
				if (check[nx][ny]==true) continue; //새로운주소를 이미 방문했던 경우 생략
				check[nx][ny]=true;
				dist[nx][ny]=dist[x][y]+1;
				from[nx][ny]=new Pair(x,y);
				q.add(new Pair(nx, ny));
			}
		}
		int x = n-1;
		int y = n-1;
//		while(check[x][y]==false) { //check[x][y]값이 true가 되는 x,y좌표를 찾음
//			y--;
//			if(y<0) {
//				x--;
//				y=n-1;
//				if(x%2==1) y--;
//			}
//		}
		System.out.println(dist[x][y]);
		Stack<Pair> s = new Stack<>();
		while(!(x==0&&y==0)) { //x,y좌표가 0,0이 되면 while 탈출
			s.push(new Pair(x, y));
			Pair p = from[x][y];
			x=p.first;
			y=p.second;
		}
		s.push(new Pair(x, y));
		while(!s.isEmpty()) {
			System.out.print(num(s.peek().first, s.peek().second) + " ");
			s.pop();
		}
		System.out.println();
	}
}
