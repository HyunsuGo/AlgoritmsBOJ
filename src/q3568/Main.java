package q3568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main { //풀이시간 105분                                                             ////(if문쓸때 항상 else도 확인하기 !!!)
	public static void main(String[] args) throws Exception {
//		File file = new File("src/q3568/test.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		String common = st.nextToken();

		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			String name="";
			sb.append(common);
			
			for(int i=0; i<temp.length()-1; i++) {
				if(('A'<=temp.charAt(i) && temp.charAt(i)<='Z')
						||('a'<=temp.charAt(i) && temp.charAt(i)<='z')) { //알파벳이 등장하면
					for(i=i; i<temp.length()-1; i++) { //알파벳인동안
						if(('A'<=temp.charAt(i) && temp.charAt(i)<='Z')
								||('a'<=temp.charAt(i) && temp.charAt(i)<='z')) { //기록함
							name = name.concat(String.valueOf(temp.charAt(i)));
//							System.out.println("name : " +name);
						} else { //알파벳이 다시 안나오면 나감
							break;
						}
					}
					
					for(int j=temp.length()-2; j>=i; j--) {
//						System.out.println("i : " + i + "   j : " + j);
						if(temp.charAt(j)==']') sb.append('[');
						else if(temp.charAt(j)=='[') sb.append(']');
						else sb.append(temp.charAt(j));
//						System.out.println(sb.toString());
					}
					
					break;
				} else { //알파벳이 등장하지 않으면
					sb.append(temp.charAt(i)); //기호들 붙임
				}
			}
			sb.append(" ").append(name).append(";\n");
		}
		System.out.print(sb.toString());
	}
}
