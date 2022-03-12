package week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3020 {
    static int N, H;
    static int[] nums;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        count = new int[H+1];
        for(int h = 1; h <= H ; h++){
            for (int j = 1 ; j <= N ; j++){
                if(isClash(j, h)){
                    count[h]++;
                }
            }
        }
//        System.out.println(Arrays.toString(count));
        Arrays.sort(count);
        int cnt = 1;
        for (int i = 1 ; i < N ; i++){
            if(count[i]<count[i+1]){
                break;
            }
            
            cnt++;
        }
        System.out.println(count[1]+" "+cnt);
        
    }
    static boolean isClash(int idx, int h){
        if(idx%2==1){
            if(nums[idx]>=h) return true;
        }else{
            if(H-nums[idx]<h) return true;
        }
        return false;
    }
}
