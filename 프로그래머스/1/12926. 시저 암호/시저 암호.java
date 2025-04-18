class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == ' ') {
                sb.append(c);
                continue;
            }

            if (Character.isUpperCase(c)) {
                c += n;

                if (c > 'Z') {
                    c = (char) ('A' + (c - 'Z' - 1));
                }
                sb.append(c);
                continue;
            }

            if (Character.isLowerCase(c)) {
                c += n;

                if (c > 'z') {
                    c = (char) ('a' + (c - 'z' - 1));
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }
}