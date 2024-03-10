package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 바이러스
public class BOJ2606 {

    static int N;
    static int M;
    static int[][] tree;
    static boolean visited[];
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        tree = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x][y] = tree[y][x] = 1;
        }

        dfs(1);

        System.out.println(result - 1);
    }

    public static void dfs(int start) {
        visited[start] = true;
        result++;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false && tree[start][i] == 1) {
                dfs(i);
            }
        }
    }

}
