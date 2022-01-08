package com.카카오._2021인턴십.표편집;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 표편집 {
    public static void main(String[] args) {
        String[] cmd1 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String[] cmd2 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        new Solution().solution(8, 2, cmd1);
        new Solution().solution(8, 2, cmd2);
    }
}

class Solution {
    private class Node {
        int id;
        Node before;
        Node next;
        public Node(int id) {
            this.id = id;
        }
    }
    private Node current;
    private List<Node> list = new ArrayList<>();
    private Stack<Node> stack = new Stack<>();

    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("O");
            Node node = new Node(i);
            list.add(node);
        }
        for (int i = 0; i < n; i++) {
            Node node = list.get(i);
            if (i > 0) node.before = list.get(i - 1);
            if (i < n - 1) node.next = list.get(i + 1);
        }
        current = list.get(k);
        for (int i = 0; i < cmd.length; i++) {
            String[] line = cmd[i].split(" ");
            switch (line[0]) {
                case "U":
                    upStair(Integer.parseInt(line[1]));
                    break;
                case "D":
                    downStair(Integer.parseInt(line[1]));
                    break;
                case "C":
                    remove();
                    break;
                case "Z":
                    backup();
                    break;
            }
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int idx = node.id;
            sb.setCharAt(idx, 'X');
        }
        System.out.println(sb);
        return sb.toString();
    }

    public void upStair(int step) {
        for (int i = 0; i < step; i++) {
            current = current.before;
        }
    }
    public void downStair(int step) {
        for (int i = 0; i < step; i++) {
            current = current.next;
        }
    }

    public void remove() {
        stack.push(current);
        Node beforeNode = current.before;
        Node nextNode = current.next;
        if(nextNode==null){
            beforeNode.next = null;
            current = beforeNode;
        }
        else{
            if(beforeNode!=null) beforeNode.next = nextNode;
            nextNode.before = beforeNode;
            current = nextNode;
        }
    }

    public void backup() {
        Node node = stack.pop();
        Node beforeNode = node.before;
        Node nextNode = node.next;
        if (beforeNode != null) beforeNode.next = node;
        if (nextNode != null) nextNode.before = node;
    }
}