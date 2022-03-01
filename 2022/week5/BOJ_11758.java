import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11758 {
    static final int N = 3;
    static Pos[] positions = new Pos[N];
    static int[] dx = new int[2];
    static int[] dy = new int[2];
    static double delta;                       // delta (p1,p2)
    static double constant;                    // Constant
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions[i] = new Pos(x,y);
        }
        for (int i = 0 ; i < 2 ; i++){
            dx[i] = positions[i+1].x-positions[i].x;
            dy[i] = positions[i+1].y-positions[i].y;
        }
        delta = ((double) dy[0])/((double)dx[0]);
        constant = positions[0].y - positions[0].x * delta;
        System.out.println(delta);
        System.out.println(constant);
        if(getResult(positions[2].x)==positions[2].y || (dx[0]== 0 && positions[0].x == positions[2].x)) System.out.println(0);
        else{
            if(dx[0]>0){
                if(getResult(positions[2].x)>positions[2].y)
                    System.out.println(-1);
                else System.out.println(1);
            }else if(dx[0]<0){
                if(getResult(positions[2].x)<positions[2].y)
                    System.out.println(1);
                else System.out.println(-1);
            }else{      // dx == 0

            }
        }
    }
    static double getResult(int x){
        return delta*(double)x+constant;
    }
    static class Pos{
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
