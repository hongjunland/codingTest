package wx.bj1149;

import java.util.Scanner;

public class BJ_1149 {
    static int N;
    static int[][] mat;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        mat = new int[N][3];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j <3 ; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        for(int i = 0 ; i < N-1 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                int num = Integer.MAX_VALUE;
                for(int k = 0 ; k < 3 ; k++){
                    if(j!=k){
                        num = Integer.min(num,mat[i+1][j]+mat[i][k]);
                    }
                }
                mat[i+1][j]=num;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3 ; i++){
            result = Integer.min(result,mat[N-1][i]);
        }
        System.out.println(result);

    }
}
