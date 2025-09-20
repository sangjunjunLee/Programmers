import java.util.*;
class Solution {
  public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> userCountMap = new HashMap<>();
        Map<Integer, Double> percentMap = new HashMap<>();

        for (int i = 1; i <= N + 1; i++) {
            userCountMap.put(i, 0);
        }

        for (int num : stages) {
            userCountMap.put(num, userCountMap.get(num) + 1);
        }

        int reached = stages.length;
        for (int i = 1; i <= N; i++) {
            int currentStageUserCnt = userCountMap.get(i);
            double fail = (reached == 0) ? 0.0 : (double) currentStageUserCnt / reached;
            percentMap.put(i, fail);
            reached -= currentStageUserCnt;
        }

        List<Integer> order = new ArrayList<>();
        for (int i = 1; i <= N; i++) order.add(i);

        order.sort((a, b) -> {
            int cmp = Double.compare(percentMap.get(b), percentMap.get(a));
            if (cmp != 0) return cmp;
            return Integer.compare(a, b);
        });

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = order.get(i);
        }
        return result;
    }
}