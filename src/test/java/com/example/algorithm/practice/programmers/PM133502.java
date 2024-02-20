package com.example.algorithm.practice.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

// 프로그래머스 Lv1 햄버거 만들기
@SpringBootTest
public class PM133502 {

    int[][] ingredient = {
            {2, 1, 1, 2, 3, 1, 2, 3, 1},
            {1, 3, 2, 1, 2, 1, 3, 1, 2},
            {1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 2, 3, 1}
    };
    int[] comp = {2, 0, 3};

    @Test
    void test() {
        for (int i = 0; i < ingredient.length; i++) {
            int result = solution(ingredient[2]);
            Assertions.assertThat(result).isEqualTo(comp[2]);
        }
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int ing : ingredient) {
            list.add(ing);

            while (list.size() >= 4) {
                int lastIndex = list.size() - 1;

                if (list.get(lastIndex) == 1
                && list.get(lastIndex - 1) == 3
                && list.get(lastIndex -2) == 2
                && list.get(lastIndex - 3) == 1) {
                    for (int i = 0; i < 4; i++) {
                        list.remove(list.size() - 1);
                    }
                    answer++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
