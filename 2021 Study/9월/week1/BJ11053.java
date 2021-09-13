
import java.io.* ;
import java.util.*;

public class bj11053 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	public static void main(String[] args) throws Exception {

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] lis = new int[n];
		int[] array = new int[n];

		for(int i = 0 ; i < n ; ++i) array[i] = Integer.parseInt(st.nextToken());

		int idx = 0; 
		lis[idx] = array[0];
		for (int i = 1; i < n; i++) { 
			if (lis[idx] < array[i]) lis[++idx] = array[i]; 
			else { 
				int j = Arrays.binarySearch(lis,0,idx,array[i]); 
				if(j < 0) j = -j-1;
				lis[j] = array[i];
			} 
		}
		System.out.println(idx+1);
		
	}

}