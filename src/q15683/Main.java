package q15683;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Cctv {
	int y, x, num;
	Cctv (int y, int x, int num) {
		this.y=y;
		this.x=x;
		this.num=num;
	}
}

public class Main {  //풀이시간 48분
	static int[][] map;
	static int[][] tMap;
	static ArrayList<Cctv> list = new ArrayList<>();
	static int[] dy = {0, 1, 0, -1}; //동 남 서 북
	static int[] dx = {1, 0, -1, 0};
	static int ans = Integer.MAX_VALUE;
	
	static void go(int y, int x, int dir, int num) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if(0<=ny && ny<tMap.length && 0<=nx && nx<tMap[0].length) {
			if(tMap[ny][nx]==0) { //빈칸인경우
				tMap[ny][nx]=num;
				go(ny, nx, dir, num);
			} else if(map[ny][nx]!=6) { //감시카메라의 시야이면서 벽이 아닌경우
				go(ny, nx, dir, num);
			}
		}
		return;
	}
	
	static void backGo(int y, int x, int dir, int num) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if(0<=ny && ny<tMap.length && 0<=nx && nx<tMap[0].length) {
			if(tMap[ny][nx]==num) { //시야인경우
				tMap[ny][nx]=0;
				backGo(ny, nx, dir, num);
			} else if(map[ny][nx]!=6) { //감시카메라의 시야이면서 벽이 아닌경우
				backGo(ny, nx, dir, num);
			}
		}
		return;
	}
	
	static void show() {
		for(int i=0; i<tMap.length; i++) {
			for(int j=0; j<tMap[0].length; j++) {
				System.out.print(tMap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void check(int n) { //0동 1남 2서 3북
		if(n==list.size()) {
			int count=0;
			for(int i=0; i<tMap.length; i++) {
				for(int j=0; j<tMap[0].length; j++) {
					if(tMap[i][j]==0) count++;
				}
			}
			if(ans>count) ans = count;
			
			System.out.println(count);
			show();
//			if(count==10) System.exit(0);
			return;
		}
		Cctv tmp = list.get(n);
		switch(tmp.num) {
		case 1:
			for(int i=0; i<4; i++) {
//				if(n==0) for(int j=0; j<map.length; j++) tMap[j]=Arrays.copyOf(map[j], map[j].length);
				go(tmp.y, tmp.x, i, tmp.num);
				check(n+1);
				backGo(tmp.y, tmp.x, i, tmp.num);
			}
			break;
		case 2:
			for(int i=0; i<2; i++) {
//				if(n==0) for(int j=0; j<map.length; j++) tMap[j]=Arrays.copyOf(map[j], map[j].length);
				go(tmp.y, tmp.x, i, tmp.num);
				go(tmp.y, tmp.x, i+2, tmp.num);
				check(n+1);
				backGo(tmp.y, tmp.x, i, tmp.num);
				backGo(tmp.y, tmp.x, i+2, tmp.num);
			}
			break;
		case 3:
			for(int i=0; i<4; i++) {
//				if(n==0) for(int j=0; j<map.length; j++) tMap[j]=Arrays.copyOf(map[j], map[j].length);
				go(tmp.y, tmp.x, i, tmp.num);
				go(tmp.y, tmp.x, (i+3)%4, tmp.num);
				check(n+1);
				backGo(tmp.y, tmp.x, i, tmp.num);
				backGo(tmp.y, tmp.x, (i+3)%4, tmp.num);
			}
			break;
		case 4:
			for(int i=0; i<4; i++) {
//				if(n==0) for(int j=0; j<map.length; j++) tMap[j]=Arrays.copyOf(map[j], map[j].length);
				go(tmp.y, tmp.x, i, tmp.num);
				go(tmp.y, tmp.x, (i+3)%4, tmp.num);
				go(tmp.y, tmp.x, (i+2)%4, tmp.num);
				check(n+1);
				backGo(tmp.y, tmp.x, i, tmp.num);
				backGo(tmp.y, tmp.x, (i+3)%4, tmp.num);
				backGo(tmp.y, tmp.x, (i+2)%4, tmp.num);
			}
			break;
		case 5:
//			if(n==0) for(int j=0; j<map.length; j++) tMap[j]=Arrays.copyOf(map[j], map[j].length);
			for(int i=0; i<4; i++) go(tmp.y, tmp.x, i, tmp.num);
			check(n+1);
			for(int i=0; i<4; i++) backGo(tmp.y, tmp.x, i, tmp.num);
			break;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n][m];
		tMap = new int[n][m];
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++) {
				tMap[i][j] = map[i][j]=sc.nextInt();
				if(map[i][j]!=0 && map[i][j]!=6) list.add(new Cctv(i, j, map[i][j]));
			}
		check(0);
		System.out.println(ans);
	}
}
