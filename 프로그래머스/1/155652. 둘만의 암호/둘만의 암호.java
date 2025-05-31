import java.util.*;
class Solution {
    public static String solution(String s, String skip, int index) {
        Set<Character> skipWord = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : skip.toCharArray()) {
            skipWord.add(c);
        }

        for (char c : s.toCharArray()) {
            for (int i = 1; i <= index; i++) {
                c++;

                while (true) {
                    if (c > 'z') {
                        c = (char) ('a' + (c - 'z') -1);
                    }
                    if (skipWord.contains(c)) {
                        c++;
                    } else {
                        break;
                    }
                }
            }
            sb.append(c);
            System.out.println(sb);
        }
        return sb.toString();
    }
}