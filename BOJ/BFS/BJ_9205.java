package bj.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_9205 {
    static int N;
    static Pos start,target;
    static Pos[] positions;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int teset_case = 1 ; teset_case<=T; teset_case++){
            N = sc.nextInt();
            start = new Pos(sc.nextInt(),sc.nextInt());
            positions = new Pos[N+1];
            for(int i = 1 ; i <= N ; i++){
                positions[i] = new Pos(sc.nextInt(),sc.nextInt());
            }
            target = new Pos(sc.nextInt(),sc.nextInt());
            String result = "sad";
            visited = new boolean[N+1];
            if(bfs()){
                result="happy";
            }
            System.out.println(result);
        }

    }
    static boolean bfs(){
        boolean flag = false;
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            Pos position = queue.poll();
            if(getDistance(position,target)<=1000){flag = true; break;}
            for(int i = 1 ; i <= N ; i++){
                if(!visited[i]&&getDistance(position,positions[i])<=1000){
                    visited[i] = true;
                    queue.offer(positions[i]);
                }
            }
        }
        return flag;
    }
    static int getDistance(Pos p1, Pos p2){
        return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
    }
    static class Pos{
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
