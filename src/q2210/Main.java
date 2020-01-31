package q2210;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {// 34min
	static int[][] map;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	static HashSet<Integer> hashSet = new HashSet<>();
	
	static void go(int[] num, int y, int x, int count) {
		if(count==6) {
			String tmp = "";
			for(int i=0; i<num.length; i++) tmp+=String.valueOf(num[i]);
			hashSet.add(Integer.parseInt(tmp));
			return;
		}
		for(int i=0; i<4; i++) {
			num[count]=map[y][x];
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(0<=ny && ny<map.length && 0<=nx && nx<map[0].length) {
				go(num, ny, nx, count+1);
			}
		}
		return;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5];
		for(int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				int[] num = new int[6];
				go(num, i, j, 0);
			}
		}
		Iterator<Integer> tmp = hashSet.iterator();
		while(tmp.hasNext()) {
			int a=tmp.next();
//			System.out.println(a);
			
		}
		System.out.println(hashSet.size());
	}
}
