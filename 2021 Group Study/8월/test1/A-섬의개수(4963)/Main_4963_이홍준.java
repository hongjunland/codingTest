

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W;
    static int H;
    static int CNT;
    static int[][] MAP;
    static boolean[][] visited;
    static int[] dr = {-1,-1,0,1,1,1,0,-1};          //상 우상 우 우하 하 좌하 좌 좌상
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String[] line = br.readLine().split(" ");
            W = Integer.parseInt(line[0]);
            H = Integer.parseInt(line[1]);
            CNT = 0;
            if(W==0&&H==0) break;

            MAP = new int[H][W];
            visited = new boolean[H][W];
            for(int i = 0 ; i < H ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < W ; j++){
                    MAP[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0 ; i < H ; i++){
                for(int j = 0 ; j < W ; j++){
                    if(MAP[i][j]==1){
                        bfs(i,j);
                        MAP[i][j] = 1;
                    }
                }
            }
            for(int i = 0 ; i < H ; i++){
                for(int j = 0 ; j < W ; j++){
                    if(MAP[i][j]==1){
                        CNT++;
                    }
                }
            }
            sb.append(CNT+"\n");

        }
        System.out.println(sb);
    }
    public static void bfs(int row, int col){
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(row,col));
        MAP[row][col] = 0;
        while (!queue.isEmpty()){
            Location item = queue.poll();
            int r = item.row;
            int c = item.col;
            for(int i = 0 ; i < 8 ; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(0<=nr&&nr<H && 0<=nc&&nc<W && MAP[nr][nc]==1){
                    queue.offer(new Location(nr,nc));
                    MAP[nr][nc] = 0;
                }
            }
        }
    }
}
class Location{
    int row;
    int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
