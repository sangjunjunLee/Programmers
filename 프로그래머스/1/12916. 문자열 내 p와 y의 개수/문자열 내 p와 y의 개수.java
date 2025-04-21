class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        for (char c : s.toUpperCase().toCharArray()) {
            if (c == 'P') p++;
            else if (c == 'Y') y++;
        }
        return p == y;
    }
}