import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] filtered = Arrays.stream(arr).filter(o -> o % divisor == 0).toArray();
        Arrays.sort(filtered);
        return filtered.length > 0 ? filtered : new int[]{-1};
    }
}