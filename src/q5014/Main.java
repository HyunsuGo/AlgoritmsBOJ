package q5014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //23min
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[] floor = new int[f+1];
		for(int i=0; i<floor.length; i++) floor[i]=-1;
		
		Queue<Integer> q = new LinkedList<>();
		floor[s]=0;
		q.add(s);
		while(!q.isEmpty()) {
			int tmp = q.remove();
			int up = tmp + u;
			int down = tmp - d;
			if(up<=f && floor[up]==-1) {
				floor[up]=floor[tmp]+1;
				q.add(up);
			}
			if(down>=1 && floor[down]==-1) {
				floor[down]=floor[tmp]+1;
				q.add(down);
			}
		}
		if(floor[g]==-1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(floor[g]);
		}
		
	}
}

