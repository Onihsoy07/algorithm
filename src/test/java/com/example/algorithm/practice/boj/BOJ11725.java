package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 트리의 부모 찾기
public class BOJ11725 {

    static int N;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] parentNode;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        parentNode = new int[N+1];

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        parentNode[1] = 1;
        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parentNode[i]);
        }
    }

    public static void dfs(int start) {
        for (int child : tree.get(start)) {
            if (parentNode[child] == 0) {
                parentNode[child] = start;
                dfs(child);
            }
        }
    }

}
