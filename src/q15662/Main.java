package q15662;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //풀이시간 31분
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q15662/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] gears = new int[n][8];
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<8; j++) {
				gears[i][j]=tmp.charAt(j)-'0';
			}
		}
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			int[] moves = new int[n];
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			moves[num]=dir;
			
			for (int j=num; j>0; j--) //왼쪽으로
				if(gears[j][6]!=gears[j-1][2]) moves[j-1]=moves[j]*(-1);
				else break;
			for (int j=num; j<n-1; j++) //오른쪽으로
				if(gears[j][2]!=gears[j+1][6]) moves[j+1]=moves[j]*(-1);
				else break;
			
			for(int j=0; j<n; j++) {
				if(moves[j]==1) { //시계방향
					int tmp = gears[j][7];
					for(int x=7; x>0; x--) gears[j][x]=gears[j][x-1];
					gears[j][0]=tmp;
				} else if(moves[j]==-1) { //반시계방향
					int tmp = gears[j][0];
					for(int x=0; x<7; x++) gears[j][x]=gears[j][x+1];
					gears[j][7]=tmp;
				}
			}
		}
		int ans=0;
		for(int i=0; i<n; i++) if(gears[i][0]==1) ans++;
		System.out.println(ans);
	}
}
