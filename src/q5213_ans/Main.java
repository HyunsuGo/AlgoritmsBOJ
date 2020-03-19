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
		if(x1==x2) { //���� Row�� ������
			if(y1<y2) { //���� column�� ���� ������ ������
				return a[x1][y1][1]==a[x2][y2][0];
			} else { //���� column�� ������ �� ���� ������
				return a[x1][y1][0]==a[x2][y2][1];
			}
		} else { //�ٸ� Row�� ������
			if(x1%2==0) { //¦��Row
				if(y1==y2) {
					return a[x1][y1][1]==a[x2][y2][0];
				} else {
					return a[x1][y1][0]==a[x2][y2][1];
				}
			} else { //Ȧ�� Row
				if(y1==y2) {
					return a[x1][y1][0]==a[x2][y2][1];
				} else {
					return a[x1][y1][1]==a[x2][y2][0];
				}
			}
		}
	}
	
	static int num(int x, int y) { //Ÿ�� ��ȣ ���
		int ans = x/2 * (n*2-1);
		if (x%2==1) { //Ȧ����° ���ϰ��
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
			if(i%2==0) { //¦����°���� ������ �Ѱ��� �� �Է�
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
				if(x%2==0) { //¦����°��
					nx=x+dx0[k];
					ny=y+dy0[k];
				} else { //Ȧ����°��
					nx=x+dx1[k];
					ny=y+dy1[k];
				}
				if (ok(nx, ny)==false) continue; //���� ����°�� ����
				if (go(x, y, nx, ny)==false) continue; //�� �ּҿ� �� �ּ��� ���� �ٸ��� ����
				if (check[nx][ny]==true) continue; //���ο��ּҸ� �̹� �湮�ߴ� ��� ����
				check[nx][ny]=true;
				dist[nx][ny]=dist[x][y]+1;
				from[nx][ny]=new Pair(x,y);
				q.add(new Pair(nx, ny));
			}
		}
		int x = n-1;
		int y = n-1;
//		while(check[x][y]==false) { //check[x][y]���� true�� �Ǵ� x,y��ǥ�� ã��
//			y--;
//			if(y<0) {
//				x--;
//				y=n-1;
//				if(x%2==1) y--;
//			}
//		}
		System.out.println(dist[x][y]);
		Stack<Pair> s = new Stack<>();
		while(!(x==0&&y==0)) { //x,y��ǥ�� 0,0�� �Ǹ� while Ż��
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
