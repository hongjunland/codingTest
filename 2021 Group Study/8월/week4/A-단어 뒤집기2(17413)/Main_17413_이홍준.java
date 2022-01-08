import java.util.Scanner;
import java.util.Stack;

public class Main_17413_이홍준 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for(int i = 0 ; i < line.length() ; i++) {
			if(flag) {
				if(line.charAt(i)=='<') {
					while(!stack.isEmpty()) sb.append(stack.pop());
					sb.append(line.charAt(i));
					flag = false;
				}
				else if(line.charAt(i)==' ') {
					while(!stack.isEmpty()) sb.append(stack.pop());
					sb.append(line.charAt(i));
				}
				else stack.push(line.charAt(i));
				
				if(i==line.length()-1) {
					while(!stack.isEmpty()) sb.append(stack.pop());
				}
			}
			else {
				sb.append(line.charAt(i));
				if(line.charAt(i)=='>') flag = true;
			}
		}
		System.out.println(sb);
	}

}
