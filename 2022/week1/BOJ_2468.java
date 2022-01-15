import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int MaxHeight;                               // Maximum height
    static int N;
    static int[][] Mat;
    static int Answer = 1;                              // Minimum Answer = 1
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Mat = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Mat[i][j] = Integer.parseInt(st.nextToken());
                MaxHeight = Math.max(MaxHeight,Mat[i][j]);
            }
        }
        for (int i = 0; i < MaxHeight; i++) {
            Answer = Math.max(Answer,countArea(i));
        }
        System.out.println(Answer);
    }
    // return the number of group.
    static int countArea(int height){
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && Mat[i][j]>height) {
                    bfs(i, j, height, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void bfs(int row, int col, int height, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        visited[row][col] = true;
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = pos[0]+dr[i];
                int nc = pos[1]+dc[i];
                if(nr>=0 && nr < N && nc>=0 && nc<N && Mat[nr][nc]>height && !visited[nr][nc]){
                    queue.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
