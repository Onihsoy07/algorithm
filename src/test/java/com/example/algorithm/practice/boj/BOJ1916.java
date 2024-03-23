package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 최소 비용 구하기
public class BOJ1916 {

    static int N, M, busStart, busEnd;
    static List<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        busStart = Integer.parseInt(st.nextToken());
        busEnd = Integer.parseInt(st.nextToken());

        dijkstra(busStart);

        System.out.println(dist[busEnd]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int startNode = curNode.end;

            if (visited[startNode]) {
                continue;
            }

            visited[startNode] = true;

            for (Node node : list[startNode]) {
                if (dist[node.end] > (dist[startNode] + node.weight)) {
                    dist[node.end] = dist[startNode] + node.weight;
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
        return this.weight - o.weight;
    }
}