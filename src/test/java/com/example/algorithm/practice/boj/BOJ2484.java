package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 주사위 네개
public class BOJ2484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int winnerResult = 0;
        int result = 0;
        Map<Integer, Integer> currentDice = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int diceEye = Integer.parseInt(st.nextToken());

                if (currentDice.containsKey(diceEye)) {
                    currentDice.put(diceEye, currentDice.get(diceEye) + 1);
                } else {
                    currentDice.put(diceEye, 1);
                }
            }

            Set<Integer> keys = currentDice.keySet();

            if (keys.size() == 4) {
                result = Collections.max(keys) * 100;
            } else {
                for (int key : keys) {
                    Integer duplicateDice = currentDice.get(key);

                    switch (duplicateDice) {
                        case 2:
                            if (keys.size() == 3) {
                                result += 1000 + (key * 100);
                                break;
                            } else {
                                result = (result == 0) ? 2000 : result;
                                result += key * 500;
                                break;
                            }
                        case 3:
                            result += 10000 + (key * 1000);
                            break;
                        case 4:
                            result += 50000 + (key * 5000);
                            break;
                        default:
                            break;
                    }
                }
            }

            if (winnerResult < result) {
                winnerResult = result;
            }

            result = 0;
            currentDice.clear();
        }

        System.out.println(winnerResult);
    }

}
