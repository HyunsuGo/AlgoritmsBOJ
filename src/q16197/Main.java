package q16197;

import java.util.Scanner;

public class Main {
	static char[][] map;
	static int n, m, ans=-1;
	static int[] dy = {-1, 0, 1, 0}; //�� �� �� ��
	static int[] dx = {0, 1, 0, -1};
	
	static void show(char[][] tMap) {
		for(int i=0; i<tMap.length; i++) {
			for(int j=0; j<tMap[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void go(int count, int y1, int x1, int y2, int x2, boolean b1, boolean b2) {
		
		if((b1 && b2) || count==11) { //�Ѵٶ������ų� 11���� �ɰ��
//			System.out.println("�ΰ��� ������ ���");
			return;
		} else if(b1) { //ù��° ���� ��������
			if(ans==-1 || count<ans ) ans=count;
//			System.out.println("b1������� : " + count + "    ans : " + ans);
//			System.out.println("y1 : " + y1 + "  x1 : " + x1 + "    y2 : " + y2 + "  x2 : " + x2 
//					+ "    b1  : " + b1 + "  b2 : " + b2 + "\n");
			return;
		} else if(b2) { //�ι�° ���� ��������
			if(ans==-1 || count<ans ) ans=count;
//			System.out.println("b2������� : " + count + "    ans : " + ans);
//			System.out.println("y1 : " + y1 + "  x1 : " + x1 + "    y2 : " + y2 + "  x2 : " + x2 
//					+ "    b1  : " + b1 + "  b2 : " + b2 + "\n");
			return;
		}
		for(int i=0; i<4; i++) {
			b1=false; b2=false;
//			System.out.println("y1 : " + y1 + "  x1 : " + x1 + "    y2 : " + y2 + "  x2 : " + x2 
//					+ "    b1  : " + b1 + "  b2 : " + b2);
			int ny1 = y1 + dy[i];
			int nx1 = x1 + dx[i];
			int ny2 = y2 + dy[i];
			int nx2 = x2 + dx[i];
			if( ny1<0 || ny1>=n || nx1<0 || nx1>=m) { //ù��° ���� ������
				b1=true;
			}
			if( ny2<0 || ny2>=n || nx2<0 || nx2>=m ) { //�ι�° ���� ������
				b2=true;
			}
			
			if(!b1 && map[ny1][nx1]=='#') { //���� �ȳ����� ���ϰ��
				ny1=y1; nx1=x1;//���� �ȿ�����
			} else if(!b1 && map[ny1][nx1]=='.') { //���� �ȳ����� ��ĭ�ϰ��
//				y1=ny1; x1=nx1; //�� ������
			}
			
			if(!b2 && map[ny2][nx2]=='#') { //���� �ȳ����� ���ϰ��
				ny2=y2; nx2=x2;//���� �ȿ�����
			} else if(!b2 && map[ny2][nx2]=='.') { //���� �ȳ����� ��ĭ�ϰ��
//				y2=ny2; x2=nx2; //�� ������
			}
//			System.out.println("ny1 : " + ny1 + "  nx1 : " + nx1 + "  ny2 : " + ny2 + "  nx2 : " + nx2
//					+ "    b1 : " + b1 + "  b2 : " + b2);
			go(count+1, ny1, nx1, ny2, nx2, b1, b2);
		}
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y1=-1, x1=-1, y2=-1, x2=-1;
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			String tmp = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j]=tmp.charAt(j);
				if(map[i][j]=='o') {
					if(y1==-1) {
						y1=i; x1=j;
					} else {
						y2=i; x2=j;
					}
					map[i][j]='.';
				}
			}
		}
		go(0, y1, x1, y2, x2, false, false);
		System.out.println(ans);
	}
}
