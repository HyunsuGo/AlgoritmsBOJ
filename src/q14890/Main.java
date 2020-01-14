package q14890;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //Ǯ�̽ð� 57��
	static int[][] map;
	static int l;
	
	static boolean checkRow(int index) {
		for(int i=0; i<map[0].length-1; i++) {
			if(Math.abs(map[index][i]-map[index][i+1])>1) return false; //���̰� 1�� ������ false
			else if(map[index][i]==map[index][i+1]) continue; //���̰� ������ �������� ����
			else { //���̰� 1�� ����
				if(map[index][i]>map[index][i+1]) { //�տ����� �� �������
					if(i+l>map[0].length-1) return false; //�տ����� �� ������ ��縦 ������ �� �ʰ��ϴ°��
					else { //��縦 ������ �ִ°��
						for(int j=0; j<l; j++) { //������ �ٷ� �� �������� ����� ���̸�ŭ ����� Ȯ���Ǵ»��¿���
							if(map[index][i+1+j]==map[index][i+1]) continue; //��簡������ continue
							else return false; //�ٸ��� false ����
							
						}
						for(int j=0; j<l; j++)
						if(i+l+1+j>map[0].length-1) continue;
						else if(map[index][i+l+1+j]>map[index][i+l]) return false; //�� �������� �ִ���
						i=i+l-1; //������ ���ų� �� ������� ����� �������κп��� �ٽ� �����Ҽ� �ֵ��� ����
					}
				} else { //�ڿ����� �� �������
					if(i+1-l<0) return false; //�ڿ����� �� ������ �տ� ��縦 ������ �� �ʰ��ϴ� ���
					for(int j=0; j<l; j++) { //�տ� ��� ������ �ִ��� Ȯ��
						if(map[index][i-j]==map[index][i]) continue; //������ �տ� ���Ȯ�� �� ����
						else return false;
					}
					
				}
			}
		}
		return true;
	}
	
	static boolean checkColumn(int index) {
		for(int i=0; i<map.length-1; i++) {
			if(Math.abs(map[i][index]-map[i+1][index])>1) return false; //���̰� 1�� ������ false
			else if(map[i][index]==map[i+1][index]) continue; //���̰� ������ �������� ����
			else { //���̰� 1�� ����
				if(map[i][index]>map[i+1][index]) { //�տ����� �� �������
					if(i+l>map.length-1) return false; //�տ����� �� ������ ��縦 ������ �� �ʰ��ϴ°��
					else { //��縦 ������ �ִ°��
						for(int j=0; j<l; j++) { //������ �ٷ� �� �������� ����� ���̸�ŭ ����� Ȯ���Ǵ»��¿���
							if(map[i+1+j][index]==map[i+1][index]) continue; //��簡������ continue
							else return false; //�ٸ��� false ����
							
						}
						for(int j=0; j<l; j++)
						if(i+l+1+j>map.length-1) continue;
						else if(map[i+l+1+j][index]>map[i+l][index]) return false; //�� �������� �ִ���
						i=i+l-1; //������ ���ų� �� ������� ����� �������κп��� �ٽ� �����Ҽ� �ֵ��� ����
					}
				} else { //�ڿ����� �� �������
					if(i+1-l<0) return false; //�ڿ����� �� ������ �տ� ��縦 ������ �� �ʰ��ϴ� ���
					for(int j=0; j<l; j++) { //�տ� ��� ������ �ִ��� Ȯ��
						if(map[i-j][index]==map[i][index]) continue; //������ �տ� ���Ȯ�� �� ����
						else return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q14890/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br  = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int count=0;
		for(int i=0; i<n; i++) {
			if(checkRow(i)) count++;
			if(checkColumn(i)) count++;
		}
		System.out.println(count);
		
	}
}
