import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public long solution(long n) {
        String sorted = String.valueOf(n).chars()
                .mapToObj(c -> c - '0')
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
        return Long.parseLong(sorted);
    }
}