package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 DFS와 BFS
public class BOJ1260 {

    static int N;
    static int M;
    static int v;
    static int[][] tree;
    static boolean visited[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        tree = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x][y] = tree[y][x] = 1;
        }

        dfs(v);
        visited = new boolean[N+1];
        System.out.println();

        bfs(v);

    }

    public static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false && tree[start][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i = 1; i <= N; i++) {
                if (visited[i] == false && tree[node][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
