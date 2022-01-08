package bj.week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697 {
    static int N;
    static int K;
    static int Result;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Result = K - N;
        visited = new boolean[100001];
        if(Result>0) bfs();
        else Result = N-K;
        System.out.println(Result);
    }
    private static void bfs() {
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(1,N+1));
        queue.add(new Item(1,N-1));
        queue.add(new Item(1,N*2));
        while (!queue.isEmpty()){
            Item item = queue.poll();
            int cnt = item.cnt;
            int value = item.value;
            if(value>100000||value<0) continue;
            if(visited[value]) continue;
            if(value==K){
                Result = cnt;
                break;
            }
            visited[value] = true;
            queue.add(new Item(cnt+1,value-1));
            queue.add(new Item(cnt+1,value+1));
            queue.add(new Item(cnt+1,value*2));
        }
    }
    static class Item{
        int cnt;
        int value;
        public Item(int cnt, int value) {
            this.cnt = cnt;
            this.value = value;
        }
    }

}
