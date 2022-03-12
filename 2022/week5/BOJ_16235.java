package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16235 {
    static int N, M, K;
    static int[][] Mat;                                             // 양분
    static int[][] AddNutrients;                                    // 겨울에 추가할 양분
    static PriorityQueue<Tree> trees = new PriorityQueue<>();       // 나무목록(나무), 나이순
    static Queue<Tree> deadTrees = new LinkedList<>();              // 죽은나무목록
    static final int[] dr = {-1,-1,-1,0,1,1,1,0};                   // delta row
    static final int[] dc = {-1,0,1,1,1,0,-1,-1};                   // delta col
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Mat = new int[N+1][N+1];
        for (int i = 1 ; i <= N ; i++){
            for (int j = 1; j <= N ; j++) {
                Mat[i][j] = 5;
            }
        }
        AddNutrients = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                AddNutrients[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.offer(new Tree(row,col,age));
        }
        for(int i = 0 ; i < K ; i++){
            spring();
            summer();
            fall();
            winter();
        }
        System.out.println(trees.size());
    }
    static void spring(){
        PriorityQueue<Tree> newTrees = new PriorityQueue<>();   //  업데이트된 나무목록
        while (!trees.isEmpty()){
            Tree tree = trees.poll();
            if(tree.age <= Mat[tree.row][tree.col]){            // 나무나이보다 양분이 많을경우만 나이증가
                Mat[tree.row][tree.col] -= tree.age;            // 양분 = 현재 양분- 나무의 나이
                tree.aging();                                   // 나이+1
                newTrees.offer(tree);                           // 업데이트된 나무목록에 원소 추가
            }else{
                deadTrees.add(tree);                            // 죽은나무 추가, 업데이트된 나무목록에 추가하지 않음
            }
        }
        trees = newTrees;                                       // 업데이트된 나무목록으로 갱신
    }
    static void summer(){
        while (!deadTrees.isEmpty()){
            Tree tree = deadTrees.poll();                       
            Mat[tree.row][tree.col]+= tree.age/2;               // 죽은나무->양분/2
        }
    }
    static void fall(){
        PriorityQueue<Tree> newTrees = new PriorityQueue<>();   // 업데이트된 나무목록
        while (!trees.isEmpty()){
            Tree tree = trees.poll();                           
            newTrees.offer(tree);                               // 업데이된 나무목록에 다시 추가
            if(tree.age%5!=0) continue;                         // 5의 배수일 경우에만 통과
            for(int i = 0 ; i < 8 ; i++){
                int nr = tree.row+dr[i];
                int nc = tree.col+dc[i];
                if(nr>0 && nr <=N && nc>0 && nc <=N){           // boundary 예외처리
                    newTrees.offer(new Tree(nr,nc,1));     // 생성된 나무 업데이트된 나무목록에 추가
                }
            }
        }
        trees = newTrees;                                       // 업데이트된 나무목록으로 갱신
    }
    static void winter(){
        for (int i = 1 ; i <= N ; i++){
            for (int j = 1; j <=N ; j++) {
                Mat[i][j] += AddNutrients[i][j];                // 양분 추가
            }
        }
    }
    static class Tree implements Comparable<Tree>{
        int row;
        int col;
        int age;

        public Tree(int row, int col, int age) {
            this.row = row;
            this.col = col;
            this.age = age;
        }
        public void aging(){
            this.age++;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(age,o.age);
        }
    }
}
