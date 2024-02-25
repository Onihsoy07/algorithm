package com.example.algorithm.practice.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 프로그래머스 Lv1 [PCCE 기출문제] 9번 / 이웃한 칸
@SpringBootTest
public class PM250125 {

    String[][][] board = {
            {
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}
            },
            {
                {"yellow", "green", "blue"},
                {"blue", "green", "yellow"},
                {"yellow", "blue", "blue"}
            }
    };
    int[] h = {1, 0};
    int[] w = {1, 1};
    int[] result = {2, 1};

    @Test
    void test() {
        for (int i = 0; i < board.length; i++) {
            int solution = solution(board[i], h[i], w[i]);
            Assertions.assertThat(solution).isEqualTo(result[i]);
        }
    }

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        final String currentColor = board[h][w];
        int[][] destination = new int[4][2];
        int[][] direction = {
                {-1, 0},
                {0, -1},
                {0, 1},
                {1, 0}
        };

        for (int i = 0; i < 4; i++) {
            int y = h + direction[i][0];
            int x = w + direction[i][1];
            destination[i][0] = y;
            destination[i][1] = x;
        }

        for (int[] check : destination) {
            if (check[0] < 0 || check[1] < 0) {
                continue;
            }
            if (check[0] >= board.length || check[1] >= board[0].length) {
                continue;
            }

            String thisColor = board[check[0]][check[1]];
            if (currentColor.equals(thisColor)) {
                answer++;
            }
        }

        return answer;
    }
}
