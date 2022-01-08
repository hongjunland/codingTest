package wx.bj1600;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600 {
    static boolean[][][] visited;
    static int[][] Mat;
    static int N;
    static int M;
    static int K;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static final int[] hr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static final int[] hc = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int Result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        Mat = new int[N][M];
        visited = new boolean[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(Result);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int row = node.r;
            int col = node.c;
            int cnt = node.cnt;
            int jump = node.jump;
            if (row == N - 1 && col == M - 1) {
                Result = cnt;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && Mat[nr][nc] == 0 && !visited[nr][nc][jump]) {
                    visited[nr][nc][jump] = true;
                    queue.offer(new Node(nr, nc, cnt + 1, jump));
                }
            }
            if (jump < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = row + hr[i];
                    int nc = col + hc[i];
                    int nj = jump + 1;
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && Mat[nr][nc] == 0 && !visited[nr][nc][nj]) {
                        visited[nr][nc][nj] = true;
                        queue.offer(new Node(nr, nc, cnt + 1, nj));
                    }
                }
            }
        }
    }

    static class Node {
        int r;
        int c;
        int cnt;
        int jump;

        public Node(int r, int c, int cnt, int jump) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.jump = jump;
        }
    }
}
