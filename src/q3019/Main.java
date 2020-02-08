package q3019;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Pair {
	int y, x;
	Pair (int y, int x) {
		this.y=y; this.x=x;
	}
}

public class Main { // 118min
	static int[][] map;
	static Pair[] loc;
	static int ans=0;
	static int[][][][] blocks = {
			{ 	//1����
				{{-1, 0}, {-2, 0}, {-3, 0} }, 
				{{0, 1}, {0, 2}, {0, 3} }
			},	
			{	//2����
				{{0,1}, {-1, 0}, {-1, 1}}
			},
			{	//3����
				{{0,1}, {-1,1}, {-1,2}},
				{{-1,0}, {-1, -1}, {-2, -1}}
			},
			{	//4����
				{{0,1}, {1, 1}, {1, 2}},
				{{-1,0}, {-1,1}, {-2,1}}
			},
			{ 	//5����
				{{0, 1}, {0, 2}, {-1, 1}},
				{{-1, 0}, {-2, 0}, {-1, 1}},
				{{0, 1}, {0, 2}, {1, 1}},
				{{-1, 0}, {-2, 0}, {-1, -1}}
			},
			{	//6����
				{{0,1}, {0,2}, {-1,2}},
				{{0,1}, {-1,0}, {-2,0}},
				{{-1,0}, {-1, 1}, {-1,2}},
				{{-1,0}, {-2, 0}, {-2, -1}}
			},
			{	//7����
				{{-1,0}, {0,1}, {0,2}}, //���
				{{-1,0}, {-2,0}, {-2,1}}, //���
				{{-1,0}, {-1,-1}, {-1,-2}},
				{{0,1}, {-1,1}, {-2,1}}
			}
			
	};
	
	static void show(int[][] cMap) {
		for(int i=0; i<cMap.length; i++) {
			for(int j=0; j<cMap[0].length; j++) {
				System.out.print(cMap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean check(int[][] tMap, int col) { //col���� ��ĭ���� ������Ű���� Ȯ���ϴ� �޼ҵ�
		boolean flag;
		if(tMap[tMap.length-1][col]==0) flag=false; //�����Ҷ� ��ĭ�̸� false
		else flag=true; //�����Ҷ� ĭ�� �������� true
		
		for(int i=tMap.length-2; i>=0; i--) {
			if(flag==false) { //������ ��ĭ�̿��µ�
				if(tMap[i][col]==1) return false; //����ĭ�� ĭ�� �������� false ����
			} else { //������ ĭ�� ���־��µ�
				if(tMap[i][col]==0) flag=false; //��ĭ������ flag�� false�� �ٲ���
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q3019/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		Scanner sc = new Scanner(fis);
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int p = sc.nextInt()-1;
		map = new int[104][c];
		loc = new Pair[c];
		for(int i=0; i<c; i++) {
			int tmp = sc.nextInt();
			loc[i] = new Pair(map.length-1-tmp, i);
			for(int j=map.length-1; j>map.length-1-tmp; j--) {
				map[j][i]=1;
			}
		}
//		System.out.println("����ó����");
//		show(map);
		int count=0;
		for(int i=0; i<loc.length; i++) {
			int y=loc[i].y; 
			int x=loc[i].x;
Outter:		for(int j=0; j<blocks[p].length; j++) {//p������ ���°�����
				int[][] tMap = new int[map.length][map[0].length];
				count++;
				for(int l=0; l<tMap.length; l++) tMap[l]=Arrays.copyOf(map[l], map[l].length);
				tMap[y][x]=1;
				for(int k=0; k<blocks[p][j].length; k++) {
					int dy = blocks[p][j][k][0];
					int dx = blocks[p][j][k][1];
					int ny = y + dy; int nx = x + dx;
					if(ny<0 || ny>map.length-1 || nx<0 || nx>map[0].length-1 || map[ny][nx]==1) continue Outter; //���� ����� ������
					tMap[ny][nx]=1;
//					System.out.println("dy:" + dy+"\tdx: "+dx + "\tp : " + p + "\tj : " + j + "\tk : " + k);
				}
				for(int col=0; col<map[0].length; col++) {
					if(!check(tMap, col)) break;
//					System.out.println("col : " + col);
					if(col==map[0].length-1) ans++;
				}
//				System.out.println("ans : " + ans);
//				show(tMap);
			}
			
		}
//		System.out.println(count);
		System.out.println(ans);
//		for (int i=0; i<loc.length; i++) {
//			System.out.println(loc[i].y+" "+loc[i].x);
//		}
//		show();
//		for(int i=0; i<c; i++) {
//			System.out.print(check(i)+" ");
//		}
	}
}

