package week7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_81302 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}));
    }
    private static class Solution {
        static final int[] dr = {-1,1,0,0};
        static final int[] dc = {0,0,-1,1};
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];
            for (int i = 0 ; i < places.length; i++){
                if(isValid(places[i])){
                    answer[i] = 1;
                }
                else answer[i] = 0;
            }
            return answer;
        }
        public boolean isValid(String[] map){
            List<Person> people = new ArrayList<>();
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    if(map[i].charAt(j)=='P'){
                        people.add(new Person(i,j));
                    }
                }
            }
            for(int i = 0 ; i < people.size(); i++){
                for(int j = i+1; j < people.size() ; j++){
                    int distance = bfs(people.get(i),people.get(j),map);
                    if(distance<=2){
                        return false;
                    }
                }
            }
            return true;
        }
        public int bfs(Person person, Person target, String[] map){
            int[][] count = new int[5][5];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{person.row,person.col});
            while (!queue.isEmpty()){
                int[] pos = queue.poll();
                int row = pos[0];
                int col = pos[1];
                if(row == target.row && col == target.col){
                    return count[row][col];
                }
                for(int i = 0 ; i < 4 ; i++){
                    int nr = row+ dr[i];
                    int nc = col+ dc[i];
                    if(nr == person.row && nc == person.col) continue;
                    if(nr > -1 && nr < 5 && nc > -1 && nc < 5 && ( count[row][col]+1 < count[nr][nc] || count[nr][nc]==0)){
                        count[nr][nc] = count[row][col]+1;
                        if(map[nr].charAt(nc)=='X'){    // 파티션일 경우 거리1추가
                            count[nr][nc]++;
                        }
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
            return -1;
        }
        private class Person{
            int row;
            int col;
            public Person(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
    }


}