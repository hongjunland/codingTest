package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {
    static int N;
    static Person[] persons;
    static class Person implements Comparable<Person>{
        int document;
        int interview;
        public Person(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
        @Override
        public int compareTo(Person o) {
            return Integer.compare(document,o.document);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            persons = new Person[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                persons[i] = new Person(document,interview);
            }
            Arrays.sort(persons);
            int cnt = 1;
            int rank = persons[0].interview;
            for(int i = 1 ; i < N ; i++){
                if(rank > persons[i].interview){
                    rank = persons[i].interview;
                    cnt++;
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }

}
