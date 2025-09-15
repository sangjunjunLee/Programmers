import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        Set<Integer> reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());

        Set<Integer> overlap = new HashSet<>(lostSet);
        
        overlap.retainAll(reserveSet);
        lostSet.removeAll(overlap);
        reserveSet.removeAll(overlap);

        int answer = n - lostSet.size();

        for (int s : new TreeSet<>(lostSet)) {
            if (reserveSet.remove(s - 1) || reserveSet.remove(s + 1)) {
                answer++;
            }
        }
        return answer;
    }
}