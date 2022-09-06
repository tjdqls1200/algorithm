package com.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_말단노드_짧은거리 {
    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.lt = new Node(2);
        tree.rt = new Node(3);
        tree.lt.lt = new Node(4);
        tree.lt.rt = new Node(5);
        System.out.println(BFS(tree));
    }

    private static int BFS(Node root) {

        Queue<Node> queue = new LinkedList<>();
        int L = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node pos = queue.poll();
                if (pos.lt == null && pos.rt == null) {
                    return L;
                }
                if (pos.lt != null) queue.offer(pos.lt);
                if (pos.rt != null) queue.offer(pos.rt);
            }
            L++;
        }
        return -1;
    }

    private static class Node {
        private final Integer value;
        Node lt, rt;

        public Node(int value) {
            this.value = value;
            this.lt = null;
            this.rt = null;
        }
    }
}
