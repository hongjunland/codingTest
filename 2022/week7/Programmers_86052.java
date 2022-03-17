package week7;

import java.util.*;

public class Programmers_86052 {
    public static void main(String[] args) {
        new Solution().solution(new String[]{"SL","LR"});
        new Solution().solution(new String[]{"S"});
        new Solution().solution(new String[]{"R","R"});
    }
    private static class Solution {
        final int[] dr = {-1,0,1,0};
        final int[] dc = {0,1,0,-1};
        HashMap<Character,Integer> hashMap = new HashMap<>(){{
            // 블록별 방향 변환 값
            put('L',-1);
            put('S',0);
            put('R',1);
        }};
        //        S : 0 , R : 1, L : -1,
        boolean[][][] visited;
        public int[] solution(String[] grid) {
            visited = new boolean[grid.length][grid[0].length()][4];
            List<Integer> result = new ArrayList<>();
            for(int i = 0 ; i < grid.length; i++){
                for(int j = 0 ; j < grid[0].length(); j++){
                    for(int d = 0; d < 4 ; d++){
                        if(!visited[i][j][d]){
                            result.add(bfs(grid,i,j,d));
                        }
                    }
                }
            }
            int[] answer = new int[result.size()];
            for(int i = 0 ; i < answer.length ; i++){
                answer[i] = result.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }
        public int bfs(String[] grid, int startRow, int startCol,int startDirection){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startRow,startCol,startDirection});
            visited[startRow][startCol][startDirection] = true;
            int cnt = 1;
            while (!queue.isEmpty()){
                int[] pos = queue.poll();
                int row = pos[0];
                int col = pos[1];
                int direction = pos[2];

                int nr = (row+dr[direction]+grid.length)%grid.length;
                int nc = (col+dc[direction]+grid[0].length())%grid[0].length();
                int nextDirectionIdx = (direction+hashMap.get(grid[nr].charAt(nc))+4)%4;
                if(!visited[nr][nc][nextDirectionIdx]){
                    visited[nr][nc][nextDirectionIdx] = true;
                    queue.offer(new int[]{nr,nc,nextDirectionIdx});
                    cnt++;
                }
            }
            return cnt;
        }

    }
}


