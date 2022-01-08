import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14502{
    static int N;
    static int M;
    static int[][] Mat;
    static List<int[]> virus;
    final static int[] dr = {-1,1,0,0};
    final static int[] dc = {0,0,-1,1};
    static int Max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        Mat = new int[N][M];
        virus = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                Mat[i][j] = Integer.parseInt(st.nextToken());
                if(Mat[i][j]==2) virus.add(new int[]{i,j});
            }
        }
        comb(0,0,0);
        System.out.println(Max);
    }
    public static void comb(int r,int c, int d){
        if(d==3){
            int[][] arr = copyOfArray(Mat);
            bfs(arr);
            Max = Math.max(Max,countSafeArea(arr));
        }else{
            for(int i = r ; i < N ; i++){
                for(int j = c ; j < M ; j++){
                    if(Mat[i][j]==0){
                        Mat[i][j]=1;
                        comb(i,c,d+1);
                        Mat[i][j]=0;
                    }
                }
            }
        }
    }
    public static int[][] copyOfArray(int[][] arr){
        int[][] copy = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            copy[i] = arr[i].clone();
        }
        return copy;
    }
    public static int countSafeArea(int[][] arr){
        int cnt = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(arr[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
    public static void bfs(int[][] arr){
        Queue<int[]> queue = new LinkedList<>();
        for(int[] pos : virus){
            queue.add(pos);
        }
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
            for(int i = 0 ; i < 4 ; i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&arr[nr][nc]==0){
                    arr[nr][nc] = 2;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
