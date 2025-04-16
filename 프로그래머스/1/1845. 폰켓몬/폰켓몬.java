import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.size() == nums.length / 2) break;
            set.add(n);
        }
        return set.size();
    }
}