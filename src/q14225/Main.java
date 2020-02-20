package q14225;

import java.util.Scanner;

public class Main {	//41min
	static boolean[] number = new boolean[2000001];
	
	static void go(int max ,int count, int index, int[] nums, boolean[] check) {
		if(max==count) {
			int sum=0;
			for(int i=0; i<check.length; i++) {
				if(check[i]) {
					sum+=nums[i];
				}
			}
			number[sum]=true;
		}
		if(index==nums.length) return;
		check[index]=true;
		go(max, count+1, index+1, nums, check);
		check[index]=false;
		go(max, count, index+1, nums, check);
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		number[0]=true;
		int[] nums = new int[n];
		boolean[] check = new boolean[n];
		for(int i=0; i<n; i++) {
			nums[i]=sc.nextInt();
		}
		for(int i=1; i<=n; i++) {
			go(i, 0, 0, nums, check);
		}
		for(int i=1; i<2000001; i++) {
			if(!number[i]) {
				System.out.println(i);
				break;
			}
		}
	}
}
