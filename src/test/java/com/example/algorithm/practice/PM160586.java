package com.example.algorithm.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 Lv1 대충 만든 자판
@SpringBootTest
public class PM160586 {

    String[][] keyMap = {
            {"ABACD", "BCEFD"},
            {"AA"},
            {"AGZ", "BSSS"}
    };
    String[][] targets = {
            {"ABCD","AABB"},
            {"B"},
            {"ASA","BGZ"}
    };
    int[][] comp = {
            {9, 4},
            {-1},
            {4, 6}
    };



    @Test
    public void test() {
        int[] result = new int[100];
        for (int i = 0; i < keyMap.length; i++) {
            result = solution(keyMap[i], targets[i]);
            Assertions.assertThat(result).isEqualTo(comp[i]);
        }
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char curChar = keymap[i].charAt(j);
                if (map.containsKey(curChar)) {
                    if (map.get(curChar) > j + 1) {
                        map.replace(curChar, j + 1);
                    }
                } else {
                    map.put(curChar, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;

            for (int j = 0; j < targets[i].length(); j++) {
                char curChar = targets[i].charAt(j);
                if (!map.containsKey(curChar)) {
                    answer[i] = -1;
                    break;
                }
                sum += map.get(curChar);
            }

            if (answer[i] != -1) {
                answer[i] = sum;
            }
        }

        return answer;
    }

}
