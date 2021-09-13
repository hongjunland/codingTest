import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 0810_B_이홍준 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = new int[6];
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            int r1 = nums[2];
            int r2 = nums[5];
            int sum = (r1+r2)*(r1+r2);
            int sub = (r1-r2)*(r1-r2);
            int distance = (nums[0]-nums[3])*(nums[0]-nums[3]) + (nums[1]-nums[4])*(nums[1]-nums[4]);// (x1-x2)^2 + (y1-y2)^2
//            System.out.printf("sum: %d , sub: %d , d : %d \n",sum,sub,distance);
            if(distance==0){
                if(sub==0)
                    result = -1;
                else
                    result = 0;
            }else if(distance==sum || distance==sub)
                result = 1;
            else if(sub < distance && sum > distance ){
                result = 2;
            }else{
                result = 0;
            }
            System.out.println(result);
        }
    }
}
