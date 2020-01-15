package q3190;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main { //Ǯ�̽ð� 66��
	static int[][] map;
	static int dir=0; //ó���� ������ ����
	static int[] dy = {0, 0, 1, -1}; //0�� 1�� 2�� 3��
	static int[] dx = {1, -1, 0, 0}; //L: �� �� �� �� //R: �� �� �� ��
	static int[][] change = {{3, 2, 0, 1}, //0���� L
							 {2, 3, 1, 0}};//1���� R
	static Deque<Pair> snake = new ArrayDeque<>();
			
	static class Pair {
		int y, x;
		Pair(int y, int x) {
			this.y=y; this.x=x;
		}
	}
	
	static void show() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean move(int d) {//L���� D������
//		show();
		Pair pair = snake.removeFirst();
		map[pair.y][pair.x]=0;
		int ny = pair.y + dy[d];
		int nx = pair.x + dx[d];
//		System.out.println(ny + " "+ nx);
		if(ny<0 || ny==map.length || nx<0 || nx==map[0].length) return false; //���� �ε��� �״°�� 
		else if(map[ny][nx]==1) return false; //���� �ε��� �״°��
		else if(map[ny][nx]==3) { //�̵���ĭ�� ����� �ִ°��
			snake.addFirst(new Pair(pair.y, pair.x));
			snake.addFirst(new Pair(ny, nx));
			map[pair.y][pair.x]=1;
			map[ny][nx]=1;
		} else { //�̵���ĭ�� ��ĭ�ΰ��
			snake.addFirst(new Pair(pair.y, pair.x));
			snake.addFirst(new Pair(ny, nx));
			Pair tmp = snake.removeLast();
			map[pair.y][pair.x]=1;
			map[ny][nx]=1;
			map[tmp.y][tmp.x]=0;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q3190/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		map = new int[n][n];
		snake.addFirst(new Pair(0, 0));
		map[0][0]=1;
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;//��
			int x = Integer.parseInt(st.nextToken())-1;//��
			map[y][x]=3; //����� 3���� ǥ��
		}
		
		int l = Integer.parseInt(br.readLine());
		int count=0;
		int preTime=0;
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine()); //L���� D������
			int inputTime = Integer.parseInt(st.nextToken());
			int time = inputTime-preTime;
			preTime = inputTime;
			char d = st.nextToken().charAt(0);
			while(time-->0) {//�־����ð����� �ϴ� ������
				count++;
				if(!move(dir)) {
					System.out.println(count);
					return; //������ ���α׷� ����
				}
			}
			if(d=='L') dir = change[0][dir];
			else dir = change[1][dir];
		}
		while(true) {
			count++;
			if(!move(dir)) {
				System.out.println(count);
				return; //������ ���α׷� ����
			}
		}
	}
}
