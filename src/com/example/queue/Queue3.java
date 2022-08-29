package com.example.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Queue3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        Queue<Person> queue = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            queue.add(new Person(i, arr[i]));
        }
        while (!queue.isEmpty()) {
            Person temp = queue.poll();
            for (Person person : queue) {
                if (temp.value < person.value) {
                    queue.add(temp);
                    temp = null;
                    break;
                }
            }
            if (temp != null) {
                System.out.println("temp.id = " + temp.id);
                answer++;
                if (temp.id == m)
                    return answer;
            }
        }
        return answer;
    }

    private static class Person {
        private final int id;
        private final int value;

        public Person(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }
}
