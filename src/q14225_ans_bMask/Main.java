package q14225_ans_bMask;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] c = new boolean[20*100000+10];
		int[] a = new int[20];
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		for (int i=0; i<(1<<n); i++) { //i : 000 001 010 011 100 101 110 111 (n:3)
			int sum=0;
			for (int j=0; j<n; j++) { // j : 0 1 2 -> 000 001 010
//				System.out.println("i : " + i + "\t j : " + j);
				if((i&(1<<j))!=0) { //(1<<j) : 001 010 100
//					System.out.println("if(("+i+"&(1<<"+j+"))!=0 : " + (i&(1<<j)));
					sum+=a[j];
				}
			}
			c[sum]=true;
		}
		for(int i=1;;i++) {
			if(c[i]==false) {
				System.out.println(i);
				break;
			}
		}
	}
}
