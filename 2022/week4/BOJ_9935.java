package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String reg = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++){
            sb.append(str.charAt(i));
//            if(sb.to)
        }
        if(str.length()==0) System.out.println("FRULA");
        System.out.println(str);
    }
}
