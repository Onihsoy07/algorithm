package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 내리막 길
public class BOJ1520 {

    static int M;
    static int N;
    static int[][] map;
    static int[][] visited;
    static int result = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(visited);
        System.out.println(result);
    }

    public static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            result++;
            visited[x][y] = 1;
            return 1;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }

            if (map[x][y] > map[nx][ny]) {
                if (visited[nx][ny] == 0) {
                    int a = dfs(nx, ny);
                    System.out.println(String.format("%d  %d  + %d", x, y, a));
                    visited[x][y] += a;
                } else {
                    result += visited[nx][ny];
                    return visited[nx][ny];
                }
            }
        }

        return visited[x][y];
    }

}
