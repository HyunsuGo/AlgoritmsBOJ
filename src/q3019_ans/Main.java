package q3019_ans;

import java.util.Scanner;

public class Main {
	static int[] a;
	static int n, m;
	
	static int calc(int i, String s) {
		if(i+s.length()>n) return 0;
		int base = a[i] - (s.charAt(0)-'0'); //base에는 i번째열의 높이 - s의 높이
//		System.out.println("a["+i+"] : " + a[i] + "\ts.charAt(0) : " + s.charAt(0) + " \tbase : " +base);
		for (int j=0; j<s.length(); j++) {
//			System.out.println("inner\ta["+(i+j)+"] : " + a[i+j] + "\ts.charAt("+j+") : " + s.charAt(j));
			if(base != a[i+j] - (s.charAt(j)-'0')) {
//				System.out.println();
				return 0;
			}
		}
//		System.out.println("+1\n");
		return 1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt(); //a[i]에는 i번째 열의 높이가 저장되어 있음
		}
		int ans = 0;
		for (int i=0; i<n; i++) {
			if(m==1) {
				ans +=calc(i, "0") + calc(i, "0000");
			} else if (m==2) {
				ans += calc(i, "00");
			} else if (m==3) {
				ans += calc(i, "001") + calc(i, "10");
			} else if (m==4) {
				ans += calc(i, "100") + calc(i, "01");
			} else if (m==5) {
				ans += calc(i, "000") + calc(i, "01") + calc(i, "101") + calc(i, "10");
			} else if (m==6) {
				ans += calc(i, "000") + calc(i, "00") + calc(i, "011") + calc(i, "20");
			} else if (m==7) {
				ans += calc(i, "000") + calc(i, "00") + calc(i, "110") + calc(i, "02");
			}
		}
		System.out.println(ans);
	}
}
