import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    static int N;
    static int[] nums;
    static long Min;
    static int MinLeft;
    static int MinRight;
    static int left;
    static int right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        left = 0;
        MinLeft = left;

        right = N-1;
        MinRight = right;

        Min = nums[left]+nums[right];

        while (left<N&&right>=0&&left<right){
            if(nums[left]+nums[right]>0){
                if(Math.abs(Min)>=Math.abs(nums[left]+nums[right])){
                    Min = nums[left]+nums[right];
                    MinLeft = left;
                    MinRight = right;
                }
                right--;
            }else if(nums[left]+nums[right]<0){
                if(Math.abs(Min)>=Math.abs(nums[left]+nums[right])){
                    Min = nums[left]+nums[right];
                    MinLeft = left;
                    MinRight = right;
                }
                left++;
            }else{
                MinLeft = left;
                MinRight = right;
                Min = nums[left]+nums[right];
                break;
            }
        }
        System.out.println(nums[MinLeft]+" "+nums[MinRight]);
//        System.out.println(Min);
    }
}
