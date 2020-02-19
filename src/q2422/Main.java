package q2422;

import java.util.Scanner;

class Pair { //풀이시간 23분 but 시간초과
	int a, b;
	Pair (int a, int b) {
		this.a=a; this.b=b;
	}
}

public class Main {
	static int ans=0;
	
	static void go(boolean[] icecreams, Pair[] list, int index, int count) {
		if(count==3) {
			for(int i=0; i<list.length; i++) {
				int a = list[i].a-1;
				int b = list[i].b-1;
				if(icecreams[a]==true && icecreams[b]==true) return;	
			}
			ans++;
			return;
		} else if(index==icecreams.length) return;
		icecreams[index]=true;
		go(icecreams, list, index+1, count+1);
		icecreams[index]=false;
		go(icecreams, list, index+1, count);
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] icecreams = new boolean[n];
		Pair[] list = new Pair[m];
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[i] = new Pair(a, b);
		}
		go(icecreams, list, 0, 0);
		System.out.println(ans);
	}
}
