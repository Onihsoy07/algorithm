package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 최단경로
public class BOJ1753 {

    static int V, E, K;
    static List<Node>[] list;
    static boolean[] visited;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new List[V + 1];
        visited = new boolean[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curNodeEnd = curNode.end;

            if (visited[curNodeEnd] == true) {
                continue;
            }

            visited[curNodeEnd] = true;

            for (Node node : list[curNodeEnd]) {
                if (dist[node.end] > (dist[curNodeEnd] + node.weight)) {
                    dist[node.end] = dist[curNodeEnd] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }

    }

}

class Node implements Comparable<Node> {

    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}