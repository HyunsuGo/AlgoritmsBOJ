package q15686;

import java.util.ArrayList;
import java.util.Scanner;

class Pair {
	int y, x;
	Pair(int y, int x) {
		this.y=y; this.x=x;
	}
}

public class Main { //Ǯ�̽ð� 73��
	static int[][] map;
	static int m;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<Pair> shop = new ArrayList<>(); //ġŲ��
	static ArrayList<Pair> house = new ArrayList<>(); //�׳���
	static ArrayList<Pair> select = new ArrayList<>(); //��ġŲ��
	
	static int calcul(Pair a, Pair b) { //���õ� ġŲ���� �ּҰ��� ����
		int dist = Integer.MAX_VALUE;
		for(int i=0; i<select.size(); i++) {
			int tmp = Math.abs(a.y-b.y)+Math.abs(a.x-b.x);
			if(tmp<dist) dist=tmp;
		}
		return dist;
	}
	
	static void chooseShop(int s, int e, int accum) {
		if(accum==m) { //���ܾ��� ġŲ���� ������ �Ǹ�
			int totalDist=0;
			for(int i=0; i<house.size(); i++) { //������� ���� ����
				int dist = Integer.MAX_VALUE;
				Pair a = house.get(i);
				for(int j=0; j<select.size(); j++) { //���õ����� ���� ��� ġŲ���� ���� �Ÿ� ���
					Pair b = select.get(j);
					int tmp = calcul(a, b);
					if(tmp<dist) dist=tmp; //�ּҰ� �Ǵ� �Ÿ��� ����
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
		int n = sc.nextInt(); //����ũ��
		m = sc.nextInt(); //���ܾ� �� ġŲ���� ����
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
