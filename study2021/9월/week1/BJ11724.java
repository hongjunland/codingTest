
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ11724_이홍준 {
    static int[] parent;
    static int find(int a){
        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot==bRoot) return false;
        parent[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a,b);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 1 ; i <= N ; i++){
            set.add(find(i));
        }
        System.out.println(set.size());
    }
}
