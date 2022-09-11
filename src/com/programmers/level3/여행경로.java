package com.programmers.level3;

// 코드 참고
// 1. 주어진 항공권은 모두 사용해야 합니다.
// 2. 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다. -> 알파벳이 앞서는 경로를 골랐을 때, 항공권을 전부 못 쓸 수도 있음!

// BFS로 출발지가 같은 경우 Queue에 전부 넣고 목적지의 우선 순위를 찾아서 나머지는 버리는 식으로 작성했는데
// 마지막에 목적지가 안 맞는 경우가 생겨서 그럴 때는 다시 되돌아가야 되기 때문에 DFS로 변경

// DFS 방식으로 변경
public class 여행경로 {
    static boolean[] check;
    static int len;
    static StringBuilder sb;
    static String result = "Z";

    public String[] solution(String[][] tickets) {
        len = tickets.length;
        check = new boolean[len];
        sb = new StringBuilder();
        sb.append("ICN").append(" ");

        DFS(0, "ICN", tickets);
        return result.split(" ");
    }

    private void DFS(int L, String from, String[][] tickets) {
        if (L == len) {
            result = (result.compareTo(sb.toString()) > 0) ? sb.toString() : result;
            return;
        } else {
            for (int i = 0; i < len; i++) {
                if (!check[i] && from.equals(tickets[i][0])) {
                    check[i] = true;
                    sb.append(tickets[i][1]).append(" ");
                    DFS(L + 1, tickets[i][1], tickets);

                    check[i] = false;
                    sb.delete(sb.length() - 4, sb.length());
                }
            }
        }
    }
}
