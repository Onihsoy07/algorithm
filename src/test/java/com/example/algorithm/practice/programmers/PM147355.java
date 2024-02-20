package com.example.algorithm.practice.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 프로그래머스 Lv1 크기가 작은 부분 문자열
@SpringBootTest
public class PM147355 {

    String[] t = {"3141592", "500220839878", "10203"};
    String[] p = {"271", "7", "15"};
    int[] comp = {2, 8, 3};

    @Test
    public void test() {
        for (int i = 0; i < t.length; i++) {
            int result = solution(t[i], p[i]);
            Assertions.assertThat(result).isEqualTo(comp[i]);
        }
    }

    public int solution(String t, String p) {
        int answer = 0;
        long pNumber = Long.parseLong(p);

        for (int i = 0; i <= (t.length() - p.length()); i++) {
            long subNumber = Long.parseLong(t.substring(i, i + p.length()));

            if (subNumber <= pNumber) {
                answer++;
            }
        }

        return answer;
    }
}
