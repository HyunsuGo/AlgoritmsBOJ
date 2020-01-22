package q15661;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //«Æ¿ÃΩ√∞£ 54∫–
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q15661/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[] team = new int[n];
		int ans = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<((1<<n)-1)/2+1; i++) {
			int tmp = i;
			for(int j=0; j<n; j++) {
				team[j]=tmp&1; //0∞˙ 1∑Œ ∆¿ ≥™¥Æ
				tmp>>=1;
			}
//			for(int j=0; j<n; j++) System.out.print(team[j]+" ");
//			System.out.println();
			int a=0, b=0;
			for(int p=0; p<n; p++) {
				for(int q=0; q<n; q++) {
					if(team[p]==1 && team[p]==team[q]) a = a + map[p][q];
					else if(team[p]==0 && team[p]==team[q]) b = b + map[p][q];
					
				}
//				System.out.println("a : " + a + "   b : " + b);
			}
			ans = Math.min(ans, Math.abs(b-a));
		}
		System.out.println(ans);
	}
}
