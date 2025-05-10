import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if (map.containsKey(c)) {
                    Integer index = map.get(c);
                    map.put(c, Math.min(index, j + 1));
                } else {
                    map.put(c, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int cnt = 0;
            boolean flg = true;
            for (char c : target.toCharArray()) {
                if (map.containsKey(c)) {
                    cnt += map.get(c);
                } else {
                    flg = false;
                    break;
                }
            }
            result[i] = flg == false ? -1 : cnt;
        }
        return result;
    }
}