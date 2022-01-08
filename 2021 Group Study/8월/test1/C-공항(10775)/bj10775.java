import java.util.*;
import java.io.*;
public class bj10775 {
	static int[] parent = new int[100001];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) parent[i] = i;
		int answer = 0;
		
		for(int i=0;i<M;i++) {
			int airplane = Integer.parseInt(br.readLine());
			if(airplane > N) break;
			if(find(airplane)==0) break;
			else answer++;
			union(airplane);
		}
		System.out.println(answer);
	}
	
	public static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = find(parent[x]); 
	}
	
	public static void union(int x) {
		x = find(x);
		parent[x] = x-1;
	}
}
