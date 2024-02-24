package com.example.algorithm.practice.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 프로그래머스 Lv1 [PCCP 기출문제] 1번 / 붕대 감기
@SpringBootTest
public class PM250137 {

    int[][] bandage = {
            {5, 1, 5},
            {3, 2, 7},
            {4, 2, 7},
            {1, 1, 1}
    };
    int[] health = {30, 20, 10, 5};
    int[][][] attacks = {
            {
                {2, 10},
                {9, 15},
                {10, 5},
                {11, 5}
            },
            {
                {1, 15},
                {5, 16},
                {8, 6}
            },
            {
                {1, 15},
                {5, 16},
                {8, 6}
            },
            {
                {1, 2},
                {3, 2}
            }
    };
    int[] comp = {5, -1, -1, 3};

    @Test
    void test() {
        for (int i = 0; i < bandage.length; i++) {
            int result = solution(bandage[3], health[3], attacks[3]);
            Assertions.assertThat(result).isEqualTo(comp[3]);
        }
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        final int initHealth = health;
        int lastTurn = 0;

        for (int[] attack : attacks) {
            if (lastTurn == 0) {
                health -= attack[1];
                lastTurn = attack[0];
                continue;
            }

            int thisTurn = attack[0];
            health += (thisTurn - lastTurn - 1) * bandage[1];
            health += ((thisTurn - lastTurn - 1) / bandage[0]) * bandage[2];

            if (health > initHealth) {
                health = initHealth;
            }

            health -= attack[1];
            lastTurn = thisTurn;

            if (health <= 0) {
                return -1;
            }
        }
        return health;
    }
}
