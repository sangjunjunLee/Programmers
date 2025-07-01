import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] result = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            int currentScore = score[i];

            if (pq.size() < k) {
                pq.add(currentScore);
            } else {
                int peek = pq.peek();
                if (peek < currentScore) {
                    pq.poll();
                    pq.add(currentScore);
                }
            }
            result[i] = pq.peek();
        }

        return result;
    }
}