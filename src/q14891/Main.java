package q14891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //풀이시간 45분
	static int[][] gears = new int[4][8];
	static Queue<Pair> queue = new LinkedList<>();
	
	static class Pair {
		int num, dir;
		Pair (int num, int dir) {
			this.num=num;
			this.dir=dir;
		}
	}
	
	static void move(Pair pair) { //1:시계방향 	-1:반시계방향
		int num = pair.num-1;
		int dir = pair.dir;
		if(dir==1) {
			int tmp = gears[num][7];
			for(int i=7; i>0; i--) gears[num][i]=gears[num][i-1];
			gears[num][0]=tmp;
		} else {
			int tmp = gears[num][0];
			for(int i=0; i<7; i++) gears[num][i]=gears[num][i+1];
			gears[num][7]=tmp;
		}
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q14891/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<4; i++) {
			String tmp = br.readLine();
			for(int j=0; j<8; j++) { //N극은0, S극은1
				gears[i][j]=tmp.charAt(j)-'0';
			}
		}		
		
		int k =Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			queue.add(new Pair(num, dir));
			
			if(num==1) {
				if(gears[0][2]!=gears[1][6]) {
					queue.add(new Pair(2, dir*(-1)));
					if(gears[1][2]!=gears[2][6]) {
						queue.add(new Pair(3, dir));
						if(gears[2][2]!=gears[3][6]) queue.add(new Pair(4, dir*(-1)));
					}
				}
			} else if(num==2) {
				if(gears[1][6]!=gears[0][2]) queue.add(new Pair(1, dir*(-1)));
				if(gears[1][2]!=gears[2][6]) {
					queue.add(new Pair(3, dir*(-1)));
					if(gears[2][2]!=gears[3][6]) queue.add(new Pair(4, dir));
				}
			} else if(num==3) {
				if(gears[2][6]!=gears[1][2]) {
					queue.add(new Pair(2, dir*(-1)));
					if(gears[1][6]!=gears[0][2]) queue.add(new Pair(1, dir));
				}
				if(gears[2][2]!=gears[3][6]) queue.add(new Pair(4, dir*(-1)));
			} else { //num==4
				if(gears[3][6]!=gears[2][2]) {
					queue.add(new Pair(3, dir*(-1)));
					if(gears[2][6]!=gears[1][2]) {
						queue.add(new Pair(2, dir));
						if(gears[1][6]!=gears[0][2]) queue.add(new Pair(1, dir*(-1)));
					}
				}
			}
			while(!queue.isEmpty()) move(queue.remove());
		}
		
		int ans = 0;
		for(int i=0; i<4; i++) if(gears[i][0]==1) ans+=Math.pow(2, i);
		System.out.println(ans);
	}
}
