package q16198;

import java.util.ArrayList;
import java.util.Scanner;

public class Main { // 17min
	static int ans = Integer.MIN_VALUE;
	
	static void go(ArrayList<Integer> list, int sum) {
		if(list.size()<3) {
			if(sum>ans) ans = sum;
		}
		for(int i=1; i<list.size()-1; i++) {
			sum += list.get(i-1)*list.get(i+1);
			int tmp = list.get(i);
			list.remove(i);
			go(list, sum);
			list.add(i, tmp);
			sum -= list.get(i-1)*list.get(i+1);
		}
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			list.add(sc.nextInt());
		}
		go(list, 0);
		System.out.println(ans);
	}
}
