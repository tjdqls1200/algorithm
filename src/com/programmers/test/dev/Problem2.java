package com.programmers.test.dev;

import java.util.*;

public class Problem2 {
    static final String LOCALHOST = " 192.168.0.";
    static final String REJECT = " reject";

    public String[] solution(int n, String[] queries) {
        HashMap<String, Integer> computers = new HashMap<>();
        boolean[] used = new boolean[n + 1];
        boolean[] using = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();

        for (String s : queries) {
            String[] query = s.split(" ");
            if ("release".equals(query[1])) {
                int releaseIp = computers.get(query[0]);
                using[releaseIp] = false;
                continue;
            }
            if (computers.containsKey(query[0])) {
                int recent = computers.get(query[0]);
                if (recent > 0 && !using[recent]) {
                    using[recent] = true;
                    sb.append(query[0]).append(LOCALHOST).append(recent).append("/");
                    continue;
                }
            }
            int ip = ipChecked(n, used, using);
            if (ip == 0) {
                sb.append(query[0]).append(REJECT).append("/");
            } else {
                computers.put(query[0], ip);
                sb.append(query[0]).append(LOCALHOST).append(ip).append("/");
            }
        }
        return sb.substring(0, sb.length() - 1).split("/");
    }

    private int ipChecked(int n, boolean[] used, boolean[] using) {
        int ip = 0;
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                ip = i;
                break;
            }
            if (!using[i] && ip == 0) {
                ip = i;
            }
        }
        using[ip] = true;
        return ip;
    }
}
