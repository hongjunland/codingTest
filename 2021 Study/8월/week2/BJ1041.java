package com.backjoon._1041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1041_이홍준 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/com/input.txt"));
        StringBuilder sb = new StringBuilder();
        long N = Integer.parseInt(br.readLine());
        long[] dice = new long[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 6 ; i++){
            dice[i] = Integer.parseInt(st.nextToken());
        }
        long result = 0;
        if(N==1) result = getSum(dice);
        else if(N==2){
            result = getMinOfThreeSide(dice)*4;                     //  3면(꼭짓점)  위         4개
            result+= getMinOfTwoSide(dice)*4;                       //  2면(바닥)    아래       4개
        }
        else{
            result = getMinOfThreeSide(dice)*4;                     //  3면  (꼭짓점)  위         4개
            result+= getMinOfTwoSide(dice)*4;                       //  2면  (바닥)    아래       4개
            result+= getMinOfTwoSide(dice)*(N-2)*8;                 //  2면  (모서리)  12-4      8개
            result+= getMinOfOneSide(dice)*Math.pow((N-2),2)*5;     //  1면  (N-2)^2 x (6-1)    5부분
            result+= getMinOfOneSide(dice)*(N-2)*4;                 //  1면  (모서리 바닥)4       4개
        }
        sb.append(result);
        System.out.println(sb);
    }
    public static long getMinOfOneSide(long[] arr){
        long min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length;  i++){
            min = Math.min(min,arr[i]);
        }
        return min;
    }
    public static long getMinOfTwoSide(long[] arr){
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length-1 ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                if(i+j!=5)
                    min = Math.min(min,arr[i]+arr[j]);
            }
        }
        return min;
    }
    public static long getMinOfThreeSide(long[] arr){
        long min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length; j++){
                if((i+j)==5) continue;
                for(int k = j+1 ; k < arr.length ; k++){
                    if((j+k)==5) continue;
                    if((i+k)==5) continue;
                    min = Math.min(min,arr[i]+arr[j]+arr[k]);
                }
            }
        }
        return min;
    }
    public static long getSum(long[] arr){
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length ; i++){
            long sum = arr[i];
            for(int j = 0 ; j < arr.length; j++){
                if(j!=i && i+j!=5){
                    sum+=arr[j];
                }
            }
            min = Math.min(min,sum);
        }
        return min;
    }
}
