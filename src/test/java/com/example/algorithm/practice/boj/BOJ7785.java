package com.example.algorithm.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 회사에 있는 사람
public class BOJ7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<String, String> map = new HashMap<>();
        List<String> leavePeopleList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            map.put(name, state);
        }

        br.close();

        for (String name : map.keySet()) {
            if (map.get(name).equals("enter")) {
                leavePeopleList.add(name);
            }
        }

        Collections.sort(leavePeopleList, Collections.reverseOrder());

        for (String name : leavePeopleList) {
            System.out.println(name);
        }
    }

}
