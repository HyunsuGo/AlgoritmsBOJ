package q15684;

import java.util.Scanner;

public class Main {
	static int[][] map;
	
	static void show() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean go(int index) {
		int c=index;
		for(int r=0; r<map.length; r++)
			if(map[r][c]==1)
				if(c-1>=0 && map[r][c-1]==1) c--; //좌측으로 이동하는  경우
				else if (c+1<map[0].length && map[r][c+1]==1) c++; //우측으로 이동하는 경우
		if (c==index) return true; //같은곳으로 돌아오면 true 리턴
		else return false;
	}
	
	static int make(int i, int j, int count) {
		if(map[i][j]==1) {
			j++;
			if(j==map.length) {
				i++; j=0;
			}
			make(i, j, count);
		} else if(j+1<map[0].length && map[i][j+1]==0) {
			map[i][j]=1; map[i][j+1]=1;
			j+=2;
			if(j==map.length) {
				i++; j=0;
			}
			make(i, j, count+1);
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //세로선 n
		int m = sc.nextInt(); //주어진 가로선 m
		int h = sc.nextInt(); //가로선을 놓을수 있는 위치의 개수 h
		map = new int[h][n];
		for(int i=0; i<m; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			map[a][b]=map[a][b+1]=1;
		}
		
		for(int i=0; i<h; i++) {
			for (int j=0; j<n; j++) {
				make(i, j);
			}
		}
		
		show();
	}
}