import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map;
    static int[] dr = {-1,-1,0,1,1,1,0,-1};          //상 우상 우 우하 하 좌하 좌 좌상
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/com/input.txt"));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new char[N+1][N+1];
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                map[i][j] = '*';
            }
        }
        pointer(N,(N+1)/2,(N+1)/2);
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void pointer(int n, int row, int col){
        if(n==3){
            draw(3,row,col);
            return;
        }
        draw(n,row,col);
        for(int i = 0 ; i < 8 ; i++){
            int nr = row+dr[i]*(n/3);
            int nc = col+dc[i]*(n/3);
            pointer(n/3,nr,nc);
        }
    }
    public static void draw(int n, int row, int col){
        int degree = n/6;
        for(int i = row-degree ; i <= row+degree ; i++){
            for(int j = col-degree ; j <= col+degree ; j++){
                map[i][j] = ' ';
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
