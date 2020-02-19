package q2916_ans;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //n각도의 갯수
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		boolean[] d = new boolean[360];
		d[0]=true;
		for(int i=0; i<n; i++) {
			for (int k=0; k<360; k++) {
				for (int j=0; j<360; j++) { //j는 각도
					if(d[j]==false) continue;
					d[(j-a[i]+360)%360]=true;
					d[(j+a[i])%360]=true;
				}
			}
		}
		while(m-- > 0) {
			int x = sc.nextInt();
			System.out.println(d[x] ? "YES" : "NO");
		}
	}
}
