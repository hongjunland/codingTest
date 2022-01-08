import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static boolean[] visited;
	static int N;
	static int M;
	static int Max = 0;
	static int c = 0;
//	static int[] seq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		combination(0,0);
		System.out.println(Max);
	}
	public static void combination(int d, int v) {
		if(d==3) {
			int sum = 0;
			for(int i = 0; i < N ; i++) {
				if(visited[i]) {
					sum+=nums[i];
				}
			}
			if(sum<=M) {
				Max = Integer.max(Max, sum);
			}
			return;
		}else {
			for(int i = v; i < N ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					combination(d+1, i);
					visited[i] = false;
				}
			}
		}
	}

}
