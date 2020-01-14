package q14499;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //Ǯ�̽ð� 53��
	static int[][] map;
	static int[] dice = new int[6];
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	static int x, y;
	static int[][] index = {
			{0, 1, 2, 3, 4, 5}, //�⺻
			{0, 5, 1, 2, 4, 3}, //��
			{0, 2, 3, 5, 4, 1}, //��
			{2, 1, 4, 3, 5, 0}, //��
			{5, 1, 0, 3, 2, 4} //��
	};
	
	static void move(int dir) { //�ֻ��� ������
		int tmp[] = new int[6];
		for(int i=0; i<6; i++) tmp[i]=dice[index[dir][i]];
		dice = Arrays.copyOf(tmp, 6);
		
		if (map[x][y]==0) { //�̵���ĭ 0 -> �ٴڸ龲���ִ¼��� ĭ�� ����
			map[x][y]=dice[5];
		} else { //0�� �ƴѰ�� -> ĭ�� �����ִ¼��� �ٴ����κ��� & ĭ�������ִ¼��� 0����
			dice[5]=map[x][y];
			map[x][y]=0;
		}
		System.out.println(dice[2]);
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q14499/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //����
		int m = Integer.parseInt(st.nextToken()); //����
		x = Integer.parseInt(st.nextToken()); //����
		y = Integer.parseInt(st.nextToken()); //����
		int k = Integer.parseInt(st.nextToken()); //����� ����
		
		map  = new int[n][m];
		for(int i=0; i<n; i++) { //�� �Է� (�ֻ����� �����ִ� ĭ�� ������ 0)
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()); //����Է�
		
		for (int i=0; i<k; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int nx = x + dx[dir]; int ny = y + dy[dir];
			if (nx==-1 || nx==n || ny==-1 || ny==m) continue; //������ ����� ����
			x=nx; y=ny;
			move(dir);
		}	
	}
}
