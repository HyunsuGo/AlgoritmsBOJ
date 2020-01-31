package q15686;

import java.util.ArrayList;
import java.util.Scanner;

class Pair {
	int y, x;
	Pair(int y, int x) {
		this.y=y; this.x=x;
	}
}

public class Main { //풀이시간 73분
	static int[][] map;
	static int m;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<Pair> shop = new ArrayList<>(); //치킨집
	static ArrayList<Pair> house = new ArrayList<>(); //그냥집
	static ArrayList<Pair> select = new ArrayList<>(); //고른치킨집
	
	static int calcul(Pair a, Pair b) { //선택된 치킨집중 최소값을 구함
		int dist = Integer.MAX_VALUE;
		for(int i=0; i<select.size(); i++) {
			int tmp = Math.abs(a.y-b.y)+Math.abs(a.x-b.x);
			if(tmp<dist) dist=tmp;
		}
		return dist;
	}
	
	static void chooseShop(int s, int e, int accum) {
		if(accum==m) { //남겨야할 치킨집의 갯수가 되면
			int totalDist=0;
			for(int i=0; i<house.size(); i++) { //모든집에 대해 구함
				int dist = Integer.MAX_VALUE;
				Pair a = house.get(i);
				for(int j=0; j<select.size(); j++) { //선택된집에 대해 모든 치킨집에 대해 거리 계산
					Pair b = select.get(j);
					int tmp = calcul(a, b);
					if(tmp<dist) dist=tmp; //최소가 되는 거리를 저장
				}
				totalDist+=dist;
			}
			if(ans>totalDist) ans=totalDist;
			return;
		}
		for(int i=s; i<e; i++) {
			select.add(shop.get(i));
			chooseShop(i+1, e+1, accum+1);
			select.remove(select.size()-1);
		}
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //맵의크기
		m = sc.nextInt(); //남겨야 할 치킨집의 갯수
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1) house.add(new Pair(i, j));
				else if(map[i][j]==2) shop.add(new Pair(i, j));
			}
		}
		
		for(int i=0; i<shop.size()-m+1; i++) {
			select.add(shop.get(i));
			chooseShop(i+1, shop.size()-m+2, 1);
			select.remove(select.size()-1);
		}
		System.out.println(ans);
		
	}
}
