package q15486;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n];
		int[] p = new int[n];
		int[] d =  new int[n+50];
		
		for(int i=0; i<n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			d[i+t[i]] = Math.max(d[i+t[i]], d[i]+p[i]);
			d[i+1] = Math.max(d[i+1], d[i]);
		}
		
		System.out.println(d[n]);
		
	}
}
