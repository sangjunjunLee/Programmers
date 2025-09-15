import java.util.*;
import java.util.stream.Collectors;
class Solution {
   public int[] solution(int[] lottos, int[] win_nums) {
        int min = 0;
        int max = 0;

        Set<Integer> wins = Arrays.stream(win_nums).mapToObj(m -> Integer.valueOf(m)).collect(Collectors.toSet());
        List<Integer> mine = Arrays.stream(lottos).mapToObj(l -> Integer.valueOf(l)).collect(Collectors.toList());

        for (Integer my : mine) {
            if (wins.contains(my)) {
                min++;
                max++;
            }
            if (my == 0) {
                max++;
            }
        }
        return new int[]{switch (max) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        }, switch (min) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        }};
    }
}