package com.example.algorithm.practice.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 프로그래머스 Lv1 덧칠하기
@SpringBootTest
public class PM161989 {

    int[] n = {8, 5, 4};
    int[] m = {4, 4, 1};
    int[][] section = {
            {2, 3, 6},
            {1, 3},
            {1, 2, 3, 4}
    };
    int[] comp = {2, 1, 4};

    @Test
    public void test() {
        int[] result = new int[comp.length];
        for (int i = 0; i < n.length; i++) {
           result[i] = solution(n[i], m[i], section[i]);
        }

        for (int i = 0; i < comp.length; i++) {
            Assertions.assertThat(result[i]).isEqualTo(comp[i]);
        }
    }

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int endWall = 0;

        for (int i = 0; i < section.length; i++) {
            if (endWall < section[i]) {
                endWall = section[i] + (m - 1);
                answer++;
            }
        }

        return answer;
    }

}
