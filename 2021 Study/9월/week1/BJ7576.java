
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576_이홍준 {
    static int M;
    static int N;
    static int[][] Mat;
    static Queue<Location> queue;
    static int Max;
    final static int[] dr = {-1,1,0,0};
    final static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        Mat = new int[N][M];
        queue = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++){
                Mat[i][j]=Integer.parseInt(st.nextToken());
                if(Mat[i][j]==1) queue.offer(new Location(i,j));
            }
        }
        bfs();
        outer: for(int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < M ; j++){
//                System.out.print(Mat[i][j]+" ");
                Max = Integer.max(Max,Mat[i][j]);
                if(Mat[i][j]==0){
                    Max = 0;
                    break outer;
                }
            }
//            System.out.println();
        }
        System.out.println(Max-1);
    }
    public static void bfs(){
        while (!queue.isEmpty()){
            Location location = queue.poll();
            int row = location.r;
            int col = location.c;
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr>=0 && nr<N && nc >=0 && nc <M && Mat[nr][nc]==0){
                    Mat[nr][nc] = Mat[row][col]+1;
                    queue.offer(new Location(nr,nc));
                }
            }
        }
    }
    static class Location{
        int r;
        int c;
        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
