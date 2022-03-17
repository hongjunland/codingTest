package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684 {
    static int N, M, H;
    static boolean[][] checked;         // true : 사다리 연결 , false : 연결 되지 않음
    static int Answer = -1;             // 결과 값
    static boolean flag = false;        // 조건 달성
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        checked = new boolean[H+1][N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            checked[row][col] = true;
        }
        for(int i = 0 ; i <= 3 ; i++){
            dfs(i,0);
            if(flag){
                Answer = i;
                break;
            }
        }
        Answer = (Answer > 3) ? -1 : Answer;
        System.out.println(Answer);
    }
    static void dfs(int max, int cnt){
        if(cnt==max){
            // 1~N 까지 조건에 해당하는지 확인
            for(int i = 1 ; i <= N ; i++){
                if(!isValid(i)) {
                    return;
                }
            }
            // 종료 조건 적용
            flag = true;
        }
        else{
            // 백트래킹
            for (int i = 1; i <= H ; i++){
                for (int j = 1 ; j < N ; j++){
                    if(!checked[i][j-1] && !checked[i][j] && !checked[i][j+1]){
                        checked[i][j] = true;
                        dfs(max,cnt+1);
                        checked[i][j] = false;
                    }
                }
            }
        }

    }
    // 시작과 종료지점이 같으면 true
    static boolean isValid(int start){
        int current = start;
        for(int i = 1 ; i <= H ; i++){
            if(checked[i][current]) current++;
            else if(current>1 && checked[i][current-1])
                current--;
        }
        return true ? start==current : false;
    }
}
