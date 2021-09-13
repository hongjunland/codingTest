import java.util.Scanner;

public class BJ1912_이홍준 {
    static int N;
    static int[] nums;
    static int Max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            nums[i] = sc.nextInt();
            Max = Integer.max(Max,sum+nums[i]);
            if(sum+nums[i]<0){
                if(sum<0) sum=nums[i];
                else sum = 0;
            }else sum+=nums[i];
        }
        System.out.println(Max);
    }
}
