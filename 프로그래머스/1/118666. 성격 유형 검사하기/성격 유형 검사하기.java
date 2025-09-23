import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Integer, Integer> scoreMap = Map.of(1, 3, 2, 2, 3, 1, 4, 0, 5, 1, 6, 2, 7, 3);
        Map<String, Integer> typeScores = new HashMap<>();

        String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for (String type : types) {
            typeScores.put(type, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            int choice = choices[i];

            if (choice < 4) {
                typeScores.merge(s.substring(0, 1), scoreMap.get(choice), Integer::sum);
            } else if (choice > 4) {
                typeScores.merge(s.substring(1, 2), scoreMap.get(choice), Integer::sum);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (typeScores.get("R") >= typeScores.get("T")) sb.append("R"); else sb.append("T");
        if (typeScores.get("C") >= typeScores.get("F")) sb.append("C"); else sb.append("F");
        if (typeScores.get("J") >= typeScores.get("M")) sb.append("J"); else sb.append("M");
        if (typeScores.get("A") >= typeScores.get("N")) sb.append("A"); else sb.append("N");

        return sb.toString();
    }
}