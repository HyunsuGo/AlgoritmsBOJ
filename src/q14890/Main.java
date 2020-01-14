package q14890;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //풀이시간 57분
	static int[][] map;
	static int l;
	
	static boolean checkRow(int index) {
		for(int i=0; i<map[0].length-1; i++) {
			if(Math.abs(map[index][i]-map[index][i+1])>1) return false; //차이가 1이 넘으면 false
			else if(map[index][i]==map[index][i+1]) continue; //차이가 없으면 다음으로 진행
			else { //차이가 1이 나면
				if(map[index][i]>map[index][i+1]) { //앞에꺼가 더 높은경우
					if(i+l>map[0].length-1) return false; //앞에꺼가 더 높은데 경사를 놓으면 맵 초과하는경우
					else { //경사를 놓을수 있는경우
						for(int j=0; j<l; j++) { //경사놓고 바로 그 다음부터 경사의 길이만큼 평면이 확보되는상태에서
							if(map[index][i+1+j]==map[index][i+1]) continue; //경사가같으면 continue
							else return false; //다르면 false 리턴
							
						}
						for(int j=0; j<l; j++)
						if(i+l+1+j>map[0].length-1) continue;
						else if(map[index][i+l+1+j]>map[index][i+l]) return false; //더 높은곳이 있는지
						i=i+l-1; //다음께 같거나 더 낮은경우 경사의 마지막부분에서 다시 시작할수 있도록 해줌
					}
				} else { //뒤에꺼가 더 높은경우
					if(i+1-l<0) return false; //뒤에꺼가 더 높은데 앞에 경사를 놓으면 맵 초과하는 경우
					for(int j=0; j<l; j++) { //앞에 경사 놓을수 있는지 확인
						if(map[index][i-j]==map[index][i]) continue; //나머진 앞에 경사확인 후 놓음
						else return false;
					}
					
				}
			}
		}
		return true;
	}
	
	static boolean checkColumn(int index) {
		for(int i=0; i<map.length-1; i++) {
			if(Math.abs(map[i][index]-map[i+1][index])>1) return false; //차이가 1이 넘으면 false
			else if(map[i][index]==map[i+1][index]) continue; //차이가 없으면 다음으로 진행
			else { //차이가 1이 나면
				if(map[i][index]>map[i+1][index]) { //앞에꺼가 더 높은경우
					if(i+l>map.length-1) return false; //앞에꺼가 더 높은데 경사를 놓으면 맵 초과하는경우
					else { //경사를 놓을수 있는경우
						for(int j=0; j<l; j++) { //경사놓고 바로 그 다음부터 경사의 길이만큼 평면이 확보되는상태에서
							if(map[i+1+j][index]==map[i+1][index]) continue; //경사가같으면 continue
							else return false; //다르면 false 리턴
							
						}
						for(int j=0; j<l; j++)
						if(i+l+1+j>map.length-1) continue;
						else if(map[i+l+1+j][index]>map[i+l][index]) return false; //더 높은곳이 있는지
						i=i+l-1; //다음께 같거나 더 낮은경우 경사의 마지막부분에서 다시 시작할수 있도록 해줌
					}
				} else { //뒤에꺼가 더 높은경우
					if(i+1-l<0) return false; //뒤에꺼가 더 높은데 앞에 경사를 놓으면 맵 초과하는 경우
					for(int j=0; j<l; j++) { //앞에 경사 놓을수 있는지 확인
						if(map[i-j][index]==map[i][index]) continue; //나머진 앞에 경사확인 후 놓음
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
