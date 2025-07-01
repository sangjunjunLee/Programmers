import java.util.Arrays;

public class Solution {
        public int solution(int k, int m, int[] score) {
            int[] scores = Arrays.stream(score)
                    .boxed()
                    .sorted((a, b) -> b - a)
                    .mapToInt(Integer::intValue)
                    .toArray();

            int surplus = scores.length % m;
            int len = scores.length - surplus;

            int result = 0;

            for (int i = 0; i < len; i += m) {
                int minScore = scores[i + m - 1];
                result += minScore * m;
            }

            return result;
        }
}