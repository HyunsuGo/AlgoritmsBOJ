package q3184;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair {
	int y, x;
	Pair(int y, int x) {
		this.y=y; this.x=x;
	}
}

public class Main { //49min
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	static char[][] map;
	static char count='1';
	
	static void divide(int y, int x) {
		map[y][x]=count;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || ny==map.length || nx<0 || nx==map[0].length) continue; //맵을 벗어난경우
			if(map[ny][nx]!='.') continue; //맵에 이미 표시되어있는경우
			divide(ny, nx);
		}
	}
	
	static void show(char[][] tmp) {
		for(int i=0; i<tmp.length; i++) {
			for(int j=0; j<tmp[0].length; j++) {
				System.out.print(tmp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q3184/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		ArrayList<Pair> wolfs = new ArrayList<>();
		ArrayList<Pair> sheeps = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j]=tmp.charAt(j);
				if(map[i][j]=='v') {
					wolfs.add(new Pair(i, j));
					map[i][j]='.';
				} else if(map[i][j]=='o') {
					sheeps.add(new Pair(i, j));
					map[i][j]='.';
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]=='.') {
					divide(i, j);
					count++;
				}
			}
		}
		int num = count-'0'-1;
		
		for(int i=0; i<num; i++) {
			int wolfN=0, sheepN=0;
			for(int p=0; p<n; p++) {
				for(int q=0; q<m; q++) {
					if(map[p][q]=='1'+i) { //영역별로 양의갯수 늑대의 갯수 파악함
						for(int k=0; k<wolfs.size(); k++) { //해당영역안에 있는 늑대의 갯수
							Pair wolf=wolfs.get(k);
							if(wolf.y==p&&wolf.x==q) wolfN++; 
						}
						for(int k=0; k<sheeps.size(); k++) { //해당영역안에 있는 양의 갯수
							Pair sheep=sheeps.get(k);
							if(sheep.y==p&&sheep.x==q) sheepN++; 
						}
					}
				}
			}
			if(sheepN>wolfN) { //양이 더 많은경
				for(int p=0; p<n; p++) {
					for(int q=0; q<m; q++) {
						if(map[p][q]=='1'+i) { //해당영역안에 있는 늑대 다 죽임
							for(int k=wolfs.size()-1; k>=0; k--) {
								Pair wolf = wolfs.get(k);
								if(wolf.y==p&&wolf.x==q) wolfs.remove(k);
							}
						}
					}
				}
			} else {
				for(int p=0; p<n; p++) {
					for(int q=0; q<m; q++) {
						if(map[p][q]=='1'+i) { //해당영역안에 있는 양 다 죽임
							for(int k=sheeps.size()-1; k>=0; k--) {
								Pair sheep = sheeps.get(k);
								if(sheep.y==p&&sheep.x==q) sheeps.remove(k);
							}
						}
					}
				}
			}
		}
		
//		show(map);
		System.out.println(sheeps.size()+" "+wolfs.size());
	}
}

