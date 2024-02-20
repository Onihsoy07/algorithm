package com.example.algorithm.practice.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 프로그래머스 Lv1 푸드 파이트 대회
@SpringBootTest
public class PM134240 {

    int[][] food = {
            {1, 3, 4, 6},
            {1, 7, 1, 2}
    };
    String[] comp = {"1223330333221", "111303111"};

    @Test
    public void test() {
        for (int i = 0; i < food.length; i++) {
            String result = solution(food[i]);
            Assertions.assertThat(result).isEqualTo(comp[i]);
        }
    }

    public String solution(int[] food) {
        String answer = "";

        for (int i = 1; i < food.length; i++) {
            int ableFood = food[i] / 2;

            if (ableFood == 0) {
                continue;
            }

            for (int j = 0; j < ableFood; j++) {
                answer += (i + "");
            }
        }

        StringBuffer sb = new StringBuffer(answer);
        answer = answer + "0" + sb.reverse().toString();

        return answer;
    }
}
