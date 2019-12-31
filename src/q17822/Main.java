package q17822;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Disk[] disks;
	static Move[] moves;
	static boolean[][] check;
	
	static class Disk {
		int[] nums;
		Disk(int n) {
			nums = new int[n];
		}
	}
	
	static class Move {
		int x, d, k;
		Move(int x, int d, int k) {
			this.x = x;
			this.d = d;
			this.k = k;
		}
	}
	
	static void showDisk() {
		for(int i=1; i<disks.length; i++) {
			for(int j=0; j<disks[1].nums.length; j++) {
				System.out.print(disks[i].nums[j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void showMove() {
		for(int i=0; i<moves.length; i++) {
			System.out.println(moves[i].x + " " + moves[i].d + " " + moves[i].k);
		}
	}
	
	static void showCheck() {
		for(int i=0; i<check.length; i++) {
			for(int j=0; j<check[0].length; j++) {
				System.out.print(check[i][j] + " " );
			}
			System.out.println();
		}
	}
	
	static void changeNum(Disk disk, int dir) {
		if(dir==0) { //�ð����
			int tmp = disk.nums[disk.nums.length-1];
			for (int i=disk.nums.length-1; i>0; i--) {
				disk.nums[i]=disk.nums[i-1];
			}
			disk.nums[0]=tmp;
		} else { //�ݽð����
			int tmp = disk.nums[0];
			for (int i=0; i<disk.nums.length-1; i++) {
				disk.nums[i]=disk.nums[i+1];
			}
			disk.nums[disk.nums.length-1]=tmp;
		}
	}
	
	static void delete() {
		check = new boolean[disks.length][disks[1].nums.length];
		boolean mark = false;
		
		for(int i=1; i<disks.length; i++) { //��ũ�� �ߺ� üũ
			for(int p=0; p<disks[1].nums.length-1; p++) {
				if(disks[i].nums[p]==-1) continue; //������ ����  ����
				else if(disks[i].nums[p]==disks[i].nums[p+1]) {
					check[i][p]=check[i][p+1]=true;
					mark=true;
				}
			}
			if (disks[i].nums[disks[i].nums.length-1]!=-1 //������ ���ڰ� �ƴϸ鼭 
					&& disks[i].nums[0]==disks[i].nums[disks[i].nums.length-1]) { //���ڰ� �ߺ��ɰ��
				check[i][0]=check[i][disks[i].nums.length-1]=true;
				mark=true;
			}
		}
		
		for (int i=1; i<disks.length-1; i++) { //��ũ�� �ߺ� üũ
			for(int p=0; p<disks[1].nums.length; p++) {
				if(disks[i].nums[p]==-1) continue; //���������̸� 
				else if(disks[i].nums[p]==disks[i+1].nums[p]) {
					check[i][p]=check[i+1][p]=true;
					mark=true;
				}
			}
		}
//		showCheck();
//		showDisk();
//		System.out.println();
		
		if (mark) { //�ߺ��Ȱ� �ִ°��
			for (int i=1; i<disks.length; i++) {
				for (int j=0; j<disks[1].nums.length; j++) {
					if(check[i][j]==true) disks[i].nums[j]=-1;
				}
			}
		} else { //�ߺ��Ȱ� ���°��
			int sum = 0;
			int count = 0;
			for(int i=1; i<disks.length; i++) {
				for (int j=0; j<disks[1].nums.length; j++) {
					if(disks[i].nums[j]!=-1) {
						sum += disks[i].nums[j];
						count++;
					}
				}
			}
			float average =  (float) sum / count;
			for (int i=1; i<disks.length; i++) {
				for (int j=0; j<disks[1].nums.length; j++) {
					if(disks[i].nums[j]!=-1) { //������ ���� �ƴҰ��
						if(disks[i].nums[j]>average) disks[i].nums[j]--;
						else if(disks[i].nums[j]<average) disks[i].nums[j]++;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q17822/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		disks = new Disk[N+1];
		moves = new Move[T];
		
		for (int i=1; i<N+1; i++) {
			disks[i] = new Disk(M);
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				disks[i].nums[j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			moves[i] = new Move(Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()));
		}
		
//		showDisk();
		
		for(int i=0; i<T; i++) {
			int num = moves[i].x;
			int dir = moves[i].d;
			int count = moves[i].k;
			for (int j=num; j<disks.length; j+=num) {
				for(int p=0; p<count; p++) {
					changeNum(disks[j], dir);
				}
			}
			delete();
		}
		int ans = 0;
		for(int i=1; i<disks.length; i++) {
			for(int j=0; j<disks[1].nums.length; j++) {
				if(disks[i].nums[j]!=-1)
				ans += disks[i].nums[j];
			}
		}
		System.out.println(ans);
	}
}
