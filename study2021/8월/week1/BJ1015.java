package backjoon.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj_1015_이홍준 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> A = new ArrayList<>();
        List<Integer> sortedA = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(st.nextToken());
            A.add(num);
            sortedA.add(num);
        }
        Collections.sort(sortedA);
        int[] B = new int[N];
        for(int i = 0 ; i < N ; i++){
            int idx = sortedA.indexOf(A.get(i));
            B[i] = idx;
            sortedA.set(idx,-1);
        }
        for(int num : B){
            sb.append(num+" ");
        }
        System.out.println(sb);
    }
}

