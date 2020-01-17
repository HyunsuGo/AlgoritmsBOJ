package q2933;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //풀이시간 120분
	static char[][] map;
	static int[][] check;
	
	static int[] dy = {0, 0, 1, -1}; //0동 1서 2남 3북
	static int[] dx = {1, -1, 0, 0};
	
	static void show() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
//		System.out.println();
	}
	
	static void showCheck() {
		for(int i=0; i<check.length; i++) {
			for(int j=0; j<check[0].length; j++) {
				System.out.print(check[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void marking(int y, int x, int index) {
		check[y][x]=index;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || ny==check.length || nx<0 || nx==check[0].length) continue;
			if(check[ny][nx]==0) marking(ny, nx, index);
		}
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q2933/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for(int i=0; i<r; i++) {
			String tmp = br.readLine();
			for(int j=0; j<c; j++)
				map[i][j]=tmp.charAt(j);
		}
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int dir=1;
		for(int i=0; i<n; i++) {
			int height = map.length-Integer.parseInt(st.nextToken());
			if(dir==1) { //방향이 1이면 왼쪽부터 던짐
				for(int j=0; j<map[0].length; j++)
					if(map[height][j]=='x') {map[height][j]='.'; break;}
			} else { //방향이 -1이면 오른쪽부터 던짐
				for(int j=map[0].length-1; j>=0; j--)
					if(map[height][j]=='x') {map[height][j]='.'; break;}
			}
			dir*=(-1); //던지고나서 방향 바꿔줌
			
			check = new int[r][c]; //check에서 .표시는 -1값으로 설정해줌
			for(int p=0; p<r; p++) for(int q=0; q<c; q++) if(map[p][q]=='.') check[p][q]=-1;
			int index = 1;
			for(int p=0; p<r; p++) {
				for(int q=0; q<c; q++) {
					if(check[p][q]==0) {
						marking(p, q, index);
						index++;
					}
				}
			}
			for(int p=0; p<r; p++) for(int q=0; q<c; q++) if(check[p][q]==-1) check[p][q]=0;
Outter:		for(int k=1; k<index; k++) {
				boolean flag=false; //내리지 않음
				for(int p=0; p<r; p++) {
					for(int q=0; q<c; q++) {
						if(check[p][q]==k) {
							for(int j=0; j<4; j++) {
								int ny = p + dy[j];
								int nx = q + dx[j];
								if(ny<0 || ny>=check.length || nx<0 || nx==check[0].length) continue;
//								System.out.println("ny : " + ny + "   nx : " + nx);
								if(check[ny][nx]!=k && check[ny][nx]==0) flag=true; //true면 이동
							}
						}
					}
				}
//				System.out.println("index " + k + " : " + flag);
//				showCheck();
				if(flag) { //true면 내림
					for(int p=0; p<map[0].length; p++) if(check[r-1][p]==k) {continue Outter;} //아래쪽에 있으면 이동x
					int tmp = Integer.MAX_VALUE;
					for(int q=0; q<map[0].length; q++) { //이동할것 찾기
						int count=0;
						for(int p=map.length-1; p>=0; p--) {
							if(check[p][q]==0) count++;
							else if(check[p][q]!=k) count=0;
							if(check[p][q]==k) tmp = Math.min(tmp, count); //이동할 양 계산
						}
					}
					
					for(int p=check.length-1; p>=0; p--) {
						for(int q=0; q<check[0].length; q++) {
							if(check[p][q]==k) {
								map[p][q]='.';
								map[p+tmp][q]='x';
								check[p][q]=0;
								check[p+tmp][q]=k;
							}
						}
					}
//					System.out.println(tmp);
				}
			}
//			showCheck();
		}
		show();
	}
}

