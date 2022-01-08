package backjoon.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이홍준1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0 ; test_case < T ; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] prince = new int[4];
            for(int i = 0 ; i < 4 ; i++){
                prince[i]= Integer.parseInt(st.nextToken());
            }
            int startX = prince[0];
            int startY = prince[1];
            int targetX = prince[2];
            int targetY = prince[3];
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                Planet p = new Planet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                if(p.isInside(startX,startY)^p.isInside(targetX,targetY)){
                    cnt++;
                }
            }
            sb.append(cnt);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

class Planet{
    int x;
    int y;
    int r;
    public Planet(int x , int y , int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public boolean isInside(int tX, int tY){
        int distance = (x-tX)*(x-tX)+(y-tY)*(y-tY);
        if(distance<r*r)
            return true;
        return false;
    }

}
