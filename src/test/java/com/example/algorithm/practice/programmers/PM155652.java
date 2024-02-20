package com.example.algorithm.practice.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 프로그래머스 Lv1 둘만의 암호
@SpringBootTest
public class PM155652 {

    String s = "aukks";
    String skip = "wbqd";
    int index = 5;
    String comp = "happy";


    @Test
    public void test() {
        String result = solution(s, skip, index);
        Assertions.assertThat(result).isEqualTo(comp);
    }

    public String solution(String s, String skip, int index) {
        String answer = "";
        Character[] array = new Character['z' - 'a'];
        int startIndex = 0;

        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            char curChar = (char) i;

            if (!skip.contains(Character.toString(curChar))) {
                array[startIndex] = curChar;
                startIndex++;
                continue;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int changeIndex = (Arrays.asList(array).indexOf(s.charAt(i)) + index) % startIndex;
            answer += array[changeIndex];
        }

        return answer;
    }

}
