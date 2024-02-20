package com.example.algorithm.practice.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 프로그래머스 Lv1 기사단원의 무기
@SpringBootTest
public class PM136798 {


    int[] number = {5, 10};
    int[] limit = {3, 3};
    int[] power = {2, 2};
    int[] comp = {10, 21};

    @Test
    public void test() {
        for (int i = 0; i < number.length; i++) {
            int result = solution(number[i], limit[i], power[i]);
            Assertions.assertThat(result).isEqualTo(comp[i]);
        }
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int result = divisor(i);
            answer += result > limit ? power : result;
        }

        return answer;
    }

    public int divisor(int number) {
        int result = 0;

        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                result++;
            } else if (number % i == 0) {
                result += 2;
            }
        }

        return result;
    }
}
