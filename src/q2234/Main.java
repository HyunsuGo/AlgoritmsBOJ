package q2234;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main { //74min
	static int[] dy = {0, -1, 0, 1}; //좌 상 우 하
	static int[] dx = {-1, 0, 1, 0};
	static int[][] dirs = { //번호에 따른 진행 방향
			{0, 1, 2, 3},//0
			{1, 2, 3},//1
			{2, 3, 0},
			{2, 3},
			{0, 1, 3},
			{1, 3},//5
			{0, 3},
			{3},
			{0, 1, 2},
			{1, 2},
			{0, 2},//10
			{2},
			{0, 1},
			{1},
			{0},
			{}//15
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] map = new int[n][m];
		boolean[][] check = new boolean[n][m];
		int[][] division = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		int index = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(check[i][j]==false) { //아직 방문 안한경우
					index++;
					int sum = 0;
					q.add(i); q.add(j);
					check[i][j]=true;
					division[i][j] = index;
					sum++;
					while(!q.isEmpty()) {
						int y = q.remove();
						int x = q.remove();
						for(int k=0; k<dirs[map[y][x]].length; k++) {
							int ny = y + dy[dirs[map[y][x]][k]];
							int nx = x + dx[dirs[map[y][x]][k]];
							if(ny<0 || ny>=n || nx<0 || nx>=m ) continue;
							if(check[ny][nx]) continue;
							q.add(ny); q.add(nx);
							check[ny][nx]=true;
							division[ny][nx]=index;
							sum++;
						}
					}
					list.add(sum);
				}
			}
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(division[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(index);
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<list.size(); i++) if(list.get(i)>max) max = list.get(i);
		
		System.out.println(max);
		
//		for(int i=0; i<list.size(); i++) System.out.print(list.get(i)+" ");
//		System.out.println();
		
		max = 0;
		check = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(check[i][j]==false) { //아직 방문안한경우
					check[i][j]=true;
					for(int k=0; k<4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(ny<0 || ny>=n || nx<0 || nx>=m ) continue;
						check[ny][nx]=true;
						if(division[ny][nx]!=division[i][j]) { //두 구역이 다를경우
							int tmp = list.get(division[ny][nx]-1) + list.get(division[i][j]-1);
							if(tmp>max) max=tmp;
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
