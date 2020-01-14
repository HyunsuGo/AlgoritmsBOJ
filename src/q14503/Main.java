package q14503;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //Ǯ�̽ð� 57��
	static int[][] map;
	static int[] dirs = {3, 0, 1, 2}; //������ û�������� ����ٲٴ°�
	static int[] dy = {0, -1, 0, 1}; //0�� 1�� 2�� 3�� ���⿡�� �̵����� ����
	static int[] dx = {-1, 0, 1, 0}; //�̵������� : 0�� 1�� 2�� 3��
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q14503/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m =  Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); //0�� 1�� 2�� 3�� �ٶ󺸴� ����
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count=0;
		int ans=0;
		while (true) {
			if(map[y][x]==0) {
				map[y][x] = 3; //������ġ û��
				ans++;
			}
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (map[ny][nx] == 0) { //����ĭ�� û�ҾȵǾ����� ���
				d = dirs[d]; //����ٲٰ�
				y = ny; //��ĭ���� �̵�
				x = nx;
				count=0; //������ȯ �ʱ�ȭ
			} else { //����ĭ�� û�ҵǾ�������� �Ǵ� ���ϰ��
				count++;
				d = dirs[d]; //���� ��ȯ��
				if(count==4) { //������ȯ 4���ϸ� 
					count=0; //������ȯ �ʱ�ȭ
					y = y + dy[(d+3)%4]; //�ڷκ���(������ �״��)
					x = x + dx[(d+3)%4];
					if(map[y][x]==1) break;
				}
			} 
		}
		System.out.println(ans);
		
	}
}

