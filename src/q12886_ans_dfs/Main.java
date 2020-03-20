package q12886_ans_dfs;

import java.util.Scanner;

public class Main {
	static int sum=0;
	static boolean[][] check = new boolean[1501][1501];
	static int count=0;
	
	static void go(int x, int y) {
		if(check[x][y]) return;
		check[x][y]=true;
		int[] a = {x, y, sum-x-y};
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				count++;
				if(a[i]<a[j]) {
					int[] b = {x, y, sum-x-y};
					b[i]+=a[i];
					b[j]-=a[i];
//					System.out.println(b[0]+" " + b[1] + " " + (sum-b[0]-b[1]));
					go(b[0], b[1]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		sum = x+y+z;
		
		if(sum%3!=0) { //3으로 나누어 떨어지지 않으면 무조건 불가능
			System.out.println(0);
			System.exit(0);
		}
		go(x, y);
//		System.out.println(count);
//		for(int i=0; i<=30; i++) {
//			for(int j=0; j<=30; j++) {
//				System.out.println("check["+i+"]["+j+"] : " + check[i][j]);
//			}
//		}
		if(check[sum/3][sum/3]) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
