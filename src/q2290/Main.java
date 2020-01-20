package q2290;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main { //풀이시간 45분    (문제 출력 잘보고 형식맞춰서 출력하기!)
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q2290/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		String num = st.nextToken();
		String[] out = new String[2*s+3];
		for(int i=0; i<out.length; i++) out[i]="";
 		
		for(int i=0; i<num.length(); i++) {
			char temp = num.charAt(i);
			switch (temp) {
			case'0':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+="-"; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+=" "; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+="-"; out[2*s+2]+=" ";
				break;
			case'1':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+=" "; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+=" "; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+=" "; out[2*s+2]+=" ";
				break;
			case'2':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+="-"; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+="-"; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+=" "; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+="-"; out[2*s+2]+=" ";
				break;
			case'3':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+="-"; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+="-"; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+="-"; out[2*s+2]+=" ";
				break;
			case'4':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+=" "; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+="-"; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+=" "; out[2*s+2]+=" ";
				break;
			case'5':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+="-"; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+=" "; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+="-"; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+="-"; out[2*s+2]+=" ";
				break;
			case'6':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+="-"; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+=" "; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+="-"; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+="-"; out[2*s+2]+=" ";
				break;
			case'7':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+="-"; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+=" "; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+=" "; out[2*s+2]+=" ";
				break;
			case'8':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+="-"; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+="-"; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+="-"; out[2*s+2]+=" ";
				break;
			case'9':
				out[0]+=" "; for(int p=0; p<s; p++) out[0]+="-"; out[0]+=" ";
				for(int p=1; p<s+1; p++) {
					out[p]+="|"; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[s+1]+=" "; for(int p=0; p<s; p++) out[s+1]+="-"; out[s+1]+=" ";
				for(int p=s+2; p<2*s+2; p++) {
					out[p]+=" "; for(int q=0; q<s; q++) out[p]+=" "; out[p]+="|"; 
				}
				out[2*s+2]+=" "; for(int p=0; p<s; p++) out[2*s+2]+="-"; out[2*s+2]+=" ";
				break;
			}
			for(int j=0; j<out.length; j++) out[j]+=" ";
			
		}
		for(int i=0; i<out.length; i++) {
			System.out.println(out[i]);
		}
	}
}
