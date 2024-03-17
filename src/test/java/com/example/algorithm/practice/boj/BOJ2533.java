package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 사회망 서비스
public class BOJ2533 {

    static int N;
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int start) {
        visited[start] = true;
        dp[start][0] = 0;
        dp[start][1] = 1;

        for (int node : tree.get(start)) {
            if (!visited[node]) {
                dfs(node);
                dp[start][0] += dp[node][1];
                dp[start][1] += Math.min(dp[node][0], dp[node][1]);
            }
        }
    }

}
