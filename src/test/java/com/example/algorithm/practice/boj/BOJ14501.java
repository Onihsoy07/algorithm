package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 퇴사
public class BOJ14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] t = new int[N+2];
        int[] p = new int[N+2];
        int[] dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            if (i + t[i] <= N + 1) {
                dp[i] = Math.max(p[i] + dp[i + t[i]], dp[i + 1]);
            } else {
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);

    }

}
