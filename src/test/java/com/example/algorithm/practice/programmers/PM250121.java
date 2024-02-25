package com.example.algorithm.practice.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 프로그래머스 Lv1 [PCCE 기출문제] 10번 / 데이터 분석
@SpringBootTest
public class PM250121 {

    int[][] date = {
            {1, 20300104, 100, 80},
            {2, 20300804, 847, 37},
            {3, 20300401, 10, 8}
    };
    String ext = "date";
    int val_ext = 20300501;
    String sort_by = "remain";
    int[][] result = {
            {3,20300401,10,8},
            {1,20300104,100,80}
    };

    @Test
    void test() {
        int[][] solution = solution(date, ext, val_ext, sort_by);
        Assertions.assertThat(solution).isEqualTo(result);
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<Integer, int[]> map = new HashMap<>();
        Map<String, Integer> transIndex = Map.of(
                "code", 0,
                "date", 1,
                "maximum", 2,
                "remain", 3
        );
        int transExt = transIndex.get(ext);
        int transSortBy = transIndex.get(sort_by);

        for (int[] inData : data) {
            if (inData[transExt] >= val_ext) {
                continue;
            }

            map.put(inData[transSortBy], inData);
        }

        Object[] mapKey = map.keySet().toArray();
        Arrays.sort(mapKey);

        int[][] answer = new int[mapKey.length][4];
        int index = 0;

        for (Object key : mapKey) {
            answer[index++] = map.get((int) key);
        }

        return answer;
    }
}
