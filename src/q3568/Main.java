package q3568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main { //Ǯ�̽ð� 105��                                                             ////(if������ �׻� else�� Ȯ���ϱ� !!!)
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
						||('a'<=temp.charAt(i) && temp.charAt(i)<='z')) { //���ĺ��� �����ϸ�
					for(i=i; i<temp.length()-1; i++) { //���ĺ��ε���
						if(('A'<=temp.charAt(i) && temp.charAt(i)<='Z')
								||('a'<=temp.charAt(i) && temp.charAt(i)<='z')) { //�����
							name = name.concat(String.valueOf(temp.charAt(i)));
//							System.out.println("name : " +name);
						} else { //���ĺ��� �ٽ� �ȳ����� ����
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
				} else { //���ĺ��� �������� ������
					sb.append(temp.charAt(i)); //��ȣ�� ����
				}
			}
			sb.append(" ").append(name).append(";\n");
		}
		System.out.print(sb.toString());
	}
}
